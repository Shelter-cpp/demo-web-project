// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('Index', []);

cs480App.controller('IndexCtrl', function ($scope, $http) {
	
	$scope.login = function() {
		$http.post("checkForNewUser/?userId=" + $scope.userId)
		window.open("user-home-ajs.html?userId=" + $scope.userId, "_self");
	}
});