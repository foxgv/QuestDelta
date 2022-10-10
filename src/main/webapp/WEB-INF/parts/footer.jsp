<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
    <footer class="py-3 my-4">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link px-2 text-muted">Домой</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Квесты</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Создать</a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/question" class="nav-link px-2 text-muted">Играть</a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/stats" class="nav-link px-2 text-muted">Статистика</a></li>
        </ul>
        <p class="text-center text-muted">© 2022 Ryabov project, Inc</p>
    </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>