<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-100">
                <form:form class="padding-small text-center"  method="post" modelAttribute="userDTO">
                    <h1 class="text-color-darker">Registration</h1>
                    <div class="form-group">
                        <form:label class="abel-size col-form-label" path="login">Login:</form:label>
                        <form:input class="form-control" path="login"/>
                        <small><form:errors cssClass="text-danger" path="login"/></small>
                    </div>

                    <div class="form-group">
                        <form:label class="label-size col-form-label" path="email">Email:</form:label>
                        <form:input class="form-control" path="email"/>
                        <small><form:errors cssClass="text-danger" path="email"/></small>
                    </div>
                    <div class="form-group">
                        <form:label class="label-size col-form-label" path="password">Password:</form:label>
                        <form:password  class="form-control" path="password" />
                        <small><form:errors cssClass="text-danger" path="password"/></small>
                    </div>
                    <div class="form-group">
                        <form:label class="label-size col-form-label" path="repassword">Repeat password:</form:label>
                        <form:password class="form-control" path="repassword" />
                        <small><form:errors cssClass="text-danger" path="repassword"/></small>
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Sign Up</button>
                </form:form>
            </div>
        </div>
    </div>
</section>




<%@include file="footer.jsp"%>
