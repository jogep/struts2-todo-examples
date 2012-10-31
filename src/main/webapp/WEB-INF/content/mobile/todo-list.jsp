<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags" %>
<html>
<head><title>Manage Your TODOs</title></head>
<body>

<sjm:list id="todoList" inset="true" filter="true">
	<s:iterator value="items" >
		<sjm:listItem>
			<s:if test="done">
				<h3 id="todoTopic${id}" class="todo-done"><s:property value="topic"/></h3>
			</s:if>
			<s:else>
				<h3 id="todoTopic${id}"><s:property value="topic"/></h3>
			</s:else>
			<s:if test="category != null">
				<p><strong><s:property value="category" /></strong></p>
			</s:if>
			<s:if test="description != null">
				<s:property value="description" escapeHtml="false" />
			</s:if>
			<s:if test="dueDate != null">
				<p class="ui-li-aside"><strong><s:date name="dueDate" format="dd.MM.yyyy"/></strong></p>
			</s:if>
		</sjm:listItem>
	</s:iterator>
</sjm:list>

</body>
</html>