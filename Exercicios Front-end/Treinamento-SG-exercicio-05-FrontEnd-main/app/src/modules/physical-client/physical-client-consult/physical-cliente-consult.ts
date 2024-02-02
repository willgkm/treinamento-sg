import './physical-cliente-consult.scss'


class physicalClientCreateController {
  

  private pessoasFisicas: [] = [

  ]

  constructor(
    public $scope,
    public $state,
    public $interval,
    public physicalClientService,
  ) { }

  $onInit = () => {
    this.loadPhysicalClients()
  }

  loadPhysicalClients = () => {
    this.physicalClientService.getPhysicalClient().then(response => {
      this.pessoasFisicas = response.data;
    })
  }
}

physicalClientCreateController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'physicalClientService',
]

export default physicalClientCreateController;