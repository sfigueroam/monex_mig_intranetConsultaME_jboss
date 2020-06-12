<%@ page import="java.io.*, java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="cl.tesoreria.monex.vo.ItemsMonexVO"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
    ArrayList lista = (ArrayList) request.getAttribute("lista");
    String msg = (String) request.getAttribute("msje");  
    String whereBack = (String) request.getSession().getAttribute("whereBack");
    
    System.out.println("whereBack JSP: "+whereBack);
%>  
    <body>
        <p class="titulo"> SISTEMA MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">CONSULTA ITEM</P>
        <br/>
<%
    if ( msg==null )
    {
%>
            <div align="center">
                <table width="90%" border="1" cellpadding="1" cellspacing="0">
                    <tr class="grillaDosPuntos">
                        <td>CÓDIGO</td>
                        <td>SIGNO</td>
                        <td>VALOR</td>
                    </tr>
<%
        for ( int i=0; i < lista.size(); i++ ) 
        { 
            ItemsMonexVO vo = (ItemsMonexVO) lista.get(i);
        
%>
                    <tr align="center">              
                        <td><%=vo.getCodigo()%></td>
                        <td><%=vo.getSigno()%></td>
                        <td><%=vo.getValor()%></td>
                    </tr>
<%
        }
%>
                </table>
                <br/>
                
<%
System.out.println("whereBack JSP1: "+whereBack);
    if ( "goMovimiento".equals(whereBack) )
    {
%>                
                <input class="botones" type="button" value="Aceptar" onClick="volver('goMovimiento.do')" />
<%
    }
%>

<%
System.out.println("whereBack JSP1: "+whereBack);
    if ( "goRectificados".equals(whereBack) )
    {
%>                
                <input class="botones" type="button" value="Aceptar" onClick="javascript:history.back()" />
<%
    }
%>

                
            </div>
<%
    } else {
%>
        <blockquote>
            <p><%=msg%></p>
        </blockquote>
<% 
    }
%>
        
        <p>&nbsp;</p>

    </body>
</netui:html>
