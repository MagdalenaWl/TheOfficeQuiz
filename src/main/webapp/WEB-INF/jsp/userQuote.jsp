<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-100">
                <form:form class="padding-small text-center" method="post" modelAttribute="userQuoteDTO">
                    <h1 class="text-color-darker">Add quote</h1>
                    <div class="form-group">
                        <form:label class="abel-size col-form-label" path="content">Content:</form:label>
                        <form:input class="form-control" path="content"/>
                        <small><form:errors cssClass="text-danger" path="content"/></small>
                    </div>

                    <div class="form-group">
                        <form:label class="label-size col-form-label" path="character">Character:</form:label>
                        <form:select items="${characters}" itemValue="id" itemLabel="fullName" class="form-control"
                                     path="character"/>
                        <small><form:errors cssClass="text-danger" path="character"/></small>
                    </div>

                    <button class="btn btn-color rounded-0" type="submit">Save</button>
                </form:form>
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jsp" %>
