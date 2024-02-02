angular.module("exercicioUm").factory("infoCampAPI", function($http){

    var _getInfoCamp = function () {
        return $http.get("http://localhost:8080/info-camp");
    }

    var _saveInfoCamp = function(infoCamp){
        return $http.post("http://localhost:8080/info-camp", infoCamp);
    }

    var _getInfoCampPorIdOrdenado = function(id) {
        return $http.get("http://localhost:8080/info-camp/detalhes/" + id);
    }
    var _deleteInfoCamp = function (id){
        return $http.delete("http://localhost:8080/info-camp/" + id);
    }

    return{
        getInfoCamp : _getInfoCamp,
        saveInfoCamp : _saveInfoCamp,
        getInfoCampPorIdOrdenado : _getInfoCampPorIdOrdenado,
        deleteInfoCamp : _deleteInfoCamp
    }
})