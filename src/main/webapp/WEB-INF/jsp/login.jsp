<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="sidemenu.jsp" %>

<div class="m-4 p-3 width-medium text-color-darker w-50">
    <div class="m-4 border-dashed view-height">
        <div class="container w-75 p-4">
            <c:url value="/login" var="loginUrl"/>
            <form class="padding-small" action="${loginUrl}" method="post">
                <c:if test="${param.error != null}">
                    <p>
                        Invalid username and password.
                    </p>
                </c:if>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="login"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password"/>
                </div>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button type="submit" class="btn btn-color rounded-25">Log in</button>
            </form>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>
