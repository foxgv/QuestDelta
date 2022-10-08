<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<div class="container">
    <div class="container">
        <legend>Страница находится на разработке. Нужно проявить терпение....</legend>
        <legend>Страница находится на разработке. Нужно проявить терпение....</legend>

        <legend>Сколько будет 2+2</legend>
        <legend>2+2 = ${2+2}</legend>
        <form method="get">
            <div class="form-group">
                <label class="col-md-4 control-label" for="newGame"></label>
                <div class="col-md-4">
                    <button id="newGame" name="newGame" value="newGame"
                            class="btn btn-warning">Назад
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="parts/footer.jsp" %>
