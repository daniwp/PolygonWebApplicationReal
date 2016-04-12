
<%@page import="serviceLayer.ControllerFacade"%>
<%@page import="serviceLayer.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page import="serviceLayer.entity.Building"%>
<%@page import="dataAccessLayer.mapper.BuildingMapper"%>
<jsp:include page="header.jsp" />

<div class="container page-wrapper">
    <div class="row">
        <div class="col-md-12">
            <%
                if (session.getAttribute("loggedIn") != null) { %>
            <div class="row">
                <div class="col-md-12">
                    <a href="addBuilding.jsp" class="btn btn-success pull-left" ><i class="fa fa-plus"></i> Add building</a>
                </div>
            </div><br>
            <% ControllerFacade controllerFacade = new ControllerFacade();
            List<Customer> customers = controllerFacade.getAllCustomers();
            for(Customer customer: customers) {
                
            %>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-building fa-fw"></i>&nbsp;&nbsp;<%= customer.getCompanyName() %></h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4">
                            <p>First Name: <strong><%= customer.getCustomerFirstName() %></strong></p>
                        </div>
                        <div class="col-md-4">
                            <p>Last Name: <strong><%= customer.getCustomerLastName() %></strong></p>
                        </div>
                        <div class="col-md-4">
                            <p>Email: <strong><%= customer.getCustomerEmail() %></strong></p>
                        </div>
                    </div>
                </div>
                <div style="min-height: 55px" class="panel-footer">
                    <form action="#" method="POST">
                        <input type="hidden" name="customerId" value="<%=customer.getCustomerId() %>">
                        <button class="btn btn-primary pull-left" type="submit"><i class="fa fa-fw fa-eye"></i> View</button>
                    </form>
                    <form action="#" method="POST">
                        <input type="hidden" name="customerId" value="<%=customer.getCustomerId() %>">
                        <button class="btn btn-danger pull-right" type="submit"><i class="fa fa-fw fa-ban"></i> Delete</button>
                    </form>
                </div>
            </div>

            <% }
                }%>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />