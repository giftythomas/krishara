<%@include file="adminHeader.jsp" %>
<div class="reg-form">
		<div class="container">
			<div class="reg">
				<h3>ADD PRODUCTS</h3><h3 class="text-success">${success }</h3>
				<p>Welcome, please enter the following details to continue.</p>
				 <form:form action="addProduct" modelAttribute="addProduct" method="post" enctype="multipart/form-data">
					<ul>
						<li class="text-info">Product Name: </li>
						<li><form:input type="text" path="product_name" /><br/><form:errors path="product_name" style="color:red"></form:errors></li>
					</ul>
					<ul>
						<li class="text-info">Product Description: </li>
						<li><form:input type="text" path="product_desc" /><br/><form:errors path="product_desc" style="color:red"></form:errors></li>
					</ul>
					<ul>
						<li class="text-info">Product Price: </li>
						<li><form:input type="text" path="product_price" /><br/></li>
					</ul>
					<ul>
						<li class="text-info">Category: </li>
						<li><form:select type="text" path="category"><br/>
							<form:option value="Nike"></form:option>
							<form:option value="Puma"></form:option>
							<form:option value="Adidas"></form:option>
							</form:select></li>
					</ul>
					<ul>
						<li class="text-info">Choose File: </li>
						<li><input type="file" name="file" /><br/></li>
					</ul>						
					<input type="submit" value="Add Product">
				</form:form>
			</div>
		</div>
	</div>
<%@include file="footer.jsp"%>