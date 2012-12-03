package erasm_proj_agh

class PlaceController {
    
    def index() {
        if (params.id) {
            def place = Place.get(Integer.parseInt(params.id))
            render(view: 'index', model: [place: place])
        } else {
            redirect(controller: 'main')
        }
    }
    
}
