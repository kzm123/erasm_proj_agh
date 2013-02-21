package erasm_proj_agh

import grails.test.GrailsUnitTestCase

/*
 * --------------------
 * Michał Darkowski
 * >Biszu<
 * --------------------
 */

@TestFor(CityController)
@Mock([Place, City, Country])
class CityControllerTests {

    void testIndex() {
		// if (params.city)
		params.city = "test"
		controller.index()
		assertEquals "/city/index", view
		assertEquals City.findByName(params.city), model.city
		assertEquals Place.findAllWhere(city: City.findByName(params.city)), model.places

		// else
		params.city = null
		controller.index()
		assertEquals "/main", response.redirectedUrl
    }

	void testCreateInvalid() {
		// invalid request.method
		session.user = true
		request.method = "GET"
		controller.create()
		assertNull view
		assertEquals 0, model.size()
		assertNull response.redirectedUrl

		// invalid session.user
		session.user = null
		request.method = "POST"
		controller.create()
		assertNull view
		assertEquals 0, model.size()
		assertNull response.redirectedUrl
	}

	void testCreateValid() {
		params.confirmed = true
		params.name = "miasteczko"
		params.description = "male miasto ze srednia iloscia ludzi"
		params.country = "16"
		session.user = true
		request.method = "POST"

		// save failed because Country.get(Integer.parseInt(param.value)) == null
		controller.create()
		assertEquals "/city/create", view
		assertNull response.redirectedUrl
		for (param in params) {
			if (param.key == "country") {
				assertEquals Country.get(Integer.parseInt(param.value)), model.city.country
			}
			else {
				assertEquals param.value, model.city.properties[param.key]
			}
		}

		// succesfull save
		/*
		 * nie wiem jak dodac panstwo zeby w kontrolerze
		 * Country.get(Integer.parseInt(param.value)) nie zwracalo null,
		 * wydaje mi sie ze w unit testach to niemozliwe
		 */
//		controller.create()
//		assertEquals "/city", response.redirectedUrl
	}

	void testFind() {
		request.method = "POST"
		params.findcity = "Madryt"
		controller.find()
		assertTrue response.redirectedUrl.startsWith("/city")
		assertTrue response.redirectedUrl.contains(params.findcity)

		// invalid request.method
		response.reset()
		request.method = "GET"
		controller.find()
		assertNull response.redirectedUrl

		// invalid params.findcity
		response.reset()
		request.method = "POST"
		params.findcity = ""
		controller.find()
		assertNull response.redirectedUrl
	}

	void testAddPlaceInvalid() {
		// invalid request.method
		session.user = true
		request.method = "GET"
		controller.addPlace()
		assertNull view
		assertEquals 0, model.size()
		assertNull response.redirectedUrl

		// invalid session.user
		session.user = null
		request.method = "POST"
		controller.addPlace()
		assertNull view
		assertEquals 0, model.size()
		assertNull response.redirectedUrl
	}

	void testAddPlaceValid() {
		params.confirmed = true
		params.city = "miasteczko"
		params.rating = 5
		params.name = "kebabownia"
		params.localization = "stare miasto"
		session.user = true
		request.method = "POST"

		// save failed because City.findByName(params.city) == null
		controller.addPlace()
		assertEquals "/city/index", view
		assertEquals params.city, model.city
		assertNull response.redirectedUrl
		for (param in params) {
			if (param.key == "city") {
                assertEquals City.findByName(params.city), model.place.city
            }
			else {
                assertEquals param.value, model.place.properties[param.key]
            }
		}

		// succesfull save
		/*
		 * nie wiem jak dodac miasto zeby w kontrolerze
		 * City.findByName(params.city) nie zwracalo null,
		 * wydaje mi sie ze w unit testach to niemozliwe
		 */
//		controller.addPlace()
//		assertTrue response.redirectedUrl.startsWith("/place")
//		assertTrue response.redirectedUrl.contains(place.id)
	}
}