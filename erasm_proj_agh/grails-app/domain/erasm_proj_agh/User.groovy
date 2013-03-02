package erasm_proj_agh

class User {

    transient springSecurityService
    
    static searchable = {
        mapping {
            boost 2.0
            spellCheck "include"
        }
    }

    static hasMany = [userCities: UserCity, statuses: Status, friends: User]
    static hasOne = [details: UserDetails]

    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    
    String profilePhoto

    static constraints = {
        username blank: false, unique: true, size: 5..30, matches: /[-_a-zA-Z0-9]+/
        password blank: false
        profilePhoto blank: true, nullable: true
        details blank: false, nullable: false
    }

    static mapping = {
        table 'users'
        password column: '`password`'
    }

    Set<Authority> getAuthorities() {
        UserAuthority.findAllByUser(this).collect { it.authority } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
    
    public addFriend(user) {
        friends.add(user)
    }
    
    public deleteFriend(user) {
        friends.remove(user)
    }
    
    public isMyFriend(user) {
        friends.contains(user)
    }
    
}
