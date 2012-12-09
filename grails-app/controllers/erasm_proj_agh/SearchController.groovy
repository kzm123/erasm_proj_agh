package erasm_proj_agh

import javax.swing.text.View;

class SearchController {

    def index() { }
    
    def find() {
        if (request.method == 'POST') {
            if (params.search) {
                def users = User.findByUsernameLike("%" + params.search + "%")
                def cities = City.findByNameLike("%" + params.search + "%")
                def places = Place.findByNameLike("%" + params.search + "%")
                render(view: 'index', model: [users: users, cities: cities, places: places])
            } else {
                redirect(action: "index")
            }
        }
    }
}
