'use strict';

angular.module('myApp')
    .controller('ReportController', ['$scope', 'CarService', 'UserService', 'ReportService', function ($scope, CarService, UserService, ReportService) {
        var $ctrl = this;
        $ctrl.cars = [];
        $ctrl.car = {};
        $ctrl.report = {};

        $ctrl.users = [];
        $ctrl.user = {};
        $ctrl.error = '';
        $ctrl.hire = {};
        $ctrl.showSelector = true;
        $scope.currentYear = new Date().getFullYear();

        $ctrl.submit = submit;
         $ctrl.reset = reset;


        fetchAllCars();
        fetchAllUsers();

        function fetchAllCars() {
            CarService.fetchAllCars()
                .then(
                    function (d) {
                        $ctrl.cars = d;
                    },
                    function (errResponse) {
                        console.error('Error while fetching Cars');
                    }
                );
        }

        function fetchAllUsers() {
            UserService.fetchAllClients()
                .then(
                    function (d) {
                        $ctrl.users = d;
                    },
                    function (errResponse) {
                        console.error('Error while fetching Users');
                    }
                );
        }

        function generateReport(type, id) {
            ReportService.generateReport(type,id)
                .then(
                    function(d){
                         $ctrl.reports = d;
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
            generateReport($ctrl.report.name, $ctrl.report.id);
        }

        function reset() {
            $ctrl.report = {};
            $ctrl.hire = {};
            $ctrl.showSelector = true;
            $ctrl.error = '';
            $scope.myForm.$setPristine();
        }

    }]);
