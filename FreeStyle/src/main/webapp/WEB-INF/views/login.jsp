<%@include file="header1.jsp" %>
<div class="head-bread">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="index">HOME</a></li>
                    <li class="active">LOGIN</li>
                </ol>
                <h3 class="text-success" style="font-size:30px">${success }</h3>
            </div>
        </div>
        <!--signup-->
        <!-- login-page -->
        <div class="login">
            <div class="container">
                <div class="login-grids">
                    <div class="col-md-6 log">
                             <h3>Login</h3>
                             <div class="strip"></div>
                             <p>Welcome, please enter the following to continue.</p>
                             <c:if test="${not empty param['error']}"> 
                             <div style="color: red; margin: 10px 0px;">Login Failed!!<br>
                                   Reason:<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /> 
                                   <c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
                                   </div>
                             </c:if>
                             <form action=<c:url value="j_spring_security_check" /> method="post" class="form-login">
                                 <h5>User Name:</h5>	
                                 <input type="text" name="j_username" required="required">
                                 <h5>Password:</h5>
                                 <input type="password" name="j_password" required="required"><br>					
                                 <input type="submit" value="Login">

                             </form>
                    </div>
                    <div class="col-md-6 login-right">
                            <h3>New Registration</h3>
                            <div class="strip"></div>
                            <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                            <a href="register" class="button">Create An Account</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
<%@include file="footer.jsp" %>