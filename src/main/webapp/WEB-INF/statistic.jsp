<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>
<div class="lex-content">
    <div class="lex-table-wrapper">
        <table>
            <tbody class="lex-tbody">
            <tr>
                <th>Name</th>
                <th>All Games</th>
            </tr>
                <c:forEach var="statUser" items="${requestScope.statistic.users}">
                    <tr>
                        <td>${statUser.name}</td>
                        <td>${statUser.allGames}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="footer.jsp" %>