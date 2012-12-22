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
			
			def sql = new Sql(sessionFactory.currentSession.connection())
			def colNames
			
			def tableList = ['countries', 'cities', 'places', 'users', 'user_details']
			def rowList
			if (request.method == 'POST'){
				
				sql.rows('select * from ' + params.get('table') + ' limit 0') { meta ->
					colNames = (1..meta.columnCount).collect { meta.getColumnName(it) }
				}
		
			if(colNames.size != 0){
					rowList = sql.rows('SELECT * FROM ' + params.get('table')) {
					}
		
		
					for(i in rowList){
						for(j in colNames)
							System.out.println(j + ': ' + i.getProperty(j))
					}
				}
			}
			render(view: 'query', model: [tableList: tableList, colNames : colNames, rowList : rowList])
		} else {
		redirect(controller:'main')
		}
	}
	

def index = {}

}

