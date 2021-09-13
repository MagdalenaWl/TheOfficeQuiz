<%@include file="header.jsp" %>
<%@include file="sidemenu.jsp" %>

<div class="m-4 p-3 width-medium text-color-darker w-50">
    <div class="m-4 border-dashed view-height">
        <div class="container w-75 p-4">

            <table class="table">

                <thead>
                <tr class="d-flex text-color-darker">
                    <th scope="col" class="col-12">user details</th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th scope="row" class="col-5">login</th>
                    <td class="col-5">${loggedUser.login}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-5">email</th>
                    <td class="col-5">${loggedUser.email}</td>
                </tr>

                <tr class="d-flex">
                    <th scope="row" class="col-5">played games</th>
                    <td class="col-5">${loggedUser.games}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-5">average score</th>
                    <td class="col-5">${loggedUser.avg}</td>
                </tr>

                <c:if test="${played}">
                    <tr class="d-flex">
                        <th scope="row" class="col-5">played games in month</th>
                        <td class="col-5">${loggedUser.games}</td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-5">average score in month</th>
                        <td class="col-5">${loggedUser.monthAvg}</td>
                    </tr>
                </c:if>
                <c:if test="${not played}">
                    <th scope="row" class="col-10">you haven't played this month</th>
                </c:if>

                </tbody>
            </table>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>
