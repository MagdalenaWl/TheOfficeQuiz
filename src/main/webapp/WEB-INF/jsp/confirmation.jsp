<%@include file="header.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-75">
                <form class="padding-small" method="POST">
                    <h1 class="text-color-darker text-center">Do you want to end current quiz?</h1>
                    <div class="form-check">
                        <input class="btn-check" type="radio" class="form-control" name="confirm" id="yes"
                               value="y">
                        <label class="btn btn-outline-danger" for="yes">YES</label>
                    </div>
                    <div class="form-check">
                        <input class="btn-check" type="radio" class="form-control" name="confirm" id="no"
                               value="n" checked>
                        <label class="btn btn-outline-success" for="no">NO</label>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-color rounded-25" type="submit">Confirm</button>
                </form>
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jsp" %>
