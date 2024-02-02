import consultModal from '../physical-account-consult-modal/consult-modal'
import consultModalTemplate from '../physical-account-consult-modal/consult-modal.html'

import './physical-account-consult.scss'




class physiscalAccountConsultController {

  private contasFisicas: [] = []

  private detalheContaFisica: [] = []

  constructor(
    public $scope,
    public $state,
    public $interval,
    public physicalAccountService,
    public $uibModal
  ) { }
  

  $onInit = () => {
    this.loadPhysicalAccounts()
  }

  open = () =>{
    var modalInstance = this.$uibModal.open({
      ariaLabelledBy: 'modal-title',
      ariaDescribedBy: 'modal-body',
      templateUrl: consultModalTemplate,
      controller: consultModal,
      controllerAs: '$ctrl',
      size: 'lg',
      // resolve: {
      // }
    });
  }

  loadPhysicalAccounts = () => {
    this.physicalAccountService.getPhysicalAccount().then(response => {
      this.contasFisicas = response.data;
    })
  }

  loadPhysicalAccountsDetail = (contaID) => {
    this.physicalAccountService.getPhysicalAccountDetail(contaID).then(Response => {
      this.detalheContaFisica = Response.data;
      console.log(this.detalheContaFisica);
      
    })
  }
  
}

physiscalAccountConsultController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
  'physicalAccountService',
  '$uibModal'
]


export default physiscalAccountConsultController;