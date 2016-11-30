'use strict';

angular.module('myApp').controller('UserController', ['$scope', '$rootScope','$location','UserService', function($scope,$rootScope,$location, UserService) {
    var self = this;
    self.user={
    		user_id:'',
    		user_name:'',
    		password:'',
    		user_address:'',
    		email:'',
    		role:'',
    		errorMessage:''
    		};
    self.users=[];
    
    self.getUserById=function(id){
    	console.log("getting User by Id")
    	UserService.getUserById(id)
    		.then(function(d){
    			self.user=d;
    		},
    		function(errResponse){
                console.error('Error while getting Users');
            }
    	);
    }

    self.fetchAllUsers=function (){
    	console.log("fetching all users")
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    };

    self.createUser=function(user){
    	console.log("createUser:",user)
        UserService.createUser(user)
            .then(
            		function(d) {
                        self.users = d;
                        $location.path("/login");
            		},
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    };

    self.updateUser=function(user, id){
    	console.log("updateUser:",user)
    	console.log("id:",id)
        UserService.updateUser(user, id)
            .then(
            		function(d) {
                        self.users = d;
            		},
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    };

    self.deleteUser=function(id){
    	console.log("deleteUser:",id)
        UserService.deleteUser(id)
            .then(
            		function(d) {
                        self.users = d;
            		},
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    };
    
    self.authenticate=function(user){
    	console.log("authenticate:",user)
        UserService.authenticate(user)
            .then(
            		function(d) {
                        self.user = d;
            if(user.errorMessage!=""){
            	$location.path('/');
            }
            		},
            function(errResponse){
                console.error('Error while authenticating User');
            }
        );
    };
    self.fetchAllUsers();

    self.submit=function() {
            console.log('Saving New User', self.user);
            createUser(self.user);
            self.reset();
    };

    self.edit=function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    };
    
    self.login=function(){
    	console.log("<--Login validation-->",self.user);
    	self.authenticate(self.user);
    };

    self.remove=function(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            self.reset();
        }
        self.deleteUser(id);
    };

    self.reset=function(){
    	console.log("reset form")
        self.user={user_id:'',
    		user_name:'',
    		password:'',
    		user_address:'',
    		email:'',
    		role:'',
    		errorMessage:''};
        $scope.myForm.$setPristine(); //reset Form
    }
}]);
