<%@include file="header.jsp" %>
<%--<%@include file="sidemenu.jsp" %>--%>

<%--<h2>Who said it?</h2>--%>
<%--<h4>Write first and last name of the character.</h4>--%>
<section class="dashboard-section">
    <div class="container pt-4 pb-4 w-75">
        <div class="border-dashed view-height">
            <div class="container p-4 w-75">
                <h5 class="text-color-darker p-4 d-inline text-center">
                    <c:if test="${currentQuiz.currentCorrect}">Correct!</c:if>
                    <c:if test="${not currentQuiz.currentCorrect}">Wrong. Correct answer: ${currentQuiz.currentCorrectAnswer}</c:if>
                </h5>
                <c:if test="${currentQuiz.currentQuestionIndex<currentQuiz.size-1}"><a class="btn btn-color btn-sm rounded-25 " href="/quiz/writers">Next</a> </c:if>
                <c:if test="${currentQuiz.currentQuestionIndex==currentQuiz.size-1}">
                    <br><h6 class="text-color-darker p-4 d-inline text-center">
                        <c:out value="You got ${currentQuiz.points}/${currentQuiz.size} points!" default="Error, sorry"/>
                    </h6>
                    <a class="btn btn-color btn-sm rounded-25 " href="/quiz/writers/endQuiz">Home</a>
                </c:if>
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jsp" %>
