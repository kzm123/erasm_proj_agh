package erasm_proj_agh

class CityController {
    
    def index() {
        if (params.city) {
            def city = City.findByName(params.city)
            def places = Place.findAllWhere(city: city)
            render(view: 'index', model: [city: city, places: places])
        } else {
            redirect(controller: 'main')
        }
    }

    def create() {
        if (session.user) {
            if (request.method == 'POST') {
                
                def city = new City()
                
                for (param in params) {
                    if (param.key == 'country') {
                        city.country = Country.get(Integer.parseInt(param.value))
                    } else {
                        city.properties[param.key] = param.value
                    }
                }
                
                if (!city.save()) {
                    render(view: 'create', model: [city: city])
                } else {
                    redirect(controller: 'city')
                }
            }
        }
    }
    
    def find() {
        if (request.method == 'POST') {
            if (params.findcity != '') {
                redirect(controller: 'city', params: [city: params.findcity])
            }
        }
    }
    
    def addPlace() {
        if (session.user) {
            if (request.method == 'POST') {
                
                def place = new Place()
                def city = City.findByName(params.city)
                
                for (param in params) {
                    if (param.key == 'city') {
                        place.city = city
                    } else {
                        place.properties[param.key] = param.value
                    }
                }
                
                println place.properties
                
                if (!place.save()) {
                    render(view: 'index', model: [city: params.city, place: place])
                } else {
                    redirect(controller: 'place', params: [id: place.id])
                }
            }
        }
    }
    
}
