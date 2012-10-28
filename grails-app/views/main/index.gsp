<html>
<head>
  <title>Erasm Experience - Homepage</title>
  <meta name="layout" content="main" />
</head>
<body>
  <g:if test="${session?.users}">
  </g:if>
  <g:else>
    <g:form class="userform" style="width:50%;" url="[controller: 'users', action: 'login']">
      <h1>Login</h1>
      <p>
        <label for="username">Username</label>
        <g:textField name="username" />
      </p>
      <p>
        <label for="password">Password</label>
        <g:passwordField name="password" />
      </p>
      <p class="button">
        <label>&nbsp;</label>
        <g:submitButton class="button" name="submitButton" value="Login" />
      </p>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <p class="info">
        Don't have an account?
        <g:link controller="users" action="register">Sign up now!</g:link>
      </p>
    </g:form>
  </g:else>
</body>
</html>