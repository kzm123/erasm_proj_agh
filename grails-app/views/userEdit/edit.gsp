<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    
    <head>
        <title>Erasm Experience - User Profile Edit</title>
        <meta name="layout" content="main" />
    </head>
    
    <body>
    
    <g:if test="${session?.user}">
    		
   		<h1>
			${session?.user?.details?.name} ${session?.user?.details?.surname} - Edit Profile
		</h1>
    
	    <g:form class="userform" url="[controller: 'UserEdit', action: 'edit']">
	        
	        <g:hasErrors bean="${user}">
				<div class="errors">
				    <g:renderErrors bean="${user}"/>
				</div>
			</g:hasErrors>
	        
			<g:hasErrors bean="${userDetails}">
				<div class="errors">
				    <g:renderErrors bean="${userDetails}"/>
				</div>
			</g:hasErrors>
	        
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
	            <g:textField name="name" value="${session?.user?.details?.name}"
	                class="${hasErrors(bean: userDetails, field: 'name', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="lastName">Last Name</label>
	            <g:textField name="surname" value="${session?.user?.details?.surname}"
	                class="${hasErrors(bean: userDetails, field: 'surname', 'errors')}"/>
	        </p>
	        
	        <p>
	        	<label for="gender">Gender</label>
				<g:radioGroup name="gender" labels="['Man','Woman']" values="['true','false']" value="${user?.details?.gender}" class="${hasErrors(bean: userDetails, field: 'gender', 'errors')}">
					<span>${it.radio} ${it.label}</span>
				</g:radioGroup>
	        </p>
	        
	        <p>
	            <label for="email">e-mail</label>
	            <g:textField name="email" value="${session?.user?.details?.email}"
	                class="${hasErrors(bean: userDetails, field: 'email', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="city">City</label>
	            <g:textField name="city" value="${session?.user?.details?.city}"
	                class="${hasErrors(bean: userDetails, field: 'city', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="address">Address</label>
	            <g:textField name="address" value="${session?.user?.details?.address}"
	                class="${hasErrors(bean: userDetails, field: 'address', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="country">Country</label>
	            <g:textField name="country" value="${session?.user?.details?.country}"
	                class="${hasErrors(bean: userDetails, field: 'country', 'errors')}"/>
	        </p>
	        
	        <p>
	        	<label for="dateOfBirth">Date of Birth</label>
	        	<g:datePicker name="dateOfBirth" value="${user?.details?.dateOfBirth}"
	        		precision="day" noSelection="['':'Choose']" relativeYears="[-100..-10]"
	        		class="${hasErrors(bean: userDetails, field: 'dateOfBirth', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="university">University</label>
	            <g:textField name="university" value="${session?.user?.details?.university}"
	                class="${hasErrors(bean: userDetails, field: 'university', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="highSchool">High School</label>
	            <g:textField name="highSchool" value="${session?.user?.details?.highSchool}"
	                class="${hasErrors(bean: userDetails, field: 'highSchool', 'errors')}"/>
	        </p>
	        
	        <p>
	            <label for="workPlace">Work Place</label>
	            <g:textField name="workPlace" value="${session?.user?.details?.workPlace}"
	                class="${hasErrors(bean: userDetails, field: 'workPlace', 'errors')}"/>
	        </p>
	        
	        <p class="button">
	            <label>&nbsp;</label>
	            <g:submitButton class="button" name="submitButton" value="Save" />
	        </p>
	        
	    </g:form>
	        
	        <br />
	        
	        <p style="text-align:center;display:block;">
				<g:form action="uploadProfilePhoto" method="post" enctype="multipart/form-data">
					<label for="profilePhoto">Profile photo</label>
					<input type="file" name="profilePhoto" id="profilePhoto" />
					<input type="submit" class="buttons" value="Upload" />
				</g:form>
	        </p>
	        
	        <p>
	        	<br />
	        	<g:link controller="UserEdit" action="deleteProfilePhoto" class="button">Delete photo</g:link>
	        </p>
    
    </g:if>
    
    </body>
</html>
