package erasm_proj_agh

import erasm_proj_agh.Place;

class PlaceController {
    
    def index() {
        if (params.id) {
            def place = Place.get(params.id)
            render(view: 'show', model: [place: place])
        } else {
            redirect(controller: 'main')
        }
    }
	
	def rate(){
		System.out.println(session.userid);
		def place = Place.get(Integer.parseInt(params.id))
		def voted = place.voters*.id.contains(session.userid)
		if(!voted){
		Double avg = (place.rating*place.votes + params.rating.toDouble())/(++place.votes)
		place.rating = avg
		place.voters.add(User.get(session.userid))
		place.save(flush: true)
		}
		redirect(controller: "Place", params: [id: place.id])
		
	}
	def comment(){
		def place = Place.get(Integer.parseInt(params.id))
		Comment com = new Comment(params.body, session.userid)
		place.addComment(com)
		place.save(flush: true)
		
		redirect(controller: "Place", params: [id: params.id])
	}
	
	def rateComment(){
		Comment comment = Comment.get(params.comment.toInteger())
		def voted=comment.voters*.id.contains(session.userid)
		System.out.println(voted);
		if(!voted){
		int rate = params.rate.toInteger()
		comment.rating+=rate;
		comment.voters.add(User.get(session.userid));
		System.out.println('Voters' + comment.voters);
		}
		redirect(controller: "Place", params: [id: params.placeid])
	}
}
