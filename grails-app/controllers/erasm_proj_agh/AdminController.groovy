package erasm_proj_agh

import groovy.sql.Sql

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
				System.out.println('select * from ' + params.get('table') + ' limit 0')
				sql.rows('select * from ' + params.get('table') + ' limit 0') { meta ->
					colNames = (1..meta.columnCount).collect { meta.getColumnName(it) }
				}
			}
			
			//Number of rows per page.
			def rowsPerPage = 2
			if(params.get('rowsPerPage') != null && params.get('rowsPerPage').isInteger()){
				rowsPerPage = params.get('rowsPerPage')
			}
			
			//List of selected stuff. Also number of rows pages, and list of rows shown.
			def rowList
			def rowPages = 1
			def rowShown = []
				//DEBUG
				//DEBUG end
						
			//Get row list.
			if(params.get('filled') == 't' && colNames.size() != 0){
				rowList = sql.rows('SELECT * FROM ' + params.get('table')) {
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
				def copyMax = Math.min(rowPage * rowsPerPage-1, rowList.size()-1 )
				def copyMin = (rowPage-1)*rowsPerPage
				if(rowList.size() > 0){
				rowShown = (copyMin..copyMax).collect {
					rowList.get(it)
				}
				System.out.println(rowShown.size + " " + copyMax)
			}
			}
			//DEBUG
//			System.out.println(rowPages)
//			System.out.println("rowShown size: " + rowShown.size)
			//DEBUG END
			
			render(view: 'query', model: [tableList: tableList, colNames : colNames, rowShown : rowShown, rowPages : rowPages, table: params.get('table')])
		} else {
		redirect(controller:'main')
		}
	}
	
	def queryTable() {

		if (session.admin){
//			System.out.println("Wheeee " + params.get('table'))
			redirect(controller:'admin', action:'query', params: [table: params.get('table')])	
		}
	}
	
	def queryList() {
		if (session.admin){				
			redirect(controller:'admin', action:'query', params: [table: params.get('table'), rowPage: params.get('rowPage'), filled : 't'])
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
			redirect(controller:'admin', action:'query', params: [table: params.get('table'), filled : 't', removed : 't'])
		}
	}
	

	def querySort() {
		if(session.admin){
			
		}
	}
def index = {}

}

