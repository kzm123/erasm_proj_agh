<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - University Page</title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${university}">
		
			<h1>${university?.name}</h1>
			
			<ul class="info">
			
				<li><g:if test="${university.description}">Description: ${university.description}</g:if></li>
				
				<li>City: <g:link controller="city" action="show" id="${university.city.id}">${university.city.name}</g:link></li>
				
			</ul>
			
			<g:if test="${faculties}">
			
				<h2>Faculties</h2>
				
				<ul class="info">
				
					<g:each in="${faculties}">
					
						<g:link controller="university" action="faculty" id="${it.id}"><li>${it.name}</li></g:link>
					
					</g:each>
				
				</ul>
			
			</g:if>
			
			<g:if test="${session.userid}">
			
				<br />
				
				<h2>Add new faculty to this university</h2>
			        
		        <g:hasErrors bean="${faculty}">
		            <div class="errors">
		                <g:renderErrors bean="${faculty}"/>
		            </div>
		        </g:hasErrors>
					
				<g:form class="form" url="[controller: 'university', action: 'addFaculty']">
					
			        <p>
			            <label for="name">Faculty Name</label>
			            <g:textField name="name" class="${hasErrors(bean: faculty, field: 'name', 'errors')}"/>
			        </p>
			        
			        <p>
			            <label for="localization">Description</label>
			            <g:textArea name="localization" class="${hasErrors(bean: faculty, field: 'description', 'errors')}"/>
			        </p>
			        
			        <p>
			            <label for="university">University</label>
			            <g:textField name="university" class="${hasErrors(bean: faculty, field: 'university', 'errors')}" value="${university.name}" />
			        </p>
					
			        <p class="button">
			            <label>&nbsp;</label>
			            <g:submitButton class="button" name="submitButton" value="Add faculty" />
			        </p>
		        
		    	</g:form>
	    	
	    	</g:if>
		
		</g:if>
		
	</body>

</html>