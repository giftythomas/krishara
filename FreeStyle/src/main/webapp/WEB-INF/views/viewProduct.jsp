<%@include file="adminHeader.jsp" %>
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
<center><h4 class="text-danger">${message}</h4></center>
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
      <td width="60">
          <a href="#" ng-click="sortType = 'product_id'; sortReverse = !sortReverse" style="color: blue">
            ProductId 
            <span ng-show="sortType == 'product_id' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'product_id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td width="100">
        <td>
          <a href="#" ng-click="sortType = 'category'; sortReverse = !sortReverse" style="color: blue">
            Category
            <span ng-show="sortType == 'category' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'category' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td width="200">
          <a href="#" ng-click="sortType = 'product_name'; sortReverse = !sortReverse" style="color: blue">
            ProductName
            <span ng-show="sortType == 'product_name' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'product_name' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td width="400">
          <a href="#" ng-click="sortType = 'product_desc'; sortReverse = !sortReverse" style="color: blue">
          Description
            <span ng-show="sortType == 'product_desc' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'product_desc' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td width="100">
          <a href="#" ng-click="sortType = 'product_price'; sortReverse = !sortReverse" style="color: blue">
          Price
            <span ng-show="sortType == 'product_price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'product_price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
       <td width="100">
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
           		<td class="active">{{roll.product_id}}</td>
           		<td class="warning">{{roll.category}}</td>
           		<td class="danger">{{roll.product_name}}</td>
           		<td class="info">{{roll.product_desc}}</td>
           		<td class="warning">{{roll.product_price}}</td>
           		<td class="info"><img src="resources/images/{{roll.product_id}}.jpg" style="width: 100px ;height:100px"></td>
           		<td><a href="deleteProduct?id={{roll.product_id}}" class="btn btn-danger">Delete</a> &nbsp;
                <a href="editProduct?id={{roll.product_id}}" class="btn btn-info">Edit</a></td>
      </tr>
    </tbody>
    
  </table>
  
</div><br><br/><br/><br/>
<%@include file="footer.jsp" %>