<%@include file="userHeader.jsp" %>
<script>
angular.module('myApp',[]).controller('productCtrl',function($scope)
		{
	
		$scope.names=${CartItems};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<div class="head-bread">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="products.hml">Products</a></li>
                    <li class="active">CART</li>
                </ol>
            </div>
        </div>
        <!-- check-out -->
            <div class="check" ng-app="myApp" ng-controller="productCtrl">
                <div class="container">	 
                    <div class="col-md-3 cart-total">
                        <a class="continue" href="#">Continue Shopping</a>
                        
                        <hr class="featurette-divider">
                        <ul class="total_price">
                           <li class="last_price"> <h4>TOTAL</h4></li>	
                           <li class="last_price"><span>${totalAmount}</span></li>
                           <div class="clearfix"> </div>
                        </ul> 
                        <div class="clearfix"></div>
                        <a class="order" href="#">Place Order</a>
                    </div>
                    <div class="col-md-9 cart-items">
                        <h1>My Shopping Bag </h1>
                        <div class="cart-header" ng-repeat="roll in names">
                <div class="close1"><a href="deleteCartItem?id={{roll.product_id }}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></div>
                            <div class="cart-sec simpleCart_shelfItem">
                                    <div class="cart-item cyc">
                                        <img src="resources/images/${roll.product_id}.jpg" class="img-responsive" alt="img"/>
                                    </div>
                                   <div class="cart-item-info">
                                        <ul class="qty">
                                      
                                            <li><p>Qty : {{roll.quantity}}</p></li>
                                            <li><p>Price each : Rs.{{roll.product_price}}/-</p></li>
                                        </ul>
                                        <div class="delivery">
                                             <span>Delivered in 2-3 bussiness days</span>
                                             <div class="clearfix"></div>
                                        </div>	
                                   </div>
                                   <div class="clearfix"></div>

                              </div>
                         </div>
                         
                      
                        </div>			
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <%@include file="footer.jsp"%>