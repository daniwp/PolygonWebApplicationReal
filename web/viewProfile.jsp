<%@page import="serviceLayer.entity.Customer"%>
<%@page import="serviceLayer.ControllerFacade"%>
<%@page import="java.util.List"%>
<%@page import="dataAccessLayer.mapper.MapperFacade"%>
<jsp:include page="header.jsp" />

<%
// Retrieves the customer object from the session 
    if (session.getAttribute("customer") != null) {
        Customer customer = (Customer) session.getAttribute("customer");
        customer = new ControllerFacade().getCustomerByCustomerId(customer.getCustomerId());
%>

<div class="container well">
    <div class="col-md-10 col-md-offset-1">

        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header"><%= customer.getCompanyName()%></h1>
            </div>
        </div>
        <div class="well buildingitem">
            <div class="row">
                <div class="col-md-12">
                    <div class = "col-md-6">
                        <h3> Customer info:</h3>
                    </div>
                    <div class = "col-md-6">
                        <form action="vieweditcustomer" method="POST">
                            <input type="hidden" name="customerId" value="<%=customer.getCustomerId()%>">
                            <button class="btn btn-success pull-right" type="submit"><i class="fa fa-fw fa-pencil-square-o"></i> Edit</button>
                        </form>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-4">
                    <p class="border">Company owner name: <strong><%= customer.getCustomerFirstName() + " " + customer.getCustomerLastName()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-4">
                    <p class="border">E-mail: <strong><%= customer.getCustomerEmail()%></strong></p>
                </div>
            </div>
            <br>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a href="addBuilding.jsp" class="btn btn-success pull-right" ><i class="fa fa-plus"></i> Add building</a>
                <a class="btn btn-primary" href="index.jsp"><i class="fa fa-fw fa-angle-double-left"></i> Back</a>
            </div>
        </div>
        <br>
        <% } else {%>
        <jsp:include page="pleaseLogin.jsp" />
        <% }%>
    </div>
</div>

<jsp:include page="footer.jsp" />
