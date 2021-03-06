<%@include file="header.jsp" %>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-75">
                <form class="padding-small" method="POST" modelAttribute>
                    <h1 class="text-color-darker text-center">Who wrote it?</h1>
                    <h6 class="text-color-darker text-center">Write first and last name of screenwriter of this
                        episode.</h6>
                    <div class="form-group">
                        <label>${currentQuiz.currentQuestion}</label>
                        <input type="text" class="form-control" name="answer" list="list-crew">
                        <datalist id="list-crew">
                            <c:forEach items="${crew}" var="crewMember">
                                <option>${crewMember.name}</option>
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
