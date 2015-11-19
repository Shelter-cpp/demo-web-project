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
	
    //Cannot test yet because create/add bookmark is not done yet, will use index to get correct bookmarks
	/*
	$scope.openUrls = function(){
		$http.get("loadUrls/" + $scope.user + "/" + $scope.bookmark)
		  .success(function(data){
			  console.log(" inside .success " + data);
			  $scope.links = data;
			  //might have to move forEach loop into here
		  });
		console.log("\n outside .success " + data)
		angular.forEach($scope.links, link {
			$window.open("link.html/?" + link, '_blank');
		}
		
	}
	*/
	
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
				    <li><a href="#" class="button large" onClick="getUrls(' + presetName + ')" >' + presetName +'</a></li>\
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
					    <li><a href="#" class="button large" onClick="getUrls(' + $scope.bookmarks[i] + ')" >' + $scope.bookmarks[i] +'</a></li>\
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

