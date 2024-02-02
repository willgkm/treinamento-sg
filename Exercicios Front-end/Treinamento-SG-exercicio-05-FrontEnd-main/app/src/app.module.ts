import * as angular from 'angular'
import 'angular-ui-bootstrap'
import 'angular-ui-carousel'
import 'bootstrap'
import '@uirouter/angularjs'
import './modules'

import './app.module.scss'
import baseComponents from './modules/baseComponents/baseComponents'
angular.module('app', [
  'ui.bootstrap',
  'ui.carousel',
  'ui.router',
  'app.management',
  'app.physicalClient',
  'app.legalClient',
  'app.physicalAccount',
  'app.legalAccount',
  'app.savingAccount',
  'app.moneyMovement'

])
.component('baseComponents', baseComponents)
.config(['$stateProvider', '$urlRouterProvider', ($stateProvider, $urlRouterProvider) => {
  $stateProvider
    .state('app', {
      abstract: true,
      component: 'baseComponents'
    })
  $urlRouterProvider.otherwise('/')
}])
