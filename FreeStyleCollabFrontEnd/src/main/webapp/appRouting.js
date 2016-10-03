var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
	  $routeProvider
	  .when('/', {
	    templateUrl : 'fs_home/home.html',
	    controller  : 'HomeController'
	  })
	  
	    .when('/job_opportunities', {
	    templateUrl : 'c_job/job.html',
	    controller  : 'JobController'
	  })
	  
	   .when('/manageUser', {
	    templateUrl : 'c_admin/manage_users.html',
	    controller  : 'AdminController'
	  })
	  

	  .when('/blog', {
	    templateUrl : 'c_blog/blog.html',
	    controller  : 'BlogController'
	  })
	  
	  
	  .when('/event', {
	    templateUrl : 'c_event/event.html',
	    controller  : 'EventController'
	  })

	  .when('/about', {
	    templateUrl : 'c_about/about.html',
	    controller  : 'AboutController'
	  })
	  
	   .when('/login', {
	    templateUrl : 'fs_user/login.html',
	    controller  : 'UserController'
	  })
	  
	   .when('/register', {
	    templateUrl : 'fs_user/register.html',
	    controller  : 'UserController'
	  })

	  .otherwise({redirectTo: '/'});
	});

