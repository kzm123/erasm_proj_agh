<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<%@page import="javax.transaction.UserTransaction"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - User page</title>
		<g:javascript library="jquery" plugin="jquery" />
		<r:layoutResources/>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${user}">
		
			<div id="buttons">
			<sec:ifLoggedIn>
				<g:if test="${isCurrentUser}"><g:link controller="user" action="edit" class="button">Edit</g:link></g:if>
				<g:else>
					<g:if test="${!isMyFriend}">
						<g:link controller="user" action="addFriend" class="button" id="${user.id}">Add friend</g:link>
					</g:if>
					<g:else>
						<g:link controller="user" action="deleteFriend" class="button" id="${user.id}">Delete friend</g:link>
					</g:else>
				</g:else>
				<g:link controller="logout" class="button">Logout</g:link>
			</sec:ifLoggedIn>
			<sec:ifNotLoggedIn>
				<g:link controller="login" class="button">Login</g:link>
			</sec:ifNotLoggedIn>
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
				<g:if test="${user?.userCities}">
					<li>Signed in to:
						<ul> 
							<g:each in="${user?.userCities}">
								<g:link controller="city" action="show" id="${it.city.id}"><li>${it.city.name}</li></g:link>
							</g:each>
						</ul>
					</li>
				</g:if>
				
			</ul>
			
			<sec:ifLoggedIn>
			
				<g:formRemote name="updateStatusFrom" url="[action: 'updateStatus', params: [username: user.username]]" update="messages" >
					<g:textArea name="message" value="" /><br />
					<g:submitButton name="Update Status" />
				</g:formRemote>
			
			</sec:ifLoggedIn>
			
			<div id="messages">
				<g:render template="messages" collection="${messages}" var="message" />
			</div>
		
		</g:if>
		
		<g:else>
		    
			<h1>User ${params?.user} not found!</h1>
	    
	    </g:else>
		
	</body>

</html>