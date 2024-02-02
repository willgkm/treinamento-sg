import * as angular from 'angular'
import homeTemplete from './home/home.html'
import homeController from './home/home'


const Modules = angular.module('app.management', [])
.config(['$stateProvider', ($stateProvider) => {
    $stateProvider
        .state('app.home', {
            url: '/',
            templateUrl: homeTemplete,
            controller: homeController,
            controllerAs: '$ctrl',
        })
}])