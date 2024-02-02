import './money-movement-deposit.scss'

class moneyMovementDepositController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public moneyMovementService,
  ) { }

  onDeposit = (deposito) => {
    this.moneyMovementService.deposit(deposito).then( () => {
      delete this.$scope.deposito;
      this.$scope.depositoForm.$setPristine();
      alert('Deposito realizado com sucesso!!!')
    })
  }

}

moneyMovementDepositController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'moneyMovementService'
]

export default moneyMovementDepositController;