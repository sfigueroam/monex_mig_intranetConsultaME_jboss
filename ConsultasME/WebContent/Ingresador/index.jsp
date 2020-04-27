<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.math.BigDecimal"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
<%
    String rowStyle = "2";
    BigDecimal linea = new BigDecimal(1);
    session.setAttribute("currentLine", linea);
    BigDecimal nrows = (BigDecimal)session.getAttribute("nrows");
    BigDecimal currentPage = (BigDecimal)session.getAttribute("currentPage");
    BigDecimal pageSize = (BigDecimal)session.getAttribute("pageSize");
    BigDecimal sw_filter = (BigDecimal)session.getAttribute("sw_filter");
    
    //ArrayList forms = (ArrayList) request.getAttribute("FORMS");
    //ArrayList iras = (ArrayList) request.getAttribute("IRAS");
    String clienteEncontrado = (String) request.getAttribute("clienteEncontrado");
    String clienteValidado = (String) request.getAttribute("validarCliente");
    String respME = (String )request.getAttribute("respME");
%>

<head>
    <netui:base />
    <title>APLICACIÓN MONEDA EXTRANJERA</title>
    <link rel="StyleSheet" href="<%=request.getContextPath()%>/resources/css/teso.css" type="text/css" media="all">        
    <script type="text/JavaScript" src="<%=request.getContextPath()%>/resources/js/prototype.js" language="JavaScript"></script> 
    <script language="JavaScript">        
        function submitear (valor) 
        {
            document.getElementById('formId').action = valor;
            document.getElementById('formId').submit();
            document.getElementById('formId').btnEnviar.disabled = true;
            
        }
        
        function deshabilitar(btn) 
        {
            btn.disabled = "true";
        }
        
        function isNumberKey(evt)
        {
            var charCode = (evt.which) ? evt.which : event.keyCode
                    
            if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
            return true;
        }  
            
        function ajaxFunction(divNo,div)
        {
            $(div).style.display="block";
            $(divNo).style.display="none";
        }  

    </script>     
</head>

<body>
    <p class="titulo">APLICACIÓN MONEDA EXTRANJERA</p>
    <br/>
    <p class="subtitulo">Ingreso de Formularios</P>
    <br/>
    
    <netui:form action="IngresaItem" tagId="formId">
    
    <div align="center">
        
        

<% if (clienteValidado.equals("0")) {    %>
        <table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
          <tr class="formColor1">
                <td class="cellBGColor1"><b>Formulario:</b></td>
                <td class="cellBGColor1">
                <netui:select optionsDataSource="${actionForm.codformOptions}" tagId="CodForm"
                              dataSource="actionForm.codform" defaultValue="" tabindex="1" />
                        
                </td>  
                <td class="cellBGColor1">
                    <netui:radioButtonGroup dataSource="actionForm.signo">
                        <netui:radioButtonOption value="+" tabindex="2" onClick="ajaxFunction('divActivaLLaves','divdesactivaLLaves')">+</netui:radioButtonOption><br>
                        <netui:radioButtonOption value="-" tabindex="3" onClick="ajaxFunction('divdesactivaLLaves','divActivaLLaves')">-</netui:radioButtonOption><br>
                    </netui:radioButtonGroup>
                </td>
                <td class="cellBGColor1"><b>Institución:</b></td>
                <td class="cellBGColor1">
                <netui:select optionsDataSource="${actionForm.iraOptions}" tagId="IraForm"
                              dataSource="actionForm.ira" defaultValue="" tabindex="4" />
                </td> 
                <td class="cellBGColor1" ><b>RUT:</b></td>
                <td class="cellBGColor1">
                    <netui:textBox dataSource="actionForm.rut" maxlength="8" size="8" readonly= "false" onKeyPress="return isNumberKey(event)" tabindex="5"/>
                </td>
                <td class="cellBGColor1" align="center">
                    <b style="font-family:arial;font-size:12pt;">  -  </b>
                </td>
                <td class="cellBGColor1" align="center">
                    <netui:textBox dataSource="actionForm.dv" maxlength="1" size="1" readonly="false" tabindex="6"/>
                </td>             
            </tr>
        </table>

    <div id="divActivaLLaves" style="display:none;">
        <table border="0" align="center" width="50%" cellpadding="1" cellspacing="1" class="formGrid" >
            <tr class="formColor1" width="1">
                <td class="cellBGColor1" align="center"><b>Folio:</b></td>
                <td align="center">
                    <netui:textBox dataSource="actionForm.folio" size="15" readonly="false"  tabindex="7"/>
                </td>   
                <td class="cellBGColor1" align="center"><b>Fecha Vencimiento:</b></td>  
                <td align="center">
                    <netui:textBox dataSource="actionForm.fvenc" maxlength="10" size="10" readonly="false"  tabindex="8"/>
                </td>
            </tr>
        </table>
        <br>
        <netui:button value="Ingresar Negativa" styleClass="formButton" onClick="submitear('goLLaves.do');" tabindex="11"/> 
        <netui:button value="Limpiar" styleClass="formButton" onClick="submitear('NuevoFormulario.do');" tabindex="12"/>
        <br>
    </div>
    
<% } %>


