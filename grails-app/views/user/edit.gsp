<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    
    <head>
        <title>Erasm Experience - User Profile Edit</title>
        <meta name="layout" content="main" />
    </head>
    
    <body>
    
    <g:if test="${user}">
    		
   		<h1>
			${user?.details?.name} ${user?.details?.surname} - Edit Profile
		</h1>
	        
        <g:hasErrors bean="${user}">
			<div class="errors">
			    <g:renderErrors bean="${user}"/>
			</div>
		</g:hasErrors>
				
		<g:if test="${flash.message}">
			<br />
			<div class="message">${flash.message}</div>
		</g:if>
    
	    <g:form class="form" url="[controller: 'user', action: 'edit']">
	        
	        <p>
	            <label for="password">Password</label>
	            <g:passwordField name="password"
	                class="${hasErrors(bean: user, field: 'password', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="confirm">Confirm Password</label>
	            <g:passwordField name="confirm"
	                class="${hasErrors(bean: user, field: 'confirm', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="firstName">First Name</label>
	            <g:textField name="name" value="${user?.details?.name}"
	                class="${hasErrors(bean: user, field: 'details.name', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="lastName">Last Name</label>
	            <g:textField name="surname" value="${user?.details?.surname}"
	                class="${hasErrors(bean: user, field: 'details.surname', 'errors')}"/>
	        </p>
	        
	        <p>
	        	<label for="gender">Gender</label>
	        	<g:if test="${user?.details?.gender}">
		        	<g:radioGroup name="gender" labels="['Man','Woman']" values="['true','false']" value="true" 
						 class="${hasErrors(bean: user, field: 'details.gender', 'errors')}">
						<span>${it.radio} ${it.label}</span>
					</g:radioGroup>
	        	</g:if>
	        	<g:else>
		        	<g:radioGroup name="gender" labels="['Man','Woman']" values="['true','false']" value="false" 
						 class="${hasErrors(bean: user, field: 'details.gender', 'errors')}">
						<span>${it.radio} ${it.label}</span>
					</g:radioGroup>
	        	</g:else>
				
	        </p>
	        
	        <p>
	            <label for="email">e-mail</label>
	            <g:textField name="email" value="${user?.details?.email}"
	                class="${hasErrors(bean: user, field: 'details.email', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="city">City</label>
	            <g:textField name="city" value="${user?.details?.city}"
	                class="${hasErrors(bean: user, field: 'details.city', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="address">Address</label>
	            <g:textField name="address" value="${user?.details?.address}"
	                class="${hasErrors(bean: user, field: 'address', 'errors')}"/>
	        </p>

			<p>
				<label for="country">Country</label>
				<g:select name="country" from="${erasm_proj_agh.Country.list()}" noSelection="${['null': 'Choose']}"
					optionKey="id" value="${user?.details?.country?.id}" />
			</p>
	        
	        <p>
	        	<label for="dateOfBirth">Date of Birth</label>
	        	<g:datePicker name="dateOfBirth" value="${user?.details?.dateOfBirth}"
	        		precision="day" />
	        </p>
	        
	        <p>
	            <label for="university">University</label>
	            <g:textField name="university" value="${user?.details?.university}"
	                class="${hasErrors(bean: user, field: 'details.university', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="highSchool">High School</label>
	            <g:textField name="highSchool" value="${user?.details?.highSchool}"
	                class="${hasErrors(bean: user, field: 'details.highSchool', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="workPlace">Work Place</label>
	            <g:textField name="workPlace" value="${user?.details?.workPlace}"
	                class="${hasErrors(bean: user, field: 'details.workPlace', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="phone">Phone</label>
	            <g:textField name="phone" value="${user?.details?.phone}"
	                class="${hasErrors(bean: user, field: 'details.phone', 'errors')}"/>
	        </p>
	        
	        <p class="button">
	            <label>&nbsp;</label>
	            <g:submitButton class="button" name="submitButton" value="Save" />
	        </p>
	        
	    </g:form>
	        
	        <br />
	        
	        <p style="text-align:center;display:block;">
	        
				<g:form controller="user" action="uploadProfilePhoto" method="post" enctype="multipart/form-data">
				
					<label for="profilePhoto">Profile photo</label>
					
					<input type="file" name="profilePhoto" id="profilePhoto" />
					
					<input type="submit" class="buttons" value="Upload" />
					
				</g:form>
				
	        </p>
	        
	        <p>
	        	<br />
	        	<g:link controller="user" action="deleteProfilePhoto" class="button">Delete photo</g:link>
	        </p>
    
    </g:if>
    
    </body>
</html>
