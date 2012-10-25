<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Manage Your TODOs</title></head>
<body>

<div class="row-fluid">
	<div class="span3">

		<s:fielderror theme="bootstrap" />

		<s:form action="todo-add" namespace="/" theme="bootstrap" cssClass="form-inline" label="New TODO ...">
			<div class="input-append">
				<s:textfield name="name" label="ToDo" tooltip="Name of the Tooltip" theme="simple"/>
				<s:submit cssClass="btn btn-primary" value="Add" cssStyle="height: 30px;"/>
			</div>
		</s:form>
	</div>
	<div class="span9">
		<div class="span4">
			<ul class="nav nav-list todo-list">
				<li>
					<span>Todo 1</span>
					<span class="actions pull-right">
						<a href="#"><i class="icon-ok"></i></a>
						<a href="#"><i class="icon-trash"></i></a>
					</span>
				</li>
				<li>
					<span>Todo 2</span>
					<span class="actions pull-right">
						<a href="#"><i class="icon-ok"></i></a>
						<a href="#"><i class="icon-trash"></i></a>
					</span>
				</li>
				<li>
					<span class="solved">Todo Solved</span>
					<span class="actions pull-right">
						<a href="#"><i class="icon-ok"></i></a>
						<a href="#"><i class="icon-trash"></i></a>
					</span>
				</li>
			</ul>
		</div>
	</div>
</div>

</body>
</html>