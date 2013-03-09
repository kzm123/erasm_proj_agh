package erasm_proj_agh

class Place {
    
    static searchable = {
        mapping {
            boost 2.0
            spellCheck "include"
        }
    }
    
    static belongsTo = [city: City]
    String name
    String location
    double rating
	int votes 
	static hasMany = [comments : Comment, voters: User]
	SortedSet comments
	
	static mapping = {
    	table 'places'
    }
 
    boolean confirmed

    static constraints = {
        name blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        location blank: false, nullable: false
        rating blank: true, nullable: true
		votes blank: true, nullable: true
    }
	
	public addComment(Comment comment){
		comments.add(comment);
	}
    
    public String toString() {
        name
    }
    
}
