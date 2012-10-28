package erasm_proj_agh

class Users {
    
    Date dateCreated
    Date lastUpdated

    String firstName
    String lastName
    String username
    String password
    String confirm
    String passwordHashed

    static transients = ['password', 'confirm']

    static constraints = {
        firstName blank: false, nullable: false;
        lastName  blank: false, nullable: false;
        username  blank: false, nullable: false, size: 5..20, matches: /[\S]+/, unique: true
        password  blank: false, size: 5..30, matches: /[\S]+/, validator: { val, obj -> 
                if (obj.properties['confirm'] != val) return 'user.password.dontmatch'
            }
    }
    
}
