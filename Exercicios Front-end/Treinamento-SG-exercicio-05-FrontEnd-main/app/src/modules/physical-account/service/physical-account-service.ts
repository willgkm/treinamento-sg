class physicalAccountService {

	constructor(
		public $state,
		public $http
	) { }

	getPhysicalAccount() {
		return this.$http.get("http://localhost:8081/contas-fisicas")
	}

	postPhysicalAccount(contaFisica) {
		return this.$http.post("http://localhost:8081/contas-fisicas/cadastrar", contaFisica)
	}

	alterPhysicalAccount(alterContaFisica) {
		return this.$http.put("http://localhost:8081/contas-fisicas/alterar", alterContaFisica)
	}

	deletePhysicalAccount(contaFisicaId) {
		return this.$http.delete("http://localhost:8081/contas-fisicas/desativar/" + contaFisicaId)
	}
	getPhysicalAccountDetail(contaFisicaId){
		return this.$http.get("http://localhost:8081/movimentacao/saldo-da-conta/" + contaFisicaId)
	}

}

physicalAccountService['$inject'] = [
	'$state',
	'$http'
]


export default physicalAccountService;