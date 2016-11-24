'use strict';

angular.module('myApp').controller('HomeController',function(UserService, $rootScope){
	var self=this;
	
	self.user=null;
	self.users=[];
	
	initController();

    function initController() {
        loadActiveUser();
    }
    
    function loadActiveUser(){
    	UserService.getUserById($rootScope.activeUser.user_id)
    		.then(function(user){
    			self.user=user;
    		});
    }
});