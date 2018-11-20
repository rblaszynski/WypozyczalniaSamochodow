'use strict';

angular.module('myApp').controller('CarController', ['$scope', 'CarService', function ($scope, CarService) {
    var $ctrl = this;
    $ctrl.cars = [];
    $ctrl.car = {};

    $ctrl.submit = submit;
    $ctrl.edit = edit;
    $ctrl.remove = remove;
    $ctrl.reset = reset;


    fetchAllCars();

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

    function createCar(car) {
        CarService.createCar(car)
            .then(
                fetchAllCars,
                function (errResponse) {
                    console.error('Error while creating Car');
                }
            );
    }

    function updateCar(Car, id) {
        console.log('update');
        CarService.updateCar(Car, id)
            .then(
                fetchAllCars,
                function (errResponse) {
                    console.error('Error while updating Car');
                }
            );
    }

    function deleteCar(id) {
        CarService.deleteCar(id)
            .then(
                fetchAllCars,
                function (errResponse) {
                    console.error('Error while deleting Car');
                }
            );
    }

    function submit() {
        if($ctrl.car.id===undefined){
            createCar($ctrl.car);
        }else{
            updateCar($ctrl.car, $ctrl.car.id);
            console.log('Car updated with id ', $ctrl.car.id);
        }
        reset();
    }

    function edit(id) {
        console.log('id to be edited', id);
        for (var i = 0; i < $ctrl.cars.length; i++) {
            if ($ctrl.cars[i].id === id) {
                $ctrl.car = angular.copy($ctrl.cars[i]);
                break;
            }
        }
    }

    function remove(id) {
        console.log('id to be deleted', id);
        deleteCar(id);
    }


    function reset() {
        $ctrl.car = {};
        $scope.myForm.$setPristine();
    }

}]);
