import './money-movement-statement.scss'

class moneyMovementTakeoffController {

  private extrato: [] = [

  ]

  constructor(
    public $scope,
    public $state,
    public $interval,
    public moneyMovementService,
  ) { }
  
  LoadStatement = (ExtratoDTO) => {
    this.moneyMovementService.statement(ExtratoDTO).then(response => {
      this.extrato = response.data;
        
      
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