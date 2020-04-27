<%@ page import="java.io.*, java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="Main.Controller"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%
//String url=LoginController.readPropertiesFile("urlPortal");
%>
<%
//TODO ESTA LINEA SE COMENTO EL CODIGO SE DEBE VERIFICAR 01/08/2019 ccastrov@redhat.com
// weblogic.servlet.security.ServletAuthentication.logout(request);
%>
<%--<jsp:forward page="<%=url%>" />--%>
<netui:html>
    <head>
    <script language="JavaScript">
    function close_window() {
        //if (confirm("cerrar ventana ?")) {
                  window.close();
        //}
      }
    </script>
        <title>Moneda Extranjera</title>
        <link href="<%=request.getContextPath()%>/resources/css/estilos.css" type="text/css" rel="stylesheet"/>
    </head>
<body onload="close_window()">
<p class="titulo">SISTEMA MONEDA EXTRANJERA</p>
    <br/>
    <p class="subtitulo">Ud. ha salido del Sistema</P>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<table width="100%" border="0">
  <tr>
    <td>
    <div align="center" class="subtitulo resalta-texto"><netui:span value="${requestScope.errorMessage}" defaultValue="" /></div>
    </td>
  </tr>
</table>
<p>&nbsp;</p>
<script>
window.close();
</script>
    </body>
</netui:html>