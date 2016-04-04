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

    <div class="well col-md-8 col-md-offset-2 buildingitem"> 
        <div class="row">
            <div class="col-md-4 text-center">
                <p>Building name:</p>
                <h4><%= building.getName()%></h4>
            </div>
        </div>
    </div>

    <% }%>

</div>

<jsp:include page="footer.jsp" />