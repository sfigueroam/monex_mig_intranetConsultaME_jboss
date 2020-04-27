<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
    <head>
        <title>APLICACIÓN MONEDA EXTRANJERA</title>
        <link rel="StyleSheet" href="../resources/css/teso.css" type="text/css" media="all">
    </head>

<%
    String msje = (String) request.getAttribute("msje");
%>    
    
    <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">CONSULTA ENVÍOS</P>
        <br/>
        <div align="center">

<%
    if (msje != null) 
    {
%>
        <p class="error"><%=msje%></p>
        <br>
<%
    }
%>
        
            <netui:form action="goEnvios">
                <table class="formGrid" width="90%">
                    <tr valign="top">
                        <td class="grillaIdentificador" width="150" valign="middle">FECHA RECEPCIÓN DESDE</td>
                        <td class="grillaDosPuntos" width="10" valign="middle">:</td>
                        <td class="cellBGColor1">
                        <netui:textBox dataSource="actionForm.diaDesde" maxlength="2" size="2"/>
                        /
                        <netui:textBox dataSource="actionForm.mesDesde" maxlength="2" size="2"/>
                        /
                        <netui:textBox dataSource="actionForm.agnoDesde" maxlength="4" size="2"/>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td class="grillaIdentificador" valign="middle">FECHA RECEPCIÓN HASTA</td>
                        <td class="grillaDosPuntos" width="10" valign="middle">:</td>
                        <td class="cellBGColor1">
                        <netui:textBox dataSource="actionForm.diaHasta" maxlength="2" size="2"/>
                        /
                        <netui:textBox dataSource="actionForm.mesHasta" maxlength="2" size="2"/>
                        /
                        <netui:textBox dataSource="actionForm.agnoHasta" maxlength="4" size="2"/>
                        </td>
                    </tr>
                </table>
                <table class="formGrid" width="90%">
                 <tr>
                  <td align="center"><netui:button value="Buscar" type="submit" styleClass="botones"/></td>
                  <td align="center"><netui:button value="Limpiar" type="reset" styleClass="botones"/></td>
                 </tr>
                </table>
            </netui:form>
        </div>

    </body>
</netui:html>
