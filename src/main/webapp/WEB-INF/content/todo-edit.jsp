<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags" %>

<s:form id="todoEditForm" action="todo-save" namespace="/" theme="bootstrap" cssClass="form-horizontal" label="Edit TODO %{topic}">
	<s:hidden name="id" value="%{item.id}" theme="simple"/>
	<s:textfield name="topic" value="%{item.topic}" label="TODO" tooltip="TODO Topic" required="true"/>
	<sj:datepicker name="dueDate" value="%{item.dueDate}" label="Due Date" parentTheme="bootstrap" />

	<s:url var="categoriesurl" action="todo-categories" namespace="/" />
	<sj:autocompleter name="category" value="%{item.category}" label="Category" href="%{categoriesurl}" forceValidOption="false" list="categories" parentTheme="bootstrap" loadMinimumCount="1"/>

	<s:url var="editorConfig" value="/js/ckeditor.config.js" />
	<sjr:ckeditor name="description" value="%{item.description}" label="Description" parentTheme="bootstrap" customConfig="%{editorConfig}" toolbar="TodoToolbar" />

	<div class="form-actions">
		<sj:submit
				cssClass="btn btn-primary"
				value="Save"
				formIds="todoEditForm"
				targets="todoListContent"
				onCompleteTopics="/todo/dialog/close"
		        validate="true"
		        validateFunction="bootstrapValidation"
		/>
	</div>
</s:form>