<% if (clienteValidado.equals("1")) {    %>

        <table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
          <tr class="formColor1">
                <td class="cellBGColor1"><b>Formulario:</b></td>
                <td class="cellBGColor1">
                <netui:select optionsDataSource="${actionForm.codformOptions}" tagId="CodForm"
                              dataSource="actionForm.codform" defaultValue="" disabled="true" />
                        
                </td>  
                <td class="cellBGColor1">
                    <netui:radioButtonGroup dataSource="actionForm.signo" disabled="true">
                        <netui:radioButtonOption value="+">+</netui:radioButtonOption><br>
                        <netui:radioButtonOption value="-">-</netui:radioButtonOption><br>
                    </netui:radioButtonGroup>
                </td>
                <td class="cellBGColor1"><b>Institución:</b></td>
                <td class="cellBGColor1">
                <netui:select optionsDataSource="${actionForm.iraOptions}" tagId="IraForm"
                              dataSource="actionForm.ira" defaultValue=""  disabled="true" />
                </td> 
                <td class="cellBGColor1" ><b>RUT:</b></td>
                <td class="cellBGColor1">
                    <netui:textBox dataSource="actionForm.rut" maxlength="8" size="8" readonly= "true" onKeyPress="return isNumberKey(event)"/>
                </td>
                <td class="cellBGColor1" align="center">
                    <b style="font-family:arial;font-size:12pt;">  -  </b>
                </td>
                <td class="cellBGColor1" align="center">
                    <netui:textBox dataSource="actionForm.dv" maxlength="1" size="1" readonly="true"/>
                </td>             
            </tr>
        </table>

<% } %>

<% if (clienteEncontrado.equals("0") && clienteValidado.equals("0")) { %>
        
        <table border="0" align="center" width="90%" cellpadding="1" cellspacing="1" class="formGrid" >
            <tr>
                <td colspan="2"  width="30%" class="cellBGColor1" align="center"><b>Apellido Paterno / Razón Social</b></td>
                <td colspan="2"  width="30%"class="cellBGColor1" align="center"><b>Apellido Materno</b></td>
                <td colspan="2"  width="40%" class="cellBGColor1" align="center"><b>Nombres</b></td>
            </tr>
            <tr class="formColor1" width="1">
                <td colspan="2" align="center">
                    <netui:textBox dataSource="actionForm.paterno" size="40" readonly="false"  tabindex="7"/>
                </td>
                <td colspan="2" align="center">
                    <netui:textBox dataSource="actionForm.materno" maxlength="20" size="20" readonly="false"  tabindex="9"/>
                </td>       
                <td colspan="2" align="center">
                    <netui:textBox dataSource="actionForm.nombres" maxlength="50" size="30" readonly="false"  tabindex="9"/>
                </td>
            </tr>
        </table>
<% } %>
    


<% if (clienteValidado.equals("0"))  { %>
     <div id="divdesactivaLLaves">
        <br>
        <netui:button value="Ingresar" styleClass="formButton" onClick="submitear('IngresaRut.do');" tabindex="11"/> 
        <netui:button value="Limpiar" styleClass="formButton" onClick="submitear('NuevoFormulario.do');" tabindex="12"/>
        <br>
     </div>  
<% } %>
        
    <% if (request.getAttribute("msgerrIng") != null) { %>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td class="cellError"><%= request.getAttribute("msgerrIng")%></td>
            </tr>
        </table>
    <%  } %>

    <% if ( clienteValidado.equals("1") && !respME.equals("OK") ) {    %>

        <table border="0" align="center" width="50%" cellpadding="3" cellspacing="1" class="formGrid">
            <tr>
                <td class="cellBGColor2"><b>Código:</b></td>
                <td class="cellBGColor2">
                    <netui:textBox dataSource="actionForm.codigo" tagId="Codigo" tabindex="1" />
                </td>
                <td class="cellBGColor1"><b>Valor:</b></td>
                <td class="cellBGColor1">
                    <netui:textBox  dataSource="actionForm.valor" tagId="Valor" tabindex="2"  />
                </td>        
                  
    <%
        rowStyle = rowStyle.equals("2") ? "1" : "2";
        linea = linea.add(new BigDecimal(1));
        session.setAttribute("currentLine", linea);
    %>        

                <td colspan="13" >
                    <netui:button value="Ingresa Item" onClick="submitear('IngresaItem.do');" styleClass="formButton" tabindex="3" />
                </td>
            </tr>
        </table>
            
<%}%>


