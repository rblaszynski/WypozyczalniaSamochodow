'use strict';

angular.module('myApp')
    .controller('QueriesController', ['$scope', 'QueriesService', function ($scope, QueriesService) {
        var $ctrl = this;
        $ctrl.users = [];
        $ctrl.user = {};
        $ctrl.error = '';
        $ctrl.hire = {};
        $ctrl.showSelector = true;

        $ctrl.submit = submit;
        $ctrl.reset = reset;


        function generateReport(query) {
            QueriesService.executeQuery(query)
                .then(
                    function(d){
                        $ctrl.report = d;
                    },
                    function (errResponse) {
                        console.error('Error while generating report');
                        console.log(errResponse.data);
                        $ctrl.error = errResponse.data;
                    }
                );
        }

        function submit() {
            $ctrl.showSelector = false;
            generateReport($ctrl.query);
        }

        function reset() {
            $ctrl.report = {};
            $ctrl.hire = {};
            $ctrl.showSelector = true;
            $ctrl.error = '';
            $scope.myForm.$setPristine();
        }

    }]);
