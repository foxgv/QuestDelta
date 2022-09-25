<%@include file="parts/header.jsp" %>
<div class="container">
    <form class="form-horizontal" action="signup?id=${requestScope.user.id}" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userLogin">Login</label>
                <div class="col-md-4">
                    <input id="userLogin" name="login" type="text" placeholder="placeholder"
                           class="form-control input-md"
                           value="${requestScope.user.login}">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userPassword">Password</label>
                <div class="col-md-4">
                    <input id="userPassword" name="password" type="password" placeholder="placeholder"
                           class="form-control input-md"
                           value="${requestScope.user.password}">

                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="roleSelect">Role</label>
                <div class="col-md-4">
                    <select id="roleSelect" name="select" class="form-control">
                        <option value="ADMIN">ADMIN</option>
                        <option value="USER">USER</option>
                        <option value="GUEST">GUEST</option>
                    </select>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="${requestScope.user.id>0?"update":"create"}" class="btn btn-success">
                        ${requestScope.user.id>0?"Update":"Create"}
                    </button>
                </div>
            </div>


            <!-- Button -->
            <c:if test="${requestScope.user.id>0}">
                <div class="form-group">
                    <label class="col-md-4 control-label" for="delete"></label>
                    <div class="col-md-4">
                        <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                    </div>
                </div>
            </c:if>

        </fieldset>
    </form>
</div>
<%@include file="parts/footer.jsp" %>
