<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - Homepage</title>
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
				Admin Panel
			</h1>
		
		</g:if>
		
		<g:else>
		
			<g:form class="form" style="width:50%;" url="[controller: 'admin', action: 'login']">
			
				<h1>Login</h1>
				
				<p>
					<label for="login">Login</label>
					<g:textField name="login" />
				</p>
				
				<p>
					<label for="password">Password</label>
					<g:passwordField name="password" />
				</p>
				
				<p class="button">
					<label>&nbsp;</label>
					<g:submitButton class="button" name="submitButton" value="Login" />
				</p>
				
				<g:if test="${flash.message}">
					<div class="message">${flash.message}</div>
				</g:if>
				
			</g:form>
		
		</g:else>
		
	</body>

</html>