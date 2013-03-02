<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    
<head>
    <title>Erasm Experience - Registration</title>
    <meta name="layout" content="main" />
</head>

<body>
    
	<h1>Registration</h1>
    
    <g:form class="form" url="[controller: 'user', action: 'register']">
        
        <g:hasErrors bean="${user}">
            <div class="errors">
                <g:renderErrors bean="${user}"/>
            </div>
        </g:hasErrors>
		
        <p>
            <label for="username">Username</label>
            <g:textField name="username" value="${user?.username}" 
                class="${hasErrors(bean: user, field: 'username', 'errors')}"/>
        </p>
        
        <p>
            <label for="password">Password</label>
            <g:passwordField name="password"
                class="${hasErrors(bean: user, field: 'password', 'errors')}"/>
        </p>
        
        <p>
            <label for="confirm">Confirm Password</label>
            <g:passwordField name="confirm"
            	class="${hasErrors(bean: user, field: 'password', 'errors')}"/>
        </p>
        
        <p>
            <label for="name">First Name</label>
            <g:textField name="name" value="${user?.details?.name}"
                class="${hasErrors(bean: user, field: 'details.name', 'errors')}"/>
        </p>
        
        <p>
            <label for="surname">Last Name</label>
            <g:textField name="surname" value="${user?.details?.surname}"
                class="${hasErrors(bean: user, field: 'details.surname', 'errors')}"/>
        </p>
	        
        <p>
            <label for="email">e-mail</label>
            <g:textField name="email" value="${user?.details?.email}"
                class="${hasErrors(bean: user, field: 'details.email', 'errors')}"/>
        </p>
        
        <p>
        	<label for="gender">Gender</label>
			<g:radioGroup name="gender" labels="['Man','Woman']" values="['true','false']" 
				value="${user?.details?.gender == null ? true : user?.details?.gender}" class="${hasErrors(bean: details, field: 'gender', 'errors')}">
				<span>${it.radio} ${it.label}</span>
			</g:radioGroup>
        </p>
		
        <p class="button">
            <label>&nbsp;</label>
            <g:submitButton class="button" name="submitButton" value="Create Account" />
        </p>
        
    </g:form>
    
</body>

</html>
