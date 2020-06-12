<%@ page import="java.io.*, java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="cl.tesoreria.monex.vo.MovMonexVO"%>
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
    //boolean isData = false;
    //RowSet rs = null;
    String msg = (String) request.getAttribute("msje");
    ArrayList lista = (ArrayList) request.getAttribute("lista");
        
    /**
     * Si no hay errores en la consulta
     * se asigna el resultado de la consulta
     * al puntero rs
     */
    /*
    try {
        msg = (String) request.getAttribute("ERRMSG");
        if (msg==null) {
            msg = "";
            rs = (RowSet) request.getAttribute("RES");
            isData = rs.first();
            if (!isData) {
                msg = "No se registran datos para la consulta";
            }
        }            
    }
    catch (Exception e) {
        msg = "Ha ocurrido un error en la aplicación, por favor vuelva a intentarlo";
    }
    */
        
    %>
    <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">MOVIMIENTOS DE FORMULARIO</P>
        <br/>
<% 
    if(msg == null)
    { 
%>
        <netui:form action="goItem">
            <div align="center">
                <table width="95%" border="1" cellpadding="1" cellspacing="0">
                    <tr class="grillaDosPuntos">
                        <td>&nbsp;</td>
                        <td>Tipo de Movto.</td>
                        <td>Fecha[315]</td>
                        <td>Signo Mov.</td>
                        <td>Cod.87</td>
                        <td>Cod.91</td>
                        <td>Cod.92</td>
                        <td>Cod.93</td>
                        <td>Cod.94</td>
                        <td>Cambio S.I.I. (8866)</td>
                    </tr>
<%  
    
    for(int i = 0; i < lista.size(); i++) 
    {
        MovMonexVO vo = (MovMonexVO) lista.get(i);
        
%>
                    <tr align="center">
                        <td>
                            <%  if (i==0) { %>
                            <input type="radio" name=item value="<%=vo.getId()%>" checked>
                            <% }else{%>
                            <input type="radio" name=item value="<%=vo.getId()%>">
                            <%  } %>
                        </td>
                        <td><%=vo.getTipoMov()%></td>                
                        <td><%=vo.getCod315()%></td>
                        <td>&nbsp;<%=vo.getSignoMov()%>&nbsp;</td>
                        <td><%=vo.getCod87()%></td>                         
                        <td><%=vo.getCod91()%></td>
                        <td><%=vo.getCod92()%></td>
                        <td><%=vo.getCod93()%></td>
                        <td><%=vo.getCod94()%></td>
                        <td><%=vo.getCod8866()%></tr>
<%
    } 
%>
                </table>
                <br/>
                <netui:button value="ITEM" type="submit" styleClass="botones"/>
                <input class="botones" type="button" value="Volver" onClick="javascript:history.back()" />
            </div>
        </netui:form>
<%  
    } 
    else 
    {   
%>
        <blockquote>
        <p><%=msg%></p>
        </blockquote>
        
       
<% 
    } 
%>

    </body>
</netui:html>
