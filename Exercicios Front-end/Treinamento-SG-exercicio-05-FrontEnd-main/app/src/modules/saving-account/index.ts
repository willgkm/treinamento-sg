import * as angular from 'angular'

import savingAccountCreateTemplate from './saving-account-create/saving-account-create.html'
import savingAccountCreateController from './saving-account-create/saving-account-create'

// import AccountService from ''

const savingAccountModule = angular.module('app.savingAccount', [])
  // .service('accountService', AccountService)
  .config(['$stateProvider', ($stateProvider) => {
    // console.log($routeParams)
    $stateProvider
      .state('app.savingAccount', {
        url: '^/saving-account',
        abstract: true,
      })
      .state('app.savingAccount.create', {
        url: '/create',
        templateUrl: savingAccountCreateTemplate,
        controller: savingAccountCreateController,
        controllerAs: '$ctrl',
      })

  }])
export default savingAccountModule