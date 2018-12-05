<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wypozyczalnia</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="index">HOME</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="CarManagement">Samochody</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="UserManagement">Użytkownicy</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="HireCar">Wypożycz<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="HireRaport">Raport wypożyczeń</a>
            </li>
        </ul>
    </div>
</nav>

<div class="generic-container" ng-controller="HireController as ctrl">



    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Car Form </span></div>
        <div class="formcontainer">
            <div>
    <span style="color: red; font-size: large;">
        {{ctrl.error}}
    </span>
            </div>
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal" novalidate>
                <label for="repeatSelect"> Wybierz samochod: </label>
                <select class="form-control" name="repeatSelect" id="repeatSelect" ng-model="ctrl.hire.car">
                    <option ng-repeat="option in ctrl.cars" value="{{option.id}}">{{option.marka}} {{option.model}}</option>
                </select>

                <label for="repeatSelect"> Wybierz klienta: </label>
                <select class="form-control" name="repeatSelect" id="repeatSelect" ng-model="ctrl.hire.user">
                    <option ng-repeat="option in ctrl.users" value="{{option.idKlienta}}">{{option.imie}} {{option.nazwisko}}</option>
                </select>

                <label for="repeatSelect"> Data wypozyczenia: </label>
                <input type="text" ng-model="ctrl.hire.dataWypozyczenia" name="dataWypozyczenia"
                class="form-control input-sm" placeholder="YYYY-MM-DD" ng-required="true"
                ng-model-options="{ updateOn: 'blur' }" ng-minlength="3"
                />


                <label for="repeatSelect"> Data zwrotu: </label>
                <input type="text" ng-model="ctrl.hire.dataZwrotu" name="dataZwrotu"
                       class="form-control input-sm" placeholder="YYYY-MM-DD" ng-required="true"
                       ng-model-options="{ updateOn: 'blur' }" ng-minlength="3"
                />

                <label for="repeatSelect"> Dzienny limit kilometrów: </label>
                <input type="text" ng-model="ctrl.hire.limitKilometrow" name="limitKilometrow"
                       class="form-control input-sm" placeholder="Limit kilometrów" ng-required="true"
                       ng-model-options="{ updateOn: 'blur' }" ng-minlength="3"
                />

                <div class="row">
                    <div class="form-actions floatRight">
                        <button type="button" ng-click="ctrl.submit()" class="btn btn-primary btn-sm"
                                ng-disabled="myForm.$invalid" >Add
                        </button>
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                ng-disabled="myForm.$pristine">Reset Form
                        </button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>


<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/hire_service.js' />"></script>
<script src="<c:url value='/static/js/controller/hire_controller.js' />"></script>
<script src="<c:url value='/static/js/service/user_service.js' />"></script>
<script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
<script src="<c:url value='/static/js/service/car_service.js' />"></script>
<script src="<c:url value='/static/js/controller/car_controller.js' />"></script>
</body>
</html>