package erasm_proj_agh

class City {
    
    static mapping = {
        table 'cities'
    }
    
    static searchable = {
        mapping {
            boost 2.0
            spellCheck "include"
        }
    }
    
    static belongsTo = [country: Country]
    static hasMany = [userCities: UserCity, universities: University]
    
    String name
    String description
    
    boolean confirmed

    static constraints = {
        name blank: false, nullable: false, size: 2..58, matches: /[-\.a-zA-Z0-9 ]+/
        description blank: true, nullable: true, size: 0..1000
    }
}
