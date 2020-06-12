<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="cl.tesoreria.monex.vo.PContabVO"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="javax.sql.RowSet"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
<netui-data:getData resultId="rolUsuario" value="${pageFlow.rolUsuario}"></netui-data:getData>
<%
    String rowStyle = "2";
    BigDecimal linea = new BigDecimal(1);
    session.setAttribute("currentLine", linea);

    //String rolUsuario = (String)request.getAttribute("rolUsuario");
    String rolUsuario=(String)  pageContext.getAttribute("rolUsuario");
    session.setAttribute("rolUsuario",rolUsuario);

    System.out.println(rolUsuario);
    
    
%>

<head>
    <netui:base />
    <title>APLICACIÓN MONEDA EXTRANJERA</title>
    <link rel="StyleSheet" href="<%=request.getContextPath()%>/resources/css/teso.css" type="text/css" media="all">        
    <script type="text/JavaScript" src="<%=request.getContextPath()%>/resources/js/functions.js" language="JavaScript"></script>
    <script language="JavaScript">        
        function actualizar(valor) 
        {
            document.getElementById('pcontab').value = valor;
            document.getElementById('formId').action = '../actualizar/begin.do';
            document.getElementById('formId').submit();
            
        }
        
        function submitear(valor) 
        {
            document.getElementById('formId').action = valor;
            document.getElementById('formId').submit();
            
        }
    </script>     
</head>

<body>
    <p class="titulo">APLICACIÓN MONEDA EXTRANJERA</p>
    <br/>
    <p class="subtitulo">Periodos Contables</P>
    <br/>
    
    <netui:form method="post" action="cambiarAnno" tagId="formId" >
        
        <input type="hidden" id="pcontab" name="pcontab">
    
    <div align="center">
    
    <p>Seleccione Año: 
        <netui:select optionsDataSource="${pageFlow.annoOptions}" tagId="selecAnno"
            dataSource="actionForm.seleccion" onChange="submitear('cambiarAnno.do');"/>
    </p>
    <br/>

<%
    rowStyle = rowStyle.equals("2") ? "1" : "2";
    linea = linea.add(new BigDecimal(1));
    session.setAttribute("currentLine", linea);
%>
			
        <table border="0" align="center" width="60%" cellpadding="5" cellspacing="1" class="formGrid">
            <tr>
                <td class="cellBGColor1" align="center"><b>Periodo</b></td>
                <td class="cellBGColor1" align="center"><b>Estado</b></td>
                <% if (rolUsuario=="explotador")  { %>
                <td class="cellBGColor1" align="center"><b>Editar</b></td>
                <% } %>
            </tr>
            <netui-data:getData resultId="row" value="${pageFlow.rowSet}"></netui-data:getData>
            <% RowSet rset=(RowSet)  pageContext.getAttribute("row"); 
                if(rset!=null){
                    rset.beforeFirst();
                    while (rset.next()){ %>	    
                    <tr>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                            <netui:span value='<%=rset.getString("PCONTAB")%>'>  </netui:span>
                        </td>
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                            <netui:span value='<%=rset.getString("ABIERTO")%>'>  </netui:span>
                        </td> 
                        <% if (rolUsuario=="explotador")    { %>                                           
                        <td align="center" class="cellBGColor<%=rowStyle%>" nowrap>
                            <a style="width:87px;" id="bLst" name="bLst" class="botonMediano" onclick="actualizar('<%=rset.getString("PCONTAB")%>');" >Cambiar</a>
                        </td>            
                        <% } %>
                    </tr>
<%
                rowStyle = rowStyle.equals("2") ? "1" : "2";
                linea = linea.add(new BigDecimal(1));
                session.setAttribute("currentLine", linea);
                }
            }
%>  
        </table>
        <br/>
        <% if (request.getAttribute("errorMessage") != null) { %>
        <table width="50%" border="0" align="center" cellpadding="5" cellspacing="1" class="formGrid">
        <tr>
            <td align="center" class="cellError">
                <netui:span value="${requestScope.errorMessage}" defaultValue="" />
                <netui:exceptions showMessage="true" />
            </td>
        </tr>
        </table>
        <% } %>
        
        </div>        
        </netui:form>        
    </body>
</netui:html>



