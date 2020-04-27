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
        <form action="goCargarArchivo.do" method="post" name="form" id="form" enctype="multipart/form-data">
            <table border="0" align="center" width="40%" cellpadding="3" cellspacing="1" class="formGrid">
                <tr>
                    <td class="cellBGColor2"><b>Archivo:</b></td>
                    <td class="cellBGColor2">
                    <input type="file" size="50" id="archivo" name="archivo" accept="text/plain" onBlur="LimitAttach(this,7);" />
                    </td>
                </tr>
            </table>
            <br>

            <input value="Cargar" onClick="obligaArchivo(this.form)" type="button" class="formButton"/>
        
        </form>         
        </div>
    </body>
</netui:html>
