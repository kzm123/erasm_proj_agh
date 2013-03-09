package erasm_proj_agh

class Faculty {
    
    static mapping = {
        table 'faculties'
    }
    
    static searchable = {
        mapping {
            boost 2.0
            spellCheck "include"
        }
    }

    static belongsTo = [university: University]
    static hasMany = [majors: Major]
    
    String name
    String description

    static constraints = {
        name blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        description blank: true, nullable: true, size: 0..1000
    }
    
    public String toString() {
        name
    }
    
}
