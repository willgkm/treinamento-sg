import * as angular from 'angular'

import moneyMovementDepositTemplate from './money-movement-deposit/money-movement-deposit.html'
import moneyMovementDepositController from './money-movement-deposit/money-movement-deposit'

import moneyMovementTakeoffTemplate from './money-movement-takeoff/money-movement-takeoff.html'
import moneyMovementTakeoffController from './money-movement-takeoff/money-movement-takeoff'

import moneyMovementTransferTemplete from './money-movement-transfer/money-movement-transfer.html'
import moneyMovementTransferController from './money-movement-transfer/money-movement-transfer'

import moneyMovementStatementTemplete from './money-movement-statement/money-movement-statement.html'
import moneyMovementStatementController from './money-movement-statement/money-movement-statement'


import moneyMovementService from './service/money-movement-service'

const depositModule = angular.module('app.moneyMovement', [])
  .service('moneyMovementService', moneyMovementService)
  .config(['$stateProvider', ($stateProvider) => {
    $stateProvider
      .state('app.moneyMovement', {
        url: '^/money-movement',
        abstract: true,
      })
      .state('app.moneyMovement.deposit', {
        url: '/deposit',
        templateUrl: moneyMovementDepositTemplate,
        controller: moneyMovementDepositController,
        controllerAs: '$ctrl',
      })
      .state('app.moneyMovement.takeoff', {
        url: '/takeoff',
        templateUrl: moneyMovementTakeoffTemplate,
        controller: moneyMovementTakeoffController,
        controllerAs: '$ctrl',
      })
      .state('app.moneyMovement.transfer', {
        url: '/transfer',
        templateUrl: moneyMovementTransferTemplete,
        controller: moneyMovementTransferController,
        controllerAs: '$ctrl',
      })
      .state('app.moneyMovement.statement', {
        url: '/statement',
        templateUrl: moneyMovementStatementTemplete,
        controller: moneyMovementStatementController,
        controllerAs: '$ctrl',
      })

  }])

export default depositModule