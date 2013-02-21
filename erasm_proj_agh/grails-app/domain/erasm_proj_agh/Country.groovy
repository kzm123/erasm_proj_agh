package erasm_proj_agh

class Country {
    
    static mapping = {
        table 'countries'
    }
    
    static hasMany = [userDetails: UserDetails]
    
    String name
    String description

    static constraints = {
        name blank: false, nullable: false
        description blank: true, nullable: true
    }
    
    String toString() {
        return this.name
    }
    
}
