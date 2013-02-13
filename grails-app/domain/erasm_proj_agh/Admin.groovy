package erasm_proj_agh

class Admin {

    static mapping = {
        table 'admins'
    }

	String login    
    String passwordHashed
	
	static constraints = {
		login blank: false, nullable: false, size: 5..30, matches: /[a-zA-Z0-9_-]+/, unique: true
	}
}
