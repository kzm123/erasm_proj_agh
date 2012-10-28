<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title><g:layoutTitle default="Erasm Experience" /></title>
    <link rel="stylesheet" href="${resource(dir:'css', file:'default.css')}" />
    <link rel="shortcut icon" href="${resource(dir:'images', file:'favicon.ico')}" type="image/x-icon" />
    <g:layoutHead />
  </head>
  
  <body>
    <div id="wrapper">
      
      <img id="logo" src="${resource(dir:'images', file:'logo.png')}" />
      
      <g:if test="${session?.users}">
        <div id="login">
          Logged in as ${session?.users?.firstName} ${session?.users?.lastName} |
          <g:link controller="users" action="logout">Logout</g:link>
        </div>
      </g:if>
      
      <div id="nav"></div>
      
      <div id="content"><g:layoutBody /></div>
      
    </div>
  </body>
</html>