<%@ page import="java.io.*, java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="javax.sql.RowSet"%>
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


    <%
        boolean isData = false;
        RowSet rs = null;
        String msg = ""; 

        Locale local = new Locale("es", "CL");
        NumberFormat formatNum = NumberFormat.getInstance(local);        
        
        try {
            msg = (String) request.getAttribute("msje");
            if (msg==null) {
                msg = "";
                rs = (RowSet) request.getAttribute("RESULT");
                isData = rs.first();
                if (!isData) {
                    msg = "No se registran datos para la consulta";
                }
            }            
        }
        catch (Exception e) {
            msg = "Ha ocurrido un error en la aplicación, por favor vuelva a intentarlo";
        }
        
    %>  
    
    <body>
        <p class="titulo">SISTEMA MONEDA EXTRANJERA</p>
        <br/>
        <p class="subtitulo">DETALLE CONSULTA AUTORIZADOS</P>
        <br/>
        
    <% if(isData){
         
            String autDecl = null;
            String declarar = "";
            String pagar = "";
            String fecha;
            String dia;
            String mes;
            String ano;  
            int largo;   
    %>

        <table width="90%" border="1" cellpadding="1" cellspacing="0" align="center">    
            <tr class="grillaDosPuntos">
                <td>N°</td>
                <td>RUT</td>
                <td>Formulario</td>
                <td>Fecha Inicio Autorización</td>
                <td>Fecha Termino Autorización</td>
                <td>Moneda Autorizada</td>  
                <td>Autorizado a Declarar</td>
                <td>Autorizado a Pagar</td>              
            </tr>
    <%
        for (int i=1; isData; i++) {
    %>        
            <tr align="center">
                <td><%=i%></td>
                <td><%=formatNum.format(rs.getDouble("RUT"))%>-<%=rs.getString("DV")%></td>
                <td><%=rs.getString("NRO_FORM")%></td>
                <td>
                <%
                    fecha = rs.getString("FECH_INI");
                    largo = fecha.length();
                    if  (largo==8) {
                        dia = fecha.substring(6,8);
                        mes = fecha.substring(4,6);
                        ano = fecha.substring(0,4);
                        fecha = dia+'-'+mes+'-'+ano;
                    } else {
                        fecha = "&nbsp;";
                    }
                %>
                    <%=fecha%> 
                </td>
                <td>
                <%
                    fecha = rs.getString("FECH_TER");
                    largo = fecha.length();
                    if  (largo==8) {
                        dia = fecha.substring(6,8);
                        mes = fecha.substring(4,6);
                        ano = fecha.substring(0,4);
                        fecha = dia+'-'+mes+'-'+ano;
                    } else {
                        fecha = "&nbsp;";
                    }
                %>
                    <%=fecha%> 
                </td>
                <td><%=rs.getString("ID_MON")%></td>  
                <%
                    autDecl = rs.getString("TIP_MOV");
                    if (autDecl.equals("DPS")) {
                        declarar="SI";
                        pagar="SI";
                    }
                    if (autDecl.equals("SP")) {
                        declarar="NO";
                        pagar="SI";
                    }
                %>
                <td><%=declarar%></td>
                <td><%=pagar%></td>              
            </tr>

    <%
            declarar="";
            pagar="";    
            isData = rs.next();
        }
    %>    
    
        </table> 

    <%  } else {   %> 
        <blockquote>
            <p><%=msg%></p>
        </blockquote>
    <% } %>
        
        <p>&nbsp;</p>  
        <p align="center"><input class="botones" type="button" value="Volver" onClick="javascript:history.back()" /></p>
        <p>&nbsp;</p>               
        
    </body>
</netui:html>
