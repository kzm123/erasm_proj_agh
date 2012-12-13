package erasm_proj_agh

import java.util.Date;

class User {
	
    static mapping = {
        table 'users'
    }
    
    static hasMany = [userCities: UserCity]
    static hasOne = [details: UserDetails]
    
    static searchable = true

    String username
    String passwordHashed
	    
	String profilePhoto
	
	String password
	String confirm

    static constraints = {
        username blank: false, nullable: false, size: 5..30, matches: /[a-zA-Z0-9_-]+/, unique: true
		profilePhoto blank: true, nullable: true
		details blank: false, nullable: false
		password bindable: true, blank: false, nullable: false, size: 5..30, validator: { val, obj ->
			if (obj.confirm != null) {
				val == obj.confirm ? true : 'user.password.validator'
			}
		}
        confirm bindable: true, blank: false, nullable: false
    }
	
	static transients = ['password', 'confirm']
    
}
