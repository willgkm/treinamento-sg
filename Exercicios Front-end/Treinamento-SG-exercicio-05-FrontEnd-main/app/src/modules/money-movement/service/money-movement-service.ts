class moneyMovementService {

  constructor(
    public $state,
    public $http
  ) { }

  deposit(deposito) {
    return this.$http.put("http://localhost:8081/movimentacao/" + deposito.id   + "/depositar/" + deposito.valor )
  }

  takeoff(saque) {
    return this.$http.put("http://localhost:8081/movimentacao/" + saque.id   + "/saque/" + saque.valor )
  }
  
  transfer(transeferencia) {
    return this.$http.put("http://localhost:8081/movimentacao/" + transeferencia.idEnviar   + "/transferencias/" + transeferencia.idReceber  + "/valor/" + transeferencia.valor)
  }

  statement(ExtratoDTO) {
  return this.$http.post("http://localhost:8081/movimentacao/extrato", ExtratoDTO)
    
  } 
}

moneyMovementService['$inject'] = [
  '$state',
  '$http'
]

export default moneyMovementService;