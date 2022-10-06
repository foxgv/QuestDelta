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
            <h5 class = "uk-heading-large"><%= request.getAttribute("questionText") %> </h5>
        </div>

        <div class="form-check">
            <input class="form-check-input" type="radio" name="answer1" id="answer1">
            <label class="form-check-label" for="answer1">
                <%= request.getAttribute("ans1") %>
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="answer2" id="answer2">
            <label class="form-check-label" for="answer2">
                <%= request.getAttribute("ans2") %>
            </label>
        </div>

        <div class=" form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="submit" class="btn btn-success">Играть</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
