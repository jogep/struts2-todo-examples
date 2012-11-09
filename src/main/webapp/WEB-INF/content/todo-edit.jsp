<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags" %>

<s:form id="todoEditForm" action="todo-save" namespace="/" theme="bootstrap" cssClass="form-vertical" label="Edit TODO %{item.topic}">
	<s:hidden name="item.id" theme="simple"/>
	<s:textfield key="item.topic" tooltip="TODO Topic" required="true"/>
	<sj:datepicker name="item.dueDate" label="Due Date" parentTheme="bootstrap" />

	<s:url var="categoriesurl" action="todo-categories" namespace="/" />
	<sj:autocompleter name="item.category" label="Category" href="%{categoriesurl}" forceValidOption="false" list="categories" parentTheme="bootstrap" loadMinimumCount="1"/>

	<s:url var="editorConfig" value="/js/ckeditor.config.js" />
	<sjr:ckeditor name="item.description" label="Description" parentTheme="bootstrap" customConfig="%{editorConfig}" toolbar="TodoToolbar" />

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
