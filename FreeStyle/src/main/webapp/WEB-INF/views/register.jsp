<%@include file="header1.jsp"%>
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
			<form:form modelAttribute="user">
				<ul>
					<li class="text-info">UserName:</li>
					<li><form:input type="text" path="user_name" /><br /></li>
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('user_name')}"
						var="err">
						<div>
							<span style="color:red">${err.text}</span>
						</div>
					</c:forEach>
				</ul>
				<ul>
					<li class="text-info">Email:</li>
					<li><form:input type="text" path="emailid" /></li>
					<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}" var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				</ul>
				<ul>
					<li class="text-info">Password:</li>
					<li><form:input type="password" path="password" /><br /></li>
					<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				</ul>
				<ul>
					<li class="text-info">Address:</li>
					<li><form:input type="text" path="user_address" /><br /></li>
					<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('user_address')}" var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach> 
				</ul>
				<input name="_eventId_submit" type="submit" value="Register Now">
				<p class="click">
					By clicking this button, you are agree to my <a href="#">Policy
						Terms and Conditions.</a>
				</p>
			</form:form>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>