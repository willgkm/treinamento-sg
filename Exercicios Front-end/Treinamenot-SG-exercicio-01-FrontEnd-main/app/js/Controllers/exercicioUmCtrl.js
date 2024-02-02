angular.module("exercicioUm").controller("exercicioUmCtrl", function ($scope, timesAPI, campeonatosAPI,  infoCampAPI ) {
    $scope.app = "exercicioUmCtrl"
    $scope.times = [];

    var carregarTimes = function () {
        timesAPI.getTimes().then(function (response) {
            $scope.times = response.data;
        })
    }
    $scope.adicionarTime = function (time) {
        timesAPI.saveTime(time).then(function (data) {
            delete $scope.time;
            $scope.timeForm.$setPristine();
            carregarTimes();
        });
    };

    $scope.deleteTime = function (timeSelecionado) {
        timesAPI.deleteTime(timeSelecionado.id).then( function (){
            carregarTimes();
        })
    }
    carregarTimes();

    //---------------------------------------------------------------------------------------
    
    $scope.campeonatos = [];

    var carregarCampeonatos = function () {
        campeonatosAPI.getCampeonatos().then(function (response) {
            $scope.campeonatos = response.data;
        })
    }


    $scope.adicionarCampeonato = function (campeonato) {
        campeonatosAPI.saveCampeonato(campeonato).then(function (data) {
            delete $scope.campeonato;
            $scope.campeonatoForm.$setPristine();
            carregarCampeonatos();
        });
    };

    $scope.deleteCampeonato = function (CampeonatoSelecionado) {
        campeonatosAPI.deleteCampeonato(CampeonatoSelecionado.id).then( function (){
            carregarCampeonatos();
        })
    }

    carregarCampeonatos();
    //---------------------------------------------------------------------------------------

    $scope.infoCamp = [];
    $scope.segundoInfoCamp = {}


    var carregarInfoCamp = function () {
        infoCampAPI.getInfoCamp().then(function (response) {
            $scope.infoCamp = response.data;
        })
    }


    $scope.adicionarInfoCamp = function () {
        infoCampAPI.saveInfoCamp($scope.segundoInfoCamp).then(function (data) {
            delete $scope.segundoInfoCamp;
            $scope.infoCampForm.$setPristine();
        });
    };
    
    $scope.deleteInfoCamp = function (infoCamp) {
        console.log(infoCamp)
        // infoCampAPI.deleteInfoCamp($scope.segundoInfoCamp.id).then( function(){
        //     carregarInfoCamp();
        // })
    }

    carregarInfoCamp();

    //---------------------------------------------------------------------------------------

})