<jsp:include page="header.jsp" />

<div class="section section-hero">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-8 hero">
                <h1>Lorem ipsum dolor sit</h1>
                <p>Sed elit mauris, placerat nec hendrerit quis, fringilla nec mi. Curabitur non fermentum risus, at blandit est. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Integer et feugiat orci, at faucibus nisl. Ut fermentum lacinia pretium. Mauris luctus aliquam viverra. Aliquam id tortor quam. In vitae ex at nibh porta ultrices.</p>
                <button class="btn btn-clear">Learn more</button>
            </div>
        </div>
    </div>
</div>


<div style="margin-top: 50px" class="container">
    <% if (session.getAttribute("customer") != null || session.getAttribute("admin") == null) { %>
    <div class="row">
        <div class="col-md-12">
            <a href="viewBuildings.jsp">
                <div class="col-md-3 well col-md-offset-1">
                    <div href="viewBuildings.jsp" class="col-md-4">
                        <i style="color: #009fe3" class="fa fa-building-o fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h4 class="border" style="color: grey">My Buildings</h4>
                        <p>Here you can view all the buildings you've added</p>
                        <br>
                    </div>
                </div>
            </a>
            <a href="addBuilding.jsp">
                <div style="margin-left: 30px; margin-right: 30px" class="col-md-3 well">
                    <div class="col-md-4">
                        <i style="color: #009fe3" class="fa fa-plus-square-o fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h4 class="border" style="color: grey">Add a Building</h4>
                        <p>Here you can add a new building</p>
                        <br><br>
                    </div>
                </div>
            </a>
            <a href="viewProfile.jsp">
                <div style="" class="col-md-3 well">
                    <div class="col-md-4">
                        <i style="color: #009fe3" class="fa fa-user fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h4 class="border" style="color: grey">My Profile</h4>
                        <p>Here you can access and edit your customer information</p>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1 well">
            <div class="col-md-10 col-md-offset-1">
                <div class="col-md-3">
                    <i style="color: #009fe3" class="fa fa-life-ring fa-5x" aria-hidden="true"></i>
                </div>
                <div class="col-md-8">
                    <h2>In case of urgent emergency call: <i class="fa fa-phone-square" aria-hidden="true"></i> 48140555&emsp;&emsp; (Open 24/7)</h2>
                </div>
            </div>
            <div class="col-md-10 col-md-offset-1">
                <br><br>
                <p class="text-center">A quick response is crucial when it comes to minimizing the damage and insurance claims for fire, water damage, flooding or natural disaster.
                    <br><br>Our Direct Reaction Team (DRT®) is equipped to respond quickly, ensuring that the property is restored to the conditions before the injury as soon as possible. It reduces the customer's cost of disruptions and protects the customer's investment.</p>
            </div>
        </div>
    </div>
    <% } %>
    <% if (session.getAttribute("admin") != null) { %>
    <div class="row">
        <div class="col-md-12">
            <a href="viewPendingCheckups.jsp">
                <div class="col-md-5 well col-md-offset-1">
                    <div class="col-md-4">
                        <i style="color: #009fe3" class="fa fa-calendar-check-o fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h4 class="border" style="color: grey">Pending Checkups</h4>
                        <p>Here you can view all requested Checkups</p>
                        <br>
                    </div>
                </div>
            </a>
            <a href="viewCustomers.jsp">
                <div style="margin-left: 30px" class="col-md-5 well">
                    <div class="col-md-4">
                        <i style="color: #009fe3" class="fa fa-users fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h4 class="border" style="color: grey">View Customers</h4>
                        <p>Here you view a list of all customers</p>
                        <br><br>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <a href="createCustomer.jsp">
                <div class="col-md-5 well col-md-offset-1">
                    <div class="col-md-4">
                        <i style="color: #009fe3" class="fa fa-user-plus fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h4 class="border" style="color: grey">Add a Customer</h4>
                        <p>Here you can add a new Customer</p>
                        <br><br>
                    </div>
                </div>
            </a>
            <a href="createAdmin.jsp">
                <div style="margin-left: 30px" class="col-md-5 well">
                    <div class="col-md-4">
                        <i style="color: #009fe3" class="fa fa-user-md fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h4 class="border" style="color: grey">Add an Admin</h4>
                        <p>Here you can add a new Admin user</p>
                        <br><br>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <% }%>
</div>

<jsp:include page="footer.jsp" />
