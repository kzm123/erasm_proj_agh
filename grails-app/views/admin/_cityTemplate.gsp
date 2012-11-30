
<p>	City:
	${it.name}
	<g:if test="${it.confirmed == false}">
		<g:link controller="Admin" action="confirmCity" params="[id : it.id]">   UNCONFIRMED</g:link>
	</g:if>
</p>
<p>Description: ${it.description}</p><br>