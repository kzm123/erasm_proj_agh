<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    
    <head>
        <title>Erasm Experience - Registration</title>
        <meta name="layout" content="main" />
    </head>
    
    <body>
    <g:form class="userform" url="[controller: 'user', action: 'register']">
        <h1>Registration</h1>
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
                class="${hasErrors(bean: user, field: 'username', 'errors')}"/>
        </p>
        <p>
            <label for="confirm">Confirm Password</label>
            <g:passwordField name="confirm"
                class="${hasErrors(bean: user, field: 'username', 'errors')}"/>
        </p>
        <p>
            <label for="firstName">First Name</label>
            <g:textField name="name" value="${user?.details?.name}"
                class="${hasErrors(bean: user, field: 'username', 'errors')}"/>
        </p>
        <p>
            <label for="lastName">Last Name</label>
            <g:textField name="surname" value="${user?.details?.surname}"
                class="${hasErrors(bean: user, field: 'username', 'errors')}"/>
        </p>
        <p class="button">
            <label>&nbsp;</label>
            <g:submitButton class="button" name="submitButton" value="Create Account" />
        </p>
    </g:form>
    </body>
</html>
