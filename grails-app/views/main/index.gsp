<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - Homepage</title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${session?.user}">
		
			<div id="buttons">
				<g:link controller="UserEdit" action="edit" class="button">Edit</g:link>
				<g:link controller="User" action="logout" class="button">Logout</g:link>
			</div>
			
			<h1>
				${session?.user?.details?.name} ${session?.user?.details?.surname}
			</h1>
			
			<ul class="profileinfo">
			
				<g:if test="${session?.user?.profilePhoto}">
					<img src="${resource(dir:'images', file:session.user.profilePhoto)}" />
				</g:if>
				
				<!-- 
				<g:if test="${session?.user?.details?.gender}">
					<li>Gender: ${session?.user?.details?.gender}</li>
				</g:if>
			 	-->
			 	
				<g:if test="${session?.user?.details?.email}">
					<li>e-mail: ${session?.user?.details?.email}</li>
				</g:if>
				
				<g:if test="${session?.user?.details?.city}">
					<li>City: ${session?.user?.details?.city}</li>
				</g:if>
				
				<g:if test="${session?.user?.details?.address}">
					<li>Address: ${session?.user?.details?.address}</li>
				</g:if>
				
				<g:if test="${session?.user?.details?.country}">
					<li>Country: ${session?.user?.details?.country}</li>
				</g:if>
			
				<g:if test="${session?.user?.details?.dateOfBirth}">
					<li>Date of Birth: <g:formatDate date="${session?.user?.details?.dateOfBirth}" type="date" style="LONG"/></li>
					
				</g:if>
				
				<g:if test="${session?.user?.details?.university}">
					<li>University: ${session?.user?.details?.university}</li>
				</g:if>
				
				<g:if test="${session?.user?.details?.highSchool}">
					<li>High School: ${session?.user?.details?.highSchool}</li>
				</g:if>
			
				<g:if test="${session?.user?.details?.workPlace}">
					<li>Work Place: ${session?.user?.details?.workPlace}</li>
				</g:if>
			</ul>
		
		</g:if>
		
		<g:else>
		
			<g:form class="userform" style="width:50%;" url="[controller: 'user', action: 'login']">
			
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
		
		</g:else>
		
	</body>

</html>