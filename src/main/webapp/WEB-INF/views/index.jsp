<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wypozyczalnia</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<main role="main">
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Witamy w naszej wypożyczalni!</h1>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h2>Lista samochodów</h2>
                <p>Zarządzanie samochodami</p>
                <p><a class="btn btn-secondary" href="CarManagement" role="button">Szczegóły »</a></p>
            </div>
            <div class="col-md-4">
                <h2>Lista użytkowników</h2>
                <p>Zarządzanie użytkownikami</p>
                <p><a class="btn btn-secondary" href="UserManagement" role="button">Szczegóły »</a></p>
            </div>
            <div class="col-md-4">
                <h2>Wypożycz samochodów</h2>
                <p>Zarządzanie wypożyczeniami</p>
                <p><a class="btn btn-secondary" href="HireCar" role="button">Szczegóły »</a></p>
            </div>
            <div class="col-md-4">
                <h2>Raport wypożyczeń</h2>
                <p>Szczegóły</p>
                <p><a class="btn btn-secondary" href="HireRaport" role="button">Szczegóły »</a></p>
            </div>
        </div>
        <hr>
    </div>
</main>

<footer class="container">
    <p>©Błaszczyk&Błaszyński 2018</p>
</footer>

</body>
</html>
