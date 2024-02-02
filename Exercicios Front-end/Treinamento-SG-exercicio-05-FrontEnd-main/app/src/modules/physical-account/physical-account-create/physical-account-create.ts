import './physical-account-create.scss'

class physiscalAccountCreateController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public physicalAccountService,
  ) { }

  createPhysicalAccount = (contaFisica) => {
    
    this.physicalAccountService.postPhysicalAccount(contaFisica).then( () => {
      delete this.$scope.contaFisica;
      this.$scope.contaFisicaForm.$setPristine();
      alert('Conta fisica criado com sucesso!!!')
    })
  }

}

physiscalAccountCreateController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'physicalAccountService'
]


export default physiscalAccountCreateController;