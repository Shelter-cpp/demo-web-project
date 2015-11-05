  var increment = (function() {
	  var count = 1;
	  
	  return (function() {
		  return count++;
	  })
  })();

  function addPreset() {
	  var count = increment();
	  var div = document.createElement('div');

	    div.className = 'large-3 small-3 columns end';

	    div.innerHTML = '&nbsp;\
			&nbsp;\
	    	&nbsp;\
	    	&nbsp;\
	    	<ul class="stack button-group">\
	    	<li><a href="#" class="button large" >Preset Button ' + count +'</a></li>\
	    	<li><a href="#" class="button small">Edit Preset</a></li>\
	    	</ul>\
	    	</div>';

	     document.getElementById('content').appendChild(div);
  };