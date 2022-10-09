<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Игра</title>
</head>
<body>

<form class="form-horizontal" action="game" method="get">
    <div class="form-group">
        <div class="col-md-4">
        </div>
        <div>
            <h1><%= request.getAttribute("questionText") %> </h1>
        </div>

        <div class="form-check">

            <input class="form-check-input" type="radio" name="answer"  value="0" id="0">
            <label class="form-check-label" for="0">
                <%= request.getAttribute("ans1") %>
            </label>
            <br>
            <input class="form-check-input" type="radio" name="answer"  value="1" id="1">
            <label class="form-check-label" for="1">
                <%= request.getAttribute("ans2") %>
            </label>
        </div>

        <div class=" form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="submit" class="btn btn-success">Играть</button>
            </div>
        </div>

        <div>
            <h5 class = "uk-heading-medium">Имя: <%= request.getSession().getAttribute("name") %> </h5>
            <h5 class = "uk-heading-medium">Игр сыграно: <%= request.getSession().getAttribute("count") %> </h5>
        </div>
    </div>
</form>
</body>
</html>
