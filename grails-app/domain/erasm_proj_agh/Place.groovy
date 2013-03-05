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
<<<<<<< HEAD
    int rating
    String location
    
    boolean confirmed

    static constraints = {
        name blank: false, nullable: false, size: 2..45, matches: /[-\.a-zA-Z0-9 ]+/
        location blank: false, nullable: false
        rating blank: true, nullable: true, range: 0..10
=======
    String localization
    double rating
	int votes 
	static hasMany = [comments : Comment, voters: User]
	SortedSet comments
	
	static mapping = {
    	table 'places'
    }
 
    boolean confirmed

    static constraints = {
        name blank: false, nullable: false, size: 2..45
        localization blank: false, nullable: false, size: 2..45
        rating blank: true, nullable: true
		votes blank: true, nullable: true
>>>>>>> 1833222470bf069b502f36ccf4dc9224cdff57f0
    }
	
	public addComment(Comment comment){
		comments.add(comment);
	}
}
