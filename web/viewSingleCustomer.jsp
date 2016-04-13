<%@page import="serviceLayer.entity.Building"%>
<%@page import="serviceLayer.entity.Customer"%>
<%@page import="serviceLayer.ControllerFacade"%>
<%@page import="java.util.List"%>
<%@page import="dataAccessLayer.mapper.MapperFacade"%>
<jsp:include page="header.jsp" />

<%
    if (session.getAttribute("admin") != null) {
        ControllerFacade controllerFacade = new ControllerFacade();
        int customerId = Integer.parseInt((String) session.getAttribute("customerId"));
        List<Building> buildings = controllerFacade.getAllBuildingsByCustomerId(customerId);
        Customer customer = controllerFacade.getCustomerByCustomerId(customerId); %>

<div class="container well">
    <div class="col-md-10 col-md-offset-1">

        <%if (customer != null) {%>

        <div class="row">
            <h1 class="page-header"><%= customer.getCompanyName()%></h1>
        </div>
        <div class="well buildingitem">
            <div class="row">
                <h3 class="page-header col-md-12">Customer info:</h3>
            </div>
            <div class="row border">
                <div class="col-md-4">
                    <p>Company owner name: <strong><%= customer.getCustomerFirstName() + " " + customer.getCustomerLastName()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row border">
                <div class="col-md-4">
                    <p>E-mail: <strong><%= customer.getCustomerEmail()%></strong></p>
                </div>
            </div>
            <br>
        </div>
        <% }%>
        <a class="btn btn-primary" href="viewCustomers.jsp"><i class="fa fa-fw fa-angle-double-left"></i> Back</a>
        <br>
        <% for (Building building : buildings) {%>
        <br>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-building fa-fw"></i>&nbsp;&nbsp;<%= building.getName()%></h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-4">
                        <p>Street: <strong><%= building.getAddress()%></strong></p>
                    </div>
                    <div class="col-md-4">
                        <p>Zipcode: <strong><%= building.getZipcodes()%></strong></p>
                    </div>
                    <div class="col-md-4">
                        <p>City: <strong><%= building.getCity()%></strong></p>
                    </div>
                </div>
            </div>
            <div style="min-height: 55px" class="panel-footer">
                <form action="viewbuilding" method="POST">
                    <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                    <button class="btn btn-primary pull-left" type="submit"><i class="fa fa-fw fa-eye"></i> View</button>
                </form>
                <form action="#" method="POST">
                    <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                    <button style="margin-left: 5px" class="btn btn-success pull-left" type="submit"><i class="fa fa-fw fa-pencil-square-o"></i> Edit</button>
                </form>
                <form action="deletebuilding" method="POST">
                    <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                    <button class="btn btn-danger pull-right" onClick="return confirm('Are you sure you want to delete this building?');" type="submit"><i class="fa fa-fw fa-ban"></i> Delete</button>
                </form>
            </div>
        </div>


        <% }
            }%>
    </div>
</div>

<jsp:include page="footer.jsp" />

