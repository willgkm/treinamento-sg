class physicalClientService {

  constructor(
    public $state,
    public $http
  ) { }

  getPhysicalClient() {
    return this.$http.get("http://localhost:8081/pessoas-fisicas")
  }

  postPhysicalClient(pessoaFisica) {
    return this.$http.post("http://localhost:8081/pessoas-fisicas", pessoaFisica)
  }

  deletePhysicalCliente(pessoaFisicaID ){
    return this.$http.delete("http://localhost:8081/pessoas-fisicas/" + pessoaFisicaID )
  }

  alterPhysicalCliente(pessoaFisica) {
    return this.$http.put("http://localhost:8081/pessoas-fisicas" , pessoaFisica)
  }

}

physicalClientService['$inject'] = [
  '$state',
  '$http'
]

export default physicalClientService;