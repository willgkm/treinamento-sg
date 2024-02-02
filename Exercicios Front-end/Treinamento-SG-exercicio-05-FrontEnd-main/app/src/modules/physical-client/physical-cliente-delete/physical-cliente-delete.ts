
class physicalClientDeleteController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public physicalClientService,
  ) { }

  deletePhysiscalClient = (clienteFisico) => {
    
    this.physicalClientService.deletePhysicalCliente(clienteFisico.id).then( () => {
      delete this.$scope.clienteFisico;
      this.$scope.deleteContaFisicaForm.$setPristine();
      alert('Usuario ' + clienteFisico.id +' excluido com sucesso!!!')
    })
  }

}

physicalClientDeleteController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'physicalClientService'
]


export default physicalClientDeleteController;