package erasm_proj_agh

class City {
    
    static mapping = {
        table 'cities'
    }
    
    static belongsTo = [country: Country]
    static hasMany = [users: User]
    
    String name
    String description
    
    boolean confirmed

    static constraints = {
        name blank: false, nullable: false, size: 2..58
        description blank: true, nullable: true, size: 0..1000
    }
}
