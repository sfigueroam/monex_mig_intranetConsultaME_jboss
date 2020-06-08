package cl.tesoreria.monex.utiles; 

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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
	
  private static InputStream in = null;
	
  private static Logger logger = Logger.getLogger("cl.tesoreria.monex.utiles.Constantes"); 

  public static String URL_CUT = "";
  public static String URL_WS = "";
  public static String RECA_DATASOURCE = "";
  public static String URL_SERVICIOS = "";
  public static String WS_ENDPOINT_URL_WSRENTAMASIVAME = "";
  public static String JNDI_DATASOURCE_RECA = "";
  public static String JNDI_DATASOURCE_BEA816 = "";
  public static String JNDI_DATASOURCE_SII = "";
  public static String JNDI_EJB_PKGCMONEXREMOTE = "";
  public static String JNDI_EJB_PKGCONSULTASMONEXREMOTE = "";

  //public static final String FILE_NAME1 = "interfazCUT.properties";
  public static final String FILE_NAME_ME = "intranetConsultasME.properties";
  
  public Constantes() {
  }



  public static void cargarArchivo() throws Exception
  {
     try{
		in = Constantes.class.getClassLoader().getResourceAsStream(FILE_NAME_ME);
        Properties prop = new Properties();
        prop.load(in);
        logger.info("------>>>>> Carga de propiedades Exitosa : " + FILE_NAME_ME );
 
 
         URL_CUT = prop.getProperty("URL_CUT");
         RECA_DATASOURCE = prop.getProperty("RECA_DATASOURCE");
         URL_SERVICIOS = prop.getProperty("URL_SERVICIOS");
     
         logger.info("------>>>>> Carga de propiedades Exitosa : ");
         in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Error en el metodo CargarProperties():1 : " );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("Error en el metodo CargarProperties():2 : ");			            
		}
  }

  /**
   * Archivo WSRentaMasivaME.properties
   */
  
  public static void cargarArchivoME() throws Exception
  {
     try
     {
 		in = Constantes.class.getClassLoader().getResourceAsStream(FILE_NAME_ME);
        Properties prop = new Properties();
        prop.load(in);
        logger.info("------>>>>> Carga de propiedades Exitosa : " + FILE_NAME_ME);
 

         WS_ENDPOINT_URL_WSRENTAMASIVAME = prop.getProperty("WS.ENDPOINT.URL.WSRENTAMASIVAME");
         JNDI_DATASOURCE_RECA = prop.getProperty("JNDI.DATASOURCE.RECA");
         JNDI_DATASOURCE_BEA816 = prop.getProperty("JNDI.DATASOURCE.BEA816");
         JNDI_DATASOURCE_SII = prop.getProperty("JNDI.DATASOURCE.SII");
         JNDI_EJB_PKGCMONEXREMOTE = prop.getProperty("JNDI.EJB.PKGCMONEXREMOTE");
         JNDI_EJB_PKGCONSULTASMONEXREMOTE = prop.getProperty("JNDI.EJB.PKGCONSULTASMONEXREMOTE");

//         URL_WS = "http://dptest.tesoreria.cl:9120/RentaMasivaWS/WSRentaMasivaME.jws?wsdl";  
    
        logger.info("------>>>>> Carga de propiedades Exitosa : ");
       in.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		logger.info("Error en el metodo CargarProperties()1 : " + e);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		logger.info("Error en el metodo CargarProperties()2 : " + e);			            
	}
  }

}
