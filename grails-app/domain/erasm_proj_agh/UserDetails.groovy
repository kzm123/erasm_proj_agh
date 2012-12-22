package erasm_proj_agh

class UserDetails {
	
	static belongsTo = [user: User, country: Country]
	
	String name
	String surname
	boolean gender
	String email
	String city
	String address
	Date dateOfBirth
	String university
	String highSchool
	String workPlace
    String phone

    static constraints = {
        name blank: false, nullable: false, size: 2..45, matches: "[a-zA-Z-]+"
        surname blank: false, nullable: false, size: 2..45, matches: "[a-zA-Z-]+"
        gender blank: false, nullable: false
        email blank: false, nullable: false, size: 6..45, matches: "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})"
        city blank: true, nullable: true, size: 2..58
		address blank: true, nullable: true, size: 3..45
		dateOfBirth blank: true, nullable: true
        country blank: true, nullable: true
		university blank: true, nullable: true, size: 2..45
		highSchool blank: true, nullable: true, size: 2..45
		workPlace blank: true, nullable: true, size: 2..45
        phone blank: true, nullable: true, size: 7..15, matches: "[0-9]+"
    }
}
