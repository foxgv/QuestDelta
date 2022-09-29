<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Pricing example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="pricing.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>

<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal"></h5>
    <nav class="my-2 my-md-0 mr-md-3">

        <a class="p-2 text-dark" href="/">Главная<br></a>
    </nav>
    <a class="p-2 text-dark" href="/users">List of users</a>
    <ul>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <li><a href="/profile" class="nav-link px-2 link-dark">Profile</a></li>
                <li><a href="/logout" class="nav-link px-2 link-dark">Logout</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="/login" class="nav-link px-2 link-dark">Login</a></li>
                <li><a href="/signup" class="nav-link px-2 link-dark">Sign-up</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Welcome to my Quest</h1>
    <p class="lead"><b>Для прохождения квеста необходимо авторизоваться</b></p>
</div>

<div class="container">



</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="../../js/vendor/popper.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/holderjs@2.9.4/holder.js"></script>
<script>
    Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>