<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0"	prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0"	prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0"	prefix="netui-template"%>

<netui:html>
<head>
<netui:base />
<title>Consultas Moneda Extranjera</title>
<link href="<%=request.getContextPath()%>/resources/css/teso.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div align="center">
		<netui:image align="center"
						src='<%= request.getContextPath() + "/resources/images/logo_teso2.png" %>'
						height="47" width="200" />
	</div>
	<table style="border: 0">
		<tr>
			<td>
				<netui:tree dataSource="pageFlow.simpleTree" selectionAction="treeState" tagId="tree"/>
			</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;<netui:anchor action="doLogout" target="_top">Salir</netui:anchor></td>
		</tr>
	</table>
</body>
</netui:html>
