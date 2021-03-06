package erasm_proj_agh

class UserDetails {
    
    static belongsTo = [user: User, country: Country]
    
    static searchable = {
        mapping {
            boost 2.0
            spellCheck "include"
        }
    }
    
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
        name blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z]+/
        surname blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z]+/
        gender blank: false, nullable: false
        email blank: false, nullable: false, size: 6..45, matches: /[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})/
        city blank: true, nullable: true, size: 2..58, matches: /[-\.a-zA-Z0-9 ]+/
        address blank: true, nullable: true, size: 3..45, matches: /[-\.a-zA-Z0-9]+/
        dateOfBirth blank: true, nullable: true
        country blank: true, nullable: true
        university blank: true, nullable: true, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        highSchool blank: true, nullable: true, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        workPlace blank: true, nullable: true, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        phone blank: true, nullable: true, size: 7..15, matches: /[0-9 ]+/
    }
    
    public String toString() {
        name + " " + surname
    }
    
}
