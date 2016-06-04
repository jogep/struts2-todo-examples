<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head><title>Manage Your TODOs</title></head>
<body>

<div class="row">
    <div class="col-md-4">

        <s:fielderror theme="bootstrap"/>

        <s:form id="todoAddForm" action="todo-save" namespace="/" theme="bootstrap" cssClass="well form-inline" label="New TODO ...">
            <div class="input-group">
                <s:textfield name="item.topic" label="TODO" tooltip="TODO Topic" theme="simple" cssClass="form-control"/>
				<span class="input-group-btn">
					<sj:submit
							cssClass="btn btn-primary"
							cssStyle="height: 30px"
							value="Add"
							formIds="todoAddForm"
							targets="todoListContent"
							clearForm="true"
							validate="true"
							validateFunction="bootstrapValidation"
					/>
				</span>
            </div>
        </s:form>
    </div>
	<s:url var="listurl" action="todo-list" namespace="/" />
	<sj:div id="todoListContent" cssClass="col-md-8" href="%{listurl}">
    </sj:div>
</div>

<sj:dialog id="todoDialog" modal="true" title="TODO Dialog" autoOpen="false" width="900" height="680" closeTopics="/todo/dialog/close" />

</body>
</html>