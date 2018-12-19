'use strict';

angular.module('myApp').factory('QueriesService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WypozyczalniaSamochodow/query/';

    var factory = {
        executeQuery: executeQuery
    };

    return factory;

    function executeQuery(query) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, query)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while executing query');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
