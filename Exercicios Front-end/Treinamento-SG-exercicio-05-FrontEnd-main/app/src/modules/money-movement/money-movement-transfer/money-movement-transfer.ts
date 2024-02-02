import './money-movement-transfer.scss'

class moneyMovementDepositController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public moneyMovementService,
  ) { }

  onTransfer = (transferencia) => {

    this.moneyMovementService.transfer(transferencia).then( () => {
      delete this.$scope.transferencia;
      this.$scope.transferenciaForm.$setPristine();
      alert('Transferencia realizado com sucesso!!!')
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