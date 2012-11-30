package erasm_proj_agh

class AdminController {

	def editCities() {
		if (session.admin) {
			[cityList: City.findAll()]
		} else {
			redirect(controller:'main')
		}
	}
	
	
	def login = {
		if (request.method == 'POST') {
			session.admin = "admin";
			redirect(controller:'admin')
		}
	}

	def logout = {
		session.removeAttribute("admin")
		redirect(controller:'main')
	}
	
	def confirmCity = {
		if (session.admin) {
			def city = City.get(params.id)
			city.confirmed = true;
			redirect(controller:'admin', action: 'editCities')
		}
	}
	
	def index() { }
}

