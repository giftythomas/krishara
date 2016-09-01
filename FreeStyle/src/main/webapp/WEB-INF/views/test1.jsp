<%@include file="userHeader.jsp" %>
<title>PRODUCT'S</title>
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
<div class="bg-1" ng-app="myApp" ng-controller="productCtrl">
  <div class="container">
    <h3 class="text-center">MEN'S FOOTWEAR</h3>
    <p class="text-center"> Style your feet as you like!</p>
    <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search Product" ng-model="search">      
       </div> 
<div class="row text-center">
      <div class="col-sm-4">
        <div class="thumbnail" ng-repeat="roll in names | orderBy:sortType:sortReverse | filter:search">
          <img src="resources/images/{{roll.product_id}}.jpg" alt="Paris" width="200" height="150">
          <p><strong>{{roll.product_name}}</strong></p>
          <p>Rs.{{roll.product_price}}/-</p>
          <button class="btn" data-toggle="modal" data-target="#myModal">Product Details</button>
        </div>
      </div>
      </div></div></div>
<%@include file="footer.jsp" %>