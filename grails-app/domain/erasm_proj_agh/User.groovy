package erasm_proj_agh

import java.util.Date;

class User {
	
    static mapping = {
        table 'users'
    }

    String username
    String passwordHashed
	
    String password
    String confirm
	
	UserDetails details

    static transients = ['password', 'confirm']

    static constraints = {
        username blank: false, nullable: false, size: 5..20, matches: /[\S]+/, unique: true
        password  blank: false, size: 5..30, matches: /[\S]+/, validator: { val, obj -> 
                if (obj.properties['confirm'] != val) return 'user.password.dontmatch'
            }
    }
    
}
