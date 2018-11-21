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
            <li class="nav-item active">
                <a class="nav-link" href="">Samochody<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="UserManagement">Użytkownicy</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="HireCar">Wypożyczenia</a>
            </li>
        </ul>
    </div>
</nav>
<div class="generic-container" ng-controller="CarController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Car Form </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.car.id"/>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Marka</label>
                        <input type="text" ng-model="ctrl.car.marka"
                               class="form-control input-sm" placeholder="Wpisz car producer" required
                        />
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Model</label>
                        <input type="text" ng-model="ctrl.car.model" class="form-control input-sm"
                               placeholder="Wpisz car model" required/>
                    </div>
                </div>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Kolor</label>
                        <input type="text" ng-model="ctrl.car.kolor" class="form-control input-sm"
                               placeholder="Wpisz car colour" required/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Rok Produkcji</label>
                        <input type="text" ng-model="ctrl.car.rokProdukcji" class="form-control input-sm"
                               placeholder="Wpisz production date" required/>
                    </div>
                </div>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Pojemnosc Baku</label>
                        <input type="text" ng-model="ctrl.car.pojemnoscBaku" class="form-control input-sm"
                               placeholder="Wpisz pojBaku" required/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Id Klasy</label>
                        <input type="text" ng-model="ctrl.car.idKlasy" class="form-control input-sm"
                               placeholder="Wpisz idKlasy" required/>
                    </div>
                </div>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Pojemnosc silnika</label>
                        <input type="text" ng-model="ctrl.car.silnik" class="form-control input-sm"
                               placeholder="Wpisz poj silnika" required/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Cena wypozyczenia</label>
                        <input type="text" ng-model="ctrl.car.cenaWypozyczenia" class="form-control input-sm"
                               placeholder="Wpisz cene wyp" required/>
                    </div>
                </div>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Aktualny przebieg</label>
                        <input type="text" ng-model="ctrl.car.aktualnyPrzebieg" class="form-control input-sm"
                               placeholder="Wpisz aktualny przebieg" required/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <button type="button" ng-click="ctrl.submit()" class="btn btn-primary btn-sm"
                                ng-disabled="myForm.$invalid">{{!ctrl.car.id ? 'Add' : 'Update'}}
                        </button>
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                ng-disabled="myForm.$pristine">Reset Form
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Cars </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Marka</th>
                    <th>Model</th>
                    <th>Kolor</th>
                    <th>Rok Produkcji</th>
                    <th>Pojemnosc Baku</th>
                    <th>Id Klasy</th>
                    <th>Silnik</th>
                    <th>Cena wypożyczenia</th>
                    <th>Aktualny przebieg</th>
                    <th width="14%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="car in ctrl.cars">
                    <td><span ng-bind="car.id"></span></td>
                    <td><span ng-bind="car.marka"></span></td>
                    <td><span ng-bind="car.model"></span></td>
                    <td><span ng-bind="car.kolor"></span></td>
                    <td><span ng-bind="car.rokProdukcji"></span></td>
                    <td><span ng-bind="car.pojemnoscBaku"></span></td>
                    <td><span ng-bind="car.idKlasy"></span></td>
                    <td><span ng-bind="car.silnik"></span></td>
                    <td><span ng-bind="car.cenaWypozyczenia"></span></td>
                    <td><span ng-bind="car.aktualnyPrzebieg"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(car.id)" class="btn btn-success custom-width">Edit
                        </button>
                        <button type="button" ng-click="ctrl.remove(car.id)" class="btn btn-danger custom-width">Remove
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/car_service.js' />"></script>
<script src="<c:url value='/static/js/controller/car_controller.js' />"></script>
</body>
</html>