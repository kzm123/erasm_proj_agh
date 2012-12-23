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
			
			//List of selected stuff.
			def rowList
			if (params.get('table') != null){
				sql.rows('select * from ' + params.get('table') + ' limit 0') { meta ->
					colNames = (1..meta.columnCount).collect { meta.getColumnName(it) }
					}
			}
			
			//DEBUG
			//DEBUG end			
			if(params.get('filled') == 't' && colNames.size() != 0){
					rowList = sql.rows('SELECT * FROM ' + params.get('table')) {
					}
				}
			render(view: 'query', model: [tableList: tableList, colNames : colNames, rowList : rowList])
		} else {
		redirect(controller:'main')
		}
	}
	
	def queryTable() {
		if (session.admin){
			redirect(controller:'admin', action:'query', params: [table: params.get('table')])
		}
	}
	
	def queryList() {
		if (session.admin){
			redirect(controller:'admin', action:'query', params: [table: params.get('table'), filled : 't'])
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
					 }
					 
				}
			}
			redirect(controller:'admin', action:'query', params: [table: params.get('table'), filled : 't'])
		}
	}
	

def index = {}

}

