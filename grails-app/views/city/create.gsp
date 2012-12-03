<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    
    <head>
        <title>Erasm Experience - Create City</title>
        <meta name="layout" content="main" />
    </head>
    
    <body>
    
    <g:form class="form" url="[controller: 'city', action: 'create']">
    
        <h1>Create City</h1>
        
        <g:hasErrors bean="${city}">
            <div class="errors">
                <g:renderErrors bean="${city}"/>
            </div>
        </g:hasErrors>
		
        <p>
            <label for="name">City Name</label>
            <g:textField name="name" value="${city?.name}" 
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
				optionKey="id" value="${city?.country}" />
		</p>
		
        <p class="button">
            <label>&nbsp;</label>
            <g:submitButton class="button" name="submitButton" value="Create city" />
        </p>
        
    </g:form>
    </body>
</html>
