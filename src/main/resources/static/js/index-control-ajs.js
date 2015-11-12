// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('AddBookmark', []);

cs480App.controller('AddBookmarkCtrl', function ($scope, $http) {
	
    $scope.addBookmark = function() {
	  var div = document.createElement('div');

	  div.className = 'large-3 small-3 columns end';

      div.innerHTML = '&nbsp;\
			&nbsp;\
		    &nbsp;\
		    &nbsp;\
		    <ul class="stack button-group">\
		    <li><a href="#" class="button large" onClick="openUrls(' + count + ')" >Preset Button ' + count +'</a></li>\
		    <li><a href="#" class="button small">Edit Preset</a></li>\
		    </ul>\
		    </div>';

	  document.getElementById('content').appendChild(div);
  	}
  
	$http.post("cs480/user/" + "user1" + "/" + count + "?bookmark=" + $scope.newBookmark)
		.success(function(data){
	  		$scope.loadUsers();
	})
	
	$scope.loadPages = function() {
		  $http.get("preset1/pages")
		  	.success(function(data){
		  		$scope.pageitems = data;
		  	});
	  }
	
	/*Does not work - Alex
	$scope.addPreset1 = function() {
		alert('alert');
		$http.get("cs480/users/list").success(function(data) {
			$scope.addPreset();
		});
	}

	function addPreset() {
		alert('alert');
		  var div = document.createElement('div');
		  var presetName = document.getElementById('presetName').value;
		  if(presetName == '') {
			  //do nothing
			  
		  }
		  else {
			  div.className = 'large-3 small-3 columns end';

			    div.innerHTML = '&nbsp;\
					&nbsp;\
			    	&nbsp;\
			    	&nbsp;\
			    	<ul class="stack button-group">\
			    	<li><a href="#" class="button large" onClick="openUrls(' + presetName + ')" >' + presetName +'</a></li>\
			    	<li><a href="get-preset-ajs.html?user=user1&bookmark=0" class="button small">Edit</a></li>\
			    	</ul>\
			    	</div>';

			     document.getElementById('content').appendChild(div);
			     
		  }
		    
	}

	function openUrls(name) {
		  alert(name);
	}

	//use angular
	function getUrls(name) {
		  //get a list of the urls from the user.bookmark
		  //call openURLS by passing list of URLS to it
	}
	*/

	$scope.loadUsers();
});

