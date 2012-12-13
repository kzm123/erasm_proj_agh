package erasm_proj_agh

class UserCity {
    
    User user
    City city
    
    static UserCity link(User user, City city) {
        UserCity userCity = UserCity.findByUserAndCity(user, city);
        if (!userCity) {
            userCity = new UserCity()
            user?.addToUserCities(userCity)
            city?.addToUserCities(userCity)
            userCity.save()
        }
        return userCity
    }
    
    static void unlink(User user, City city) {
        UserCity userCity = UserCity.findByUserAndCity(user, city)
        if (userCity) {
            user.removeFromUserCities(userCity)
            city.removeFromUserCities(userCity)
            userCity.delete()
        }
    }
    
    static boolean isLinked(User user, City city) {
        UserCity userCity = UserCity.findByUserAndCity(user, city)
        if (userCity) {
            return true
        }
        return false
    }
    
    static constraints = {
    }
}
