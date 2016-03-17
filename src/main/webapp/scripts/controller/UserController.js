module.controller('UserController', ['$scope', '$location', 'UserService', function ($scope, $location, UserService) {
    var _this = this;
    _this.login = function () {
        UserService.validateUser({username: _this.username, password: _this.password}).then(function (data) {
            if(data.data.STATUS === "OK"){
                $location.path("/")
            }else{
                $location.path("/user/loginPage")
            }
        })
    }
}]);