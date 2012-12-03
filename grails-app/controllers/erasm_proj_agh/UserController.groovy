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
            redirect(controller: 'main')
        }
    }

    def logout = {
        session.invalidate()
        redirect(controller: 'main')
    }

    def edit() {
        if ((request.method == 'POST') && session.user) {
            def user = session.user
            def domainUser = User.get(user.id)
            
            for (param in params) {
                if (param.key == 'country') {
                    if (param.key == null) {
                        domainUser.details.properties['country'] = Country.get(Integer.parseInt(param.value))
                        user.details.properties['country'] = Country.get(Integer.parseInt(param.value))
                    } else {
                        domainUser.details.properties['country'] = null
                        user.details.properties['country'] = null
                    }
                } else if (param.key == 'gender') {
                    if (param.value == 'true') {
                        domainUser.details.properties['gender'] = true
                        user.details.properties['gender'] = true
                    } else {
                        domainUser.details.properties['gender'] = false
                        user.details.properties['gender'] = false
                    }
                } else if (param.key == 'password' || param.key == 'confirm') {
                    if (param.key != '') {
                        domainUser.properties[param.key] = param.value
                        user.properties[param.key] = param.value
                    }
                } else {
                    if (param.value == "" || param.value == null) {
                        domainUser.details.properties[param.key] = null
                        user.details.properties[param.key] = null
                    } else {
                        domainUser.details.properties[param.key] = param.value
                        user.details.properties[param.key] = param.value
                    }
                }
            }
            
            if (!domainUser.details.validate()) {
                render(view: 'edit', model: [userDetails: domainUser.details, user: domainUser])
                for (property in session.user.details.properties) {
                    user.details.properties.property = domainUser.details.properties.property
                }
                println "after render"
            } else {
                //domainUser.passwordHashed = params.password.encodeAsPassword()
                if (!domainUser.details.save()) {
                    println "save error"
                } else {
                    for (property in session.user.details.properties) {
                        user.details.properties.property = domainUser.details.properties.property
                    }
                    redirect(controller:'main')
                }
            }
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
