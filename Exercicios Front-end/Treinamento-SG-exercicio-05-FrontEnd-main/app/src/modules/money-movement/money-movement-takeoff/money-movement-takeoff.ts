import './money-movement-takeoff.scss'

class moneyMovementTakeoffController {

  constructor(
    public $scope,
    public $state,
    public $interval,
    public moneyMovementService,
  ) { }

  onTakeoff = (saque) => {
    this.moneyMovementService.takeoff(saque).then( () => {
      delete this.$scope.saque;
      this.$scope.saqueForm.$setPristine();
      alert('Saque realizado com sucesso!!!')
    })
  } 

}

moneyMovementTakeoffController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'moneyMovementService'
]

export default moneyMovementTakeoffController;