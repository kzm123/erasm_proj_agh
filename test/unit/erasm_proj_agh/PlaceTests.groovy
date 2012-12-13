package erasm_proj_agh

import grails.test.GrailsUnitTestCase

/*
 * --------------------
 * Michał Darkowski
 * >Biszu<
 * --------------------
 */

@TestFor(Place)
class PlaceTests {
	def existingPlace = new Place (
		name: "Zapiekanki u Endziora",
		localization: "Krakow",
		rating: 4,
		confirmed: true,
		city: new City()
	)

    void testValidate() {
		mockForConstraintsTests(Place, [existingPlace])
		assert existingPlace.validate()
	}

	void testName() {
		mockForConstraintsTests(Place, [existingPlace])

		// name = null
		existingPlace.name = null
		assertFalse existingPlace.validate()
		assertEquals "nullable", existingPlace.errors["name"]

		// too long name
		existingPlace.name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingPlace.validate()
		assertEquals "size", existingPlace.errors["name"]

		// too short name
		existingPlace.name = "A"
		assertFalse existingPlace.validate()
		assertEquals "size", existingPlace.errors["name"]

		// name is blank
		existingPlace.name = ""
		assertFalse existingPlace.validate()
		assertEquals "blank", existingPlace.errors["name"]

		// strange characters
		existingPlace.name = "asasas:as.ałsas"
		assertTrue existingPlace.validate()

		// regional character
		existingPlace.name = "Michałowice"
		assertTrue existingPlace.validate()
	}

	void testLocalization() {
		mockForConstraintsTests(Place, [existingPlace])

		// localization = null
		existingPlace.localization = null
		assertFalse existingPlace.validate()
		assertEquals "nullable", existingPlace.errors["localization"]

		// too long localization
		existingPlace.localization = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingPlace.validate()
		assertEquals "size", existingPlace.errors["localization"]

		// too short localization
		existingPlace.localization = "A"
		assertFalse existingPlace.validate()
		assertEquals "size", existingPlace.errors["localization"]

		// localization is blank
		existingPlace.localization = ""
		assertFalse existingPlace.validate()
		assertEquals "blank", existingPlace.errors["localization"]

		// strange characters
		existingPlace.localization = "asasas:as.ałsas"
		assertTrue existingPlace.validate()

		// regional character
		existingPlace.localization = "Michałowice"
		assertTrue existingPlace.validate()
	}

	void testRating() {
		mockForConstraintsTests(Place, [existingPlace])

		// rating = null
		shouldFail(IllegalArgumentException) {
			existingPlace.rating = null
		}

		// rating is blank
		existingPlace.confirmed = ""
		assertTrue existingPlace.validate()

		// rating is big int
		existingPlace.confirmed = 651651651651
		assertFalse existingPlace.validate()
	}

	void testConfirmed() {
		mockForConstraintsTests(Place, [existingPlace])

		// confirmed = null
		shouldFail(IllegalArgumentException) {
			existingPlace.confirmed = null
		}

		// confirmed is blank
		existingPlace.confirmed = ""
		assertTrue existingPlace.validate()
		assertFalse existingPlace.confirmed

		// confirmed is not boolean
		existingPlace.confirmed = new Date()
		assertTrue existingPlace.validate()
		assertTrue existingPlace.confirmed
	}
}