<%@include file="header.jsp" %>
<%@include file="sidemenu.jsp" %>

<div class="m-4 p-3 width-medium text-color-darker w-50">
    <div class="m-4 border-dashed view-height">
        <div class="container w-75 p-4">
            <h4 class="text-color-darker p-4 d-inline text-center">
                Players of the Month
            </h4>
            <h4></h4>
            <table class="table">

                <thead>
                <tr class="d-flex text-color-darker">
                    <th scope="col" class="col-2">place</th>
                    <th scope="col" class="col-5">login</th>
                    <th scope="col" class="col-5">average score</th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <c:forEach items="${best}" var="user" varStatus="i">
                    <tr class="d-flex">
                        <th scope="row" class="col-2">${i.count}</th>
                        <td class="col-5">
                                ${user.login}
                        </td>
                        <td class="col-5">${user.avg}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>
