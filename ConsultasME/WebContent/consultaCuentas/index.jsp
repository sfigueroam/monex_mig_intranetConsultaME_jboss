<%@ page import="java.io.*, java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.math.BigDecimal"%>
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
    ArrayList formularios = (ArrayList) request.getAttribute("formularios");
%>
    
    <body onload="fechaActual()">
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">CONSULTA FORMULARIOS</P>
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
        
        <form action="goCuentas.do" method="post">
            <table class="formGrid" width="90%">
                <tr valign="middle" class="formColor1">
                    <td class="grillaIdentificador" width="145">RUT</td>
                    <td class="grillaDosPuntos" width="10">:</td>
                    <td>
                    <input type="text" name="rut" size="8" onblur="pone_dv(rut.value,1);" />-<input type="text" name="dv" maxlength="1" size="1"/>
                    </td>
                </tr>
                <tr valign="middle" class="formColor1">
                    <td class="grillaIdentificador">FORMULARIO</td>
                    <td class="grillaDosPuntos">:</td>
                    <td>
                        <select name="formulario">
                                <option value="">Todos los formularios</option>
                                <% boolean f76 =  true;
                                   for (int i=0; i<formularios.size(); i++) {
                                     String f = (String) formularios.get(i);
                                     
                                     
                                     if (Integer.parseInt(f) == 76)
                                        f76 = false;
                                     
                                     if (Integer.parseInt(f) <= 99) {
                                %>
                                        <option value="<%=f%>">Formulario <%=f%></option>
                                
                                <%     
                                     } 
                                    } 
                                %>
                                  <!--  if (f76) {*/
                                       %>
                                        <option value="76">Formulario 76</option>
                                        < %
                                    }
                                % -->
                                
                                <!--option value="10">Formulario 10</option>
                                <option value="21">Formulario 21</option>
                                <option value="22">Formulario 22</option>
                                <option value="29">Formulario 29</option>
                                <option value="45">Formulario 45</option>
                                <option value="50">Formulario 50</option>
                                <option value="74">Formulario 74</option>
                                <option value="76">Formulario 76</option -->
                        </select>
                    </td>
                </tr>
                <tr valign="middle" class="formColor1">
                    <td class="grillaIdentificador">FOLIO</td>
                    <td class="grillaDosPuntos">:</td>
                    <td>
                    <input type="text" name="folio"/>
                    </td>
                </tr>
                <tr valign="middle" class="formColor1">
                    <td class="grillaIdentificador">FECHA VENCIMIENTO</td>
                    <td class="grillaDosPuntos">:</td>
                    <td>
                    <input type="text" name="diaVenc" maxlength="2" size="2"/> /
                    <input type="text" name="mesVenc" maxlength="2" size="2"/> /
                    <input type="text" name="agnoVenc" maxlength="4" size="2"/>
                    </td>
                </tr>
                <tr valign="middle" class="formColor1">
                    <td class="grillaIdentificador">FECHA RECEPCIÓN DESDE</td>
                    <td class="grillaDosPuntos">:</td>
                    <td>
                    <input type="text" name="diaDesde" id="diaDesde" maxlength="2" size="2"/> /
                    <input type="text" name="mesDesde" id="mesDesde" maxlength="2" size="2"/> /
                    <input type="text" name="anoDesde" id="anoDesde" maxlength="4" size="2"/>
                    </td>
                </tr>   
                <tr valign="middle" class="formColor1">
                    <td class="grillaIdentificador">FECHA RECEPCIÓN HASTA</td>
                    <td class="grillaDosPuntos">:</td>
                    <td>
                    <input type="text" name="diaHasta" id="diaHasta" maxlength="2" size="2"/> /
                    <input type="text" name="mesHasta" id="mesHasta" maxlength="2" size="2"/> /
                    <input type="text" name="anoHasta" id="anoHasta" maxlength="4" size="2"/>
                    </td>
                </tr>              
            </table>
            <table class="formGrid" width="90%">
                <tr>
                 <td align="center"><input value="Buscar" type="submit" class="botones"/></td>
                 <td align="center"><input value="Limpiar" type="reset" class="botones"/></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</netui:html>