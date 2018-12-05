'use strict';

angular.module('myApp').factory('ReportService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WypozyczalniaSamochodow/report';

    var factory = {
        generateReport: generateReport
    };

    return factory;

    function generateReport(type, id) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'/'+type+'/'+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while generating report');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
