package erasm_proj_agh


class Major {
    
    static mapping = {
        table 'majors'
    }
    
    static searchable = true

    static belongsTo = [faculty: Faculty]
    
    String name
    String description

    static constraints = {
        name blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        description blank: true, nullable: true, size: 0..1000
    }
    
}
