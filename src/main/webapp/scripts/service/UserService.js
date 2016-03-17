module.factory("UserService", ["$http", function ($http) {
    function validateUser(user) {
        return $http.post("/user/login", user);
    }

    return {
        validateUser: validateUser
    }
}]);