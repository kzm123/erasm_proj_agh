<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - place Page</title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${place}">
		
			<h1>Place ${place?.name}</h1>
			
			<ul class="info">
			
				<li><g:if test="${place.localization}">Localization: ${place.localization}</g:if></li>
				
				<li>City: <g:link controller="city" action="show" id="${place.city.id}">${place.city.name}</g:link></li>
				
			</ul>
		
		</g:if>
		
		<g:else>
		
			<h1>Place ${params.place} not found!</h1>
		
		</g:else>
		
	</body>

</html>