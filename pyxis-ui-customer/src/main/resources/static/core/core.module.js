define([
   'angular',
   'core/controller/RootController'
], function (angular, RootController) {
  console.debug('Configuring core.module');
  angular.module('core.module', [])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

      $urlRouterProvider
        .when('', '/');

      $stateProvider.state('default', {
        url: '/',
        templateUrl: 'core/view/default.html',
        controller: RootController,
        abstract: true
      });

    }])

    //Try to have the oader for every http
    .config(['$httpProvider', function ($httpProvider) {
      $httpProvider.interceptors.push(['$q', '$rootScope', '$window', function ($q, $rootScope, $window) {
        var numLoadings = 0;
        return {
          request: function (config) {
            numLoadings++;
            $rootScope.$broadcast("loader_show");
            return config || $q.when(config);
          },
          response: function (response) {
            if ((--numLoadings) === 0) {
              $rootScope.$broadcast("loader_hide");
            }
            return response;
          },
          responseError: function (response) {
            if (!(--numLoadings)) {
              $rootScope.$broadcast("loader_hide");
            }
            //redirect to home on unauthorized
            if (response.status === 401) {
              $window.location.href = '/';
            }
            return $q.reject(response);
          }
        };
      }]);
    }])

    //Scroll to top on location change
    .run(['$rootScope', '$window', function ($rootScope, $window) {
      $rootScope.$on("$locationChangeSuccess", function() {
        $window.scrollTo(0,0);
      });
    }]);

});