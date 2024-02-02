angular.module("exercicioUm").controller("detalhesCampeonatoCtrl", function ($scope, infoCamp, infoCampAPI) {
    $scope.infoCamp = infoCamp.data
    
    var carregarInfoCamp = function () {
        infoCampAPI.getInfoCamp().then(function (response) {
            $scope.infoCamp = response.data;
        })
    }
    
    $scope.deleteInfoCamp = function (infoCamp) {
        infoCampAPI.deleteInfoCamp(infoCamp.id).then( function(){
            carregarInfoCamp();
        })
    }
    
});