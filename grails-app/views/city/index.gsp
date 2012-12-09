<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>Erasm Experience - City Page</title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
		<g:if test="${city}">
		
			<g:if test="${session?.userid}">			
				<div id="buttons">
					<g:link controller="city" action="create" class="button">Create new city</g:link>
					<g:if test="${userSignedIn}">
						<g:link controller="user" action="signOutFromCity" class="button" id="${city.id}">Sign out from this city</g:link>
					</g:if>
					<g:else>
						<g:link controller="user" action="signInToCity" class="button" id="${city.id}">Sign in to this city</g:link>
					</g:else>
				</div>
			</g:if>
			
			<h1>${city.name}</h1>
			
			<ul class="info">
			
				<li><g:if test="${city.description}">Description: ${city.description}</g:if></li>
				
				<li>Country: ${city.country.name}</li>
				
			</ul>
			
			<br />
			
			<g:if test="${places}">
			
				<h2>Places</h2>
				
				<ul class="info">
				
					<g:each in="${places}">
					
						<g:link controller="place" action="index" id="${it.id}"><li>${it.name}</li></g:link>
					
					</g:each>
				
				</ul>
			
			</g:if>
			
			<g:if test="${session.userid}">
			
				<br />
				
				<h2>Add new place to this city</h2>
			        
		        <g:hasErrors bean="${place}">
		            <div class="errors">
		                <g:renderErrors bean="${place}"/>
		            </div>
		        </g:hasErrors>
					
				<g:form class="form" url="[controller: 'city', action: 'addPlace']">
					
			        <p>
			            <label for="name">Place Name</label>
			            <g:textField name="name" class="${hasErrors(bean: place, field: 'name', 'errors')}"/>
			        </p>
			        <p>
			            <label for="localization">Localization</label>
			            <g:textArea name="localization" class="${hasErrors(bean: place, field: 'localization', 'errors')}"/>
			        </p>
			        <p>
			            <label for="city">City</label>
			            <g:textField name="city" class="${hasErrors(bean: place, field: 'city', 'errors')}" value="${city.name}" />
			        </p>
					
			        <p class="button">
			            <label>&nbsp;</label>
			            <g:submitButton class="button" name="submitButton" value="Add place" />
			        </p>
		        
		    	</g:form>
	    	
	    	</g:if>
		
		</g:if>
		
		<g:else>
		
			<g:if test="${session?.userid}">
			
				<h1>City ${params.city} not found! Would you like to create it?</h1>
				
				<g:form class="form" url="[controller: 'city', action: 'create']">
			        
			        <g:hasErrors bean="${city}">
			            <div class="errors">
			                <g:renderErrors bean="${city}"/>
			            </div>
			        </g:hasErrors>
					
			        <p>
			            <label for="name">City Name</label>
			            <g:textField name="name" value="${params.city}" 
			                class="${hasErrors(bean: city, field: 'name', 'errors')}"/>
			        </p>
			        <p>
			            <label for="description">Description</label>
			            <g:textArea name="description" value="${city?.description}" 
			            	class="${hasErrors(bean: city, field: 'description', 'errors')}"/>
			        </p>
        
					<p>
						<label for="country">Country</label>
						<g:select name="country" from="${erasm_proj_agh.Country.list()}" noSelection="${['null':'Choose']}"
							optionKey="id" value="${city?.country?.id}" />
					</p>
					
			        <p class="button">
			            <label>&nbsp;</label>
			            <g:submitButton class="button" name="submitButton" value="Create City" />
			        </p>
		        
		    	</g:form>
		    
		    </g:if>
		    
		    <g:else>
		    
				<h1>City ${params.city} not found!</h1>
		    
		    </g:else>
		
		</g:else>
		
	</body>

</html>