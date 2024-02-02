
class physicalClientUpdateController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public physicalClientService,
  ) { }

  alterPhysiscalClient = (alterarFisico) => {
    this.physicalClientService.alterPhysicalCliente(alterarFisico).then( () => {
      delete this.$scope.alterarFisico;
      this.$scope.alterarFisicoForm.$setPristine();
      alert('Cliente fisico alterado com sucesso!!!')
    })
  }
}

physicalClientUpdateController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'physicalClientService'
]


export default physicalClientUpdateController;