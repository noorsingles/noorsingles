var myModule = angular.module('myModule', ['datatables', 'ngRoute']);

myModule.config(function ($routeProvider) {

    $routeProvider.
            when('/', {
                templateUrl: 'blank.html'
            }).
            when('/brothers', {
                templateUrl: 'brothers.html',
                controller: 'BrothersProfilesCtrl'
            }).
            when('/sisters', {
                templateUrl: 'sisters.html',
                controller: 'SistersProfilesCtrl'
            }).
            when('/profile/:id', {
                templateUrl: 'profile.html',
                controller: 'ViewProfileCtrl'
            }).
            when('/profileByEmail/:email', {
                templateUrl: 'profile.html',
                controller: 'ViewProfileCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
});

myModule.filter('removeP', function () {
    return function (input) {
        return input.substring(3, input.length);
    };
});

myModule.controller('BrothersProfilesCtrl', function ($scope, DTOptionsBuilder, DTColumnBuilder) {
    $scope.dtOptions = DTOptionsBuilder.fromSource('api/profiles/Male')
            .withPaginationType('full_numbers')
            .withOption('stateSave', true);

    $scope.dtColumns = [
        DTColumnBuilder.newColumn('currentLocation').withTitle('Current Location'),
        DTColumnBuilder.newColumn('bornCountry').withTitle('Born Country'),
        DTColumnBuilder.newColumn('hashCode').withTitle('ID').notVisible(),
        DTColumnBuilder.newColumn('gender').withTitle('Gender').notVisible(),
        DTColumnBuilder.newColumn('yearOfBirth').withTitle('Year of Birth'),
        DTColumnBuilder.newColumn('languagesSpoken').withTitle('Languages Spoken'),
        DTColumnBuilder.newColumn('education').withTitle('Education'),
        DTColumnBuilder.newColumn(null).withTitle('').notSortable()
                .renderWith(function (data, type, full, meta) {
                    return '<a class="btn btn-warning" href="datatable#/profile/' + data.hashCode + '">' +
                            '   <i class="fa fa-arrow-right"></i>' +
                            '</a>&nbsp;';
                })

    ];
});
myModule.controller('SistersProfilesCtrl', function ($scope, DTOptionsBuilder, DTColumnBuilder) {

    $scope.dtOptions = DTOptionsBuilder.fromSource('api/profiles/Female')
            .withPaginationType('full_numbers')
            .withOption('stateSave', true);

    $scope.dtColumns = [
        DTColumnBuilder.newColumn('currentLocation').withTitle('Current Location'),
        DTColumnBuilder.newColumn('bornCountry').withTitle('Born Country'),
        DTColumnBuilder.newColumn('hashCode').withTitle('ID').notVisible(),
        DTColumnBuilder.newColumn('gender').withTitle('Gender').notVisible(),
        DTColumnBuilder.newColumn('yearOfBirth').withTitle('Year of Birth'),
        DTColumnBuilder.newColumn('languagesSpoken').withTitle('Languages Spoken'),
        DTColumnBuilder.newColumn('education').withTitle('Education'),
        DTColumnBuilder.newColumn(null).withTitle('').notSortable()
                .renderWith(function (data, type, full, meta) {
                    return '<a class="btn btn-warning" href="datatable#/profile/' + data.hashCode + '">' +
                            '   <i class="fa fa-arrow-right"></i>' +
                            '</a>&nbsp;';
                })

    ];
});
myModule.controller('ViewProfileCtrl', function ($scope, $http, $routeParams) {

    if (typeof $routeParams.email === 'undefined') {

        $http.get('api/profile/' + $routeParams.id).success(function (data) {
            $scope.profile = data;
            $scope.profile.id = $routeParams.id;
        });

    } else {
        $http.get('api/profileByEmail?email=' + $routeParams.email).success(function (data) {
            $scope.profile = data;
        });
    }
});

myModule.controller('TitleCtrl', function ($location, $scope) {

    if ($location.path() !== '') {
        $scope.title = "Noor Singles";
    }

});

myModule.controller('MailingListCtrl', function ($scope, AlertsService, $http) {

    $scope.joinMailingList = function () {
        var url = 'api/joinMailingList';
        $http.post(
                url, {},
                {
                    params: {
                        email: $scope.email
                    }
                })
                .success(function () {
                    AlertsService.addAlert('success', $scope.email + ' Successfully Added');


                }).error(function () {
            AlertsService.addAlert('warning', $scope.email + 'Something Wrong');

        });
    };
});


myModule.factory('AlertsService', function () {
    var alerts = [];

    var closeAlert = function (index) {
        alerts.splice(index, 1);
    };

    var addAlert = function (type, msg) {
        closeAlert();
        alerts.push({type: type, msg: msg});
    };

    return {
        alerts: alerts,
        addAlert: addAlert,
        closeAlert: closeAlert

    };
});


myModule.controller('AlertCtrl', function ($scope, AlertsService) {
    $scope.alerts = AlertsService.alerts;

    $scope.closeAlert = AlertsService.closeAlert;
});