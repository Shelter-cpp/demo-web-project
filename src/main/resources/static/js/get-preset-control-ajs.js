// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('GetPreset1', []);

cs480App.controller('GetPreset1Ctrl', function ($scope, $http) {

	function getQueryVariable(variable)
	{
	       var query = window.location.search.substring(1);
	       var vars = query.split("&");
	       for (var i=0;i<vars.length;i++) {
	               var pair = vars[i].split("=");
	               if(pair[0] == variable){
	            	   return pair[1];
	               }
	       }
	       return(false);
	}
	//actually loads url's not users
  $scope.loadUrls = function() {
	  $http.get("loadUrls/" + $scope.user + "/" + $scope.bookmark)
	  	.success(function(data){
	  		console.log(data);
	  		$scope.urls = data;
	  	});
  }
  
  $scope.addUrl = function() {
	  $http.post("cs480/user/addUrl/" + $scope.user + "/" + $scope.bookmark + "?url=" + $scope.newUrl)
	  	.success(function(data){
	  		$scope.loadUrls();
	  	});
  }
  
  $scope.deleteUrl = function(index) {
	  $http.post("cs480/user/deleteUrl/" + $scope.user + "/" + $scope.bookmark + "?urlIndex=" + index)
	  	.success(function(data){
	  		$scope.loadUrls();
	  	});
  }
  /*$scope.deleteBookmark = function() {
	 //deletes entire bookmark then loads index.html
	  	});
  }*/

  $scope.user = getQueryVariable("user");
  $scope.bookmark = getQueryVariable("bookmark");
  console.log($scope.user);
  console.log($scope.bookmark);
  $scope.loadUrls();

});