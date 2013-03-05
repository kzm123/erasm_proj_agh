package erasm_proj_agh

class Place {
    
    static mapping = {
        table 'places'
    }
    
    static searchable = {
        mapping {
            boost 2.0
            spellCheck "include"
        }
    }
    
    static belongsTo = [city: City]
    
    String name
    int rating
    String location
    
    boolean confirmed

    static constraints = {
        name blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        location blank: false, nullable: false
        rating blank: true, nullable: true, range: 0..10
    }
}
