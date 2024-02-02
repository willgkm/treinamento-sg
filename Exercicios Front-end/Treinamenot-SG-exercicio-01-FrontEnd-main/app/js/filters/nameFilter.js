angular.module("exercicioUm").filter("name", function(){
    return function (input){
        var listaDeNomes = input.split(" ");
        var listaDeNomesFormatada  = listaDeNomes.map(function (nome){
            input
            if(/(da|de)/.test(nome)) return nome;
            if(nome.length === 2  ) return nome;
            return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
        });
        return listaDeNomesFormatada.join(" ");
    }
})