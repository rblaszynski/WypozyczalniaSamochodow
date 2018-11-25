'use strict';

angular.module('myApp').factory('HireService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WypozyczalniaSamochodow/hire/';

    var factory = {
        hireCar: hireCar
    };

    return factory;

    function hireCar(car) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, car)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating Car');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
