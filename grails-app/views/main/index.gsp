<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - Homepage</title>
		<meta name="layout" content="main" />
	</head>

	<body>
		
		<g:if test="${!session.user}">
		
			<g:form class="form" style="width:50%;" url="[controller: 'user', action: 'login']">
			
				<h1>Login</h1>
				
				<p>
					<label for="username">Username</label>
					<g:textField name="username" />
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
				
				<p class="info">
					Don't have an account?
					<g:link controller="user" action="register">Sign up now!</g:link>
				</p>
				
			</g:form>
		
		</g:if>
		
	</body>

</html>