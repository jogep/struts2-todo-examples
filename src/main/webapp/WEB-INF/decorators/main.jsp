<?xml version="1.0" ?>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<s:set var="renderDoc" scope="request" value="#parameters['nodoc']==null" />
<s:set var="decorate" scope="request" value="(#parameters['nodec']==null)&&(#parameters['nodoc']==null)" />
<s:if test="#attr['renderDoc']">
<html>
<head>
    <title>
        <decorator:title default="Home"/> - Struts 2 TODO Example
    </title>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sj:head jqueryui="true" locale="de" loadAtOnce="true" defaultIndicator="indicator"/>
	<sb:head includeStylesResponsive="true"/>
    <link rel="stylesheet" href='<s:url namespace="/css" action="todo.css"/>' type="text/css"/>
	<script src="<s:url value="/js/todo.js" />"></script>
	<decorator:head/>
</head>
<body>
</s:if>
<s:if test="#attr['decorate']">
<div class="navbar navbar-fixed-top">
    <s:url namespace="/" action="index" var="homeUrl">
        <s:param name="request_locale" value="'de'"/>
    </s:url>
    <div class="navbar-inner">
        <div class="container">
            <a class="brand pull-right" href="${homeUrl}">Struts 2 TODO Example</a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">What's up <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="nav-header">View</li>
                            <li><a href="<s:url namespace="/foo/bar" action="list"/>">My TODOs</a></li>
                            <li class="divider"></li>
                            <li class="nav-header">Manage</li>
                            <li><a href="<s:url namespace="/foo/bar" action="create"/>">New TODO ...</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
	        <div class="pull-right" style="margin-top: 10px">
		        <img id="indicator" src="<s:url value="/img/indicator.gif" />" style="display: none;"/>
	        </div>

            <!-- /.nav-collapse -->
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row-fluid">
        <div id="content" class="span12 page-header">
            <h1><decorator:title default="What's Up?"/></h1>
</s:if>

				<decorator:body/>

<s:if test="#attr['decorate']">
		</div>
    </div>

    <footer class="footer">
        <p class="pull-right"><a href="http://strutters.eu">Strutters we are...</a></p>
    </footer>
</div>
<!-- /container -->

</s:if>
<s:if test="#attr['renderDoc']">
</body>
</html>
</s:if>
