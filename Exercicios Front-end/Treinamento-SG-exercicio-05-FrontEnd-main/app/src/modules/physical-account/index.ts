import * as angular from 'angular'

import physicalAccountCreateTemplate from './physical-account-create/physical-account-create.html'
import physicalAccountCreateController from './physical-account-create/physical-account-create'

import physicalAccountConsultTemplate from './physical-account-consult/physical-account-consult.html'
import physicalAccountConsultController from './physical-account-consult/physical-account-consult'

import physicalAccountUpdateTemplate from './physical-account-update/physical-account-update.html'
import physicalAccountUpdateController from './physical-account-update/physical-account-update'

import physicalAccountDeleteTemplate from './physical-account-delete/physical-account-delete.html'
import physicalAccountDeleteController from './physical-account-delete/physical-account-delete'

import physicalAccountService from './service/physical-account-service'

const physicalAccountModule = angular.module('app.physicalAccount', [])
  .service('physicalAccountService', physicalAccountService)
  .config(['$stateProvider', ($stateProvider) => {
    // console.log($routeParams)
    $stateProvider
      .state('app.physicalAccount', {
        url: '^/physical-account',
        abstract: true,
      })
      .state('app.physicalAccount.create', {
        url: '/create',
        templateUrl: physicalAccountCreateTemplate,
        controller: physicalAccountCreateController,
        controllerAs: '$ctrl',
      })
      .state('app.physicalAccount.consult ', {
        url: '/consult',
        templateUrl: physicalAccountConsultTemplate,
        controller: physicalAccountConsultController,
        controllerAs: '$ctrl',
      })
      .state('app.physicalAccount.update', {
        url: '/update',
        templateUrl: physicalAccountUpdateTemplate,
        controller: physicalAccountUpdateController,
        controllerAs: '$ctrl',
      })
      .state('app.physicalAccount.delete', {
        url: '/delete',
        templateUrl: physicalAccountDeleteTemplate,
        controller: physicalAccountDeleteController,
        controllerAs: '$ctrl',
      })

  }])
export default physicalAccountModule