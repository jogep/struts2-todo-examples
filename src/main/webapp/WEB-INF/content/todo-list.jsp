<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<ul class="nav nav-list todo-list">
	        <s:iterator value="items">
		        <li id="todoItem${id}">
                    <s:if test="done">
                        <s:set var="todoClass">todo-done</s:set>
                    </s:if>
                    <s:else>
                        <s:set var="todoClass"></s:set>
                    </s:else>
                    <span id="todoTopic${id}" class="${todoClass}"><s:property value="topic"/></span>

 			        <s:if test="description != null">
				        <span id="todoTopicDescription${id}" class="todo-description">
					        <i class="icon-info-sign"></i>
				            <span id="todoTopicDescriptionContent${id}" class="todo-description-content">
						       <s:property value="description" escapeHtml="false" />
				            </span>
				        </span>
			        </s:if>

			        <s:if test="category != null">
				        <s:url var="listurl" action="todo-list" namespace="/">
					        <s:param name="category" value="category" />
						</s:url>
					    <span id="todoTopicCategory${id}" class="todo-category badge badge-info">
				            <sj:a id="todoTopicCategory%{id}Link" href="%{listurl}" targets="todoListContent" cssClass="todo-category-link">
				                <i class="icon-tag"></i> <s:property value="category" />
				            </sj:a>
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
                        <s:url var="listurl" action="todo-list" namespace="/">
                            <s:param name="dueDate"><s:date name="dueDate" format="dd.MM.yyyy"/></s:param>
                        </s:url>
                        <span id="todoTopicDate${id}" class="todo-due-date pull-right"><sub><sj:a id="todoTopicDate%{id}Link" href="%{listurl}" targets="todoListContent"><s:date name="dueDate" format="dd.MM.yyyy"/></sj:a></sub></span>
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