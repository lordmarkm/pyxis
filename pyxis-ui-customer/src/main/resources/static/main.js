require.config({
  paths: {
    'angular': '../lib/angular/angular.min',
    'angular-animate': '../lib/angular-animate/angular-animate.min',
    'angular-ui-router': '../lib/angular-ui-router/release/angular-ui-router.min',
    'angular-resource': '../lib/angular-resource/angular-resource.min',
    'angular-ngtable': '../lib/ng-table/dist/ng-table.min',
    'angular-ui-select': '../lib/angular-ui-select/dist/select.min',
    'angular-sanitize': '../lib/angular-sanitize/angular-sanitize.min',
    'angular-bootstrap': '../lib/angular-bootstrap/ui-bootstrap-tpls.min',
    'toaster': '../lib/angularjs-toaster/toaster.min',
    'bootstrap': '../lib/bootstrap/dist/js/bootstrap.min',
    'jquery': '../lib/jquery/dist/jquery.min',
    'metisMenu': '../lib/metisMenu/dist/metisMenu.min',
    'moment': '../lib/moment/min/moment.min',
    'angular-moment': '../lib/angular-moment/angular-moment.min',
    'angular-busy': '../lib/angular-busy/dist/angular-busy.min',
  },
  shim: {
    'angular': {
      exports: 'angular',
      deps: ['jquery']
    },
    'angular-resource': {
      deps: ['angular']
    },
    'angular-ui-router': {
      deps: ['angular']
    },
    'angular-animate': {
      deps: ['angular']
    },
    'angular-ngtable': {
      deps: ['angular']
    },
    'angular-ui-select': {
      deps: ['angular']
    },
    'angular-sanitize': {
      deps: ['angular']
    },
    'angular-bootstrap': {
      deps: ['angular']
    },
    'angular-moment': {
      deps: ['angular', 'moment']
    },
    'angular-busy': {
      deps: ['angular']
    },
    'toaster': {
      deps: ['angular']
    },
    'metisMenu': {
      deps: ['jquery']
    },
    'bootstrap': {
      deps: ['jquery']
    }
  }
});

require([
         'angular',
         'angular-resource',
         'angular-animate',
         'angular-ngtable',
         'angular-ui-select',
         'angular-sanitize',
         'angular-bootstrap',
         'toaster',
         'angular-ui-router',
         'jquery',
         'bootstrap',
         'metisMenu',
         'moment',
         'angular-busy',
         'angular-moment',
         'saiku-embed'
         ], function (angular) {
  angular.element().ready(function () {
    angular.bootstrap(document, [
                                 'ui.router',
                                 'ngResource',
                                 'ngAnimate',
                                 'ngTable',
                                 'ui.select',
                                 'ngSanitize',
                                 'ui.bootstrap',
                                 'toaster',
                                 'cgBusy',
                                 'angularMoment'
                                 ]);
  });
});