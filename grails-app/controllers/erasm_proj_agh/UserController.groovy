package erasm_proj_agh

class UserController {
    
    def register = {
        if (request.method == 'POST') {
            def user = new User(params)
            
            user.details = new UserDetails(params)
            
            user.passwordHashed = params.password.encodeAsPassword()
            if (!user.save()) {
                render(view: 'register', model: [user: user])
            } else {
                session.user = user
                redirect(controller: 'main')
            }
        } else if (session.user) {
            redirect(controller: 'main')
        }
    }

    def login = {
        if (request.method == 'POST') {
            def passwordHashed = params.password.encodeAsPassword()
            def user = User.findByUsernameAndPasswordHashed(params.username, passwordHashed)
            if (user) {
                session.user = user
                session.user.details = user.details
                redirect(controller: 'main')
            } else {
                flash.message = "User not found or password incorrect"
                redirect(controller: 'main')
            }
        } else if (session.user) {
            redirect(controller:'main')
        }
    }

    def logout = {
        session.invalidate()
        redirect(controller:'main')
    }
    
}
