<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
    <head>
        <title>
            APLICACIÓN MONEDA EXTRANJERA
        </title>
    <link rel="StyleSheet" href="<%=request.getContextPath()%>/resources/css/teso.css" type="text/css" media="all">
  </head>
  <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <BR/>  
        <BR/>
        <BR/>  
        <BR/>
    <blockquote>
<% 
    if (request.getAttribute("msje") != null) 
    { 
%>
      <%=request.getAttribute("msje")%>
      <br>
      Comunicarse con el Administrador de Sistemas. 
<%  
    } else {
%>
      Comunicarse con el Administrador del Sistema. 
<%
    }
%>
      <BR/>
      <netui:span value="${requestScope.errorMessage}" defaultValue="" />
      <br/>
      <netui:exceptions showMessage="true" />
      <br/>
    </blockquote>
    <p align="center">
        <input  class="botones" type="button" value="Volver" onClick="javascript:history.back()" />
    </p> 
  </body>
</netui:html>