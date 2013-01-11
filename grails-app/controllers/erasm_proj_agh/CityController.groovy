package erasm_proj_agh

class CityController {
    
    def show() {
        if (params.id) {
            def city = City.get(params.id)
            def places = Place.findAllWhere(city: city)
            def universities = University.findAllWhere(city: city)
            
            def user = User.get(session.userid)
            def userSignedIn = UserCity.isLinked(user, city)
            
            render(view: 'show', model: [city: city, places: places, universities: universities, userSignedIn: userSignedIn])
        } else {
            redirect(controller: 'main')
        }
    }

    def create() {
        if (!session.userid) {
            redirect(controller: 'main')
        } else if (request.method == 'POST') {
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
                redirect(action: 'show', params: [id: city.id])
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
                render(view: 'show', model: [city: city, place: place])
            } else {
                redirect(controller: 'place', params: [id: place.id])
            }
        }
    }
    
    def addUniversity() {
        if (request.method == 'POST' && session.userid) {
            
            def university = new University()
            def city = City.findByName(params.city)
            
            for (param in params) {
                if (param.key == 'city') {
                    university.city = city
                } else {
                    university.properties[param.key] = param.value
                }
            }
            
            if (!university.save()) {
                render(view: 'show', model: [city: city, university: university])
            } else {
                redirect(controller: 'university', action: 'show', params: [id: university.id])
            }
        }
    }
    
}
