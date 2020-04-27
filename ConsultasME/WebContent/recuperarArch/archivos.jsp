<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="javax.sql.RowSet"%>
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

    <%
        boolean isData = false;
        RowSet rs = null;
        String msg = null;
        String rowStyle = "2";
        
        try {
            msg = (String) request.getAttribute("msje");
            if (msg==null) {
                msg = "";
                rs = (RowSet) request.getAttribute("RESULT");
                isData = rs.first();
                if (!isData) {
                    msg = "No hay registros";
                }   
            }        
        }
        catch (Exception e) {
            msg = "Ha ocurrido el siguiente error: " + e.getMessage();
        }
    %>
           
    <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">RECUPERAR ARCHIVOS</P>
        <br/>    
        <br/>
        
    <%  if(isData){     %>

        <form method="post" id="formulario" action="<%=request.getContextPath()%>/recuperarArch/goContenido.do">

            <table width="60%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
                <tr>
                    <td width="5%" class="cellBGColor1">
                    <td class="cellBGColor1"><b>Nombre Archivo</b></td>
                    <td class="cellBGColor1"><b>Fecha</b></td>
                </tr>
        <%
            for (int i=0; isData; i++) {
        %>

                <tr>
                    <td width="5%" class="cellBGColor<%=rowStyle%>">
                        <% if (i==0) { %>
                        <input type="radio" checked name="id" value="<%=rs.getString("ID_SII_ARCH_GENERADOS")%>">
                        <%}else{%>
                        <input type="radio" name="id" value="<%=rs.getString("ID_SII_ARCH_GENERADOS")%>">
                        <%}%>
                    </td>
                    <td align="left" class="cellBGColor<%=rowStyle%>">
                        <%=rs.getString("NOMBRE_ARCH")%>
                        
                    </td>
                    <td align="left" class="cellBGColor<%=rowStyle%>">
                        <%=rs.getString("FECHA")%>
                    </td>
                </tr>   
    
        <%  
                rowStyle = rowStyle.equals("2") ? "1" : "2";
                isData = rs.next();
            }
        %>
            </table>            
        <table width="60%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr class="cellBGColor1">
                <td align="center" colspan="4">
                    <input value="Capturar" type="submit" class="botones"/>
                    <input class="botones" type="button" value="Volver" onClick="javascript:history.back()" />
                </td>
            </tr>
        </table>
    </form>

    <%  }else{  %>

        <blockquote>
            <%=msg%>
        </blockquote>
        
        <br>
        <br>
        
        <center>
            <input class="botones" type="button" value="Volver" onClick="javascript:history.back()" />
        </center>
    <%}%>


        <div align="center">
            
        </div>
    </body>
</netui:html>

