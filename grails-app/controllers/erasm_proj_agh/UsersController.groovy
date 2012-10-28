package erasm_proj_agh

class UsersController {
    
    def register = {
        if (request.method == 'POST') {
            def u = new Users(params)
            u.passwordHashed = params.password.encodeAsPassword()
            if (!u.save()) {
                // validation failed, render registration page again
                return [users:u]
            } else {
                // validate/save ok, store user in session, redirect to homepage
                session.users = u
                redirect(controller:'main')
            }
        } else if (session.users) {
            // if user is logged in, redirect to main
            redirect(controller:'main')
        }
    }

    def login = {
        if (request.method == 'POST') {
            def passwordHashed = params.password.encodeAsPassword()
            def u = Users.findByUsernameAndPasswordHashed(params.username, passwordHashed)
            if (u) {
                session.users = u
                redirect(controller:'main')
            } else {
                flash.message = "User not found or password incorrect"
                redirect(controller:'main')
            }
        } else if (session.users) {
            // if user is logged in, redirect to main
            redirect(controller:'main')
        }
    }

    def logout = {
        session.invalidate()
        redirect(controller:'main')
    }
    
}
