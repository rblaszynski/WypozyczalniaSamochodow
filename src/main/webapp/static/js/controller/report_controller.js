'use strict';

angular.module('myApp')
    .controller('ReportController', ['$scope', 'CarService', 'UserService', 'HireService', function ($scope, CarService, UserService, HireService) {
        var $ctrl = this;
        $ctrl.cars = [];
        $ctrl.car = {};

        $ctrl.users = [];
        $ctrl.user = {};
        $ctrl.error = '';
        $ctrl.hire = {};
        $scope.currentYear = new Date().getFullYear();

        $ctrl.submit = submit;
        // $ctrl.edit = edit;
        // $ctrl.remove = remove;
        // $ctrl.reset = reset;


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

        //
        //
        function createCar(hire) {
            HireService.hireCar(hire)
                .then(
                    fetchAllCars,
                    function (errResponse) {
                        console.error('Error while creating Car');
                        console.log(errResponse.data);
                        $ctrl.error = errResponse.data;
                    }
                );
        }

        // function updateCar(Car, id) {
        //     console.log('update');
        //     CarService.updateCar(Car, id)
        //         .then(
        //             fetchAllCars,
        //             function (errResponse) {
        //                 console.error('Error while updating Car');
        //                 console.log(errResponse.toString());
        //                 $ctrl.error = errResponse.data;
        //             }
        //         );
        // }
        //
        // function deleteCar(id) {
        //     CarService.deleteCar(id)
        //         .then(
        //             fetchAllCars,
        //             function (errResponse) {
        //                 console.error('Error while deleting Car');
        //             }
        //         );
        // }
        //
        function submit() {
            createCar($ctrl.hire);
            reset();
        }

        //
        // function edit(id) {
        //     console.log('id to be edited', id);
        //     for (var i = 0; i < $ctrl.cars.length; i++) {
        //         if ($ctrl.cars[i].id === id) {
        //             $ctrl.car = angular.copy($ctrl.cars[i]);
        //             break;
        //         }
        //     }
        // }
        //
        // function remove(id) {
        //     console.log('id to be deleted', id);
        //     deleteCar(id);
        // }
        //
        //
        function reset() {
            $ctrl.hire = {};
            $ctrl.error = '';
            $scope.myForm.$setPristine();
        }

    }]);
