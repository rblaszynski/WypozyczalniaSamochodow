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
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
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
                <a class="nav-link " href="HireCar">Wypożycz</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="HireRaport">Raport wypożyczeń</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="Queries">Zapytania<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<div class="generic-container" ng-controller="QueriesController as ctrl">


    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Car Form </span></div>
        <div class="formcontainer">
            <div>
    <span style="color: red; font-size: large;">
        {{ctrl.error}}
    </span>
            </div>
            <form ng-show="ctrl.showSelector" ng-submit="ctrl.submit()" name="myForm" class="form-horizontal"
                  novalidate>
                <label class="control-label">Wpisz zapytanie: </label>
                <input type="text" ng-model="ctrl.query" name="query"
                       class="form-control input-sm" placeholder="SELECT * FROM TABLE" ng-required="true"
                       ng-model-options="{ updateOn: 'blur' }"
                />


                <div class="row" style="padding-top: 10px">
                    <div class="form-actions floatRight">
                        <button type="button" ng-click="ctrl.submit()" class="btn btn-primary btn-sm"
                                ng-disabled="myForm.$invalid">Pokaż raport
                        </button>
                    </div>
                </div>
            </form>
            <div ng-show="!ctrl.showSelector" class="panel panel-default">
                <div class="panel-heading"><span class="lead">Raport:</span>
                </div>
                <div class="tablecontainer">
                    <pre>{{ ctrl.report | json }}</pre>
                    <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                            ng-disabled="myForm.$pristine">Wygeneruj jeszcze raz
                    </button>
                </div>
            </div>

        </div>
    </div>
</div>


<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/hire_service.js' />"></script>
<script src="<c:url value='/static/js/controller/hire_controller.js' />"></script>
<script src="<c:url value='/static/js/service/user_service.js' />"></script>
<script src="<c:url value='/static/js/controller/queries_controller.js' />"></script>
<script src="<c:url value='/static/js/service/queries_service.js' />"></script>
<script src="<c:url value='/static/js/service/car_service.js' />"></script>
<script src="<c:url value='/static/js/controller/car_controller.js' />"></script>
<script src="<c:url value='/static/js/service/report_service.js' />"></script>
<script src="<c:url value='/static/js/controller/report_controller.js' />"></script>
</body>
</html>