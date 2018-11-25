'use strict';

angular.module('myApp').factory('CarService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WypozyczalniaSamochodow/car/';

    var factory = {
        fetchAllCars: fetchAllCars,
        createCar: createCar,
        updateCar:updateCar,
        deleteCar:deleteCar
    };

    return factory;

    function fetchAllCars() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Cars');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createCar(car) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, car)
            .then(
            function (response) {
                deferred.resolve(response.data);
                fetchAllCars();
            },
            function(errResponse){
                console.error('Error while creating Car');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateCar(Car, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, Car)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse, response, data){
                console.log(response);
                console.log(data);
                console.error('Error while updating Car');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteCar(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Car');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
