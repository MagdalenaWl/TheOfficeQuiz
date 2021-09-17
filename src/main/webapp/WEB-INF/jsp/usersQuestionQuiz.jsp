<%@include file="header.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container p-4 w-75">
                <h1 class="text-color-darker text-center">Check the correct answer</h1><br>
            </div>
                <div class="container w-75">
                <form class="padding-small" method="POST">
                    <label>"${currentQuiz.currentQuestion}"</label>

                    <div class="form-group">
                            <c:forEach items="${currentQuiz.currentAnswers}" var="answer">
                                <input type="radio" class="btn-check" name="answer" id="${answer.answer}" value="${answer.answer}" autocomplete="off">
                                <label class="btn btn-outline-primary" for="${answer.answer}">${answer.answer}</label><br>
                            </c:forEach>
                        </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-color rounded-25" type="submit">Check</button>
                </form>
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jsp" %>
