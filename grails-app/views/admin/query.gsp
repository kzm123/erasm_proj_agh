<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
<title>Erasm Experience - Admin's panel - Queries</title>
<meta name="layout" content="main" />
</head>

<body>

	<g:if test="${session?.admin}">

		<div id="buttons">
			<g:link controller="Admin" action="index" class="button">Home</g:link>
			<g:link controller="Admin" action="query" class="button">Queries</g:link>
			<g:link controller="Admin" action="editCities" class="button">City Database</g:link>
			<g:link controller="Admin" action="logout" class="button">Logout</g:link>
		</div>


		<h1>Admin Panel - Manage database</h1>

		<br> <g:form class="form" style="width:100%;"
				url="[controller: 'admin', action: 'query']">

				<h2>Select table</h2>

				<p align=center>
					<g:select name="table" value="${it}" optionValue="${{it}}"
						from="${tableList}" />

					<g:submitButton class="button" name="submitButton" value="Show" />
				</p>
				
				<g:if test="${colNames}">
					<center>
					<table>
						<tr>
							<g:each in="${colNames}">
								<g:sortableColumn property="${it}" title="${it}" />

							</g:each>
							<th><u>REMOVE</u></th>
						</tr>
						
						<g:each in="${rowList}">
							<tr>
								<g:each var="col" in="${colNames}">
									<td>
										${it.getProperty(col)}
									</td>
								</g:each>
								<td>
									<g:checkBox name="${it.getProperty(colNames.get(0))}" value="${false}" />
								</td>
							</tr>
						</g:each>
					</table>
						<br>
						<g:submitButton class="button" name="submitButton" value="Remove selected" />
					</center>
					
					
				</g:if>

			</g:form>
	</g:if>

</body>

</html>