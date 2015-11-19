// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
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
		//$http.post("loadUrls/?userId=" + $scope.userId + "&bookmarkIndex=" + index)
		$http.post("loadUrls/?userId=" + $scope.userId + "&bookmarkIndex=" + $scope.bookmarkIndex)
	  	.success(function(data){
	  		console.log(data);
	  		$scope.urls = data;		
	  	});
		/*console.log("\n outside .success " + data)
		angular.forEach($scope.links, link {
			$window.open("link.html/?" + link, '_blank');
		}*/
		
	}
	
	$scope.userId = getQueryVariable("userId");
	$scope.bookmarkIndex = getQueryVariable("bookmarkIndex");
	$scope.openUrls();

});

