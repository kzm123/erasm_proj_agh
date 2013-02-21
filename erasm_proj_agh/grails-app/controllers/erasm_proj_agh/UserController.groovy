package erasm_proj_agh

import java.lang.invoke.SpreadGeneric;

import erasm_proj_agh.Authority;
import erasm_proj_agh.City;
import erasm_proj_agh.Country;
import erasm_proj_agh.Status;
import erasm_proj_agh.User;
import erasm_proj_agh.UserAuthority;
import erasm_proj_agh.UserCity;
import erasm_proj_agh.UserDetails;
import grails.plugins.springsecurity.SpringSecurityService;


class UserController {
    
    def springSecurityService
    
    def index() {
        if (springSecurityService.isLoggedIn()) {
            redirect(action: 'show', params: [user: springSecurityService.principal.username])
        } else {
            redirect(controller: 'main')
        }
    }
    
    private showUser(user) {
        def messages = currentUserTimeline(user.username)
        
        def isCurrentUser = false
        def isMyFriend = false
       
        if (user.username == springSecurityService.principal.username) {
            isCurrentUser = true
            isMyFriend = false
        } else {
            isCurrentUser = false
            User me = User.get(springSecurityService.principal.id)
            isMyFriend = me.isMyFriend(user)
        }
        
        render(view: 'show', model: [user: user, messages: messages, isCurrentUser: isCurrentUser, isMyFriend: isMyFriend])
    }
    
    def show() {
        if (params.user) {
            def user = User.findByUsername(params.user)
            showUser(user)
            
        } else if (params.id) {
            def user = User.get(params.id)
            showUser(user)
            
        } else if (springSecurityService.isLoggedIn()) {
            redirect(action: 'show', params: [user: springSecurityService.principal.username])
            
        } else {
            redirect(controller: 'main')
        }
    }
    
    def register() {
        if (springSecurityService.isLoggedIn()) {
            redirect(action: 'show', params: [user: springSecurityService.principal.username])
        } else if (request.method == 'POST') {
        
            def details = new UserDetails(params)
            def user = new User(username: params.username, password: params.password, 
                                details: details, enabled: true, profilePhoto: null)
            
            if (params.password != params.confirm) {
                user.validate()
                user.errors.rejectValue('password', 'user.password.doesnotmatch')
                render(view: 'register', model: [user: user])
            } else if (!user.save()) {
                render(view: 'register', model: [user: user])
            } else {
                Authority.withTransaction {
                    def userRole = new Authority(authority: 'ROLE_USER').save()
                    UserAuthority.create(user, userRole, true)
                }
                
                springSecurityService.reauthenticate(params.username)   // auto login user
                redirect(action: 'show', params: [user: params.username])
            }
            
        }
    }

    def edit() {
        if (springSecurityService.isLoggedIn()) {
            if (request.method == 'POST') {
                def user = User.get(springSecurityService.principal.id)
                
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
                        
                    } else if (param.value == null || param.value == "") {
                        user.details.properties[param.key] = null
                    } else {
                        user.details.properties[param.key] = param.value
                    }
                }
                
                if (params.password != params.confirm) {
                    user.validate()
                    user.errors.rejectValue('password', 'user.password.doesnotmatch')
                    render(view: 'edit', model: [user: user])
                    
                } else {
                    if (params.password != null && params.password != "") {
                        user.password = params.password
                    }
                    if (!user.save()) {
                        render(view: 'edit', model: [user: user])    
                    } else {
                        showUser(user)
                    }
                }
                
            } else {
                def user = User.get(springSecurityService.principal.id)
                render(view: 'edit', model: [user: user])
            }
        }
    }
    
    def uploadProfilePhoto() {
        def user = User.get(springSecurityService.principal.id)
        
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
            
            file.transferTo(
                new File(grailsAttributes.getApplicationContext().getResource("images/").getFile().toString() 
                    + File.separatorChar + filename))
            
            user.profilePhoto = filename
        
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
        def user = User.get(springSecurityService.principal.id)
        
        if (user.profilePhoto != null) {
            File oldPhoto = new File(grailsAttributes.getApplicationContext().getResource("images/").getFile().toString() + File.separatorChar + user.profilePhoto)
            if (oldPhoto.exists()) {
                oldPhoto.delete()
            }
            
            user.profilePhoto = null
            user.save()
            
            flash.message = "Photo deleted successfully."
            
            render(view: "edit", model: [user: user])
        } else {
            render(view: "edit", model: [user: user])
        }
    }
    
    def signInToCity() {
        if (springSecurityService.isLoggedIn()) {
            def user = User.get(springSecurityService.principal.id)
            def city = City.get(params.id)
            
            UserCity.link(user, city)
            
            user.save()
            city.save()
            
            redirect(controller: 'city', action: 'show', params: [id: city.id])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def signOutFromCity() {
        if (springSecurityService.isLoggedIn()) {
            def user = User.get(springSecurityService.principal.id)
            def city = City.get(params.id)

            UserCity.unlink(user, city)
            
            user.save()
            city.save()
            
            redirect(controller: 'city', action: 'show', params: [id: city.id])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def updateStatus() {
        def status = new Status(message: params.message)
        status.author = User.get(springSecurityService.principal.id)
        status.user = User.findByUsername(params.username)
        status.save(flush: true)
        
        def messages = currentUserTimeline(params.username)
        
        render(template: 'messages', collection: messages, var: 'message')
    }
    
    private currentUserTimeline(username) {
        Status.withCriteria {
            user {
                eq 'username', username
            }
            maxResults 10
            order 'dateCreated', 'desc'
        }
    }
    
    def addFriend() {
        User user = User.get(springSecurityService.principal.id)
        User friend = User.get(params.id)
        user.addFriend(friend)
        user.save()
        redirect(controller: 'user', action: 'show', params: [id: params.id])
    }
    
    def deleteFriend() {
        User user = User.get(springSecurityService.principal.id)
        User friend = User.get(params.id)
        user.deleteFriend(friend)
        user.save()
        redirect(controller: 'user', action: 'show', params: [id: params.id])
    }
    
}
