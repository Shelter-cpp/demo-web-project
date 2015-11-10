// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('AddBookmark', []);

cs480App.controller('AddBookmarkCtrl', function ($scope, $http) {
  
	var increment = (function() {
		  var count = 1;
		  
		  return (function() {
			  return count++;
		  })
	  })();
	
  $scope.addBookmark = function() {
	  var count = increment();
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
	  
	  $http.post("cs480/user/" + "user1" + "/" + count + "?bookmark=" + $scope.newBookmark)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }

  $scope.loadUsers();

});