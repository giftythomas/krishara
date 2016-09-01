<%@include file="adminHeader.jsp"%>
<title>USER'S</title>

<div class="container">

	<table class="table table-bordered table-striped">

		<thead>
			<tr>
				<td><a href="#"
					ng-click="sortType = 'product_id'; sortReverse = !sortReverse"
					style="color: blue"> ProductId </a></td>
				<td><a href="#"
					ng-click="sortType = 'category'; sortReverse = !sortReverse"
					style="color: blue"> Category </a></td>
				<td><a href="#"
					ng-click="sortType = 'product_name'; sortReverse = !sortReverse"
					style="color: blue"> ProductName </a></td>
				<td><a href="#"
					ng-click="sortType = 'product_desc'; sortReverse = !sortReverse"
					style="color: blue"> Description </a></td>
				<td><a href="#"
					ng-click="sortType = 'product_price'; sortReverse = !sortReverse"
					style="color: blue"> Price </a></td>
				<td><a href="#"
					ng-click="sortType = ''; sortReverse = !sortReverse"
					style="color: blue"> Image </a></td>
				<td><a href="#"
					ng-click="sortType = ''; sortReverse = !sortReverse"
					style="color: blue"> Link </a></td>
			</tr>
		</thead>

		<tbody>

			<tr>
				<form action="updateProduct" method="post">
				<td class="active"><input type="hidden" value="${product.product_id}" name="product_id"></td>
				<td class="warning"><input value="${product.category}" name="category"></td>
				<td class="danger"><input value="${product.product_name}" name="product_name"></td>
				<td class="info"><input value="${product.product_desc}" name="product_desc"></td>
				<td class="warning"><input value="${product.product_price}" name="product_price"></td>
				<td class="primary"><img
					src="resources/images/${product.product_id}.jpg"
					style="width: 100px; height: 100px"></td>
				<td><input type="submit" class="btn btn-primary" value="Update"></td>
				</form>
			</tr>

		</tbody>

	</table>

</div>
<br>
<br />
<br />
<br />
<%@include file="footer.jsp"%>