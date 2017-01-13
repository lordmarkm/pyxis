define([
   'angular',
   'product/controller/ProductRootController',
   'product/controller/ProductListController'
], function (angular, ProductRootController, ProductListController) {

  console.debug('Configuring product.module');
  angular.module('product.module', [])
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.product', {
        url: '/product',
        template: '<ui-view></ui-view>',
        controller: ProductRootController,
        abstract: true
      })
      .state('default.product.list', {
        url: '/list',
        templateUrl: 'product/view/list.html',
        controller: ProductListController
      });

    }]);

});