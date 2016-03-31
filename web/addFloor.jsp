<jsp:include page="header.jsp" />
<div class="container well">
    <div class="col-md-8 col-md-offset-2">
        <h1 class="page-header">Add floors</h1>
        <form action="#" method="POST">
            <% if (request.getParameter("nrOfFloors") != null)
                            for (int i = 0; i < Integer.parseInt(request.getParameter("nrOfFloors")); i++) { %>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Floor Nr.: </p><input class="list-item" type="text" name="floorNr<%=i+1%>" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Floor m2: </p><input class="form-control" type="text" name="floorM2<%=i+1%>" required>
                    </div>
                </div>
            </div>
            <% }
                    else {%>
            <br><br>
            <div class="alert alert-danger">
                <p class="text-center">Something went wrong ): <br> Please try again</p>
            </div>
            <br><br>
            <a href="index.jsp" class="btn btn-primary col-md-2 col-md-offset-5">Add building</a>
            <% }%>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
