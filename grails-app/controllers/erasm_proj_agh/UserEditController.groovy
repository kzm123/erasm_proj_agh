package erasm_proj_agh

class UserEditController {

    def edit() {
		if ((request.method == 'POST') && session.user) {
			for (param in params) {
				session.user.details.properties[param.key] = param.value
			}
			session.user.details.save()
            redirect(controller:'main')
	    } else if (!session.user) {
			// user not logged in, redirect to main page
            redirect(controller:'main')
	    }
	}
}
