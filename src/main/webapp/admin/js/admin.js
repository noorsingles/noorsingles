var adminModule = angular.module('admin', ['ui.bootstrap', 'ui.router']);

adminModule.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/login');

    $stateProvider

            .state('login', {
                url: '/login',
                templateUrl: 'login.html'
            })
            .state('main', {
                url: '/main',
                templateUrl: 'main.html'
            });

});


adminModule.controller('SearchController', function ($scope, $http, $location) {

    var checkLoggedIn = function () {
        var url = '../adminapi/isAuthenticated';
        $http.get(url)
                .success(function (data, status) {

                }).error(function (data, status) {
            $location.url('login');
        });
    };

    checkLoggedIn();

    $scope.searchForId = function () {
        console.log('searchForId');
        var url = '../api/getPrivateProfile';
        $http.get(url, {
            params: {
                id: $scope.id
            }
        }).success(function (data) {
           
            $scope.mainProfile = data;
            $scope.mainProfile.privateFields.push({label: "ID", value: $scope.id});
            $scope.mainProfile.id=$scope.id;
            
             data.privateFields.forEach(function(field){
              if(field.label == "Email"){
                  $scope.mainProfile.email=field.value;
              }
            });
        });
    };
    
    
    $scope.matches = [];
    
    $scope.searchForMatchId = function () {
        var url = '../api/getPrivateProfile';
        $http.get(url, {
            params: {
                id: $scope.matchId
            }
        }).success(function (data) {
            
            var profile={};
            profile = data;
            profile.id=$scope.matchId;
            profile.privateFields.push({label: "ID", value: $scope.matchId});
            
             data.privateFields.forEach(function(field){
              if(field.label === "Email"){
                  profile.email=field.value;
              }
            });

           $scope.matches.push(profile);
            
        });
    };
    
    $scope.goToEmailProfile = function () {
        console.log("go to email profile");
        $location.url('../datatable#/profileByEmail/' + $scope.email);
    };

    $scope.logout = function () {
        var url = '../adminapi/logout';
        $http.get(url, {
        }).success(function (data, status) {
            $location.url('login');
        }).error(function (data, status) {
        });
    };

});

adminModule.controller('LoginController', function ($scope, $http, $location) {

    var login = function (username, password) {

        var url = '../adminapi/login';

        $http({
            url: url,
            method: "POST",
            params: {'username': username, 'paswd': password},
            data: {},
            withCredentials: true
        }).success(function (data, status, headers, config) {
            console.log(status);
            if (status === 202) {
                console.log("Logged in");
                $location.url('main');
            }
        }).error(function (data, status, headers, config) {
            if (status === 401) {
                console.log("Invalid Username or password");
            }
        });


//        $http.get('',
//        {'params':params}).
//                success(function (data, status, headers, config) {
//                    console.log(status);
//                    // this callback will be called asynchronously
//                    // when the response is available
//                }).
//                error(function (data, status, headers, config) {
//                    // called asynchronously if an error occurs
//                    // or server returns response with an error status.
//                });
    };

    $scope.submit = function () {
        login($scope.username, $scope.password);
    };




});

adminModule.controller('AlertDemoCtrl', function ($scope) {
    $scope.alerts = [
        {type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.'},
        {type: 'success', msg: 'Well done! You successfully read this important alert message.'}
    ];

    $scope.addAlert = function () {
        $scope.alerts.push({msg: 'Another alert!'});
    };

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };
});
