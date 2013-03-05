<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - place Page</title>
		<meta name="layout" content="main" />
		
		<g:if test="${place}">
        
        <script type="text/javascript"
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDqqgA3m7G8sC2nwSn5y9L_cwz48NdBV-Y&sensor=false">
	    </script>
	    
	    <script type="text/javascript">
	    	var map, marker;
	    	
			function initialize() {
				var location = new google.maps.LatLng(${place.location});
				
				var mapOptions = {
					center: location,
					zoom: 8,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
				map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);

				marker = new google.maps.Marker({
					position: location,
					map: map
				});
			}
	    </script>
        
        </g:if>
        
	  	<g:javascript library='jquery' />
   		<r:layoutResources/>
    
	</head>

	<body onload="initialize()">
	
	<body>
		
		<g:if test="${place}">
		
			<h1>Place ${place?.name}</h1>
			
			<ul class="info">
				
				<li>City: <g:link controller="city" action="index" params="[city: place.city.name]">${place.city.name}</g:link></li>

				<div id="map_canvas" style="width:400px; height:400px"></div>
				
				<div class="rating" >
				
				<g:if test="${!voted }">
				<g:link action="rate" params="[rating : 1,id: params.id ]">1 </g:link>
				<g:link action="rate" params="[rating : 2,id: params.id ]">2 </g:link>
				<g:link action="rate" params="[rating : 3,id: params.id ]">3 </g:link>
				<g:link action="rate" params="[rating : 4,id: params.id ]">4 </g:link>
				<g:link action="rate" params="[rating : 5,id: params.id ]">5 |</g:link>
				</g:if>${place.rating }
				</div>
			</ul>

			<div class="comments">
			<g:form action="comment">
				<g:hiddenField name="id" value="${place.id }"/>
				<g:field type="text" name="body" />
				<g:submitButton name="comment"/>
			</g:form></div>
			<tr>
			<g:each in="${place.comments }" var="comment">
				<div class="comment">
					<p>${comment.author.username } | ${comment.rating} | <g:link action="reply">Reply ${place.id }</g:link>
					<g:link action="rateComment" params="[rate: 1, placeid: place.id, comment: comment.id]">+1 | </g:link>
					<g:link action="rateComment" params="[rate: -1, placeid: place.id, comment: comment.id]">-1</g:link>
					
					
					
					</p>
					<p>${comment.body }</p>
					<g:each in="${place.comments.replies }" var="reply">
					</g:each>
				</div>
			</g:each>		
			</tr>
		</g:if>
		
		<g:else>
		
			<h1>Place ${params.place} not found!</h1>
		
		</g:else>
		
	</body>

</html>
