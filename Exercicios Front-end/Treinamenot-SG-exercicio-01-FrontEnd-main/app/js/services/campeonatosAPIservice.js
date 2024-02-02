angular.module("exercicioUm").factory("campeonatosAPI", function($http){

    var _getCampeonatos = function () {
        return $http.get("http://localhost:8080/campeonatos");
    }

    var _saveCampeonato = function(campeonato){
        return $http.post("http://localhost:8080/campeonatos", campeonato);
    }

    var _deleteCampeonato = function (id){
        return $http.delete("http://localhost:8080/campeonatos/" + id);
    }

    return{
        getCampeonatos: _getCampeonatos,
        saveCampeonato: _saveCampeonato,
        deleteCampeonato: _deleteCampeonato

    }
})