angular.module("exercicioUm").config(function ($routeProvider) {
    $routeProvider.when("/times",{
        templateUrl: "view/times.html",
        controller: "exercicioUmCtrl"
    })
    .when("/", {
        templateUrl:"view/main.html",
        controller:"exercicioUmCtrl"
    })
    .when("/campeonatos", {
        templateUrl:"view/campeonatos.html",
        controller: "exercicioUmCtrl"
    })
    .when("/info-camp" , {
        templateUrl:"view/inserirTimeInCamp.html",
        controller:"exercicioUmCtrl"
    })
    .when("/info-camp/detalhes/:id", {
        templateUrl:"view/detalhesCampeonato.html",
        controller:"detalhesCampeonatoCtrl",
        resolve:{
            infoCamp : function (infoCampAPI, $route){
                return infoCampAPI.getInfoCampPorIdOrdenado($route.current.params.id);
            }
        }
    })
    $routeProvider.otherwise({redirectTo: "/"});
})
