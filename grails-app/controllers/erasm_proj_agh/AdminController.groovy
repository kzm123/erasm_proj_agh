package erasm_proj_agh

import groovy.sql.Sql
import org.postgresql.util.PSQLException

class AdminController {
	def sessionFactory

	def editCities = {
		if (session.admin) {
			def cityList = City.findAll()
			render(view: 'editCities', model: [cityList: cityList])
		} else {
			redirect(controller:'main')
		}
	}


	def login = {
		if (request.method == 'POST') {
			def passwordHashed = params.password.encodeAsPassword()
			def admin = Admin.findByLoginAndPasswordHashed(params.login, passwordHashed)
			if (admin) {
				session.admin = admin
				redirect(controller: 'admin')
			} else {
				flash.message = "Admin not found or password incorrect"
				redirect(controller: 'admin')
			}
		} else if (session.admin) {
			redirect(controller: 'admin')
		}
	}

	def logout = {
		session.removeAttribute("admin")
		redirect(controller:'main')
	}

	def confirmCity = {
		if (session.admin && params.id) {
			def city = City.get(params.id)
			city.confirmed = true;
			redirect(controller:'admin', action: 'editCities')
		}
	}

	def query = {
		if (session.admin) {
			
			//Gets currentSession's database connection.
			def sql = new Sql(sessionFactory.currentSession.connection())
			
			//Available table list, for browsing tables. No admin here.
			def tableList = ['countries', 'cities', 'places', 'users', 'user_details']
			
			//Available columns for a table. Default null.
			def colNames
			def colTypes
			
			if (params.get('table') != null){
//				System.out.println('select * from ' + params.get('table') + ' limit 0')
				sql.rows('select * from ' + params.get('table') + ' limit 0') { meta ->
					colNames = (1..meta.columnCount).collect { meta.getColumnName(it) }
				}
			}
			
			//Number of rows per page.
			def rowsPerPage = 2
			if(params.get('rowsPerPage') != null && params.get('rowsPerPage').isInteger()){
				rowsPerPage = Integer.parseInt(params.get('rowsPerPage'))
				if (rowsPerPage < 1)
					rowsPerPage = 1
			}
			
			//List of selected stuff. Also number of rows pages, and list of rows shown.
			def rowList
			def rowPages = 1
			def rowShown = []
				//DEBUG
				//DEBUG end
						
			//Get row list.
			if(params.get('filled') == 't' && colNames.size() != 0){
				try{
					if(params.get('whereStatement').equals(''))
						rowList = sql.rows('SELECT * FROM ' + params.get('table')) {};
					else
						rowList = sql.rows('SELECT * FROM ' + params.get('table') + ' WHERE ' + params.get('whereStatement')) {};
				}catch(PSQLException ex){
					flash.message = ex.getMessage()
					rowList = []
				}
				//Caluclates how many pages for displaying all rows.
				rowPages = Math.ceil(rowList.size / rowsPerPage )
				def rowPage = 1
				
				//Get set rowShown
				if(params.get('rowPage') != null && params.get('rowPage').isInteger() ){
					rowPage = Integer.parseInt(params.get('rowPage'))
					//System.out.println('rowPage')
				}
				
				//Get the list of shown rows.
				def copyMax = Math.min((rowPage * rowsPerPage)-1, (rowList.size() - 1))
				def copyMin = (rowPage-1)*rowsPerPage
//				System.out.println(copyMin.toString() + " " + copyMax.toString() + " " + ((rowPage * rowsPerPage)-1).toString() + " " + (rowList.size() - 1).toString() )
				if(rowList.size() > 0){
					rowShown = (copyMin..copyMax).collect {
						rowList.get(it)
					}
				}
			}
			
			render(view: 'query', model: [tableList: tableList, colNames : colNames, rowShown : rowShown, rowPages : rowPages, rowsPerPage: rowsPerPage, table: params.get('table')])
		} else {
		redirect(controller:'main')
		}
	}
	
	def queryTable() {

		if (session.admin){
//			System.out.println("Wheeee " + params.get('table'))
			redirect(controller:'admin', action:'query', params: [table: params.get('table'), rowsPerPage: params.get('rowsPerPage')])	
		}
	}
	
	def queryList() {
		if (session.admin){	
			def paramsMap = [table: params.get('table'), rowPage: params.get('rowPage'), whereStatement: params.get('whereStatement'), rowsPerPage: params.get('rowsPerPage'), filled : 't']
//			System.out.println(params.get('whereStatement'));
			redirect(controller:'admin', action:'query', params: paramsMap)
		}
		
	}
	
	def queryRemove() {
		if (session.admin){
			//Gets currentSession's database connection.
			def sql = new Sql(sessionFactory.currentSession.connection())
			
			for(i in params){
				//Parse params, and find checkobex. Check if they're on.
				if (i.getKey().toString() ==~ /(Rem_).*/ && i.getValue() == 'on'){
					//DEBUG
//					System.out.println('Woah, sorry fella nr ' + i.getKey().toString().substring(4))
//					System.out.println("DELETE FROM " + params.get('table') + " WHERE id = " + i.getKey().toString().substring(4))
					//DEBUG end
					
					
					//Execute delete query.
					try {
						sql.execute("DELETE FROM " + params.get('table') + " WHERE id = " + i.getKey().toString().substring(4))
					 } catch(Exception e){
					 	System.out.println("DELETE QUERY FAILED")
						redirect(controller:'admin', action:'query', params: [table: params.get('table'), filled : 't', removed : 'f'])
					 }
					 
				}
			}
			redirect(controller:'admin', action:'query', params: [table: params.get('table'), whereStatement: params.get('whereStatement'), rowsPerPage: params.get('rowsPerPage'), filled : 't', removed : 't'])
		}
	}
	

	def querySort() {
		if(session.admin){
			
		}
	}
	
	public queryCustom() {
		//Gets currentSession's database connection.
		def sql = new Sql(sessionFactory.currentSession.connection())
		
		//Available columns for a table. Default null.
		def colNames
		def rowPage = 1
		def rowList = []
		def rowPages
		def rowsPerPage = 2
		if(params.get('rowsPerPage') != null && params.get('rowsPerPage').isInteger()){
			rowsPerPage = Integer.parseInt(params.get('rowsPerPage'))
			if (rowsPerPage < 1)
				rowsPerPage = 1
		}
		
		def rowShown = []
		
		try{
			if(params.get('query')){
				rowList = sql.rows(params.get('query')) { meta ->
					colNames = (1..meta.columnCount).collect { meta.getColumnName(it) }
				}
			}
		}catch(PSQLException ex){
		   flash.message = ex.getMessage()
		}
		
		rowPages = Math.ceil(rowList.size / rowsPerPage )
		
		if(params.get('rowPage') != null && params.get('rowPage').isInteger() ){
			rowPage = Integer.parseInt(params.get('rowPage'))
			//System.out.println('rowPage')
		}
		
		//Get the list of shown rows.
		def copyMax = Math.min((rowPage * rowsPerPage)-1, (rowList.size() - 1))
		def copyMin = (rowPage-1)*rowsPerPage
//		System.out.println(copyMin.toString() + " " + copyMax.toString() + " " + ((rowPage * rowsPerPage)-1).toString() + " " + (rowList.size() - 1).toString() )
		if(rowList.size() > 0){
			rowShown = (copyMin..copyMax).collect {
				rowList.get(it)
			}
		}
		
		render(view: 'queryCustom', model: [colNames : colNames, rowShown : rowShown, rowPages : rowPages, rowsPerPage: rowsPerPage, query: params.get('query')])
	}
def index = {}

}

