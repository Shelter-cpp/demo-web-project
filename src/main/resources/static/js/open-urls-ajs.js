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
	  			//window.open("link.html/?" + data[i], '_blank');
	  			/*var url = data[i];
				var link = angular.element('<a href="' + url + '" target="_blank"></a>');
				console.log("link to open: "+link);
				 
				angular.element(document.body).append(link);
				 
				link[0].click();
				link.remove();*/
	  		}
	  	});
	}
	
	$scope.userId = getQueryVariable("userId");
	$scope.bookmarkIndex = getQueryVariable("bookmarkIndex");
	$scope.openUrls();
});

