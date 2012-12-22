package erasm_proj_agh

import grails.test.GrailsUnitTestCase

/*
 * --------------------
 * Michał Darkowski
 * >Biszu<
 * --------------------
 */

@TestFor(PlaceController)
@Mock(Place)
class PlaceControllerTests {

	void testIndex() {
		// if (params.id)
		params.id = "16"
		controller.index()
		assertEquals "/place/index", view
		assertEquals Place.get(Integer.parseInt(params.id)), model.place

		// else
		params.id = null
		controller.index()
		assertEquals "/main", response.redirectedUrl
	}
}