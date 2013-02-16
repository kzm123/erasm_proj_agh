<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - Search</title>
		<meta name="layout" content="main" />
	</head>

	<body>
		
		<h1>Search results</h1>
		
		<g:if test="${!users && !cities && !places && !universities}">
			<br /><p>Nothing found!</p>
		</g:if>
		
		<g:else>
		
			<g:if test="${users}">
			
				<br />
				
				<h2>Users</h2>
				<ul class="info">
					<g:each in="${users}">
						<g:link controller="user" action="show" id="${it.user.id}"><li>${it.name} ${it.surname}</li></g:link>
					</g:each>
				</ul>
			
			</g:if>
			
			<g:if test="${cities}">
			
				<br />
			
				<h2>Cities</h2>
				<ul class="info">
					<g:each in="${cities}">
						<g:link controller="city" action="show" id="${it.id}"><li>${it.name}</li></g:link>
					</g:each>
				</ul>
			
			</g:if>
			
			<g:if test="${places}">
			
				<br />
			
				<h2>Places</h2>
				<ul class="info">
					<g:each in="${places}">
						<g:link controller="place" action="show" id="${it.id}"><li>${it.name}</li></g:link>
					</g:each>
				</ul>
				
			</g:if>
			
			<g:if test="${universities}">
			
				<br />
			
				<h2>Universities</h2>
				<ul class="info">
					<g:each in="${universities}">
						<g:link controller="university" action="show" id="${it.id}"><li>${it.name}</li></g:link>
					</g:each>
				</ul>
				
			</g:if>
			
		</g:else>
			
		<br/>
		
		<g:if test="${session.username}">
			<g:link controller="city" action="create" class="button">Create new city</g:link>
		</g:if>
		
	</body>

</html>