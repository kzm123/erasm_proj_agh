import erasm_proj_agh.City

class BootStrap {

    def init = { servletContext ->
    
		if (!City.count()) {
			new City(name: "Kraków", description: "", confirmed:true).save(failOnError: true)
			new City(name: "Oooooo", description: "Another universe", confirmed:false).save(failOnError: true)
		}
	}
    def destroy = {
    }
}
