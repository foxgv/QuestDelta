<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="web-parts/HTML-header.jsp"%>

<div class="bg-dark text-secondary px-4 py-5 text-center" style="min-height: 100%; padding-top: 15% !important;">
    <div class="py-5">
        <h1 class="display-5 fw-bold text-white">Введите пользователя</h1>
        <div class="col-lg-6 mx-auto">
            <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                <form action="user" method="post">
                    <div class="form-floating mb-3">
                        <input type="text" name="user" class="form-control" id="floatingInput" placeholder="Пользователь" required style="width: 300">
                        <label for="floatingInput">Пользователь</label>
                    </div>
                    <button type="submit" class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">Начать</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="web-parts/HTML-footer.jsp"%>