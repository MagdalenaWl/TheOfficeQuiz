<%@include file="header.jsp" %>
<%@include file="sidemenu.jsp" %>

<section class="dashboard-section">
    <div class="container pt-4 pb-4 w-75">
        <div class="border-dashed view-height">
            <div class="container p-4 w-75">
                <h6 class="text-color-darker p-4 d-inline text-center">
                    <c:out value="You got ${points}/10 points!" default="Error, sorry"/>
                </h6>
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jsp" %>
