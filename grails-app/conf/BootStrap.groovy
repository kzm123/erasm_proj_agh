import erasm_proj_agh.Admin
import erasm_proj_agh.City
import erasm_proj_agh.Country
import erasm_proj_agh.User

class BootStrap {

    def init = { servletContext ->
		if(Admin.count == 0){
			new Admin(login: 'admin', passwordHashed: 'ala123'.encodeAsPassword()).save()
		}
		new Country(name:'Poland', description:'Mój kraj taki pienkny').save();
	}
    def destroy = {
    }
}
