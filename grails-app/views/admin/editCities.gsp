<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    
    <head>
        <title>Erasm Experience - City Database</title>
        <meta name="layout" content="main" />
    </head>
    
    <body>
    
    <g:if test="${session?.admin}">
    	
    	<div id="buttons">
    		<g:link controller="Admin" action="index" class="button">Home</g:link>
    		<g:link controller="Admin" action="query" class="button">Queries</g:link>
			<g:link controller="Admin" action="editCities" class="button">City Database</g:link>
			<g:link controller="Admin" action="logout" class="button">Logout</g:link>
		</div>
    	
   		<h1>
			Admin Panel - City Database
		</h1>
    
    	<g:render template="cityTemplate" collection="${cityList}" />

	   
	        
    
    </g:if>
    </body>
</html>
