class consultModal {

  private contasFisicas: [] = []

  private detalheContaFisica: [] = []

  constructor(
    public $scope,
    public $state,
    public $interval,
    public $uibModalInstance,
    public physicalAccountService
  ) { }

  $onInit = () => {
    // this.loadPhysicalAccounts()
  }

  close = () => {
    this.$uibModalInstance.dismiss('fachar');
    
  }

  loadPhysicalAccountsDetail = (contaID) => {
    this.physicalAccountService.getPhysicalAccountDetail(contaID).then(Response => {
      this.detalheContaFisica = Response.data;
      console.log(this.detalheContaFisica);

    })
  }

}

consultModal['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  '$uibModalInstance',
  'physicalAccountService'
]


export default consultModal;