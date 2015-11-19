// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('EditBookmark', []);

cs480App.controller('EditBookmarkCtrl', function ($scope, $http) {

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
	
  $scope.loadUrls = function() {
	  $http.post("loadUrls/?userId=" + $scope.userId + "&bookmarkIndex=" + $scope.bookmarkIndex)
	  	.success(function(data){
	  		console.log(data);
	  		$scope.urls = data;
	  	});
  }
  
  $scope.addUrl = function() {
	  $http.post("edit-bookmark-ajs/addUrl/?userId=" + $scope.userId + "&bookmarkIndex=" + $scope.bookmarkIndex + "&url=" + $scope.newUrl)
	  	.success(function(data){
	  		console.log("Added url: " + $scope.newUrl);
	  		$scope.loadUrls();
	  	});
  }
  
  $scope.deleteUrl = function(index) {
	  $http.post("edit-bookmark-ajs/deleteUrl/?userId=" + $scope.userId + "&bookmarkIndex=" + $scope.bookmarkIndex + "&urlIndex=" + index)
	  	.success(function(data){
	  		console.log("Deleted url at index: " + index);
	  		$scope.loadUrls();
	  	});
  }
  $scope.deleteBookmark = function() {
	  $http.post("edit-bookmark-ajs/deleteBookmark/?userId=" + $scope.userId + "&bookmarkIndex=" + $scope.bookmarkIndex)
	  	.success(function(data){
	  		console.log("Deleted bookmark at index: " + $scope.bookmarkIndex);
	  	});
  }

  $scope.userId = getQueryVariable("userId");
  $scope.bookmarkIndex = getQueryVariable("bookmarkIndex");
  console.log($scope.userId);
  console.log($scope.bookmarkIndex);
  $scope.loadUrls();

});