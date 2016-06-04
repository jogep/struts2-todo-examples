<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%
    String xReq = request.getHeader("X-Requested-With");
    if(xReq == null) {
        request.setAttribute("decorate", "true");
    }
%>
<s:if test="#attr['decorate']">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <title>
        <decorator:title default="Home"/> - Struts 2 TODO Example
    </title>
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sj:head jqueryui="true" locale="de" loadAtOnce="true" defaultIndicator="indicator"/>
    <sb:head />
    <link rel="stylesheet" href='<s:url namespace="/css" action="todo.css"/>' type="text/css"/>
	<script src="<s:url value="/js/todo.js" />"></script>
	<decorator:head/>
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <s:url namespace="/" action="todo" var="homeUrl">
                    <s:param name="request_locale" value="'de'"/>
                </s:url>
                <a class="navbar-brand" href="${homeUrl}">Struts 2 TODO Example</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">What's up <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">View</li>
                            <li><a href="<s:url namespace="/" action="todo"/>">My TODOs</a></li>
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header">Manage</li>
                            <s:url var="newtodourl" namespace="/" action="todo-edit"/>
                            <li><sj:a id="newTodoLink" href="%{newtodourl}" openDialog="todoDialog" openDialogTitle="New TODO ...">New TODO ...</sj:a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <div class="pull-right" style="margin-top: 10px">
                        <img id="indicator" src="<s:url value="/img/indicator.gif" />" style="display: none;"/>
                    </div>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
</nav>
<div class="container">
    <div class="row">
        <div id="content" class="col-md-12 page-header">
            <h1><decorator:title default="What's Up?"/></h1>
</s:if>

				<decorator:body/>

<s:if test="#attr['decorate']">
		</div>
    </div>

    <footer class="footer">
	    <p class="pull-left"><a href="<s:url namespace="/mobile" action="todo-list"/>">Mobile View</a></p>
        <p class="pull-right"><a href="http://strutters.eu"> Rene Gielen </a></p>
        <p class="pull-right"> and </p>
        <p class="pull-right"><a href="http://www.jgeppert.com"> Johannes Geppert </a></p>
        <p class="pull-right"> Strutters we are... </p>
    </footer>
</div>
<!-- /container -->

</body>
</html>
</s:if>
