package erasm_proj_agh

class PlaceController {
    
    def show() {
        if (params.id) {
            def place = Place.get(params.id)
            render(view: 'show', model: [place: place])
        } else {
            redirect(controller: 'main')
        }
    }
    
}
