<%--
  Created by IntelliJ IDEA.
  User: lexink
  Date: 25.09.2022
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Quest</title>
        <!-- CSS only -->
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
                         <li><a href="#" class="nav-link px-2 text-white">Constructor</a></li>
                         <li><a href="#" class="nav-link px-2 text-white">Users</a></li>
                         <li><a href="#" class="nav-link px-2 text-white">Statistic</a></li>
                     </ul>

                     <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                         <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                     </form>

                     <div class="text-end">
                         <c:choose>
                            <c:when test="${empty sessionScope.user}">
                                 <%--button type="button" class="btn btn-outline-light me-2" data-bs-toggle="modal" data-bs-target="#modalSignin">Войти</button>--%>
                                 <button type="button" class="btn btn-outline-light me-2" onclick="window.location.href = 'login'">Войти</button>
                                 <button type="button" class="btn btn-warning">Регистрация</button>
                            </c:when>
                             <c:otherwise>
                                 <button type="button" class="btn btn-outline-light me-2" onclick="window.location.href = 'profile'">Профиль</button>
                                 <button type="button" class="btn btn-warning" onclick="window.location.href = 'logout'">Выйти</button>
                             </c:otherwise>
                         </c:choose>
                     </div>
                 </div>

                 <div class="modal fade modal-signin bg-secondary py-5" tabindex="-1" role="dialog" id="modalSignin">
                     <div class="modal-dialog" role="document">
                         <div class="modal-content rounded-4 shadow">
                             <div class="modal-header p-5 pb-4 border-bottom-0">
                                 <!-- <h5 class="modal-title">Modal title</h5> -->
                                 <h2 class="fw-bold mb-0">Войти в аккаунт</h2>
                                 <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                             </div>

                             <div class="modal-body p-5 pt-0">
                                 <form class="" action="login" method="post">
                                     <div class="form-floating mb-3">
                                         <input type="email" class="form-control rounded-3" id="floatingInput" placeholder="name@example.com">
                                         <label for="floatingInput">Login</label>
                                     </div>
                                     <div class="form-floating mb-3">
                                         <input type="password" class="form-control rounded-3" id="floatingPassword" placeholder="Password">
                                         <label for="floatingPassword">Password</label>
                                     </div>
                                     <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit"">Войти</button>
                                     <small class="text-muted">By clicking Sign up, you agree to the terms of use.</small>
                                     <hr class="my-4">
                                     <c:if test="${not empty requestScope.errorMessage}">
                                         <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                                             <symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
                                                 <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                             </symbol>
                                         </svg>
                                         <div class="alert alert-danger d-flex align-items-center" role="alert">
                                             <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                                             <div>
                                                     ${requestScope.errorMessage}
                                             </div>
                                         </div>
                                     </c:if>
                                 </form>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </header>

