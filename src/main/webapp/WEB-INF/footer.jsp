<%--
  Created by IntelliJ IDEA.
  User: lexink
  Date: 25.09.2022
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
        <div class="lex-container">
            <footer class="lex-footer">
                    <nav class="lex-footer-nav">
                        <ul class="lex-nav-list">
                            <li class="nav-item-footer"><a href="/" class="nav-link px-2 text-muted">Домой</a></li>
                            <li class="nav-item-footer"><a href="/quests" class="nav-link px-2 text-muted">Квесты</a></li>
                            <c:if test="${not empty sessionScope.user}">
                                <li class="nav-item-footer"><a href="/constructor" class="nav-link px-2 text-muted">Конструктор</a></li>
                                <c:if test="${sessionScope.user.role=='ADMINISTRATOR'}">
                                    <li class="nav-item-footer"><a href="#" class="nav-link px-2 text-muted">Пользователи</a></li>
                                </c:if>
                            </c:if>
                            <li class="nav-item-footer"><a href="/statistic" class="nav-link px-2 text-muted">Статистика</a></li>
                        </ul>
                    </nav>
                    <p class="text-center text-muted">© 2022 Lexink, Inc</p>
            </footer>
        </div>

        <!-- JavaScript  -->
        <script src="../js/aeroplane.js"></script>
        <script src="../js/three.js"></script>
        <script src="../js/myScript.js"></script>
    </body>
</html>
