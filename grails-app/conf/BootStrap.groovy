import erasm_proj_agh.Admin
import erasm_proj_agh.Authority
import erasm_proj_agh.City
import erasm_proj_agh.Country
import erasm_proj_agh.User
<<<<<<< HEAD
import erasm_proj_agh.UserAuthority
import erasm_proj_agh.UserDetails
=======
>>>>>>> 1833222470bf069b502f36ccf4dc9224cdff57f0

class BootStrap {

    def init = { servletContext ->
		if(Admin.count == 0){
			new Admin(login: 'admin', passwordHashed: 'ala123'.encodeAsPassword()).save()
		}
<<<<<<< HEAD
        
        new Country(name: "Poland", description: "Poland description").save()
        new Country(name: "USA", description: "USA description").save()
        
        UserDetails details1 = new UserDetails(name: "Jan", surname: "Kowalski", email: "jan.kowalski@gmail.com", gender: true)
        User user1 = new User(username: "jankow", password: "zxcasdqwe", details: details1, enabled: true, profilePhoto: null)
        user1.save()
        
        Authority.withTransaction {
            def userRole = new Authority(authority: 'ROLE_USER').save()
            UserAuthority.create(user1, userRole, true)
        }
        
        UserDetails details2 = new UserDetails(name: "Maria", surname: "Nowak", email: "maria.nowak@gmail.com", gender: false)
        User user2 = new User(username: "marnow", password: "zxcasdqwe", details: details2, enabled: true, profilePhoto: null)
        user2.save()
        
        Authority.withTransaction {
            def userRole = new Authority(authority: 'ROLE_USER').save()
            UserAuthority.create(user2, userRole, true)
        }
=======
		new Country(name:'Poland', description:'M�j kraj taki pienkny').save();
>>>>>>> 1833222470bf069b502f36ccf4dc9224cdff57f0
	}
    def destroy = {
    }
}
