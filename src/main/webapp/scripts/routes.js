module.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/user/loginPage', {
            templateUrl: '/login.html',
            controller: 'UserController'
        })
        .when('/', {
            templateUrl: '/home.html'
        })
        .otherwise({redirectTo: '/'});
}]);