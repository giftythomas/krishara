'use strict';

app.module('myApp').controller('HomeController',function(UserService, $rootScope){
	var self=this;
	
	self.user=null;
	self.users=[];
	
	initController();

    function initController() {
        loadCurrentUser();
        loadAllUsers();
    }
    
    function loadCurrentUser(){
    	UserService.getUserById($rootScope.activeUser.user_id)
    }
});