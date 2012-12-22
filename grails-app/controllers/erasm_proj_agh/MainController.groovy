package erasm_proj_agh

class MainController {

    def index() {
        if (session.username) {
            redirect(controller: 'user')
        }
    }
    
}
