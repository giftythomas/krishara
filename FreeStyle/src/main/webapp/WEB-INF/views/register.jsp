 <%@include file="header1.jsp" %>
 <div class="head-bread">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="register.html">LOGIN</a></li>
                    <li class="active">REGISTER</li>
                </ol>
            </div>
        </div>
        <!-- reg-form -->
	<div class="reg-form">
		<div class="container">
			<div class="reg">
				<h3>Register Now</h3>
				<p>Welcome, please enter the following details to continue.</p>
				<%-- <center><h3>${success }</h3></center> --%>
				 <form:form action="reg" modelAttribute="user">
					<ul>
						<li class="text-info">UserName: </li>
						<li><form:input type="text" path="user_name" /><br/><form:errors path="user_name" style="color:red"></form:errors></li>
					</ul>
					<ul>
						<li class="text-info">Email: </li>
						<li><form:input type="text" path="emailid" /><br/><form:errors path="emailid" style="color:red"></form:errors></li>
					</ul>
					<ul>
						<li class="text-info">Password: </li>
						<li><form:input type="password" path="password" /><br/><form:errors path="password" style="color:red"></form:errors></li>
					</ul>
					<ul>
						<li class="text-info">Address: </li>
						<li><form:input type="text" path="user_address" /><br/><form:errors path="user_address" style="color:red"></form:errors></li>
					</ul>						
					<input type="submit" value="Register Now">
					<p class="click">By clicking this button, you are agree to my  <a href="#">Policy Terms and Conditions.</a></p> 
				</form:form>
			</div>
		</div>
	</div>
<%@include file="footer.jsp" %>