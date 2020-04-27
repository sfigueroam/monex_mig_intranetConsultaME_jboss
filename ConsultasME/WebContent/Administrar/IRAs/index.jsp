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
    String clienteEncontrado = (String)request.getAttribute("clienteEncontrado");
    String clienteValidado = (String)request.getAttribute("validarCliente");
    
%>

<head>
    <netui:base />
    <title>APLICACIÓN MONEDA EXTRANJERA</title>
    <link rel="StyleSheet" href="<%=request.getContextPath()%>/resources/css/teso.css" type="text/css" media="all">        
    <script type="text/JavaScript" src="<%=request.getContextPath()%>/resources/js/functions.js" language="JavaScript"></script>
    <script language="JavaScript">        
        function submitear (valor) 
        {
            document.getElementById('formId').action = valor;
            document.getElementById('formId').submit();
        }
        
        function isNumberKey(evt)
        {
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
            return true;
        }
    </script>     
</head>

<body>
    <p class="titulo">APLICACIÓN MONEDA EXTRANJERA</p>
    <br/>
    <p class="subtitulo">Administrador de IRAs ME</P>
    <br/>
    
    <netui:form action="InsertIRAs" tagId="formId">
    
    <div align="center">        

		<table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
          <tr class="formColor1">
                <td class="cellBGColor1"><b>IRA:</b></td>
                <td class="cellBGColor1"><netui:textBox dataSource="actionForm.ira" maxlength="10" size="10" readonly= "false" tabindex="1"/></td>  
                <td class="cellBGColor1"><b>RUT:</b></td>
                <td class="cellBGColor1">
                    <netui:textBox dataSource="actionForm.rutIra" maxlength="8" size="8" readonly= "false" onKeyPress="return isNumberKey(event)" tabindex="2"/> -
                    <netui:textBox dataSource="actionForm.dvIra" maxlength="1" size="1" readonly= "false" tabindex="3"/>
                </td>
                <td class="cellBGColor1"><b>Descripción:</b></td>
                <td class="cellBGColor1">
                    <netui:textBox dataSource="actionForm.descripcion" maxlength="50" size="40" readonly= "false" tabindex="4"/>
                </td>               
            </tr>
        </table>        

        
        <br>
        <netui:button value="Ingresar IRA"  type="submit" styleClass="formButton" tabindex="5" />
        <br>
        <br>

    <% if (request.getAttribute("iraIngresado") == "1") { %>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td align="center" class="cellError">IRA ingresada exitosamente</td>
            </tr>
        </table>
    <%  } %>

    <% if (request.getAttribute("iraEliminado") == "1") { %>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td class="cellError">IRA(s) eliminada(s) exitosamente</td>
            </tr>
        </table>
    <%  } %>
        
    <% if (request.getAttribute("msgerrIng") != null) { %>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td align="center" class="cellError"><%= request.getAttribute("msgerrIng")%></td>
            </tr>
        </table>
    <%  } %>


<%
    rowStyle = rowStyle.equals("2") ? "1" : "2";
    linea = linea.add(new BigDecimal(1));
    session.setAttribute("currentLine", linea);
%>
			
        <table border="0" align="center" width="90%" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td class="cellBGColor1" align="center"><b>Seleccionar</b></td>
                <td class="cellBGColor1" align="center"><b>IRA</b></td>
                <td class="cellBGColor1" align="center"><b>RUT</b></td>
                <td class="cellBGColor1" align="center"><b>Descripción</b></td>
            </tr>
			<netui-data:repeater dataSource="pageFlow.tuplas">
                <netui-data:repeaterItem>
                    <tr>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                            <netui:checkBox dataSource="container.item.selecc" tabindex="6"/>
                        </td>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                            <netui:label value="${container.item.ira}"> </netui:label>
                        </td>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                            <netui:label value="${container.item.rutIra}-${container.item.dvIra}"> </netui:label>
                        </td>
                        <td align="left" class="cellBGColor<%=rowStyle%>" nowrap>
                            <netui:label value="${container.item.descripcion}"> </netui:label>
                        </td>                   
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
                    <netui:button value="Eliminar" styleClass="formButton" onClick="submitear('EliminarIRA.do');" tabindex="7" />
                </td>
                <td align="right">&nbsp;</td>
                <td align="right">&nbsp;</td>
            </tr>
        </table>
        
        </div>        
        </netui:form>        
    </body>
</netui:html>
