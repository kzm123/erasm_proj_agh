package erasm_proj_agh

class CityController {
    
    def index() {
        if (params.id) {
            def city = City.get(params.id)
            redirect(action: 'index', params: [city: city.name])
        } else if (params.city) {
            def city = City.findByName(params.city)
            def places = Place.findAllWhere(city: city)
            
            def user = User.get(session.userid)
            def userSignedIn = UserCity.isLinked(user, city)
            
            render(view: 'index', model: [city: city, places: places, userSignedIn: userSignedIn])
        } else {
            redirect(controller: 'main')
        }
    }

    def create() {
        if (request.method == 'POST' && session.userid) {
            def city = new City()
            
            for (param in params) {
                if (param.key == 'country') {
                    if (param.value != 'null') {
                        city.properties['country'] = Country.get(Integer.parseInt(param.value))
                    }
                } else {
                    city.properties[param.key] = param.value
                }
            }
            
            if (!city.save()) {
                render(view: 'create', model: [city: city])
            } else {
                redirect(action: 'index', params: [city: city.name])
            }
        }
    }
    
    def addPlace() {
        if (request.method == 'POST' && session.userid) {
            
            def place = new Place()
            def city = City.findByName(params.city)
            
            for (param in params) {
                if (param.key == 'city') {
                    place.city = city
                } else {
                    place.properties[param.key] = param.value
                }
            }
            
            if (!place.save()) {
                render(view: 'index', model: [city: city, place: place])
            } else {
                redirect(controller: 'place', params: [id: place.id])
            }
        }
    }
    
}
