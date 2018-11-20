'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserServiceService) {
    var $ctrl = this;
    $ctrl.users = [];
    $ctrl.user = {};

    $ctrl.submit = submit;
    $ctrl.edit = edit;
    $ctrl.remove = remove;
    $ctrl.reset = reset;


    fetchAllUsers();

    function fetchAllUsers() {
        UserService.fetchAllUsers()
            .then(
                function (d) {
                    $ctrl.users = d;
                },
                function (errResponse) {
                    console.error('Error while fetching Users');
                }
            );
    }

    function createUser(user) {
       UserService.createUser(user)
            .then(
                fetchAllUsers,
                function (errResponse) {
                    console.error('Error while creating Users');
                }
            );
    }

    function updateUser(User, id) {
        console.log('update');
        UserService.updateUser(User, id)
            .then(
                fetchAllUsers,
                function (errResponse) {
                    console.error('Error while updating User');
                }
            );
    }

    function deleteUser(id) {
        UserService.deleteUser(id)
            .then(
                fetchAllUsers,
                function (errResponse) {
                    console.error('Error while deleting User');
                }
            );
    }

    function submit() {
        if($ctrl.user.id===undefined){
            createUser($ctrl.user);
        }else{
            updateUser($ctrl.user, $ctrl.user.id);
            console.log('User updated with id ', $ctrl.user.id);
        }
        reset();
    }

    function edit(id) {
        console.log('id to be edited', id);
        for (var i = 0; i < $ctrl.users.length; i++) {
            if ($ctrl.users[i].id === id) {
                $ctrl.user = angular.copy($ctrl.users[i]);
                break;
            }
        }
    }

    function remove(id) {
        console.log('id to be deleted', id);
        deleteUser(id);
    }


    function reset() {
        $ctrl.user = {};
        $scope.myForm.$setPristine();
    }

}]);
