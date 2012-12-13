package erasm_proj_agh

/*
 * --------------------
 * Maciek Prokopiuk
 * --------------------
 */

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*

@TestFor(User)
class UserTests{
    
    void testTrue() {
        println "All params set right."
       

         

         def jane = new User(username:"newTestUser",
                            password:"password",
                            confirm:"password",
                            passwordHashed:"adsadadaaa",
                            profilePhoto:"",
                            details:["userName", "userSurname", true]
         )

         mockForConstraintsTests(User, [jane])
         assertTrue  jane.validate()

         
     }
     
    
     void testUsername() {
        println "Wrong username variations."
        println "#"*20
        println "Null username"
        println "Min size username"
         println "Max size username"
        println "Unique username"
        println "Blank username"
         println "Username with white space"
         println "Polish signs in username"
        

        

         def jane = new User(username:"newTestUser",
                            password:"password",
                            confirm:"password",
                            passwordHashed:"adsadadaaa",
                            profilePhoto:"",
                            details:["userName", "userSurname", true]
         )
          def test = new User(username:"testUser",
                            password:"password",
                            confirm:"password",
                            passwordHashed:"adsadadaaa",
                            profilePhoto:"",
                            details:["userName", "userSurname", true]
         )

         mockForConstraintsTests(User, [jane, test])
        
        //username null test
        jane.username = null
        assertFalse jane.validate()
        assertEquals "nullable", jane.errors["username"]
        
        //username min size test
        jane.username = "ntsa"
         assertFalse  jane.validate()
         assertEquals "size", jane.errors["username"]
         
         //username max size test
        jane.username = "adaasdasdadddddddddddddddddddddddddddddaodkoasdkaodkaodkasodak"
         assertFalse  jane.validate()
         assertEquals "size", jane.errors["username"]
        
        
        //username unique test
        jane.username = "testUser"
        assertFalse  jane.validate()
        assertEquals "unique", jane.errors["username"]
   
        //username blank test     
        jane.username = ""
        assertFalse jane.validate()
        assertEquals "blank", jane.errors["username"]
        
        //username matches test
        jane.username = "user name"
        assertFalse jane.validate()
        assertEquals "matches", jane.errors["username"]
        
        //Polish signs
         jane.username = "uśęreczek"
        assertFalse jane.validate()
        assertEquals "matches", jane.errors["username"]
        
        
        
    }
     
    void testPassword() {
         
        def jane = new User(username:"newTestUser",
                            password:"password",
                            confirm:"password",
                            passwordHashed:"adsadadaaa",
                            profilePhoto:"",
                            details:["userName", "userSurname", true]
         )
         mockForConstraintsTests(User, [jane])

         assertTrue  jane.validate()
         
        //password DontMatch
        jane.password = "asdadas"
        assertFalse jane.validate()
        assertEquals "user.password.validator", jane.errors["password"]
        
        //password min size
        jane.password = "adA"
        assertFalse jane.validate()
        assertEquals "size", jane.errors["password"]
        
        //password max size
        jane.password = "adAsadkdsakoadkasokdaoskdaoskdoaksaokdaodksodkasodkaos[kdaoskdasokdaoskdas"
        assertFalse jane.validate()
        assertEquals "size", jane.errors["password"]
        
        println "Password is blank"
        jane.password = ""
        jane.confirm = ""
        assertFalse jane.validate()
        //password is null - czy to ma jakikolwiek sens? chyba nie.
        
        println "Password is null"
        jane.password = null
        jane.confirm = null
        assertFalse jane.validate()
        
     }
}
