angular.module("exercicioUm").factory("timesAPI", function($http){

    var _getTimes = function () {
        return $http.get("http://localhost:8080/times");
    }

    var _saveTime = function(time){
        return $http.post("http://localhost:8080/times", time);
    }

    var _deleteTime = function (id){
        return $http.delete("http://localhost:8080/times/" + id);
    }

    return{
        getTimes: _getTimes,
        saveTime: _saveTime,
        deleteTime: _deleteTime
    }

})