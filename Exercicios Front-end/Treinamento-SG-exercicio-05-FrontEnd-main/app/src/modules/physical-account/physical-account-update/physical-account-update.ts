
class physiscalAccountUpdateController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public physicalAccountService,
  ) { }

  alterarPhysiscalClient = (alterarContaFisica) => {
    console.log(alterarContaFisica);
    this.physicalAccountService.alterPhysicalAccount(alterarContaFisica).then( () => {
      alert('Conta fisica criada com sucesso')
    })
  
  }
}

physiscalAccountUpdateController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'physicalAccountService'
]


export default physiscalAccountUpdateController;