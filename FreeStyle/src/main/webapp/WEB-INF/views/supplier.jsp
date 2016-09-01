<%@include file="adminHeader.jsp" %>
<div class="reg-form">
		<div class="container">
			<div class="reg">
				<h3>ADD PRODUCTS</h3><h3 class="text-success">${success }</h3>
				<p>Welcome, please enter the following details to continue.</p>
				<h3 class="text-success">${done }</h3>
				 <form:form action="addSupplier" modelAttribute="supplier" method="post">
					<ul>
						<li class="text-info">Supplier Name: </li>
						<li><form:input type="text" path="supplier_name" /><br/><form:errors path="supplier_name" style="color:red"></form:errors></li>
					</ul>
					<ul>
						<li class="text-info">Supplier Address: </li>
						<li><form:input type="text" path="supplier_address" /><br/><form:errors path="supplier_address" style="color:red"></form:errors></li>
					</ul>				
					<input type="submit" value="Add Supplier">
				</form:form>
			</div>
		</div>
	</div>
<%@include file="footer.jsp" %>