<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.sql.RowSet"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
    <head>

        <title>APLICACIÓN MONEDA EXTRANJERA</title>
        <link rel="StyleSheet" href="<%=request.getContextPath()%>/resources/css/teso.css" type="text/css" media="all">
        <script type="text/JavaScript" src="<%=request.getContextPath()%>/resources/js/functions.js" language="JavaScript"></script>
    </head> 

<%
    String msje = (String) request.getAttribute("msje");
%>  
    
    <body>
   
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">CONSULTA AUTORIZADOS</P>
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

        <form id="autorizadosForm" action="goAutorizados.do" method="post">
        
            <table class="formGrid" width="90%">
                <tr>
                    <td class="grillaIdentificador" width="135">FORMULARIO</tD>
                    <td class="grillaDosPuntos" width="10">:</td>
                    <td  class="grillaIdentificador"> 
                        <select name="form">
                                <option value="">Todos los formularios</option>
                                <option value="22">Formulario 22</option>
                                <option value="29">Formulario 29</option>
                                <option value="50">Formulario 50</option>
                        </select>                                        
                    </td>
                </tr>
                <tr>
                    <td class="grillaIdentificador" width="135">RUT CONTRIBUYENTE</tD>
                    <td class="grillaDosPuntos" width="10">:</td>
                    <td  class="grillaIdentificador"> 
                        <input name="rut" type="text" size="8" maxlength="8" onblur="pone_dv(rut.value,2);" > -
                        <input name="dv" type="text" size="1" maxlength="0">
                    </td>
                </tr>                
            </table>
            <table class="formGrid" width="90%">
                <tr>
                 <td align="center"><input value="Buscar" type="submit" Class="botones"/></td>
                 <td align="center"><input value="Limpiar" type="reset" Class="botones"/></td>
                </tr>
            </table>
        </form>
        </div>

    </body>
</netui:html>

