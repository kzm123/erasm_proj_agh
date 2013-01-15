<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - Faculty Page</title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${faculty}">
		
			<h1>${faculty?.name}</h1>
			
			<ul class="info">
			
				<li><g:if test="${faculty.description}">Description: ${faculty.description}</g:if></li>
				
				<li>University: <g:link controller="university" action="show" id="${faculty.university.id}">${faculty.university.name}</g:link></li>
				
			</ul>
			
			<g:if test="${majors}">
			
				<h2>Majors</h2>
				
				<ul class="info">
				
					<g:each in="${majors}">
					
						<g:link controller="university" action="major" id="${it.id}"><li>${it.name}</li></g:link>
					
					</g:each>
				
				</ul>
			
			</g:if>
			
			<g:if test="${session.userid}">
			
				<br />
				
				<h2>Add new major to this faculty</h2>
			        
		        <g:hasErrors bean="${major}">
		            <div class="errors">
		                <g:renderErrors bean="${major}"/>
		            </div>
		        </g:hasErrors>
					
				<g:form class="form" url="[controller: 'university', action: 'addMajor']">
					
			        <p>
			            <label for="name">Faculty Name</label>
			            <g:textField name="name" class="${hasErrors(bean: major, field: 'name', 'errors')}"/>
			        </p>
			        
			        <p>
			            <label for="localization">Description</label>
			            <g:textArea name="localization" class="${hasErrors(bean: major, field: 'description', 'errors')}"/>
			        </p>
			        
			        <p>
			            <label for="faculty">Faculty</label>
			            <g:textField name="faculty" class="${hasErrors(bean: major, field: 'faculty', 'errors')}" value="${faculty.name}" />
			        </p>
					
			        <p class="button">
			            <label>&nbsp;</label>
			            <g:submitButton class="button" name="submitButton" value="Add major" />
			        </p>
		        
		    	</g:form>
	    	
	    	</g:if>
		
		</g:if>
		
	</body>

</html>