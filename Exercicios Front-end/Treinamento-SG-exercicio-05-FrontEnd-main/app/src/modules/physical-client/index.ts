import * as angular from 'angular'

import physicalClientCreateTemplate from './physical-client-create/physical-cliente-create.html'
import PhysicalClienteCreateController from './physical-client-create/physical-cliente-create'

import physicalClientConsultTemplate from './physical-client-consult/physical-cliente-consult.html'
import PhysicalClienteConsultController from './physical-client-consult/physical-cliente-consult'

import physicalClientUpdeteTemplate from './physical-client-update/physical-client-update.html'
import PhysicalClienteUpdeteController from './physical-client-update/physical-client-update'

import physicalClientDeleteTemplate from './physical-cliente-delete/physical-cliente-delete.html'
import PhysicalClienteDeleteController from './physical-cliente-delete/physical-cliente-delete'

import physicalClientService from '../physical-client/service/physical-cliente-service'

const physicalClientModule = angular.module('app.physicalClient', [])
  .service('physicalClientService', physicalClientService)
  .config(['$stateProvider', ($stateProvider) => {
    $stateProvider
      .state('app.physicalClient', {
        url: '^/physical-cliente',
        abstract: true,
      })
      .state('app.physicalClient.create', {
        url: '/create',
        templateUrl: physicalClientCreateTemplate,
        controller: PhysicalClienteCreateController,
        controllerAs: '$ctrl',
      })
      .state('app.physicalClient.consult', {
        url: '/consult',
        templateUrl: physicalClientConsultTemplate,
        controller: PhysicalClienteConsultController,
        controllerAs: '$ctrl',
      })
      .state('app.physicalClient.update', {
        url: '/update',
        templateUrl: physicalClientUpdeteTemplate,
        controller: PhysicalClienteUpdeteController,
        controllerAs: '$ctrl',
      })
      .state('app.physicalClient.delete', {
        url: '/delete',
        templateUrl: physicalClientDeleteTemplate,
        controller: PhysicalClienteDeleteController,
        controllerAs: '$ctrl',
      })

  }])
export default physicalClientModule