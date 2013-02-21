package erasm_proj_agh

class Place {
    
    static mapping = {
        table 'places'
    }
    
    static searchable = true
    
    static belongsTo = [city: City]
    
    String name
    String localization
    int rating
    
    boolean confirmed

    static constraints = {
        name blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        localization blank: false, nullable: false, size: 2..45
        rating blank: true, nullable: true, range: 0..10
    }
}
