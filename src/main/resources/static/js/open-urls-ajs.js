var cs480App = angular.module('OpenUrls', []);

cs480App.controller('OpenUrlsCtrl', function ($scope, $http) {
	
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
		
	$scope.openUrls = function(){
		console.log("in openUrls");
		$http.post("loadUrls/?userId=" + $scope.userId + "&bookmarkIndex=" + $scope.bookmarkIndex)
	  	.success(function(data){
	  		console.log(data);
	  		if(data.length == 0){
	  			window.close();
	  		}
	  		for(var i=0; i<data.length; i++){
	  			console.log(data[i] + "\n");
	  			if(i<data.length-1){
	  			    window.open("http://" + data[i]);
	  			    console.log("in if statement, url: " + data[i]);
	  			}
	  			else{
	  				console.log("in else statement, url: " + data[i]);
	  				window.open("http://" + data[i], "_self");
	  			}
	  		}
	  	});
	}
	
	$scope.userId = getQueryVariable("userId");
	$scope.bookmarkIndex = getQueryVariable("bookmarkIndex");
	$scope.openUrls();
});

