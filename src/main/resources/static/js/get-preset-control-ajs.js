// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('GetPreset1', []);

cs480App.controller('GetPreset1Ctrl', function ($scope, $http) {

  $scope.loadUsers = function() {
	  $http.get("preset1/list")
	  	.success(function(data){
	  		$scope.presetitems = data;
	  	});
  }

  $scope.loadUsers();

});