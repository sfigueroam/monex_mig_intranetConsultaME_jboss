package generar;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;

import javax.sql.RowSet;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;

import cl.tesoreria.me.locator.PkgConsultasMonExLocator;
import cl.tesoreria.monex.pkgconsultasmonex.GeneraHuinchaResult;
import cl.tesoreria.monex.pkgconsultasmonex.RecuperaArchResult;

/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{    
	PkgConsultasMonExLocator locator = new PkgConsultasMonExLocator();
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.ControllerGenerar");
	
    // Uncomment this declaration to access Global.app.
    // 
    //     protected global.Global globalApp;
    // 

    // For an example of page flow exception handling see the example "catch" and "exception-handler"
    // annotations in {project}/WEB-INF/src/global/Global.app

    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="huinchaPagoSii.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "huinchaPagoSii.jsp")
    })
    protected Forward begin()
    {
        return new Forward("success");
    }
    
//Lee un clob y lo transforma a String

    protected static String toString(Clob clob) throws SQLException
    {
        if (clob != null)
        {
            try
            {
                int len;
                char[] buf = new char[8192];
                StringBuffer writer = new StringBuffer(8192);
                java.io.Reader reader = clob.getCharacterStream();
                while ((len = reader.read(buf)) != -1)
                {
                    writer.append(buf, 0, len);
                }
                return writer.toString();
            }
            catch (IOException ex)
            {
            	ex.printStackTrace();
            	logger.error("Error en el metodo Generar.toString() : " + ex);
            	throw new SQLException(ex.toString());
            }
        }
        return null;
    }
    

    /**
     * DHN 16-05-2017 - No se usan
     */
    /*@Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "../recuperarArch/archivos.jsp"), 
        @Jpf.Forward(name = "error",
                     path = "cuadratura.jsp")
    })
    protected Forward goCuadratura(GoCuadraturaForm form)
    {
        String fecha = form.getFecha();

        if (fecha.equals(""))
        {
            this.getRequest().setAttribute("msje", "Debe ingresar una fecha para generar archivos de cuadratura.");
            return new Forward("error");
        }
        
        try
        {
           
            locator.getPkgConsultasMonExRemote().cuadratura(new BigDecimal(fecha));
            RecuperaArchResult result = locator.getPkgConsultasMonExRemote().recuperaArch(new BigDecimal(fecha), "C", new BigDecimal(0));
            RowSet rs = result.getRowSet(0);
            
            if (rs.first())
            {
                this.getRequest().setAttribute("RESULT", rs);
                return new Forward("success");
            }
            else
            {
                this.getRequest().setAttribute("msje", "No se encuentran datos para la fecha indicada");
                return new Forward("error"); 
            }              
/ *
            CuadraturaResult result = controlCuadraturaEJB.cuadratura(new BigDecimal (fecha));
            String archivo1 = result.getArchivo1();
            String archivo2 = result.getArchivo2();
            String archivo3 = result.getArchivo3();
            BigDecimal Oerror =  result.getOCodError();
            

            String[] arch1 = archivo1.split("/");
            String[] arch2 = archivo2.split("/");
            String[] arch3 = archivo3.split("/");
            
            this.getRequest().setAttribute("archivo1",arch1[5]);
            this.getRequest().setAttribute("archivo2",arch2[5]);
            this.getRequest().setAttribute("archivo3",arch3[5]);
* /

        } 
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Generar.goCuadratura() : " + e);
        	System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","No se pudo realizar la consulta."); 

/ *            throw new RuntimeException (
                "No se puede ejecutar la consulta. " +   
                "Error porducido por: " + form, e);
* /                

           // this.getRequest().setAttribute("msje",e.getMessage());                 
        }       
       
        return new Forward("success");
        
    } */

    /**
     *  DHN 16-05-2017 - No se usan
     */
    /*@Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "../recuperarArch/archivos.jsp"), 
        @Jpf.Forward(name = "error",
                     path = "huinchaPagoSii.jsp")
    })
    protected Forward goConsulta(GoConsultaForm form)
    {
    
        String fecha = form.getFecha();

        if (fecha.equals(""))
        {
            this.getRequest().setAttribute("msje", "Debe ingresar el dato solicitado");
            return new Forward("error");
        }
        
        try
        {
            
            GeneraHuinchaResult result2 = locator.getPkgConsultasMonExRemote().generaHuincha(new BigDecimal(fecha));
            RowSet rs = result2.getRowSet(0);
            String MensajeRetorno = result2.getMensajeRetorno(); 
            
            
            if (MensajeRetorno.equals("OK"))
            {
                RecuperaArchResult result = locator.getPkgConsultasMonExRemote().recuperaArch(new BigDecimal(fecha), "H", new BigDecimal(0));
                RowSet rs2 = result.getRowSet(0);
                this.getRequest().setAttribute("RESULT", rs2);
                return new Forward("success");      
            }
            else
            {
                this.getRequest().setAttribute("msje",MensajeRetorno);
                return new Forward("error");
            }  
            
                 
            
/ *            
            GeneraHuinchaResult result = controlHuinchaEJB.generaHuincha(new BigDecimal (fecha));
            RowSet rs = result.getRowSet(0);
            
            String MensajeRetorno = result.getMensajeRetorno(); 
                        
            if (MensajeRetorno.equals("OK")) {
                this.getRequest().setAttribute("RES", rs);
                return new Forward("success");
            } else {
                this.getRequest().setAttribute("msje",MensajeRetorno);
                return new Forward("error");
            }   
* /            
        } 
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Generar.goConsulta() : " + e);
        	System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");   
        }
        
       return new Forward("success");
    }*/

    /**
     * 
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "success", path = "../recuperarArch/archivos.jsp"), 
			@Jpf.Forward(name = "error", path = "contabilidad.jsp")
		}
	)
    protected Forward goConta(getFecha form)
    {
        String fecha = form.getFecha();
        
        if (fecha.equals("")) {
            this.getRequest().setAttribute("msje", "Debe ingresar el dato solicitado");
            return new Forward("error");
        }
        
        try {
            
            locator.getPkgConsultasMonExRemote().generaLibroContabme(new String (fecha));
            RecuperaArchResult result = locator.getPkgConsultasMonExRemote().recuperaArch(new BigDecimal (fecha), "L", new BigDecimal (0));
            RowSet rs = result.getRowSet(0);
            
            
            if (rs.first()) {
                this.getRequest().setAttribute("RESULT", rs);
                return new Forward("success");
            } else {
                this.getRequest().setAttribute("msje", "No se encuentran datos para la fecha indicada");
                return new Forward("error"); 
            }             
            
/*            
            GeneraLibroContabmeResult result = controlGeneraContab.generaLibroContabme(new String (fecha));
            
            String archivo1 = result.getArchivo1();
            BigDecimal codOut = result.getCodout();
            
            if (archivo1.equals(null)) {
                this.getRequest().setAttribute("msje","No se ha generado el archivo");
                return new Forward("error");
            } else {
                this.getRequest().setAttribute("archivo1", archivo1);
                return new Forward("success");
            }              
*/            
        } 
        catch (Exception e) {
        	e.printStackTrace();
        	logger.error("Error en el metodo Generar.goConta() : " + e);
            System.out.println("Error en:" + " --> " + form + " --> " + e.getMessage());
            this.getRequest().setAttribute("msje","No se pudo realizar la consulta."); 
        }
        
       return new Forward("success");
    }

    /**
     * BaseActionForm get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoCuadraturaForm extends BaseActionForm
    {
        private String tipo;

        private String dia;

        private String mes;

        private String agno;

        private String fecha;

        public void setFecha(String fecha)
        {
            this.fecha = fecha;
        }

        public String getFecha()
        {
            return this.fecha;
        }

        public void setTipo(String tipo)
        {
            this.tipo = tipo;
        }

        public String getTipo()
        {
            return this.tipo;
        }
    }

    /**
     * BaseActionForm get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoContenidoForm extends BaseActionForm
    {
        private String id;

        public void setId(String id)
        {
            this.id = id;
        }

        public String getId()
        {
            return this.id;
        }
    }

    /**
     * BaseActionForm get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoConsultaForm extends BaseActionForm
    {
        private String tipo;

        private String fecha;

        public void setFecha(String fecha)
        {
            this.fecha = fecha;
        }

        public String getFecha()
        {
            return this.fecha;
        }

        public void setTipo(String tipo)
        {
            this.tipo = tipo;
        }

        public String getTipo()
        {
            return this.tipo;
        }
    }

    /**
     * BaseActionForm get and set methods may be overwritten by the Form Bean editor.
     */
    public static class getFecha extends BaseActionForm
    {
        private String fecha;

        public void setFecha(String fecha)
        {
            this.fecha = fecha;
        }

        public String getFecha()
        {
            return this.fecha;
        }
    }
}
