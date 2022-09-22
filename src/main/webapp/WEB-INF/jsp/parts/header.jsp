<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="p-3 text-bg-dark">
  <div class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
      <a href="${pageContext.request.contextPath}/menu" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
        <img class="bi me-2" width="40" height="40" src="images/eagle-white.svg" alt="eagle-logo"/>
      </a>

      <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li><a href="${pageContext.request.contextPath}/menu" class="nav-link px-2 text-secondary">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/accounts" class="nav-link px-2 text-white">Accounts</a></li>
        <li><a href="${pageContext.request.contextPath}/edit" class="nav-link px-2 text-white">Editor</a></li>
        <li><a href="${pageContext.request.contextPath}/play" class="nav-link px-2 text-white">Game</a></li>
      </ul>

      <div class="d-flex align-items-center">
        <c:choose>
          <c:when test="${empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-light me-2">Login</a>
            <a href="${pageContext.request.contextPath}/signup" class="btn btn-primary">Sign-up</a>
          </c:when>
          <c:otherwise>
            <p class="mb-0 px-3">${sessionScope.user.login}</p>
            <a href="${pageContext.request.contextPath}/menu" class="btn btn-outline-light me-2">Profile</a>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>
          </c:otherwise>
        </c:choose>

      </div>
    </div>
  </div>
</header>
