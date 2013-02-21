package erasm_proj_agh

class SearchController {

    def show() { }
    
    def find() {
        if (request.method == 'GET' && params.search) {
            def user = User.findByUsername(params.search)
            if (user) {
                redirect(controller: 'user', action: 'show', params: [user: user.username])
                return
            }
            
            def users = null
            def queries = []
            for (s in params.search.split()) {
                queries.add(s.toLowerCase())
            }
            
            if (queries.size() == 1) {
                users = UserDetails.findAll("from UserDetails " +
                                            "where LOWER(name) is ?", [queries[0]])
                if (!users) {
                    users = UserDetails.findAll("from UserDetails " +
                                                "where LOWER(surname) is ?", [queries[0]])
                }
            } else {
                users = UserDetails.findAll("from UserDetails " +
                                            "where LOWER(name) in ? " + 
                                            "and LOWER(surname) in ?", queries)
            }
            
            def cities = City.findAll("from City " +
                                      "where LOWER(name) like ?", ["%" + params.search.toLowerCase() + "%"])
            def places = Place.findAll("from Place " +
                                      "where LOWER(name) like ?", ["%" + params.search.toLowerCase() + "%"])
            def universities = University.findAll("from University " +
                                      "where LOWER(name) like ?", ["%" + params.search.toLowerCase() + "%"])
            
            render(view: 'show', model: [users: users, cities: cities, places: places, universities: universities, search: params.search])
        } else {
            redirect(action: "show")
        }
    }
}
