package erasm_proj_agh

class UserDetails {
	
	static belongsTo = [user:User]
	
	String name
	String surname
	boolean gender
	String email
	String city
	String address
	String country
	Date dateOfBirth
	String university
	String highSchool
	String workPlace

    static constraints = {
        name blank: false, nullable: false, size: 2..45
        surname blank: false, nullable: false, size: 2..45
        gender blank: false, nullable: false
        email blank: true, nullable: true
        city blank: true, nullable: true
		address blank: true, nullable: true
		country blank: true, nullable: true
		dateOfBirth blank: true, nullable: true
		university blank: true, nullable: true
		highSchool blank: true, nullable: true
		workPlace blank: true, nullable: true
    }
}
