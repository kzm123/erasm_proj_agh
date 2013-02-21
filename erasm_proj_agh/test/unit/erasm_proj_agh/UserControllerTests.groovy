package erasm_proj_agh

/*
 * --------------------
 * Maciek Prokopiuk
 * --------------------
 */
import grails.test.GrailsUnitTestCase
import org.codehaus.groovy.grails.plugins.testing.GrailsMockMultipartFile


@TestFor(UserController)
@Mock(User)


class UserControllerTests{

        void testLogin(){
          mockCodec(PasswordCodec) 
             
           request.method = "POST"
           params.password = "haslo"
           params.username = "testUser"
           
           controller.login()
           assert response.redirectedUrl == '/main' 
        }
       
        void testLogout() {
            // testing if default session is null
            assertNull controller.session.user
            // creating new session user and testing if it is not null
            controller.session.user = new User()
            assertNotNull controller.session.user
            controller.logout()
            // testing redirection after logout
            assertEquals "/main", controller.response.redirectedUrl
            // testing session invalidation
            assertNull controller.session.user
        }
       
        void testRegister(){
        mockForConstraintsTests(User)
        mockCodec(PasswordCodec) 
        
        request.method = "POST"
        params.username = "testUser"
        params.password = "testPasswd"
        params.confirm = "testPasswd"
        params.name = "Maciek"
        params.surname = "Prokopiuk"
        params.gender = true
        
        controller.register()
        assert response.redirectedUrl == '/main' 
      }
    

      
}
