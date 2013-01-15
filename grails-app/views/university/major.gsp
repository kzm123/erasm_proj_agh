<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - Major Page</title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${major}">
		
			<h1>${major?.name}</h1>
			
			<ul class="info">
			
				<li><g:if test="${major.description}">Description: ${major.description}</g:if></li>
				
				<li>Faculty: <g:link controller="university" action="faculty" id="${major.faculty.id}">${major.faculty.name}</g:link></li>
				
			</ul>
		
		</g:if>
		
	</body>

</html>