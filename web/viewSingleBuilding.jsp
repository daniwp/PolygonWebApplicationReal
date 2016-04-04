<%@page import="dataAccessLayer.mapper.BuildingMapper"%>
<%@page import="serviceLayer.entity.Building"%>
<jsp:include page="header.jsp" />

<% BuildingMapper buildingMapper = new BuildingMapper();
    Building building = buildingMapper.getBuildingByBuildingId(Integer.parseInt(request.getParameter("buildingId"))); %>

<div class="container well">
    <div class="col-md-10 col-md-offset-1">

        <%if (building != null) {%>

        <div class="row">
            <h1 class="page-header"><%= building.getName()%></h1>
        </div>
        <div class="well buildingitem">
            <div class="row">
                <h3 class="page-header col-md-12">Building info:</h3>
            </div>
            <div class="row border">
                <div class="col-md-4">
                    <p>Building owner: <strong><%= building.getBuildingOwner()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row border">
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
            <br>
            <div class="row border">
                <div class="col-md-4">
                    <p>Number of floors: <strong><%= building.getFloors()%></strong></p>
                </div>
                <div class="col-md-4">
                    <p>Total m2: <strong><%= building.getTotalSize()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row border">
                <div class="col-md-4">
                    <p>Building year: <strong><%= building.getBuildingYear()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-4">
                    <p>Building condition: <strong><%= building.getBuildingCondition()%></strong></p>
                </div>
            </div>
        </div>
        <% }%>
        <a class="btn btn-primary" href="viewBuildings.jsp">Back</a>
    </div>
</div>

<jsp:include page="footer.jsp" />
