<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="web-parts/HTML-header.jsp" %>

<div class="bg-dark text-secondary px-4 py-5 text-center" style="min-height: 100%; padding-top: 15% !important;">
    <div class="py-5">
        <h1 class="display-5 fw-bold text-white">Игра окончена</h1>
        <div class="col-lg-6 mx-auto">
            <p class="fs-5 mb-4">Вы правильно ответили на ${sessionScope.correctAnswersCount} вопросов
                из ${applicationScope.totalQuestionsCount}</p>
            <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                <form action="user">
                    <button type="submit" name="new_game" class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">Новая
                        игра
                    </button>
                </form>
                <form action="statistics">
                    <button type="submit" class="btn btn-outline-light btn-lg px-4">Статистика</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="web-parts/HTML-footer.jsp" %>