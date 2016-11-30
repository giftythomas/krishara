'use strict';

app.factory('UserService', ['$http', '$q', '$rootScope' , '$location', function($http, $q, $rootScope,$location){

	console.log("In UserService")
	
    var BACK_END_URL = 'http://localhost:8084/FreeStyleCollabBackEnd/';
	return{
		
		getUserById:function(id) {
			return $http.get(BACK_END_URL+'/user'+id)
				.then(function(response){
					return response.data;
				},
				function(errResponse){
	                console.error('Error while getting User By Id');
	                return $q.reject(errResponse);
					}
				);
		},

		fetchAllUsers:function () {
		return $http.get(BACK_END_URL+'/user')
            .then(
            function (response) {
                return response.data;
            },
            function(errResponse){
                console.error('Error while fetching Users');
                return $q.reject(errResponse);
            }
        );
    },

    createUser:function(user) {
        return $http.post(BACK_END_URL+'/user/', user)
            .then(
            function (response) {
                return response.data;
            },
            function(errResponse){
                console.error('Error while creating User');
               return $q.reject(errResponse);
            }
        );
    },

    updateUser: function(user, id) {
       return $http.put(BACK_END_URL+'/user/'+id, user)
            .then(
            function (response) {
                return response.data;
            },
            function(errResponse){
                console.error('Error while updating User');
                 return $q.reject(errResponse);
            }
        );
    },

    deleteUser:function(id) {
        return $http.delete(BACK_END_URL+'/user/'+id)
            .then(
            function (response) {
                return response.data;
            },
            function(errResponse){
                console.error('Error while deleting User');
                 return $q.reject(errResponse);
            }
        );
    },
    
    authenticate:function(user) {
    	return $http.post(BACK_END_URL+'/user/authenticate/', user)
    		.then(
            function (response) {
                if(response.data.errorMessage!=''){
                	$rootScope.loggedInUser=true;
                	$rootScope.activeUser= {
                			user_id : response.data.user_id,
                			user_name : response.data.user_name,
                			role : response.data.role
                	};
                }
                return response.data;
            },
            function(errResponse){
            	$rootScope.userLoggedIn=false;
            	console.error('Error while getting User');
                return $q.reject(errResponse);
            }
        );
    }
	}
}]);
