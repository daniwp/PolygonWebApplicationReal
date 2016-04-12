<%@page import="serviceLayer.entity.Customer"%>
<%@page import="serviceLayer.ControllerFacade"%>
<%@page import="java.util.List"%>
<%@page import="dataAccessLayer.mapper.MapperFacade"%>
<jsp:include page="header.jsp" />

<%
    if (session.getAttribute("admin") != null) {
        ControllerFacade controllerFacade = new ControllerFacade();
        int customerId = Integer.parseInt((String) session.getAttribute("customerId"));
        Customer customer = controllerFacade.getCustomerByCustomerId(customerId) ;
        List<Building> buildings = ; %>

<div class="container well">
    <div class="col-md-10 col-md-offset-1">

        <%if (customer != null) {%>

        <div class="row">
            <h1 class="page-header"><%= customer%></h1>
        </div>
        <div class="well buildingitem">
            <div class="row">
                <h3 class="page-header col-md-12">Customer info:</h3>
            </div>
            <div class="row border">
                <div class="col-md-4">
                    <p>Company owner name: <strong><%= customer + " " + customer%></strong></p>
                </div>
            </div>
            <br>
            <div class="row border">
                <div class="col-md-4">
                    <p>E-mail: <strong><%= customer%></strong></p>
                </div>
            </div>
            <br>
        </div>
        <% }%>
        <br><br>

        <% }  %>


        <% if (!floors.isEmpty()) {
                for (Floor floor : floors) {%>
        <div class="panel panel-primary">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-4">
                        <h4><strong><%= floor.getFloor()%>.</strong> Floor</h4>
                    </div>
                    <div class="col-md-4">
                        <p>Size: <strong><%= floor.getSize()%></strong></p>
                    </div>
                    <form action="deletefloor" method="POST">
                        <input type="hidden" name="floorId" value="<%=floor.getFloorId()%>">
                        <button class="btn btn-danger col-md-2 col-md-offset-1" type="submit"><i class="fa fa-fw fa-ban"></i> Delete</button>
                    </form>
                </div>
            </div>
        </div>
        <% }
            }%>
    </div>
</div>
<% }%>

<jsp:include page="footer.jsp" />

