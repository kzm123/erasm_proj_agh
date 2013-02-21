
package erasm_proj_agh



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Country)
class CountryTests {

    
    //państwo ma wiele szczegółów usera? eeee.
    
    void testName() {
       
        println "Wrong country name variations."
        println "#"*20
        
        def test = new Country(
                          name:"testCountry",
                          description:"testDescription"

         )
         
       assertTrue test.validate() 
       
        
        println "Name is null"
        test.name = null
        assertFalse test.validate()
        
        
        println "Name is blank"
        test.name = ""
        assertFalse test.validate()
        
        println "Name with polish signs"
        test.name = "pąńśtwó"
        assertTrue test.validate()
        
        println "Description is null"
        test.description = null
        assertTrue test.validate()
        
        println "Description is blank"
        test.description = ""
        assertTrue test.validate()
    }
}
