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
            <li class="nav-item active">
                <a class="nav-link" href="UserManagement">Klienci<span class="sr-only">(current)</span></a>

            </li>
            <li class="nav-item">
                <a class="nav-link" href="HireCar">Wypożycz</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="HireRaport">Raport wypożyczeń</a>
            </li>
        </ul>
    </div>
</nav>

<%--TODO: UserManagement to jest 1:1 CarManagement, więc możesz sie na nim nauczyć jak to działa. Zmieniasz ng-controller na UserController i tworzysz w folderach webapp/static/js odpowiednie pliki user_service i user_controller--%>
<%--TODO: wszedzie gdzie jest ctrl.car -> ctrl.user--%>
<%--TODO: tak samo te labelki Marka, itp - wiadomo o co chodzi--%>
<div class="generic-container" ng-controller="UserController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">User Form </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.user.id"/>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Imię</label>
                        <input type="text" ng-model="ctrl.user.imie"
                               class="form-control input-sm" placeholder="Wpisz imię: " required
                        />
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Nazwisko</label>
                        <input type="text" ng-model="ctrl.user.nazwisko" class="form-control input-sm"
                               placeholder="Wpisz nazwisko: " required/>
                    </div>
                </div>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Data urodzenia</label>
                        <input type="text" ng-model="ctrl.user.dataUrodzenia" class="form-control input-sm"
                               placeholder="Wpisz datę urodzenia w formacie yyyy-mm-dd" required/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class="control-label">ID Adres</label>
                        <input type="text" ng-model="ctrl.user.idAdres" class="form-control input-sm"
                               placeholder="Wpisz ID Adresu: "required/>
                    </div>
                </div>

                <div class="row col-md-8">
                    <div class="col-md-4 mb-3">
                        <label class="control-label">Numer telefonu</label>
                        <input type="text" ng-model="ctrl.user.nrTelefonu" class="form-control input-sm"
                               placeholder="Wpisz numer telefonu" required/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <button type="button" ng-click="ctrl.submit()" class="btn btn-primary btn-sm"
                                ng-disabled="myForm.$invalid">{{!ctrl.user.id ? 'Add' : 'Update'}}
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
        <div class="panel-heading"><span class="lead">Lista użytkowników </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Data Urodzenia</th>
                    <th>ID Adres</th>
                    <th>Numer telefonu</th>
                    <th width="14%"></th>
                </tr>
                </thead>
                <tbody>
                <%--TODO: user in ctrl.users--%>
                <tr ng-repeat="user in ctrl.users">
                    <td><span ng-bind="user.id"></span></td>
                    <td><span ng-bind="user.imie"></span></td>
                    <td><span ng-bind="user.nazwisko"></span></td>
                    <td><span ng-bind="user.dataUrodzenia"></span></td>
                    <td><span ng-bind="user.idAdres"></span></td>
                    <td><span ng-bind="user.nrTelefonu"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(user.id)" class="btn btn-success custom-width">Edit
                        </button>
                        <button type="button" ng-click="ctrl.remove(user.id)" class="btn btn-danger custom-width">Remove
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="<c:url value='/static/js/app.js' />"></script>
<%--TODO: Tutaj uzupełniasz sciezki do serwisu i kontrolera--%>
<script src="<c:url value='/static/js/service/user_service.js' />"></script>
<script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
</body>
</html>