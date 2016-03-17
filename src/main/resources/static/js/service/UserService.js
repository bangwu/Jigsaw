module.factory("userService", ["$http", function ($http) {
    function getLoginPage() {
        return $http.get("/api/pets")
    }

    return {
        login: getLoginPage
    }
}]);