package erasm_proj_agh

class MainController {
    
    def springSecurityService

    def index() {
        if (springSecurityService.isLoggedIn()) {
            redirect(controller: 'user')
        } else {
            redirect(controller: 'login')
        }
    }
    
}
