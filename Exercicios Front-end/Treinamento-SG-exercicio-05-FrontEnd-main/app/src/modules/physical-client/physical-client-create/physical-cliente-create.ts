import './physical-cliente-create.scss'

class physicalClientCreateController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public physicalClientService,
  ) { }

  createPhysiscalClient = (clienteFisico) => {
    this.physicalClientService.postPhysicalClient(clienteFisico).then( () => {
      delete this.$scope.clienteFisico;
      this.$scope.clienteFisicoForm.$setPristine();
      alert('cliente fisico criado com sucesso!!!')
    })
  }


}

physicalClientCreateController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'physicalClientService'
]


export default physicalClientCreateController;