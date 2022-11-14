<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
    <head>
        <title>Quest</title>
        <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
        <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
        <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta:400">

        <!-- CSS only -->
        <link href="../css/bootstrap-reboot.css" rel="stylesheet">
        <link rel="icon" href="../icons/favicon.png" type="image/png">
        <link href="../css/myStyle.css" rel="stylesheet">

     </head>
     <body>
        <div class="lex-container">
            <header class="lex-header">
                 <a href="/" class="lex-logo">
                     <div class="lex-logo-wrap">
                         <img src="../icons/favicon.png" alt="Lex-logo" class="lex-logo-img">
                         <div class="lex-logo-text">КВЕСТЫ</div>
                     </div>

                 </a>
                 <nav class="lex-header-nav">
                     <ul class="lex-nav-list">
                         <li class="lex-nav-item"><a href="/" class="nav-link px-2 text-secondary">Домой</a></li>
                         <li class="lex-nav-item"><a href="/quests" class="nav-link px-2 text-white">Квесты</a></li>
                         <c:if test="${not empty sessionScope.user}">
                             <li class="lex-nav-item"><a href="/constructor" class="nav-link px-2 text-white">Конструктор</a></li>
                             <c:if test="${sessionScope.user.role=='ADMINISTRATOR'}">
                                 <li class="lex-nav-item"><a href="#" class="nav-link px-2 text-white">Пользователи</a></li>
                             </c:if>
                         </c:if>
                         <li class="lex-nav-item"><a href="/statistic" class="nav-link px-2 text-white">Статистика</a></li>
                     </ul>
                 </nav>
                 <div class="lex-auth">
                     <c:choose>
                         <c:when test="${empty sessionScope.user}">
                             <nav class="lex-main-nav">
                                 <ul>
                                     <!-- inser more links here -->
                                     <li><a class="cd-signin" href="#0">Войти в систему</a></li>
                                     <li><a class="cd-signup" href="#0">Зарегистрироваться</a></li>
                                 </ul>
                             </nav>
                         </c:when>
                         <c:otherwise>
                             <nav class="lex-main-nav">
                                 <ul>
                                    <li><a class="lex-head-profile" href="/user" class="nav-link px-2 text-white">${sessionScope.user.name}</a></li>
                                    <li><a class="cd-quit" href="logout">Выйти</a></li>
                                 </ul>
                             </nav>
                             <%--                                 <button type="button" class="btn btn-warning" onclick="window.location.href = 'logout'">Выйти</button>--%>
                         </c:otherwise>
                     </c:choose>
                 </div>
                 <div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
                     <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
                         <ul class="cd-switcher">
                             <li><a href="#0">Вход</a></li>
                             <li><a href="#0">Новый аккаунт</a></li>
                         </ul>

                         <div id="cd-login"> <!-- log in form -->
                             <form class="cd-form" id="login-form">
                                 <p class="fieldset">
                                     <label class="image-replace cd-email" for="signin-login">Логин</label>
                                     <input class="full-width has-padding has-border" id="signin-login" name="login" type="text" placeholder="Login">
                                     <span class="cd-error-message">Ошибка! Не заполнен логин!</span>
                                 </p>

                                 <p class="fieldset">
                                     <label class="image-replace cd-password" for="signin-password">Пароль</label>
                                     <input class="full-width has-padding has-border" id="signin-password" name="password" type="password"  placeholder="Password">
                                     <a href="#0" class="hide-password">Show</a>
                                     <span class="cd-error-message">Ошибка! Не заполнен пароль!</span>
                                 </p>

                                 <p class="fieldset">
                                     <input type="checkbox" id="remember-me" checked>
                                     <label for="remember-me">Запомнить меня</label>
                                 </p>

                                 <p class="fieldset">
                                     <input class="full-width" type="submit" value="Войти">
                                 </p>
                             </form>
                         </div> <!-- cd-login -->

                         <div id="cd-signup"> <!-- sign up form -->
                             <form class="cd-form" id="signup-form">
                                 <p class="fieldset">
                                     <label class="image-replace cd-username" for="signup-username">Имя</label>
                                     <input class="full-width has-padding has-border" id="signup-username" name="name" type="text" placeholder="Имя пользователя">
                                     <span class="cd-error-message">Необходимо указать имя пользователя!</span>
                                 </p>

                                 <p class="fieldset">
                                     <label class="image-replace cd-email" for="signup-login">Логин</label>
                                     <input class="full-width has-padding has-border" id="signup-login" name="login" type="text" placeholder="Логин">
                                     <span class="cd-error-message">Необходимо указать логин!</span>
                                 </p>

                                 <p class="fieldset">
                                     <label class="image-replace cd-password" for="signup-password">Пароль</label>
                                     <input class="full-width has-padding has-border" id="signup-password" name="password" type="password"  placeholder="Пароль">
                                     <a href="#0" class="hide-password">Show</a>
                                     <span class="cd-error-message">Поле с паролем не может быть пустым!</span>
                                 </p>

                                 <p class="fieldset">
                                     <input type="checkbox" id="accept-terms">
                                     <label for="accept-terms">I agree to the <a href="#0">Terms</a></label>
                                 </p>

                                 <p class="fieldset">
                                     <input class="full-width has-padding" type="submit" value="Создать">
                                 </p>
                             </form>

                             <!-- <a href="#0" class="cd-close-form">Close</a> -->
                         </div> <!-- cd-signup -->

                         <div id="cd-reset-password"> <!-- reset password form -->
                             <p class="cd-form-message">Lost your password? Please enter your email address. You will receive a link to create a new password.</p>

                             <form class="cd-form">
                                 <p class="fieldset">
                                     <label class="image-replace cd-email" for="reset-email">E-mail</label>
                                     <input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
                                     <span class="cd-error-message">Error message here!</span>
                                 </p>

                                 <p class="fieldset">
                                     <input class="full-width has-padding" type="submit" value="Reset password">
                                 </p>
                             </form>

                             <p class="cd-form-bottom-message"><a href="#0">Back to log-in</a></p>
                         </div> <!-- cd-reset-password -->
                         <a href="#0" class="cd-close-form">Close</a>
                         <div id="error-login" class="is-hide">
                             <svg xmlns="http://www.w3.org/2000/svg" class="alert-icon" style="display: none;">
                                 <symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
                                     <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                 </symbol>
                             </svg>
                             <div class="alert alert-danger d-flex align-items-center" role="alert">
                                 <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                                 <div>
                                     Неверно указаны логин или пароль.
                                 </div>
                             </div>
                         </div>
                         <div id="error-submit" class="is-hide">
                             <svg xmlns="http://www.w3.org/2000/svg" class="alert-icon" style="display: none;">
                                 <symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
                                     <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                 </symbol>
                             </svg>
                             <div class="alert alert-danger d-flex align-items-center" role="alert">
                                 <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                                 <div>
                                     Неверно введены данные или пользователь с таким логином уже существует.
                                 </div>
                             </div>
                         </div>
                     </div> <!-- cd-user-modal-container -->
                 </div> <!-- cd-user-modal -->
            </header>
        </div>

