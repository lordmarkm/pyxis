define([
   'angular',
   'landing/controller/LandingController'
], function (angular, LandingController) {

  console.debug('Configuring landing.module');
  angular.module('landing.module', [])
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.landing', {
        url: '',
        templateUrl: 'landing/view/homepage-two.html',
        controller: LandingController
      });

    }]);

});