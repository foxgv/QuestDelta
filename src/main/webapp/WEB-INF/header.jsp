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
        <link href="../css/reset.css" rel="stylesheet">
        <link rel="icon" href="../icons/favicon.png" type="image/png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <link href="../css/myStyle.css" rel="stylesheet">

     </head>
     <body>
         <header class="p-3 text-bg-dark">
             <div class="container">
                 <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                     <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                         <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                     </a>
                     <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                         <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                         <li><a href="/quests" class="nav-link px-2 text-white">Quests</a></li>
                         <c:if test="${not empty sessionScope.user}">
                             <li><a href="#" class="nav-link px-2 text-white">Constructor</a></li>
                            <c:if test="${sessionScope.user.role=='ADMINISTRATOR'}">
                                <li><a href="#" class="nav-link px-2 text-white">Users</a></li>
                            </c:if>
                         </c:if>
                         <li><a href="/statistic" class="nav-link px-2 text-white">Statistic</a></li>
                     </ul>
                     <!--<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                         <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                     </form> -->

                     <div class="text-end">
                         <c:choose>
                            <c:when test="${empty sessionScope.user}">
<%--                                 <button type="button" class="btn btn-outline-light me-2" data-bs-toggle="modal" data-bs-target="#modalSignin">Войти</button>--%>
<%--                                 &lt;%&ndash;<button type="button" class="btn btn-outline-light me-2" onclick="window.location.href = 'login'">Войти</button>&ndash;%&gt;--%>
<%--                                 <button type="button" class="btn btn-warning">Регистрация</button>--%>
                                <nav class="main-nav">
                                    <ul>
                                        <!-- inser more links here -->
                                        <li><a class="cd-signin" href="#0">Войти в систему</a></li>
                                        <li><a class="cd-signup" href="#0">Зарегистрироваться</a></li>
                                    </ul>
                                </nav>
                            </c:when>
                             <c:otherwise>
                                 <nav class="main-nav">
                                     <div style="display: inline-block">
                                         <a href="/user" class="nav-link px-2 text-white">${sessionScope.user.name}</a>
                                     </div>
                                     <li><a class="cd-quit" href="logout">Выйти</a></li>
                                 </nav>
<%--                                 <button type="button" class="btn btn-warning" onclick="window.location.href = 'logout'">Выйти</button>--%>
                             </c:otherwise>
                         </c:choose>
                     </div>
                 </div>

                 <div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
                     <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
                         <ul class="cd-switcher">
                             <li><a href="#0">Войти</a></li>
                             <li><a href="#0">Новый пользователь</a></li>
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

                             <!-- <p class="cd-form-bottom-message"><a href="#0">Forgot your password?</a></p>-->
                             <!-- <a href="#0" class="cd-close-form">Close</a> -->
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
                                     <input class="full-width has-padding has-border" id="signup-password" name="password" type="text"  placeholder="Пароль">
                                     <a href="#0" class="hide-password">Hide</a>
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
                                     ${requestScope.errorMessage} - Пользователь с такими данными не существует
                                 </div>
                             </div>
                         </div>
                     </div> <!-- cd-user-modal-container -->
                 </div> <!-- cd-user-modal -->
             </div>
         </header>

