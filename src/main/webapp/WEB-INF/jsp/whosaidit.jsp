<%@include file="header.jsp" %>
<%--<%@include file="sidemenu.jsp" %>--%>

<%--<h2>Who said it?</h2>--%>
<%--<h4>Write first and last name of the character.</h4>--%>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-75">
                <form class="padding-small" method="POST" modelAttribute>
                    <h1 class="text-color-darker text-center">Who said it?</h1>
                    <h6 class="text-color-darker text-center">Write first and last name of character.</h6>
                        <div class="form-group">
                            <label>"${currentQuiz.currentQuestion}"</label>
                            <input type="text" class="form-control" name="answer" list="list-characters">
                            <datalist id="list-characters">
                                <c:forEach items="${characters}" var="character">
                                    <option>${character.fullName}</option>
                                </c:forEach>
                            </datalist>
                        </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-color rounded-25" type="submit">Check</button>
                </form>
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jsp" %>
