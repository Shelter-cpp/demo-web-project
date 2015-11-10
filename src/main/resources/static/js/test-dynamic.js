  var increment = (function() {
	  var count = 1;
	  
	  return (function() {
		  return count++;
	  })
  })();

  function addPreset() {
	  var count = increment();
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
		    	<li><a href="#" class="button large" onClick="openUrls(' + presetName + ')" >' + presetName +'</a></li>\
		    	<li><a href="#" class="button small">Edit</a></li>\
		    	</ul>\
		    	</div>';

		     document.getElementById('content').appendChild(div);
		     
	  }
	    
  };
  
  function openUrls(name) {
	  alert(name);
  };
  
  //use angular
  function getUrls(name) {
	  //get a list of the urls from the user.bookmark
	  //call openURLS by passing list of URLS to it
  };