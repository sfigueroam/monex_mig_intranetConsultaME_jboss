<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
    <head>
        <title>
            APLICACIÓN MONEDA EXTRANJERA
        </title>
    <link rel="StyleSheet" href="../resources/css/teso.css" type="text/css" media="all">
  </head>
  <%String msje = (String) request.getAttribute("msje");%>
  <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <BR/>
        <p class="subtitulo">CONSULTA FORMULARIOS</p>    
        <BR/>
    <blockquote>
      <p><%=msje%></p>
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