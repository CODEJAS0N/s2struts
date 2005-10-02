<%@ page contentType="text/html;charset=Windows-31j" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html:html locale="true">
<head>
<title><bean:message key="mod.title"/></title>
<html:base/>
</head>
<body bgcolor="white">

<html:errors/>

<html:form action="/mod" focus="arg1">
<html:text property="arg1"/> %
<html:text property="arg2"/>
<html:submit><bean:message key="calc"/></html:submit>
</html:form>
</body>
</html:html>
