<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>
<div class="lex-content">
    <section class="profile-section">

        <div class="u-clearfix u-sheet u-sheet-1">
            <h1 class="u-custom-font u-text-1">Profile</h1>
            <p class="u-large-text u-text u-text-variant u-text-2">I'm a creative webdeveloper</p>
        </div>
        <form class="profile-form">
            <div class="lex-details">
                <h4 class="u-custom-font u-text u-text-3">Details</h4>
                <p class="u-text u-text-4">
                    <span style="font-weight: 700;">Name: </span>
                    <br>${sessionScope.user.name}
                    <br>
                    <span style="font-weight: 700;">Login: </span>
                    <br>${sessionScope.user.login}
                    <span style="font-weight: 700;">
                        <br>Role:
                    </span>
                    <br>${sessionScope.user.role}
                </p>
            </div>
            <div class="lex-profile-image-wrapper">
                <img class="lex-profile-image" src="/user_images/${sessionScope.user.avatar}">
                <input type="file" class="lex-image-input" id="inputGroupFile01">
            </div>
        </form>
    </section>
</div>

<%@include file="footer.jsp" %>
