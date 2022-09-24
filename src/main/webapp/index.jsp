<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="WEB-INF/parts/header.txt"%>

<div class="container">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link">Home</a></li>
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    Quests
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="space-quest">Space Quest</a></li>
                    <li><a class="dropdown-item" href="java-quest">Java Quest</a></li>
                </ul>
            </div>
            <li class="nav-item"><a href="/stat" class="nav-link">Statistics</a></li>
        </ul>
    </header>
</div>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <div class="col-10 col-sm-8 col-lg-6">
            <img src="${pageContext.request.contextPath}/images/img.png" class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="700" height="500" loading="lazy">
        </div>
        <div class="col-lg-6">
            <h1 class="display-5 fw-bold lh-1 mb-3">Hello, there!</h1>
            <p class="lead">This website is made for training purpose. Choose your quest, think, learn, have fun.</p>
        </div>
    </div>
</div>

<%@ include file="WEB-INF/parts/footer.txt"%>