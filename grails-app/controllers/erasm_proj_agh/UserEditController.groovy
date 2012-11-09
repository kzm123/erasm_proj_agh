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
	
	def uploadProfilePhoto() {
		def user = session.user
		
		def file = request.getFile('profilePhoto')
		
		def types = ['image/png', 'image/jpeg', 'image/gif']
		if (!types.contains(file.getContentType())) {
			flash.message = "Photo must be one of: ${types}"
			render(view:'edit', model:[user:user])
			return;
		}
		
		def extension = ""
		
		switch (file.getContentType()) {
			case 'image/png':
				extension = "png"
				break
			case 'image/jpeg':
				extension = "jpg"
				break
			case 'image/gif':
				extension = "gif"
				break
		}
		
		session.user.profilePhoto = user.username + "." + extension
		
		if (!file.isEmpty()) {
			file.transferTo(new File("web-app/images/" + user.username + "." + extension))
		} else {
			flash.message = "File ${file.inspect()} was empty!"
			render(view:'edit', model:[user:user])
			return;
		}
		
		flash.message = "Photo uploaded successfully."
        redirect(controller:'main')
	}	

}
