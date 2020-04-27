<%@ page language="java" contentType="text/html;charset=UTF-8"%>
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
    String rut = (String) request.getAttribute("RUT");
    String dv = (String) request.getAttribute("DV");
    String diaDesde = (String) request.getAttribute("diaDesde");
    String anoDesde = (String) request.getAttribute("anoDesde");
    String mesDesde = (String) request.getAttribute("mesDesde");
    String anoHasta = (String) request.getAttribute("anoHasta");
    String mesHasta = (String) request.getAttribute("mesHasta");
    String diaHasta = (String) request.getAttribute("diaHasta");    

    String fechaDesde = diaDesde+mesDesde+anoDesde;
    
    if (diaDesde == null) diaDesde="";
    if (anoDesde == null) anoDesde="";
    if (mesDesde == null) mesDesde="";
    if (anoHasta == null) anoHasta="";
    if (mesHasta == null) mesHasta="";
    if (diaHasta == null) diaHasta="";
    if (rut == null) rut="";
    if (dv == null) dv="";
    

    
%>    
    
    <body <% if (fechaDesde.equals("nullnullnull")) {%> onload="fechaActual()" <% } %>>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">CASOS RECTIFICADOS</P>
        <br/>
        <div align="center">
    <%if (msje != null) {%>
        <p class="error"><%=msje%></p>
        <br>
    <%}%>
        
        
        
        
            <form action="goRectificados.do" name="rectificadosForm" method="post">
                <table class="formGrid" width="90%">
                    <tr valign="top">
                        <td class="grillaIdentificador" width="150" valign="middle">RUT</td>
                        <td class="grillaDosPuntos" width="10" valign="middle">:</td>
                        <td class="cellBGColor1"><input type="text" name="rut" size="8" onblur="pone_dv(rut.value,1);" value="<%=rut%>" />-<input type="text" name="dv" maxlength="1" size="1" value="<%=dv%>"/></td>
                    </tr>                
                    <tr valign="top">
                        <td class="grillaIdentificador" width="150" valign="middle">FECHA RECEPCIÓN DESDE</td>
                        <td class="grillaDosPuntos" width="10" valign="middle">:</td>
                        <td class="cellBGColor1">
                        <input name="diaDesde" id="diaDesde" type="text" size="2" maxlength="2" value="<%=diaDesde%>">
                        /
                        <input name="mesDesde" id="mesDesde" type="text" size="2" maxlength="2" value="<%=mesDesde%>">
                        /
                        <input name="anoDesde"  id="anoDesde" type="text" size="2" maxlength="4" value="<%=anoDesde%>">
                        </td>
                    </tr>
                    <tr valign="top">
                        <td class="grillaIdentificador" valign="middle">FECHA RECEPCIÓN HASTA</td>
                        <td class="grillaDosPuntos" width="10" valign="middle">:</td>
                        <td class="cellBGColor1">
                        <input name="diaHasta" id="diaHasta" type="text" size="2" maxlength="2" value="<%=diaHasta%>">
                        /
                        <input name="mesHasta" id="mesHasta" type="text" size="2" maxlength="2" value="<%=mesHasta%>">
                        /
                        <input name="anoHasta" id="anoHasta" type="text" size="2" maxlength="4" value="<%=anoHasta%>">
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="item" value="0">
                <table class="formGrid" width="90%">
                  <tr>
                   <td align="center"><input value="Buscar" type="submit" class="botones"  /></td>
                   <td align="center"><input value="Limpiar" type="button" class="botones" onclick="limpiar()"/></td>
                  </tr>
                </table>
                
                
            </form>
        </div>

    </body>
</netui:html>
