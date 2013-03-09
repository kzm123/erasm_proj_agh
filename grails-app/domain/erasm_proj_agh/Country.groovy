package erasm_proj_agh

class Country {
    
    static mapping = {
        table 'countries'
    }
    
    static hasMany = [userDetails: UserDetails]
    
    static searchable = {
        mapping {
            boost 2.0
            spellCheck "include"
        }
    }
    
    String name
    String description

    static constraints = {
        name blank: false, nullable: false
        description blank: true, nullable: true
    }
    
    public String toString() {
        name
    }
    
}
