<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><g:layoutTitle default="Erasm Experience" /></title>
		<link rel="stylesheet" href="${resource(dir:'css', file:'default.css')}" />
		<link rel="shortcut icon" href="${resource(dir:'images', file:'favicon.ico')}" type="image/x-icon" />
		<g:layoutHead />
	</head>
  
<body>
	<div id="wrapper">
		  
		<g:link controller="main">
			<img id="logo" src="${resource(dir:'images', file:'logo.png')}" />
		</g:link>
		
		<div id="nav"></div>
		
		<div id="content">
		
			<g:form method="GET" class="form" style="width:50%;" url="[controller: 'searchable', action: 'index']">
			
				<p>
					<label for="q">Search</label>
					<g:textField name="q" value="${params.q}" />
				</p>
				
				<p class="button">
					<label>&nbsp;</label>
					<button type="submit">Search</button>
<%--					<g:submitButton class="button" name="submitButton" value="Search" />--%>
				</p>
					
			</g:form>
			
			<g:layoutBody />
		</div>
	  
	</div>
</body>

</html>