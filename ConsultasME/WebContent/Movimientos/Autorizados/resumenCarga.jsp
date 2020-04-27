<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
<head>
    <netui:base />
    <title>Carga Autorizados - Moneda Extranjera</title>
    <link rel="StyleSheet" href="<%=request.getContextPath()%>/resources/css/teso.css" type="text/css" media="all">
    <script type="text/JavaScript" src="<%=request.getContextPath()%>/resources/js/functions.js" language="JavaScript"></script>    
<%

String msje = (String) request.getAttribute("msje");

%>

</head>
    <body>
        <p class="titulo">APLICACIÓN MONEDA EXTRANJERA</p>
        <br/>
        <p class="subtitulo">Carga Autorizados</P>
        <br/>
        <div align="center">

        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td align="center" class="cellError"><%=msje%></td>
            </tr>
        </table>            
        <p>&nbsp;</p>
        <p align="center">
            <!--netui:button styleClass="botones" type="button" value="Volver" onClick="parent.location='Controller.jpf'" /-->
            <netui:button styleClass="botones" type="button" value="Volver" onClick="javascript:history.back()" />
        </p>
        <p>&nbsp;</p>   
    </body>
</netui:html>
