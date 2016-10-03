<%@include file="userHeader.jsp" %>
<title>PRODUCT'S</title>
<div class="container" ng-app="myApp" ng-controller="productCtrl">
<form>
    <div class="form-group">
      <div class="text-center input-group col-md-4">
        <div class="input-group-addon "><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search Product" ng-model="search">      
       </div>      
    </div>
  </form> 
<div class="w3-container w3-teal">
<h1>Winter 2016</h1>
</div>
<div class="w3-row-padding w3-margin-top" >
<div class="w3-third" ng-repeat="roll in names | orderBy:sortType:sortReverse | filter:search">
<div class="w3-card-2" >
<img src="resources/images/{{roll.product_id}}.jpg"  style="width:100 px; height:100 px" alt="image from db">
<div class="w3-container text-center">
<h4>{{roll.product_name}}</h4>
<p>Rs.{{roll.product_price}}/-</p>
<a href="productDetails?id={{roll.product_id}}" class="btn btn-warning" >Product Details</a>
</div>

</div>
</div>
</div>
</div>
<script>
angular.module('myApp',[]).controller('productCtrl',function($scope)
		{
	
		$scope.names=${listofproducts};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<%@include file="footer.jsp" %>