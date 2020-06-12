<%@ page import="java.io.*, java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.sql.RowSet"%>
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
        boolean isData = false;
        RowSet rs = null;
        String msje = "";
        
        String rut = (String) request.getAttribute("RUT");
        String dv = (String) request.getAttribute("DV");
        
        int ojo = 0;        
        if (rut.equals("")) { ojo=1; }
        
        
        Locale local = new Locale("es", "CL");
        NumberFormat formatNum = NumberFormat.getInstance(local);
                        
        /**
         * Si no hay errores en la consulta
         * se asigna el resultado de la consulta
         * al puntero rs
         */
        try 
        {
            rs = (RowSet) request.getAttribute("RESULT");
            isData = rs.first();
            if (!isData) 
            {
                msje = "No se registran datos para la consulta";
            }          
        }
        catch (Exception e) {
            msje = "Ha ocurrido un error en la aplicación, por favor vuelva a intentarlo";
        }
        
    %> 
    <body>
        <p class="titulo"> APLICACIÓN MONEDA EXTRANJERA </p>
        <br/>
        <p class="subtitulo">CASOS RECTIFICADOS</P>
        <br/>
        <div align="center">
        
    <%  if (msje != "") { %>
            <p class="error"><%=msje%></p>
            <br>
    <%  } else { %>
        <form name="" method="post" action="">  
            <table width="95%" border="1" cellpadding="1" cellspacing="0">
                <tr class="grillaDosPuntos">
                    <td>&nbsp;</td>
                    <td>SIGNO</td>
                    <td>FORM</td>
                    <td>AÑO TRIBUTARIO</td>
                    <td>RUT</td>
                    <td>FOLIO</td>
                    <td>VCTO (COD15)</td>
                    <td>FECHA ENVIO (9927)</td>
                    <td>FECHA RECEPCIÓN</td>
                    <td>9901</td>
                    <td>9902</td>
                    <td>MONEDA</td>
                    <td>91</td>
                    <td>87</td>
                    <td>9916</td>
                    <td>9907</td>
                </tr>        
    <%  
            int sw = 0;
            while (isData) {
                rut = rs.getString("RUT_ROL");
    %>
                <tr align="center">
                    <td>
                        <%  if (sw==0) { %>
                        <input type="radio" name="item" value="<%=rs.getString("ID")%>" checked>
                        <%      sw=1;
                            }else{%>
                        <input type="radio" name="item" value="<%=rs.getString("ID")%>">
                        <%  } %>
                    </td>
                    <td><%=rs.getString("SIGNO_FORM")%></td>
                    <td><%String form_tipo=rs.getString("FORM_TIPO");%>
                        <%=form_tipo%></td>
                    <td><%
                        String fecha = rs.getString("FECHA_VCTO");
                        String ano = fecha.substring(0,4);
                        if (form_tipo.equals("22")){%>
                        <%=ano%>
                        <%}else{%>&nbsp;<%}%></td>
                    <td><%
                            
                            int rutInt = rs.getInt("RUT_ROL");

                               int aux=rutInt;
                               int digito;
                               int factor=2;
                               int suma=0;
                               int dv2;
                            
                                 while (aux!=0){
                                    digito = aux % 10;
                                    suma = suma + factor * digito;
                                    aux /= 10;
                                    factor++;
                                    if (factor==8)
                                       factor = 2;
                                 }
                                 dv2=11-suma%11;
                                 if (dv2 == 11) { dv= "0"; }
                                 else if (dv2==10) { dv = "K"; }
                                      else { dv = ""+dv2; }

                        %>
                        <%=formatNum.format(rs.getDouble("RUT_ROL"))%>-<%=dv%>
                    </td>
                    <td><%=rs.getString("FORM_FOLIO")%></td>
                    <%
                        String fVcto = rs.getString("valor_15");
                        if (fVcto.length()>6) {
                            String dia = fVcto.substring(6,8);
                            String mes = fVcto.substring(4,6);
                            ano = fVcto.substring(0,4);
                            fVcto = dia+'/'+mes+'/'+ano;
                        }else{
                            String mes = fVcto.substring(4,6);
                            ano = fVcto.substring(0,4);                            
                            fVcto = mes+'/'+ano;
                        }
                    %>
                    <td><%=fVcto%></td>
                    <%
                        fecha = rs.getString("COD9927");
                        String dia = fecha.substring(6,8);
                        String mes = fecha.substring(4,6);
                        ano = fecha.substring(0,4);
                        fecha = dia+'/'+mes+'/'+ano;
                    %>
                    <td><%=fecha%></td>                    
                    <td align="right">
                    <%
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); 
                        Date fPkg = rs.getDate("FECHA_PACKAGE");
                    %>
                    <%=formatoFecha.format(fPkg)%></td> 
                    <td align="right">&nbsp;<%=rs.getString("valor_9901")%></td>
                    <td align="right">&nbsp;<%=rs.getString("valor_9902")%></td>
                    <td><%=rs.getString("NEMO")%></td>
                    <td align="right">
                    <%  String v91 = rs.getString("valor_91");
                        if (!v91.equals(" ")) { %>
                        <netui:span value='<%=v91%>' tagId="uno"> 
                            <netui:formatNumber language="es" pattern="#,##0.00"/>
                        </netui:span>  
                    <%  } else { %>&nbsp;<%}%>
                    </td>
                    <td align="right">
                    <%  String v87 = rs.getString("valor_87");
                        if (!v87.equals(" ")) { %>                    
                        <netui:span value='<%=v87%>' tagId="uno"> 
                            <netui:formatNumber language="es" pattern="#,##0.00"/>
                        </netui:span>
                    <%  } else { %>&nbsp;<%}%>
                    </td>
                    <td align="right">
                    <%  String v9916 = rs.getString("valor_9916");
                        if (!v9916.equals(" ")) { %>
                        <netui:span value='<%=v9916%>' tagId="uno"> 
                            <netui:formatNumber language="es" pattern="#,##0.00"/>
                        </netui:span>  
                    <%  } else { %>&nbsp;<%}%>                     
                    </td>
                    <td><%=rs.getString("valor_9907")%></td>
                </tr>
                
    <%      isData = rs.next();
            }
            
            String diaDesde = (String) request.getAttribute("diaDesde");
            String anoDesde = (String) request.getAttribute("anoDesde");
            String mesDesde = (String) request.getAttribute("mesDesde");
            String anoHasta = (String) request.getAttribute("anoHasta");
            String mesHasta = (String) request.getAttribute("mesHasta");
            String diaHasta = (String) request.getAttribute("diaHasta");
            
            if (ojo==1) {rut="0";}
                  
    %>
            </table>
            <br>
            
            <input type="hidden"  name="diaDesde" value="<%=diaDesde%>">
            <input type="hidden" name="anoDesde" value="<%=anoDesde%>">
            <input type="hidden" name="mesDesde" value="<%=mesDesde%>">
            <input type="hidden" name="anoHasta" value="<%=anoHasta%>">
            <input type="hidden" name="mesHasta" value="<%=mesHasta%>">
            <input type="hidden" name="diaHasta" value="<%=diaHasta%>">
            <input type="hidden" name="rut" value="<%=rut%>">
            <input type="hidden" name="dv" value="<%=dv%>">
            
            <input class="botones" type="button" value="Volver" onClick="javascript:history.back()" />
            <input type="button" value="Ver Item" class="botones" onclick="enviaForm(this.form,'GoMovimientoForm','goItem.do');">            
            <input type="button" value="Ver Rectificado" class="botones"  onclick="enviaForm(this.form,'rectificadosForm','goRectificados.do');">
            <input type="button" value="Exportar" class="botones"  onclick="enviaForm(this.form,'rectificadosForm','goExpRect.do');">    
        </form>
    <%
        }
    %>
        </div>

    </body>
</netui:html>
