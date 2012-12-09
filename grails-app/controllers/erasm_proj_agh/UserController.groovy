package erasm_proj_agh

class UserController {
    
    def index() {
        if (session.username) {
            redirect(action: 'show', params: [user: session.username])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def show() {
        if (params.user) {
            def user = User.findByUsername(params.user)
            render(view: 'show', model: [user: user])
        } else if (session.username) {
            redirect(action: 'show', params: [user: session.username])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def register() {
        if (request.method == 'POST') {
            def user = new User(params)
            user.details = new UserDetails(params)
            user.passwordHashed = params.password.encodeAsPassword()
            
            if (!user.save()) {
                user.password = null
                user.confirm = null
                render(view: 'register', model: [user: user])
            } else {
                session.userid = user.id
                session.username = user.username
                redirect(action: 'show', params: [user: session.username])
            }
        } else if (session.username) {
            redirect(action: 'show', params: [user: session.username])
        }
    }

    def login() {
        if (request.method == 'POST') {
            def passwordHashed = params.password.encodeAsPassword()
            def user = User.findByUsernameAndPasswordHashed(params.username, passwordHashed)
            
            if (user) {
                session.userid = user.id
                session.username = user.username
                redirect(action: 'show', params: [user: session.username])
            } else {
                flash.message = "User not found or password incorrect"
                redirect(controller: 'main')
            }
        } else if (session.username) {
            redirect(action: 'show', params: [user: session.username])
        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: 'main')
    }

    def edit() {
        if ((request.method == 'POST') && session.userid) {
            def user = User.get(session.userid)
            
            for (param in params) {
                
                if (param.key == 'country') {
                    if (param.value != 'null') {
                        user.details.properties['country'] = Country.get(Integer.parseInt(param.value))
                    } else {
                        user.details.properties['country'] = null
                    }
                    
                } else if (param.key == 'gender') {
                    if (param.value == 'true') {
                        user.details.properties['gender'] = true
                    } else {
                        user.details.properties['gender'] = false
                    }
                    
                } else if (param.key == 'password' || param.key == 'confirm') {
                    if (param.value != '' && param.value != null) {
                        user.properties[param.key] = param.value
                    }
                    
                } else if (param.value == null || param.value == "") {
                    user.details.properties[param.key] = null
                } else {
                    user.details.properties[param.key] = param.value
                }
            }
            
            if ((params['password'] == '' || params['password'] == null) && (params['confirm'] == '' || params['confirm'] == null)) {
                user.properties['password'] = "example_password"
                user.properties['confirm'] = "example_password"
            }
            
            if (params['password'] != '' && params['password'] != null) {
                user.passwordHashed = params.password.encodeAsPassword()
            }
            
            if (!user.save()) {
                render(view: 'edit', model: [user: user])
            } else {
                redirect(action: 'show', params: [user: session.username])
            }
        } else if (session.userid) {
            def user = User.get(session.userid)
            render(view: 'edit', model: [user: user])
        } else {
            redirect(action: 'show', params: [user: session.username])
        }
    }
    
    def uploadProfilePhoto() {
        def user = User.get(session.userid)
        
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
        
        if (!file.isEmpty()) {
            if (user.profilePhoto != null) {
                File oldPhoto = new File(user.profilePhoto)
                if (oldPhoto.exists()) {
                    oldPhoto.delete()
                }
            }
            
            String filename = user.username + "." + extension
            
            file.transferTo(new File(grailsAttributes.getApplicationContext().getResource("images/").getFile().toString() + File.separatorChar + filename))
            
            user.profilePhoto = filename
            user.password = "example_password"
            user.confirm = "example_password"
        
            if (!user.save()) {
                flash.message = "Photo save error."
            } else {
                flash.message = "Photo uploaded successfully."
            }
            render(view: 'edit', model: [user: user])
        } else {
            flash.message = "File is empty!"
            render(view: 'edit', model: [user: user])
        }
    }
    
    def deleteProfilePhoto() {
        def user = User.get(session.userid)
        
        if (user.profilePhoto != null) {
            File oldPhoto = new File(grailsAttributes.getApplicationContext().getResource("images/").getFile().toString() + File.separatorChar + user.profilePhoto)
            if (oldPhoto.exists()) {
                oldPhoto.delete()
            }
            
            user.profilePhoto = null
            user.password = "example_password"
            user.confirm = "example_password"
            user.save()
            
            flash.message = "Photo deleted successfully."
            
            render(view: "edit", model: [user: user])
        } else {
            render(view: "edit", model: [user: user])
        }
    }
    
    def signInToCity() {
        if (session.userid) {
            def user = User.get(session.userid)
            user.city = City.get(params.id)
            user.password = "example_password"
            user.confirm = "example_password"
            user.save()
            redirect(controller: 'city', params: [city: user.city.name])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def signOutFromCity() {
        if (session.userid) {
            def user = User.get(session.userid)
            user.city = null
            user.password = "example_password"
            user.confirm = "example_password"
            user.save()
            redirect(controller: 'city', params: [id: params.id])
        } else {
            redirect(controller: 'main')
        }
    }
    
}
