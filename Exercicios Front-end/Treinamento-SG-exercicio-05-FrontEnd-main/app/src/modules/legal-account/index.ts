import * as angular from 'angular'

import legalAccountCreateTemplate from './legal-account-create/legal-account-create.html'
import legalAccountCreateController from './legal-account-create/legal-account-create'
import legalClientModule from '../legal-client'


const legalAccountModule = angular.module('app.legalAccount', [])
  .config(['$stateProvider', ($stateProvider) => {
    $stateProvider
      .state('app.legalAccount', {
        url: '^/legal-account',
        abstract: true,
      })
      .state('app.legalAccount.create', {
        url: '/create',
        templateUrl: legalAccountCreateTemplate,
        controller: legalAccountCreateController,
        controllerAs: '$ctrl',
      })

  }])

export default legalAccountModule