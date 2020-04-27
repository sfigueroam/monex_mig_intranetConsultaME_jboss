package recuperarArch;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.RowSet;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;

import cl.tesoreria.me.locator.PkgConsultasMonExLocator;
import cl.tesoreria.monex.pkgconsultasmonex.RecuperaArchResult;
import cl.tesoreria.utiles.sql.TypesExt;

/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{
	PkgConsultasMonExLocator locator = new PkgConsultasMonExLocator();
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.ControllerRecuperarArch");
	
    // Uncomment this declaration to access Global.app.
    // 
    //     protected global.Global globalApp;
    // 

    // For an example of page flow exception handling see the example "catch" and "exception-handler"
    // annotations in {project}/WEB-INF/src/global/Global.app

    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="goCuadratura.do"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "goCuadratura.do")
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
            	logger.error("Error en el metodo ControllerRecuperarArch.toString() : " + ex);
            	throw new SQLException(ex.toString());
            }
        }
        return null;
    }
    

    /**
     * @jpf:action
     * @jpf:forward name="success" path="archivos.jsp"
     * @jpf:forward name="error" path="error.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "archivos.jsp"), 
        @Jpf.Forward(name = "error",
                     path = "error.jsp")
    })
    protected Forward goCuadratura(GoCuadraturaForm form)
    {
        String fecha = form.getFecha();
        String tipo = form.getTipo(); 

        if (fecha.equals(""))
        {
            this.getRequest().setAttribute("msje", "Debe ingresar la fecha para recuperar archivos.");
            return new Forward("error");
        }
        
        try
        {
            RecuperaArchResult result = locator.getPkgConsultasMonExRemote().recuperaArch(new BigDecimal(fecha), new String(tipo), new BigDecimal(0));
            RowSet rs = result.getRowSet(0);
            
            if (rs.first())
            {
                this.getRequest().setAttribute("RESULT", rs);
                return new Forward("success");
            }
            else
            {
                this.getRequest().setAttribute("msje", "No se encuentran archivos para la fecha indicada.");
                return new Forward("error"); 
            }                
            
        } 
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo ControllerRecuperarArch.goCuadratura() : " + e);
        	System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","No se pudo realizar la consulta."); 
        }  
        
        return new Forward("success");
      
    }

    /**
     * @throws SQLException 
     * @jpf:action
     * @jpf:forward name="error" path="error.jsp"
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "error", path = "error.jsp")
		}
	)
    protected Forward goContenido(GoContenidoForm form) throws SQLException
    {
        String id = form.getId();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement call = null;
        try {
//            RecuperaArchResult result = locator.getPkgConsultasMonExRemote().recuperaArch(new BigDecimal (0), "", new BigDecimal (id));
            
            
        	Context ctx = new InitialContext();
    		DataSource dataSource = (DataSource)ctx.lookup("java:/jdbc/bea816DS");
    		conn = dataSource.getConnection();
            
        	 call = conn.prepareCall("{call SII.PKG_CONSULTAS_MON_EX.RECUPERA_ARCH(?,?,?,?,?)}");
             
                 call.setBigDecimal(1, new BigDecimal (0));
                 call.setString(2, "");
                 call.setBigDecimal(3, new BigDecimal (id));
                 call.registerOutParameter(4, Types.CLOB);
                 call.registerOutParameter(5, TypesExt.CURSOR);
                 call.execute();
//                 result.setArchclob(toString(call.getClob(4)));
                 
//                 resultSets.add(toRowSet((ResultSet) call.getObject(5)));
            
                 System.out.println("ñlaskdñlaskd ñlsak d");
             
            
            
            
            
            
            rs = (ResultSet)call.getObject(5);           
            String contenido;
            if (rs.next()) {
                
                String nomArch = rs.getString("NOMBRE_ARCH");
                contenido = this.toString(rs.getClob("CONTENIDO"));
                
                String[] bytes = contenido.split("\n");
                String fileName = "attachment;filename="+nomArch ;
           

                this.getResponse().setContentType("text/plain");
                this.getResponse().setHeader("Content-Disposition",fileName); 
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                //buffer.write(contenido.getBytes());        
                
                byte[] bytes1=contenido.getBytes();        
               /* String s;
                for(int i=0;i<bytes.length;i++){
                    s=bytes[i]+"     \n";
                    buffer.write(s.getBytes());        
                    buffer.write(contenido.getBytes());        
                }*/
                
                //byte[] bytes1 = buffer.toByteArray();
                this.getResponse().setContentLength(bytes1.length);
                //System.out.println("Buffer " + bytes1.length);
                DataOutputStream output = new DataOutputStream(this.getResponse().getOutputStream());
                for( int i = 0; i < bytes1.length; i++ )
                { 
                    output.writeByte(bytes1[i]); 
                }  
                             
                
            } else {
                this.getRequest().setAttribute("msje", "No se encuentran datos para la fecha indicada");
                return new Forward("error"); 
            } 
            
        } 
        catch (Exception e) {
        	e.printStackTrace();
        	logger.error("Error en el metodo ControllerRecuperarArch.goContenido() : " + e);
            System.out.println("Error en:" + " --> " + form + " --> " + e.getMessage());
            this.getRequest().setAttribute("msje","No se pudo realizar la consulta."); 
            return new Forward("error"); 
        } finally {
        	conn.close();
        	rs.close();
        	call.close();
        }     
        
        return null;
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
}
