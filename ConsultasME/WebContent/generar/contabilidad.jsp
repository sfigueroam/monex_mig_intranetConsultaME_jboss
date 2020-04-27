<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
    <head>

        <title>APLICACIÓN MONEDA EXTRANJERA</title>
        <link rel="StyleSheet" href="../resources/css/teso.css" type="text/css" media="all">
    </head>
    <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">GENERAR ARCHIVO PARA CONTABILIDAD</P>
        <br/>
        <div align="center">
        <%
            String msje = (String) request.getAttribute("msje");  
            if (msje==null) { msje=""; }
              
        %>
        
        <p class="error"><font color="#FF0000"><%=msje%></font></p>
        <br>
        <form action="goConta.do" id="goContaForm"  name="goContaForm">
        
            <table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
                <tr>
                    <td class="grillaIdentificador" width="135">PERIODO [AAAAMM]</tD>
                    <td class="grillaDosPuntos" width="10">:</td>
                    <td  class="grillaIdentificador"> 
                        <input name="fecha" type="text" size="10" maxlength="6">                                          
                    </td>
                </tr>
            </table>
            <br/>
            <input type="hidden" name="tipo" value="L">
            <input value="Recuperar" type="button" Class="botones" onclick="document.forms[0].action='../recuperarArch/goCuadratura.do'; document.forms[0].submit();"/>
            <input value="Generar" type="submit" Class="botones"/>
            <input value="Limpiar" type="reset" Class="botones"/>
        </form>
        </div>
    </body>
</netui:html>
