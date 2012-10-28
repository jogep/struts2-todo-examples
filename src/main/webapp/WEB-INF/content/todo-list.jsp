<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<ul class="nav nav-list todo-list">
	        <s:iterator value="items">
		        <li id="todoItem${id}">
			        <s:if test="done">
				        <span id="todoTopic${id}" class="todo-done"><s:property value="topic"/></span>
			        </s:if>
			        <s:else>
				        <span id="todoTopic${id}"><s:property value="topic"/></span>
			        </s:else>
			        <s:if test="description != null">
				        <span id="todoTopicDescription${id}" class="todo-description">
					        <i class="icon-info-sign"></i>
				            <span id="todoTopicDescriptionContent${id}" class="todo-description-content">
						       <s:property value="description" escapeHtml="false" />
				            </span>
				        </span>
			        </s:if>
			        <s:if test="category != null">
				        <span id="todoTopicCategory${id}" class="todo-category badge badge-info">
						      <i class="icon-tag"></i> <s:property value="category" />
				        </span>
			        </s:if>
						<span class="actions pull-right">
			                <s:if test="!done">
					            <s:url var="doneurl" action="todo-done" namespace="/">
						            <s:param name="id" value="%{id}"/>
					            </s:url>
					            <sj:a id="todoDoneLink%{id}" href="%{doneurl}" dataType="json" onSuccessTopics="/todo/status"><i class="icon-ok"></i></sj:a>
			                </s:if>

							<s:url var="editurl" action="todo-edit" namespace="/" escapeAmp="false">
								<s:param name="id" value="%{id}"/>
							</s:url>
							<sj:a id="todoEditLink%{id}" href="%{editurl}" openDialog="todoDialog" openDialogTitle="Edit %{topic}"><i class="icon-pencil"></i></sj:a>

							<s:url var="deleteurl" action="todo-delete" namespace="/" escapeAmp="false">
								<s:param name="id" value="%{id}"/>
							</s:url>
							<sj:a id="todoRemoveLink%{id}" href="%{deleteurl}" dataType="json" onSuccessTopics="/todo/remove"><i class="icon-trash"></i></sj:a>
						</span>
			        <s:if test="dueDate != null">
				        <span id="todoTopicDate${id}" class="todo-due-date pull-right"><sub><s:date name="dueDate" format="dd.MM.yyyy"/></sub></span>
			        </s:if>
		        </li>
	        </s:iterator>
        </ul>
 <script type="text/javascript">
	    $(".todo-description").popover({
		    html:true,
		    title: "Description",
		    trigger: "hover",
		    content : function(){return $(this).find(".todo-description-content").html() }
	    });
 </script>