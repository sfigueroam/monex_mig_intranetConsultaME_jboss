<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="cl.tesoreria.seguridad.encoder.Base64"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui:html>
<head>
   <title>Tesorería General de la República</title>
   <link rel="StyleSheet" href="resources/css/teso.css" type="text/css" media="all">
</head>
<body class="body">
   <p>&nbsp;</p>
   <p>&nbsp;</p>
   <form method="post" action="j_security_check">
		<p align="center">
   			<img src="resources/images/logo_teso2.png">
   		</p>
    	<p>&nbsp;</p>
    	<div align="center">
   		<table align="center" border="0" cellpadding="5" cellspacing="1" width="40%" class="formGrid">   
		   <tr class="formColor1">
		    <td width="22%" class="grillaIdentificador">Login</td>
		    <td width="70%" ><input type="text" name="j_username" id="userName" /></td>
		   </tr>
		   <tr class="formColor2">
		    <td width="22%" class="grillaIdentificador">Password</td>
		    <td width="70%" ><input type="password" name="j_password" id="textfield2"  /></td>
		   </tr>
		   <tr class="formColor1" align="center">
		    <td width="100%" colspan=2 align="center" >
		    <input type="submit" name="btn1" id="btn1" value="Ingresar" class="botones">    
		    </td>
		   </tr>      
   		</table>
   		</div>
   
   <% if (request.getAttribute("javax.servlet.error.status_code")!=null){%>
          <% if (request.getAttribute("javax.servlet.error.status_code").toString().equals("403")){%>
          <br>
          <br>       
          <table width="90%" border="0" align="center" cellspacing="0" cellpadding="0" bgcolor="#ffffff">  
          <tr>
          <td align=center style="color:#ff0033;font-size:11px;">Error: Usuario y/o Password incorrecto(s)</td>
          </tr>
         </table>
         <%}%> 
  <%}%>
   <%  /* if (request.getUserPrincipal()!=null){
            String userCoding=Base64.encode(request.getRemoteUser());
            String idAppCoding=Base64.encode("33");
            response.sendRedirect("http://" + request.getServerName() + ":" + request.getServerPort() +"/" + request.getContextPath() + "/cl/tesoreria/seguridad/forward/forwardRequest.fw?IDA=" +idAppCoding +"&UAP=" + userCoding);
       } */
    %>   
 
   </form>
   </body>
</netui:html>