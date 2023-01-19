<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:import url="parts/header.jsp"/>
<div class="container">
    <form class="form-horizontal" action="signup" method="post" enctype="multipart/form-data">
        <fieldset>

            <!-- Form Name -->
            <legend>User Form</legend>

            <!-- File Button -->
            <div class="form-group">

                <label class="col-md-4 control-label" for="image">
                    <div class="form-group">
                        <img id="previewId" src="images/${user.image}" width="150" alt="${user.image}">
                    </div>
                    Нажмите чтобы изменить
                </label>
                <div class="col-md-4">
                    <input onchange="PreviewImage('image','previewId');" id="image" name="image"
                           style="visibility:hidden;"
                           class="input-file" type="file">
                </div>
            </div>

            <script type="text/javascript">
                            function PreviewImage(inputFileId,imageId) {
                                var oFReader = new FileReader();
                                oFReader.readAsDataURL(document.getElementById(inputFileId).files[0]);
                                oFReader.onload = function (oFREvent) {
                                    document.getElementById(imageId).src = oFREvent.target.result;
                                };
                            };

            </script>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userLogin">Login</label>
                <div class="col-md-4">
                    <input id="userLogin" name="login" type="text" placeholder="set login" class="form-control input-md"
                           required=""
                           value="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userPassword">Password</label>
                <div class="col-md-4">
                    <input id="userPassword" name="password" type="password" placeholder="pass req"
                           class="form-control input-md" required=""
                           value="">

                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userRole">Role</label>
                <div class="col-md-4">
                    <select id="userRole" name="role" class="form-control">
                        <c:forEach items="${applicationScope.roles}" var="role">
                            <option value="${role}" ${role=="USER"?"selected":""}>
                                    ${role}
                            </option>
                        </c:forEach>

                    </select>
                </div>
            </div>

            <!-- Button -->
            <div class=" form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="create"
                            class="btn btn-success">Create</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
<c:import url="parts/footer.jsp"/>

