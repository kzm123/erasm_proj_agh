<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<%@page import="javax.transaction.UserTransaction"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - User page</title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${user}">
		
			<div id="buttons">
				<g:if test="${session?.username == user.username}"><g:link controller="user" action="edit" class="button">Edit</g:link></g:if>
				<g:if test="${session?.userid}"><g:link controller="user" action="logout" class="button">Logout</g:link></g:if>
			</div>
			
			<h1>
				${user?.details?.name} ${user?.details?.surname}
			</h1>
			
			<ul class="info">
			
				<g:if test="${user?.profilePhoto}">
					<img src="${resource(dir: 'images', file: user.profilePhoto)}" />
				</g:if>
				
				<li>Gender: 
					<g:if test="${user?.details?.gender}">male</g:if>
					<g:else>female</g:else>
				</li>
			 	
				<g:if test="${user?.details?.email}">
					<li>e-mail: ${user?.details?.email}</li>
				</g:if>
				
				<g:if test="${user?.details?.city}">
					<li>City: ${user?.details?.city}</li>
				</g:if>
				
				<g:if test="${user?.details?.address}">
					<li>Address: ${user?.details?.address}</li>
				</g:if>
				
				<g:if test="${user?.details?.country}">
					<li>Country: ${user?.details?.country?.name}</li>
				</g:if>
			
				<g:if test="${user?.details?.dateOfBirth}">
					<li>Date of Birth: <g:formatDate date="${user?.details?.dateOfBirth}" type="date" style="LONG"/></li>
				</g:if>
				
				<g:if test="${user?.details?.university}">
					<li>University: ${user?.details?.university}</li>
				</g:if>
				
				<g:if test="${user?.details?.highSchool}">
					<li>High School: ${user?.details?.highSchool}</li>
				</g:if>
			
				<g:if test="${user?.details?.workPlace}">
					<li>Work Place: ${user?.details?.workPlace}</li>
				</g:if>
			
				<g:if test="${user?.details?.phone}">
					<li>Phone: ${user?.details?.phone}</li>
				</g:if>
				
				<g:if test="${user?.city}">
					<li>Signed in to: 
						<g:link controller="city" action="index" id="${user.city.id}">
							${user.city.name}
						</g:link>
					</li>
				</g:if>
				
			</ul>
		
		</g:if>
		
		<g:else>
		    
			<h1>User ${params.user} not found!</h1>
	    
	    </g:else>
		
	</body>

</html>