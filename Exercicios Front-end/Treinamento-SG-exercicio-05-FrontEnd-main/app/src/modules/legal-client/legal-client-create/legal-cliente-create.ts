import './legal-cliente-create.scss'

class legalClientCreateController {

  constructor(
    public $scope,
    public $state,
    public $interval,
  ) { }

  createLegalClient = (clienteJuridico) => {
    console.log(clienteJuridico)
  }


}

legalClientCreateController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
]


export default legalClientCreateController;