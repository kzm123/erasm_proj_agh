package erasm_proj_agh

import grails.test.GrailsUnitTestCase

/*
 * --------------------
 * Michał Darkowski
 * >Biszu<
 * --------------------
 */

@TestFor(City)
class CityTests {
	def existingCity = new City (
		name: "Madryt kolego",
		description: "wspaniale miasto z przykladowym opisem",
		confirmed: true,
		country: new Country()
	)

	void testValidate() {
		mockForConstraintsTests(City, [existingCity])
		assert existingCity.validate()
	}

	void testName() {
		mockForConstraintsTests(City, [existingCity])

		// name = null
		existingCity.name = null
		assertFalse existingCity.validate()
		assertEquals "nullable", existingCity.errors["name"]

		// too long name
		existingCity.name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingCity.validate()
		assertEquals "size", existingCity.errors["name"]

		// too short name
		existingCity.name = "A"
		assertFalse existingCity.validate()
		assertEquals "size", existingCity.errors["name"]

		// name is blank
		existingCity.name = ""
		assertFalse existingCity.validate()
		assertEquals "blank", existingCity.errors["name"]

		// strange characters
		existingCity.name = "asasas:as.ałsas"
	}

	void testDescription() {
		mockForConstraintsTests(City, [existingCity])

		// description = null
		existingCity.description = null
		assertTrue existingCity.validate()

		// too long description
		existingCity.description = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingCity.validate()
		assertEquals "size", existingCity.errors["description"]

		// description is blank
		existingCity.description = ""
		assertTrue existingCity.validate()

		// strange characters
		existingCity.description = "asasas:as.ałsas"
		assertTrue existingCity.validate()
	}

	void testConfirmed() {
		mockForConstraintsTests(City, [existingCity])

		// confirmed = null
		shouldFail(IllegalArgumentException) {
		existingCity.confirmed = null
		}

		// confirmed is blank
		existingCity.confirmed = ""
		assertTrue existingCity.validate()
		assertFalse existingCity.confirmed

		// confirmed is not boolean
		existingCity.confirmed = new Date()
		assertTrue existingCity.validate()
		assertTrue existingCity.confirmed
	}
}