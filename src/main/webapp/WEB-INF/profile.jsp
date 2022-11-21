<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>
<div class="app-body">
    <div class="lex-content-wrapper">
        <div class="lex-content">
            <div class="lex-profile-intro">
                <h1>Профиль</h1>
                <div class="lex-intro-description">Здесь вы можете настроить свой профиль</div>
            </div>
            <form class="lex-profile-form">
                <div class="lex-profile-image-wrapper">
                    <img class="lex-profile-image" src="/user_images/${sessionScope.user.avatar}">
                    <input type="file" class="lex-image-input" id="inputGroupFile01">
                </div>
                <div class="lex-details">
                    <h4>Подробности</h4>
                    <div class="lex-table-details-wrap">
                        <table class="lex-table-details">
                            <tbody>
                            <tr>
                                <td>Имя:</td>
                                <td>${sessionScope.user.name}</td>
                            </tr>
                            <tr>
                                <td>Логин:</td>
                                <td>${sessionScope.user.login}</td>
                            </tr>
                            <tr>
                                <td>Роль:</td>
                                <td>${sessionScope.user.role}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="lex-change-pwd-wrap">
                        <button>Сменить пароль</button>
                        <div class="lex-pswd-wrap">
                            <label for="old-pswd">Старый пароль</label>
                            <input id="old-pswd" type="password" name="oldPassword" placeholder="Введите старый пароль">
                        </div>
                        <div class="lex-pswd-wrap">
                            <label for="new-pswd">Новый пароль</label>
                            <input id="new-pswd" type="password" name="newPassword" placeholder="Введите новый пароль">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