<%
    //String clienteValidado = (String) request.getAttribute("validarCliente");
    if (clienteValidado.equals("1"))
    {
%>
        <!--netui:form action="MuestraItem"-->
<%
    rowStyle = rowStyle.equals("2") ? "1" : "2";
    linea = linea.add(new BigDecimal(1));
    session.setAttribute("currentLine", linea);
%>
            
        <table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td class="cellBGColor1" align="center"><b>Seleccionar</b></td>
                <td class="cellBGColor1" align="center"><b>Código</b></td>
                <td class="cellBGColor1" align="center"><b>Descripción</b></td>
                <td class="cellBGColor1" align="center"><b>Valor</b></td>
            </tr>
            <netui-data:repeater dataSource="pageFlow.tuplas">
                <netui-data:repeaterItem>
                    <tr>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                        <netui:checkBox dataSource="container.item.selecc" tabindex="4"/>
                        </td>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                        <netui:label value="${container.item.codigo}"> </netui:label>
                        </td>
                        <td align="left" class="cellBGColor<%=rowStyle%>" nowrap>
                        <netui:label value="${container.item.descripcion}"> </netui:label>
                        </td>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap><netui:label value="${container.item.valor}"> </netui:label></td>
                   
                    </tr>

<%
    rowStyle = rowStyle.equals("2") ? "1" : "2";
    linea = linea.add(new BigDecimal(1));
    session.setAttribute("currentLine", linea);
%>
                </netui-data:repeaterItem>
            </netui-data:repeater>                
            <tr>
                <td align="center"> 
                <% if (!respME.equals("OK")) { %>
                    <netui:button value="Actualizar" styleClass="formButton" onClick="submitear('Actualizar.do');" tabindex="5" />
                <% } %>
                </td>
                <td align="right">&nbsp;</td>
                <td align="right">&nbsp;</td>
            </tr>
        </table>
        
        <table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td align="center">
                    <netui:button value="Nuevo Formulario" type="submit" onClick="submitear('NuevoFormulario.do');" styleClass="formButton" tabindex="7" />
                </td>
            <% if (!respME.equals("OK")) {%>
                <td align="center">
                    <!--netui:button value="Liquidar" type="submit" action="LiquidarFormulario" styleClass="formButton" /-->
                </td>
                <td align="center">
                    <netui:button value="Validar Formulario" onClick="submitear('ValidaADF.do');" styleClass="formButton" tabindex="6" />    
                </td>
            <% }%>
            </tr>
        </table>
<%    
    if ( respME.equals("OK") ) 
    {
%>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td align="center" class="cellError">Formulario enviado exitosamente.</td>
            </tr>
        </table>        
<%
    } else {
        if ( request.getAttribute("validarADF") == "1" && !respME.equals("OK") ) {
%>
        <table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
               <td align="center">
                <netui:button value="Enviar Formulario" onClick="submitear('EnviaForm.do');deshabilitar(this);" styleClass="formButton" tabindex="8" tagId="btnEnviar" />
               </td>
            </tr>
        </table>
<%
        }
    }
    if (!respME.equals("") && !respME.equals("OK") && !respME.equals("NOK")) 
    {
%>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td align="center" class="cellError"><%=request.getAttribute("respME")%></td>
            </tr>
        </table>        
<%        
    }
    if (request.getAttribute("msgerr") != null) {
%>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <netui-data:repeater dataSource="pageFlow.errorArr">
                    <netui-data:repeaterItem>
                        <tr>
                            <td align="center" class="cellError">
                            <netui:label value= "${container.item}"/>
                            </td>
                        </tr>
                    </netui-data:repeaterItem>
                </netui-data:repeater>
                <td class="cellError"><%= request.getAttribute("msgerr")%></td>
            </tr>
        </table>


<%  }} %>            
        </div>        
        </netui:form>


        
    </body>
</netui:html>

