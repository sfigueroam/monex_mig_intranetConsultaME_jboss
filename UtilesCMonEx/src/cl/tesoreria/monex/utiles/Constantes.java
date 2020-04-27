package cl.tesoreria.monex.utiles; 

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Constantes {

  public static String URL_CUT = "";
  public static String URL_WS = "";
  public static String RECA_DATASOURCE = "";
  public static String URL_SERVICIOS = "";
  //public static final String FILE_NAME1 = "interfazCUT.properties";
  public static final String FILE_NAME_ME = "/META-INF/intranetConsultasME.properties";
  
  public Constantes() {
  }



  public static void cargarArchivo() throws Exception
  {
     FileInputStream fileInputStream = null;
     try{
         fileInputStream = new FileInputStream(FILE_NAME_ME);
         System.out.println("fileInputStream: " + fileInputStream);
         Properties prop = new Properties();
         prop.load(fileInputStream);

         URL_CUT = prop.getProperty("URL_CUT");
         RECA_DATASOURCE = prop.getProperty("RECA_DATASOURCE");
         URL_SERVICIOS = prop.getProperty("URL_SERVICIOS");
     
     } finally {
         fileInputStream.close();
     }
  }

  /**
   * Archivo WSRentaMasivaME.properties
   */
  
  public static void cargarArchivoME() throws Exception
  {
     FileInputStream fileInputStream = null;
     try
     {
         fileInputStream = new FileInputStream(FILE_NAME_ME);
         System.out.println("fileInputStream: " + fileInputStream);
         Properties prop = new Properties();
         prop.load(fileInputStream);

         URL_WS = prop.getProperty("URL_WS");     
//         URL_WS = "http://dptest.tesoreria.cl:9120/RentaMasivaWS/WSRentaMasivaME.jws?wsdl";  
     } 
     finally 
     {
         fileInputStream.close();
     }
  }

}
