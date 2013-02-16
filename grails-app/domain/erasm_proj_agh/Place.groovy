package erasm_proj_agh

class Place {
    
    
    static belongsTo = [city: City]
    String name
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
    }
	
	public addComment(Comment comment){
		comments.add(comment);
	}
}
