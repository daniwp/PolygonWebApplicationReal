<%@page import="serviceLayer.Controller"%>
<jsp:include page="header.jsp" />
<% Controller controller = new Controller(); %>
<div class="container well">
    <div class="col-md-8 col-md-offset-2">
        <h1 class="page-header">Add floors</h1>
        <form action="addfloor" method="POST">
            <% if (request.getParameter("nrOfFloors") != null) {
                    for (int i = 0; i < Integer.parseInt(request.getParameter("nrOfFloors")); i++) {%> 
            <div class="row well flooritem">
                <div class="col-md-2">
                    <h4 class="vtop"><%= i + 1%>. </h4>
                </div>
                <div class="vcenter col-md-4">
                    <div class="form-group">
                        <div class="col-md-6">
                            <p>Floor nr.: </p>
                        </div>
                        <div class="col-md-6">
                            <input class="form-control" type="number" maxlength="3" name="floorNr<%=i + 1%>" required>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="col-md-4">
                            <p>Floor size: </p>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="number" maxlength="4" name="floorSize<%=i + 1%>" required>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
            <button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Submit</button>
            <% } else {%>
            <br><br>
            <div class="alert alert-danger">
                <p class="text-center">Something went wrong ): <br> Please try again</p>
            </div>
            <br><br>
            <a href="index.jsp" class="btn btn-primary col-md-2 col-md-offset-5">Add building</a>
            <% }%>
            <br><br><br><br><br><br><br><br>
            <input type="hidden" name="buildingId" value="<%= controller.getBuildingIdByName((String)session.getAttribute("buildingName")) %>">
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
