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
<h3 class="text-info">Welcome ${loggedInUser},</h3>
<div class="container" ng-app="myApp" ng-controller="productCtrl" >
  
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search Product" ng-model="search">      
       </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
      
        <td>
          <a href="#" ng-click="sortType = 'category'; sortReverse = !sortReverse" style="color: blue">
            Category
            <span ng-show="sortType == 'category' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'category' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'product_name'; sortReverse = !sortReverse" style="color: blue">
            ProductName
            <span ng-show="sortType == 'product_name' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'product_name' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'product_price'; sortReverse = !sortReverse" style="color: blue">
          Price
            <span ng-show="sortType == 'product_price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'product_price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
       <td>
      <a href="#" ng-click="sortType = ''; sortReverse = !sortReverse" style="color: blue">
      Image
      <span ng-show="sortType == '' && !sortReverse" class="fa fa-caret-down"></span>
      <span ng-show="sortType == '' && sortReverse" class="fa fa-caret-up"></span>
      </a>
      </td>
      <td>
      <a href="#" ng-click="sortType = ''; sortReverse = !sortReverse" style="color: blue">
      Link
      <span ng-show="sortType == '' && !sortReverse" class="fa fa-caret-down"></span>
      <span ng-show="sortType == '' && sortReverse" class="fa fa-caret-up"></span>
      </a>
      </td>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in names | orderBy:sortType:sortReverse | filter:search">
           		<td class="warning">{{roll.category}}</td>
           		<td class="danger">{{roll.product_name}}</td>
           		<td class="warning">{{roll.product_price}}</td>
           		<td class="primary"><img src="resources/images/{{roll.product_id}}.jpg" style="width: 100px ;height:100px"></td>
           		<td><a href="productDetails?id={{roll.product_id}}">Product Details</a> 
                </td>
      </tr>
    </tbody>
    
  </table>
  
</div><br><br/><br/><br/>
<%@include file="footer.jsp" %>