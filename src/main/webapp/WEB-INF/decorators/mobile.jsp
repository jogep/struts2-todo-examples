<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><decorator:title default="TODOs Mobile"/></title>
	<sjm:head jqueryui="false" compressed="true"/>
	<link rel="stylesheet" href='<s:url namespace="/css" action="todo.css"/>' type="text/css"/>
	<decorator:head/>
</head>
<body>
<sjm:div role="page" id="start">
	<sjm:div role="header">
		<h1><decorator:title default="TODOs Mobile"/></h1>
	</sjm:div>

	<sjm:div role="content">
		<decorator:body/>
	</sjm:div>

	<sjm:div role="footer">
		<s:url namespace="/" action="todo" var="homeUrl">
			<s:param name="request_locale" value="'de'"/>
		</s:url>
		<sjm:a href="%{homeUrl}" button="true" buttonIcon="home" rel="external">Web View</sjm:a>
		Strutters we are...
		<sjm:a hreff="http://strutters.eu" button="true" buttonIcon="star" rel="external"> Rene Gielen </sjm:a>
		and
		<sjm:a href="http://www.jgeppert.com" button="true" buttonIcon="star" rel="external"> Johannes Geppert </sjm:a>
	</sjm:div>
</sjm:div>
</body>
</html>
			