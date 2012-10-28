<html>
<head>
  <title>Erasm Experience - Registration</title>
  <meta name="layout" content="main" />
</head>
<body>
<g:form class="userform" url="[controller: 'users', action: 'register']">
  <h1>Registration</h1>
  <g:hasErrors bean="${users}">
    <div class="errors">
      <g:renderErrors bean="${users}"/>
    </div>
  </g:hasErrors>
  <p>
    <label for="username">Username</label>
    <g:textField name="username" value="${users?.username}" 
      class="${hasErrors(bean: users, field: 'username', 'errors')}"/>
  </p>
  <p>
    <label for="password">Password</label>
    <g:passwordField name="password"
      class="${hasErrors(bean: users, field: 'username', 'errors')}"/>
  </p>
  <p>
    <label for="confirm">Confirm Password</label>
    <g:passwordField name="confirm"
      class="${hasErrors(bean: users, field: 'username', 'errors')}"/>
  </p>
  <p>
    <label for="firstName">First Name</label>
    <g:textField name="firstName" value="${users?.firstName}"
      class="${hasErrors(bean: users, field: 'username', 'errors')}"/>
  </p>
  <p>
    <label for="lastName">Last Name</label>
    <g:textField name="lastName" value="${users?.lastName}"
      class="${hasErrors(bean: users, field: 'username', 'errors')}"/>
  </p>
  <p class="button">
    <label>&nbsp;</label>
    <g:submitButton class="button" name="submitButton" value="Create Account" />
  </p>
</g:form>
</body>
</html>
