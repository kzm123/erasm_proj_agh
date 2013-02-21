package erasm_proj_agh

import grails.test.GrailsUnitTestCase

/*
 * --------------------
 * Michał Darkowski
 * >Biszu<
 * --------------------
 */

@TestFor(UserDetails)
class UserDetailsTests {
	def existingUserDetails = new UserDetails (
		name: "Marian",
		surname: "Januszowaty",
		gender: true,
		email: "mar.jan@gmail.com",
		city: "Bdziszewo",
		address: "Polna 1",
		country: new Country(),
		dateOfBirth: new Date(),
		university: "Wyższa Szkoła Segregacji Żywnoci",
		highSchool: "Taki Tam Ogólniak Bez Palarni",
		workPlace: "Firma",
		user: new User(),
		phone: 510236236
	)

	void testValidate() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])
		assert existingUserDetails.validate()
	}

	void testName() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// name = null
		existingUserDetails.name = null
		assertFalse existingUserDetails.validate()
		assertEquals "nullable", existingUserDetails.errors["name"]

		// too long name
		existingUserDetails.name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["name"]

		// too short name
		existingUserDetails.name = "A"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["name"]

		// name is blank
		existingUserDetails.name = ""
		assertFalse existingUserDetails.validate()
		assertEquals "blank", existingUserDetails.errors["name"]

		// illegal character
		existingUserDetails.name = "asasas:asasas"
		assertFalse existingUserDetails.validate()
		assertEquals "matches", existingUserDetails.errors["name"]

		// illegal character
		existingUserDetails.name = "ewwwe,wewe"
		assertFalse existingUserDetails.validate()
		assertEquals "matches", existingUserDetails.errors["name"]

		// regional character
		existingUserDetails.name = "Michał"
		assertTrue existingUserDetails.validate()
	}

	void testSurname() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// surname = null
		existingUserDetails.surname = null
		assertFalse existingUserDetails.validate()
		assertEquals "nullable", existingUserDetails.errors["surname"]

		// too long surname
		existingUserDetails.surname = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["surname"]

		// too short surname
		existingUserDetails.surname = "A"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["surname"]

		// surname is blank
		existingUserDetails.surname = ""
		assertFalse existingUserDetails.validate()
		assertEquals "blank", existingUserDetails.errors["surname"]

		// illegal character
		existingUserDetails.surname = "asasas:asasas"
		assertFalse existingUserDetails.validate()
		assertEquals "matches", existingUserDetails.errors["surname"]

		// illegal character
		existingUserDetails.surname = "ewwwe,wewe"
		assertFalse existingUserDetails.validate()
		assertEquals "matches", existingUserDetails.errors["surname"]

		// regional character
		existingUserDetails.surname = "Michał"
		assertTrue existingUserDetails.validate()
	}

	void testGender() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// gender = null
		shouldFail(IllegalArgumentException) {
			existingUserDetails.gender = null
		}

		// gender is blank
		existingUserDetails.gender = ""
		assertTrue existingUserDetails.validate()
		assertFalse existingUserDetails.gender

		// gender is not boolean
		existingUserDetails.gender = new Date()
		assertTrue existingUserDetails.validate()
		assertTrue existingUserDetails.gender
	}

	void testEmail() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// email = null
		existingUserDetails.email = null
		assertTrue existingUserDetails.validate()

		// too long email
		existingUserDetails.email = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA@AAAAAAAAAAAAA.AA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["email"]

		// too short email
		existingUserDetails.email = "A@A.A"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["email"]

		// email is blank
		existingUserDetails.email = ""
		assertTrue existingUserDetails.validate()
		assertNull existingUserDetails.errors["email"]

		// not email syntax
		existingUserDetails.email = "AAAA@AAA"
		assertFalse existingUserDetails.validate()
		assertEquals "email", existingUserDetails.errors["email"]

		// valid email
		existingUserDetails.email = 'valid@country.nl'
		assertTrue existingUserDetails.validate()
	}

	void testCity() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// city = null
		existingUserDetails.city = null
		assertTrue existingUserDetails.validate()

		// too long city
		existingUserDetails.city = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["city"]

		// too short city
		existingUserDetails.city = "A"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["city"]

		// city is blank
		existingUserDetails.city = ""
		assertTrue existingUserDetails.validate()

		// strange character
		existingUserDetails.city = "asa,sas:as`as~ałs"
		assertTrue existingUserDetails.validate()
	}

	void testAddress() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// address = null
		existingUserDetails.address = null
		assertTrue existingUserDetails.validate()

		// too long address
		existingUserDetails.address = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["address"]

		// too short address
		existingUserDetails.address = "AA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["address"]

		// address is blank
		existingUserDetails.address = ""
		assertTrue existingUserDetails.validate()

		// strange character
		existingUserDetails.address = "asa,sas:as`as~ałs"
		assertTrue existingUserDetails.validate()
	}

	void testCountry() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// country = null
		existingUserDetails.country = null
		assertTrue existingUserDetails.validate()

		// country is blank
		shouldFail(ClassCastException) {
			existingUserDetails.country = ""
		}

		// country is not country
		shouldFail(ClassCastException) {
			existingUserDetails.country = new Date()
		}

		// country is not country
		shouldFail(ClassCastException) {
			existingUserDetails.country = "takie tam"
		}

		// country is ok
		existingUserDetails.country = new Country(name: "Bdziszewo", description: "małe miasto z dużš ilociš ludzi")
		assertTrue existingUserDetails.validate()
	}

	void testDateOfBirth() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// dateOfBirth = null
		existingUserDetails.dateOfBirth = null
		assertTrue existingUserDetails.validate()

		// dateOfBirth is blank
		shouldFail(ClassCastException) {
			existingUserDetails.dateOfBirth = ""
		}

		// dateOfBirth is not date
		shouldFail(ClassCastException) {
			existingUserDetails.dateOfBirth = new Long(1)
			println existingUserDetails.dateOfBirth
		}

		// dateOfBirth is not date
		shouldFail(ClassCastException) {
			existingUserDetails.dateOfBirth = "takie tam"
		}

		// dateOfBirth is ok
		existingUserDetails.dateOfBirth = new Date(6854196851968541)
		assertTrue existingUserDetails.validate()
	}

	void testUniversity() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// university = null
		existingUserDetails.university = null
		assertTrue existingUserDetails.validate()

		// too long university
		existingUserDetails.university = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["university"]

		// too short university
		existingUserDetails.university = "A"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["university"]

		// university is blank
		existingUserDetails.university = ""
		assertTrue existingUserDetails.validate()

		// strange character
		existingUserDetails.university = "asa,sas:as`as~ałs"
		assertTrue existingUserDetails.validate()
	}

	void testHighSchool() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// highSchool = null
		existingUserDetails.highSchool = null
		assertTrue existingUserDetails.validate()

		// too long highSchool
		existingUserDetails.highSchool = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["highSchool"]

		// too short highSchool
		existingUserDetails.highSchool = "A"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["highSchool"]

		// highSchool is blank
		existingUserDetails.highSchool = ""
		assertTrue existingUserDetails.validate()

		// strange character
		existingUserDetails.highSchool = "asa,sas:as`as~ałs"
		assertTrue existingUserDetails.validate()
	}

	void testWorkPlace() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// workPlace = null
		existingUserDetails.workPlace = null
		assertTrue existingUserDetails.validate()

		// too long workPlace
		existingUserDetails.workPlace = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["workPlace"]

		// too short workPlace
		existingUserDetails.workPlace = "A"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["workPlace"]

		// workPlace is blank
		existingUserDetails.workPlace = ""
		assertTrue existingUserDetails.validate()

		// strange character
		existingUserDetails.workPlace = "asa,sas:as`as~ałs"
		assertTrue existingUserDetails.validate()
	}

	void testPhone() {
		mockForConstraintsTests(UserDetails, [existingUserDetails])

		// phone = null
		existingUserDetails.phone = null
		assertTrue existingUserDetails.validate()

		// too long phone
		existingUserDetails.phone = "1231231231231235"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["phone"]

		// too short phone
		existingUserDetails.phone = "123456"
		assertFalse existingUserDetails.validate()
		assertEquals "size", existingUserDetails.errors["phone"]

		// phone is blank
		existingUserDetails.phone = ""
		assertTrue existingUserDetails.validate()

		// illegal character
		existingUserDetails.phone = "6516j5651"
		assertFalse existingUserDetails.validate()
		assertEquals "matches", existingUserDetails.errors["phone"]
	}
}