<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-100">
                <form:form class="padding-small text-center" method="post" modelAttribute="userQuestionDTO">
                    <h1 class="text-color-darker">Add question</h1>
                    <div class="form-group">
                        <form:label class="label-size col-form-label" path="question">Question:</form:label>
                        <form:input class="form-control" path="question"/>
                        <small><form:errors cssClass="text-danger" path="question"/></small>
                    </div>

                    <div class="form-group">
                        <form:label class="label-size col-form-label"
                                    path="correctAnswer">Enter the correct answer:</form:label>
                        <form:input class="form-control" path="correctAnswer"/>
                        <small><form:errors cssClass="text-danger" path="correctAnswer"/></small>
                    </div>
                    <label class="label-size col-form-label" for="answers">Enter three incorrect answers:</label>
                    <div id="answers">
                        <c:forEach begin="0" end="2" var="i">
                            <div class="form-group">
                                <form:label class="label-size col-form-label" path="answers">${i+1}.</form:label>
                                <form:input class="form-control" path="answers[${i}]"/>
                                <small><form:errors cssClass="text-danger" path="answers[${i}]"/></small>
                            </div>
                        </c:forEach>
                    </div>

                    <button class="btn btn-color rounded-0" type="submit">Save</button>
                </form:form>
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jsp" %>
