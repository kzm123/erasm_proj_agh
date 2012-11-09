package erasm_proj_agh

class UserController {
    
    def register = {
        if (request.method == 'POST') {
            def user = new User(params)
            user.details = new UserDetails(params)
			if (params['password'] != params['confirm']) {
				return [user:user]
			} else {
	            user.passwordHashed = params.password.encodeAsPassword()
	            if (!user.save()) {
	                // validation failed, render registration page again
	                return [user:user]
	            } else {
	                // validate/save ok, store user in session, redirect to homepage
	                session.user = user
					redirect(controller:'main')
	            }
			}
        } else if (session.user) {
            // if user is logged in, redirect to main
            redirect(controller:'main')
        }
    }

    def login = {
        if (request.method == 'POST') {
            def passwordHashed = params.password.encodeAsPassword()
            def user = User.findByUsernameAndPasswordHashed(params.username, passwordHashed)
            if (user) {
                session.user = user
                session.user.details = user.details
                redirect(controller:'main')
            } else {
                flash.message = "User not found or password incorrect"
                redirect(controller:'main')
            }
        } else if (session.user) {
            // if user is logged in, redirect to main
            redirect(controller:'main')
        }
    }

    def logout = {
        session.invalidate()
        redirect(controller:'main')
    }
    
}
