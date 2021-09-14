<%@include file="header.jsp" %>

<div class="m-4 p-3 width-medium text-color-darker w-50">
    <div class="m-4 border-dashed view-height">
        <div class="container w-75 p-4">

            <table class="table">

                <thead>
                <tr class="d-flex text-color-darker">
                    <th scope="col" class="col-12"> Quotes for approval</th>
                </tr>
                <tr class="d-flex text-color-darker">
                    <th scope="col" class="col-6">content</th>
                    <th scope="col" class="col-4">character</th>
                    <th scope="col" class="col-2">approve</th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <c:forEach items="${quotesToApprove}" var="quote">

                    <tr class="d-flex">
                        <td class="col-6">${quote.content}</td>
                        <td class="col-4">${quote.character.fullName}</td>
                        <td class="col-2">
                            <a href="/add/approve/quote/${quote.id}" class="btn btn-color rounded-25 btn-sm">Approve</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>
