define(function () {
  return ['$scope', '$rootScope', '$state', '$q',
          function ($scope, $rootScope, $state, $q) {

    $scope.contextPath = 'pyxis';

    //This is for loader
    $scope.cgLoader = {};
    $rootScope.$on('loader_show', function () {
      $scope.cgLoader.promise = $q.defer();
    });
    $rootScope.$on('loader_hide', function () {
      delete $scope.cgLoader.promise;
    });

  }];
});