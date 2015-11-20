// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('AddBookmark', []);

cs480App.controller('AddBookmarkCtrl', function ($scope, $http) {
	
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
	
/*
	$scope.openUrls = function(index){
		console.log("in openUrls");
		//$http.post("loadUrls/?userId=" + $scope.userId + "&bookmarkIndex=" + index)
		$http.post("loadUrls/?userId=" + "user1" + "&bookmarkIndex=" + index)
	  	.success(function(data){
	  		console.log(data);
	  		$scope.urls = data;		
	  	});
		console.log("\n outside .success " + data)
		angular.forEach($scope.links, link {
			$window.open("link.html/?" + link, '_blank');
		}
		
	}*/
	
	
	//basically I combined the getBookmarkCount(username) and addPreset()
	//functions because scoping was an issue, but probably not good practice
	$scope.addPreset = function() {
		//username needs to be dynamic
		var username = "user1";
		$http.get(username + "/getBookmarkCount/")
			.success(function(num) {
				console.log(num);
				
			var div = document.createElement('div');
			var presetName = document.getElementById('presetName').value;
			if(presetName == "") {
				//do nothing
			}
			else {
				div.className = 'large-3 small-3 columns end';
				div.innerHTML = '&nbsp;\
					&nbsp;\
					&nbsp;\
				    &nbsp;\
					<ul class="stack button-group">\
				    <li><a target="_blank" href="open-urls-ajs.html?userId=user1&bookmarkIndex=' + num + '" class="button large" ng-click="openUrls(' + num + ')" >' + presetName +'</a></li>\
				    <li><a href="edit-bookmark-ajs.html?userId=user1&bookmarkIndex=' + num +'" class="button small">Edit</a></li>\
				    </ul>\
				    </div>';
				document.getElementById('content').appendChild(div);
				
				$http.get("user1/addBookmark/" + presetName).success(function(data) {
					console.log(data);
				    });   
			}
		});
	}
	
	$scope.loadBookmarks = function() {
		  $http.post("loadBookmarks/?userId=user1")
		  	.success(function(data){
		  		console.log(data);
		  		$scope.bookmarks = data;
		  		var div = document.createElement('div');
		  		//for loop to create buttons on load
		  		for(var i=0;i<$scope.bookmarks.length;i++) {
		  			div = document.createElement('div');
		  			console.log(i+"\n");
		  			div.className = 'large-3 small-3 columns end';
					div.innerHTML = '&nbsp;\
						&nbsp;\
						&nbsp;\
					    &nbsp;\
						<ul class="stack button-group">\
					    <li><a target="_blank" href="open-urls-ajs.html?userId=user1&bookmarkIndex=' + i + '" class="button large" ng-click="openUrls(' + i + ')" >' + $scope.bookmarks[i] +'</a></li>\
					    <li><a href="edit-bookmark-ajs.html?userId=user1&bookmarkIndex=' + i +'" class="button small">Edit</a></li>\
					    </ul>\
					    </div>';
					document.getElementById('content').appendChild(div);  
		  		}

		  		
		  	});
	  }
	
	$scope.userId = getQueryVariable("userId");
	$scope.loadBookmarks();

});

