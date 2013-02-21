package erasm_proj_agh

class MainController {

    def index() {
        if (session.userid) {
            redirect(controller: 'user')
        }
    }
    
}
