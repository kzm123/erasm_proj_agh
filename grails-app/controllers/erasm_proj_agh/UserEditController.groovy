package erasm_proj_agh

class UserEditController {

    def edit() {
        if ((request.method == 'POST') && session.user) {
            def user = session.user
            def domainUser = User.get(user.id)
            
            for (param in params) {
                if (param.value == "") {
                    domainUser.details.properties.put(param.key, null)
                } else {
                    domainUser.details.properties.put(param.key, param.value)
                }
            }
            
            if (params['gender'] == 'true') {
                domainUser.details.properties.put('gender', true)
            } else {
                domainUser.details.properties.put('gender', false)
            }
            
            if (params['password'] != "") {
                domainUser.passwordHashed = params.password.encodeAsPassword()
            }
            
            if (!domainUser.details.save()) {
                if (!domainUser.details.save()) {
                    render(view: 'edit', model: [userDetails: domainUser.details, user: domainUser])
                }
            }
            
            for (param in params) {
                if (param.value == "") {
                    user.details.properties.put(param.key, null)
                } else {
                    user.details.properties.put(param.key, param.value)
                }
            }
            
            if (params['gender'] == 'true') {
                user.details.properties.put('gender', true)
            } else {
                user.details.properties.put('gender', false)
            }
            
            render(view: 'edit', model: [userDetails: domainUser.details, user: domainUser])
        } else if (!session.user) {
            redirect(controller:'main')
        }
    }
    
    def uploadProfilePhoto() {
        def user = session.user
        def domainUser = User.get(user.id)
        
        def file = request.getFile('profilePhoto')
        
        def types = ['image/png', 'image/jpeg', 'image/gif']
        if (!types.contains(file.getContentType())) {
            flash.message = "Photo must be one of: ${types}"
            render(view: 'edit', model: [user: user])
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
        
        if (user.profilePhoto != null) {
            File oldPhoto = new File(user.profilePhoto)
            if (oldPhoto.exists()) {
                oldPhoto.delete()
            }
        }
        
        String filename = user.username + "." + extension
        
        user.profilePhoto = filename
        domainUser.profilePhoto = filename
        
        if (!domainUser.save()) {
            println "save error"
            domainUser.errors.allErrors.each { println it }
        }
        
        if (!file.isEmpty()) {
            println grailsAttributes.getApplicationContext().getResource("images/").getFile().toString() + File.separatorChar + filename
            file.transferTo(new File(grailsAttributes.getApplicationContext().getResource("images/").getFile().toString() + File.separatorChar + filename))
        } else {
            flash.message = "File ${file.inspect()} was empty!"
            render(view: 'edit', model: [user: user])
            return;
        }
        
        flash.message = "Photo uploaded successfully."
        redirect(controller: 'main')
    }
    
    def deleteProfilePhoto() {
        def user = session.user
        def domainUser = User.get(user.id)
        
        if (user.profilePhoto != null) {
            File oldPhoto = new File(grailsAttributes.getApplicationContext().getResource("images/").getFile().toString() + File.separatorChar + domainUser.profilePhoto)
            if (oldPhoto.exists()) {
                oldPhoto.delete()
            }
            
            user.profilePhoto = null
            domainUser.profilePhoto = null
            domainUser.save()
            
            flash.message = "Photo deleted successfully."
        }
        redirect(controller: 'main')
    }

}
