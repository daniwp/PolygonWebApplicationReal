<%@page import="java.util.List"%>
<%@page import="serviceLayer.entity.Building"%>
<%@page import="dataAccessLayer.mapper.BuildingMapper"%>
<jsp:include page="header.jsp" />

<div class="container well">

    <%
        BuildingMapper buildingMapper = new BuildingMapper();
        List<Building> buildings = buildingMapper.getAllBuildings(1);
    %>    
    <%
        for (Building building : buildings) {
    %>

    <div class="well col-sm-8 col-sm-offset-2 buildingitem"> 
        <div class="row">
            <div class="col-sm-4 text-center">
                <h3><%= building.getName()%></h3>
            </div>
            <div class="col-sm-2 col-md-offset-4 text-center">
                <form action="viewbuilding" method="POST">
                    <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                    <button class="btn btn-primary btn-lg" type="submit">View</button>
                </form>
            </div>
            <div class="col-sm-2 text-center">
                <form action="deletebuilding" method="POST">
                    <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                    <input class="btn btn-danger btn-lg" type="submit" value="Delete">
                </form>
            </div>
        </div>
    </div>
    <% }%>
</div>

<jsp:include page="footer.jsp" />