require.config({
  paths: {
    'angular': 'lib/angular/angular.min',
    'angular-animate': 'lib/angular-animate/angular-animate.min',
    'angular-ui-router': 'lib/angular-ui-router/release/angular-ui-router.min',
    'angular-resource': 'lib/angular-resource/angular-resource.min',
    'angular-ngtable': 'lib/ng-table/dist/ng-table.min',
    'angular-ui-select': 'lib/angular-ui-select/dist/select.min',
    'angular-sanitize': 'lib/angular-sanitize/angular-sanitize.min',
    'angular-bootstrap': 'lib/angular-bootstrap/ui-bootstrap-tpls.min',
    'bootstrap': 'lib/bootstrap/dist/js/bootstrap.min',
    'jquery': 'lib/jquery/dist/jquery.min',
    'moment': 'lib/moment/min/moment.min',
    'angular-moment': 'lib/angular-moment/angular-moment.min',
    'angular-busy': 'lib/angular-busy/dist/angular-busy.min',

    //theme dependencies follow
    'less': 'theme/assets/js/less',
    //'jquery': 'theme/assets/js/jquery-1.12.0.min',
    'jquery-selectbox': 'theme/assets/js/jquery.selectbox-0.2',
    'jquery-fancybox': 'theme/assets/js/jquery.fancybox',
    //'bootstrap': 'theme/assets/js/bootstrap',
    'owl-carousel': 'theme/assets/js/owl.carousel',
    'jquery-plugin': 'theme/assets/js/jquery.plugin',
    'jquery-countdown': 'theme/assets/js/jquery.countdown.min',
    'jquery-easing': 'theme/assets/js/jquery.easing.1.3',
    'jquery-convent-accordion': 'theme/assets/js/jquery.conventAccordion',
    'site-js': 'theme/assets/js/site'
  },
  shim: {
    'angular': {exports: 'angular', deps: ['jquery']},
    'angular-animate': {deps: ['angular']},
    'angular-ui-router': {deps: ['angular']},
    'angular-resource': {deps: ['angular']},
    'angular-ngtable': {deps: ['angular']},
    'angular-ui-select': {deps: ['angular']},
    'angular-sanitize': {deps: ['angular']},
    'angular-bootstrap': {deps: ['angular']},
    'angular-moment': {deps: ['angular', 'moment']},
    'angular-busy': {deps: ['angular']},
    'bootstrap': {deps: ['jquery']},
    'jquery-selectbox': {deps: ['jquery']},
    'jquery-fancybox': {deps: ['jquery']},
    'owl-carousel': {deps: ['jquery']},
    'jquery-plugin': {deps: ['jquery']},
    'jquery-countdown': {deps: ['jquery']},
    'jquery-easing': {deps: ['jquery']},
    'jquery-convent-accordion': {deps: ['jquery']},
    'site-js': {deps: ['bootstrap',
      'jquery-selectbox',
      'jquery-fancybox',
      'owl-carousel',
      'jquery-plugin',
      'jquery-countdown',
      'jquery-easing',
      'jquery-convent-accordion',]}
  }
});

require([
         'angular',
         'angular-animate',
         'angular-ui-router',
         'angular-resource',
         'angular-ngtable',
         'angular-ui-select',
         'angular-sanitize',
         'angular-bootstrap',
         'angular-moment',
         'angular-busy',
         'moment',

         //theme dependencies
         'less',
         'jquery',
         'jquery-selectbox',
         'jquery-fancybox',
         'bootstrap',
         'owl-carousel',
         'jquery-plugin',
         'jquery-countdown',
         'jquery-easing',
         'jquery-convent-accordion',
         'site-js',

         //Project JS
         'core/core.module.js',
         'landing/landing.module.js'
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
       'cgBusy',
       'angularMoment',
       'core.module',
       'landing.module'
    ]);
  });
});