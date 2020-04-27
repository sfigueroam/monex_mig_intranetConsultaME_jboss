<%@ page import="java.util.*"%>
<%@ page import="cl.tesoreria.utiles.files.GeneraExcel"%>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%/*
response.setContentType("text/plain");
response.setHeader("Content-Disposition","attachment;filename=archivo.txt"); 
GeneraExcel generaExcel = new GeneraExcel();
DataOutput output = new DataOutputStream(response.getOutputStream());
String[] giroEncabezado = null; //(String[]) request.getAttribute("titulos");
ByteArrayOutputStream bufferSalida = generaExcel.generarArchivo((ArrayList) request.getAttribute("CONT"),giroEncabezado);
byte[] bytes = bufferSalida.toByteArray();
response.setContentLength(bytes.length);
System.out.println("Buffer " + bytes.length);
for( int i = 0; i < bytes.length; i++ )
{ 
    output.writeByte(bytes[i]); 
}*/
%>
