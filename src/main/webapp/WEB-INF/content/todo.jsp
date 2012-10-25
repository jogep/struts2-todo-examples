<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Manage Your TODOs</title></head>
<body>

<div class="row-fluid">
    <div class="span4">

        <s:fielderror theme="bootstrap"/>

        <s:form action="todo-add" namespace="/" theme="bootstrap" cssClass="form-inline" label="New TODO ...">
            <div class="input-append">
                <s:textfield name="topic" label="TODO" tooltip="TODO Topic" theme="simple"/>
                <s:submit cssClass="btn btn-primary btn-large" value="Add"/>
            </div>
        </s:form>
    </div>
    <div class="span8">
        <ul class="nav nav-list todo-list">
	        <s:iterator value="items">
		        <li>
			        <s:if test="done">
				        <span class="todo-done"><s:property value="topic"/></span>
			        </s:if>
			        <s:else>
				        <span><s:property value="topic"/></span>
			        </s:else>
						<span class="actions pull-right">
			                <s:if test="!done">
					            <s:url var="doneurl" action="todo-done" namespace="/">
						            <s:param name="id" value="%{id}"/>
					            </s:url>
					            <s:a href="%{doneurl}"><i class="icon-ok"></i></s:a>
			                </s:if>

							<s:url var="deleteurl" action="todo-delete" namespace="/">
								<s:param name="id" value="%{id}"/>
							</s:url>
							<s:a href="%{deleteurl}"><i class="icon-trash"></i></s:a>
						</span>
		        </li>
	        </s:iterator>
        </ul>
    </div>
</div>

</body>
</html>