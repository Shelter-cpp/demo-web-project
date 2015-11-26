// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('Index', []);

cs480App.controller('IndexCtrl', function ($scope, $http) {
	
	$scope.login = function() {
		var pass = document.getElementById('userPassword').value;
		console.log(pass);
		$http.post("checkForNewUser/?userId=" + $scope.userId + "&password=" + pass)
			.success(function(data){
				console.log("in js, data: " + data);
				//0 is new user, 1 is existing user, 2 is existing user wrong password
				if(data==0 || data==1)
					window.open("user-home-ajs.html?userId=" + $scope.userId, "_self");
				if(data==2)
					window.alert("Incorrect Password");
				if(data==3)
					window.alert("Please enter a Username/Password");
		});
	}
});