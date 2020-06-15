<%@ page import="java.io.*, java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="cl.tesoreria.monex.vo.FormsMonexVO"%>
<%@ page import="javax.sql.RowSet"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
    <head>
        <title>
            APLICACIÓN DE MONEDA EXTRANJERA
        </title>
        <link rel="StyleSheet" href="../resources/css/teso.css" type="text/css" media="all">

    <script type="text/javascript">
    	function volver(action){
    		document.location.href=action;
    	}
    
    </script>
            
    </head>
<%
    //boolean isData = false;
    //RowSet rs = null;
    ArrayList lista = new ArrayList();
    lista = (ArrayList) request.getAttribute("lista");
    String msg = (String) request.getAttribute("msje");
    
    String rut = (String) request.getAttribute("RUT_AUX");
    String dv = (String) request.getAttribute("DV_AUX");
    String form = (String) request.getAttribute("FORM_AUX");
    String folio = (String) request.getAttribute("FOLIO_AUX");
    String venc = (String) request.getAttribute("VENC_AUX");
    String desde = (String) request.getAttribute("DESDE_AUX");
    String hasta = (String) request.getAttribute("HASTA_AUX");
        
    /**
     * Si no hay errores en la consulta
     * se asigna el resultado de la consulta
     * al puntero rs
     */
    /*
    try 
    {
        msg = (String) request.getAttribute("msje");
        if (msg == null) 
        {
            msg = "";
            //lista = (ArrayList) request.getAttribute("lista");

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
    */
        
%>
    <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">CONSULTA FORMULARIOS</P>
        <br/>
<%
    if(msg == null)
    {
%>
        <div align="center">
            <netui:form action="goMovimiento">
                <table width="90%"  border="1" cellpadding="1" cellspacing="0">
                    <tr class="grillaDosPuntos">
                        <td>&nbsp;</td>
                        <td>N°</td>
                        <td>Rut</td>
                        <td>Formulario</td>
                        <td>Folio</td>
                        <td>Fecha de recepción</td>
                        <td>Vencimiento</td>
                        <td>Saldo</td>
                        <td>Moneda</td>
                    </tr>
<%
    int indice = 0;
    for (int i = 0; i < lista.size(); i++)
    {
        //while (isData){ 
        indice=i+1;
        FormsMonexVO vo = (FormsMonexVO) lista.get(i);
%>
                    <tr align="center">
                        <% if (indice == 1) { %>
                        <td><input type="radio" name=item value="<%=vo.getId()%>" checked></td>
                        <% } else {%>
                        <td><input type="radio" name=item value="<%=vo.getId()%>"></td>
                        <% }%>
                        <td><%=indice%></td>
                        <td align="right"><%=vo.getRut()%></td>
                        <td><%=vo.getFormulario()%></td>
                        <td><%=vo.getFolio()%></td>
                        <td><%=vo.getFechaRecepcion()%></td>
                        <td><%=vo.getVencimiento()%></td>
                        <td><%=vo.getSaldo()%></td>
                        <td><%=vo.getMoneda()%></td>
                    </tr>
<%
    }
%>
                </table>
                <br/>
                <table width="90%"  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="50%" align="center" valign="baseline"> <netui:button value="Detalle" type="submit" styleClass="botones"/></td>
                        
                        
                        <td width="50%" align="center" valign="baseline"> <input class="botones" type="button" value="Volver" onClick="volver('/ConsultasME/consultaCuentas/envios.jsp')" /></td>
                        
                        
                        
                    </tr>
                </table>
                </netui:form>  
                <table width="90%"  border="0" cellpadding="0" cellspacing="0">
                    <tr>                      
                        <td width="100%" align="center" valign="baseline">
                            <form name="formExp" method="post" action="goExportar.do">
                                <input type="hidden" name="rut" value="<%=rut%>">
                                <input type="hidden" name="dv" value="<%=dv%>">
                                <input type="hidden" name="formulario" value="<%=form%>">
                                <input type="hidden" name="folio" value="<%=folio%>">
                                <input type="hidden" name="vencimiento" value="<%=venc%>">
                                <input type="hidden" name="desde" value="<%=desde%>">
                                <input type="hidden" name="hasta" value="<%=hasta%>">
                            
                                <input type="submit" value="Exportar" class="botones" >                
                            </form>
                        </td>
                    </tr>
                </table>        
        </div>
       
       
        <%  } else {   %> 
        <blockquote>
            <p><%=msg%></p>
        </blockquote>
        <% } %>
        <p>&nbsp;</p>
    </body>
</netui:html>
