<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="sidemenu.jsp" %>

<div class="m-4 p-3 width-medium text-color-darker w-50">
    <div class="m-4 border-dashed view-height">
        <div class="container w-75 p-4">
            <c:url value="/logout" var="logoutUrl"/>
            <h1>Are you sure you want to log out?</h1>
            <form class="padding-small" action="${logoutUrl}" method="post">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button id="logoutBtn" type="submit" class="btn btn-color rounded-25" value="Logout">Log out</button>
            </form>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>
