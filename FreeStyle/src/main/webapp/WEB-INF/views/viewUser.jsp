<%@include file="adminHeader.jsp" %>
<title>USER'S</title>
<script>
angular.module('myApp',[]).controller('userCtrl',function($scope)
		{
	
		$scope.names=${listofusers};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<div class="container" ng-app="myApp" ng-controller="userCtrl" >
  
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search User" ng-model="search">      
       </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'user_id'; sortReverse = !sortReverse" style="color: blue">
            UserId 
            <span ng-show="sortType == 'user_id' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'user_id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'user_name'; sortReverse = !sortReverse" style="color: blue">
            UserName
            <span ng-show="sortType == 'user_name' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'user_name' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'emailid'; sortReverse = !sortReverse" style="color: blue">
          EmailAddress
            <span ng-show="sortType == 'emailid' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'emailid' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'user_address'; sortReverse = !sortReverse" style="color: blue">
          UserAddress
            <span ng-show="sortType == 'user_address' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'user_address' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in names | orderBy:sortType:sortReverse | filter:search">
           		<td class="active">{{roll.user_id}}</td>
           		<td class="danger">{{roll.user_name}}</td>
           		<td class="info">{{roll.emailid}}</td>
           		<td class="warning">{{roll.user_address}}</td>
      </tr>
    </tbody>
    
  </table>
  
</div><br><br/><br/><br/>
<%@include file="footer.jsp" %>