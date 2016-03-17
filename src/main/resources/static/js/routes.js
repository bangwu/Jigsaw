module.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/user/loginPage', {
            templateUrl: '/template/login.html',
            controller: 'userLoginCtrl'
        })
        .otherwise({redirectTo: '/'});
}]);