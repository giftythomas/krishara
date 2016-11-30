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
    	UserService.getUserByName($rootScope.globals.activeUser.user_name)
    		.then(function(user){
    			self.user=user;
    		});
    }
});