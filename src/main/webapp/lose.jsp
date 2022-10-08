<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Проигрыш</title>

</head>
<body>
<form class="form-horizontal" action="index.jsp" method="get">
    <div class="form-group">
        <div class="col-md-4">
        </div>
        <div>
            <h5 class = "uk-heading-large"><%= request.getAttribute("questionText") %> </h5>
        </div>
        <div>
            <% request.setAttribute("id" , null);
            %>
        </div>

    </div>

    <div class=" form-group">
        <label class="col-md-4 control-label" for="submit"></label>
        <div class="col-md-4">
            <button id="submit" class="btn btn-success">Играть заново</button>
        </div>
    </div>
</form>

</body>
</html>
