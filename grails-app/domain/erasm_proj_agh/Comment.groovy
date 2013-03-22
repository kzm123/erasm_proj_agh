package erasm_proj_agh

class Comment implements Comparable {

	static mapping = {
		table 'comments'
		
	}
	String body
	int rating = 0
	static belongsTo = [author: User]
	Date date;
	static hasMany = [replies : Comment, voters: User] //TODO: User-voter table.
	
	public Comment(String body, long authorid){
		User author = User.get(authorid);
		this.body = body;
		this.author = author;
		this.date = new Date();
	}
	
	public void addReply(String body, long authorid){
		User author = User.get(authorid);
		replies.add(new Comment(body, author));
	}
	
	public void rate(int rating, User voter){
		voters.add(voter);
		rating+=rating;
	}
    @Override
	public String toString() {
		return "Comment [body=" + body + ", rating=" + rating + ", date="
				+ date + "]";
	}
	static constraints = {
		body blank:false, nullable:false
		rating blank:false, nullable: false	
    }

	@Override
	public int compareTo(Object arg0) {
		return date <=> arg0?.date 
	}
}
