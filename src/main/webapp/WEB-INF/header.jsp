<%--
  Created by IntelliJ IDEA.
  User: lexink
  Date: 25.09.2022
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Quest</title>
        <!-- CSS only -->

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
                         <button type="button" class="btn btn-outline-light me-2" data-bs-toggle="modal" data-bs-target="#modalSignin">Войти</button>
                         <button type="button" class="btn btn-warning">Регистрация</button>
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
                                 </form>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </header>

