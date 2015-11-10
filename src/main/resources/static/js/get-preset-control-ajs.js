// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('GetPreset1', []);

cs480App.controller('GetPreset1Ctrl', function ($scope, $http) {

  $scope.loadUsers = function() {
	  $http.get("preset1/list")
	  	.success(function(data){
	  		console.log(data);
	  		$scope.presetitems = data;
	  	});
  }
  
  $scope.addUrl = function() {
	  $http.post("cs480/user/addUrl/" + "user1" + "/" + "0" + "?url=" + $scope.newUrl)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }
  
  $scope.deleteUrl = function() {
	  $http.post("cs480/user/deleteUrl/" + "user1" + "/" + "0" + "?urlIndex=" + $index)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }
});