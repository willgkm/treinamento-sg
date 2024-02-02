import './legal-account-create.scss'

class localAccountCreateController {

  constructor(
    public $scope,
    public $state,
    public $interval,
  ) { }

  createLegalAccount = (contaJuridica) => {
    console.log(contaJuridica)
  }


}

localAccountCreateController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
]


export default localAccountCreateController;