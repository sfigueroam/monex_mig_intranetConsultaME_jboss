package pcontab.consultar;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.sql.RowSet;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;

import cl.tesoreria.me.locator.PkgConsultasMonExLocator;
import cl.tesoreria.monex.pkgconsultasmonex.PeriodosContablesResult;
import pcontab.consultar.Controller.ActualizarPContabForm;


/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{    
	PkgConsultasMonExLocator locator = new PkgConsultasMonExLocator();    
    private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.ControllerPcontabConsultar");
    
    public transient RowSet rowSet;
    public String rolUsuario;
    
    public BigDecimal anno; 
    
    public BigDecimal getAnnoActual()
    {
        Date hoy = new Date();
        BigDecimal a = new BigDecimal(hoy.getYear() + 1900);
        return a;
    }

    
    
    
    
    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="../consultar/begin.do"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "begin.do")
    })
    protected Forward confirmar(ActualizarPContabForm form)
    {
    	
    	
    	logger.info("lkjasdlksja dlkajs dlkasjd ");
    	
    	System.out.println("Confirmar");
        rolUsuario = (String)getSession().getAttribute("rolUsuario");
        anno = new BigDecimal(form.getSeleccion());
        form.setSeleccion(anno.toString());
        
        System.out.println("rolUsuario: "+rolUsuario);
        System.out.println("anno: "+anno);
        
        if (rolUsuario == "explotador")
        {
            try
            {
                locator.getPkgConsultasMonExRemote().actPeriodosContables(form.getPcontab());
                getRequest().setAttribute("errorMessage","Cambio del Estado exitoso");
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            	logger.error("Error en el metodo pcontabActualizar.Begin() : " + e);
                e.printStackTrace();
                getRequest().setAttribute("errorMessage", "Ha ocurrido un error:" +
                                                          e.getMessage());
            }
        }
        else
        {
            getRequest().setAttribute("errorMessage", "Ud. no posee privilegios para cambiar Estado");
        }
        
        getRequest().setAttribute("rolUsuario", rolUsuario);
        getRequest().setAttribute("anno", anno);
        
        return new Forward("success");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Uncomment this declaration to access Global.app.
    // 
    //     protected global.Global globalApp;
    // 

    // For an example of page flow exception handling see the example "catch" and "exception-handler"
    // annotations in {project}/WEB-INF/src/global/Global.app
    
    public LinkedHashMap conditionOptions = null;

    public LinkedHashMap getConditionOptions()
    {
        if (conditionOptions != null)
            return conditionOptions;

        conditionOptions = new LinkedHashMap(2);
        conditionOptions.put("S", "Abierto");
        conditionOptions.put("N", "Cerrado");
        return conditionOptions;
    }
    
    public LinkedHashMap annoOptions = null;

    public LinkedHashMap getAnnoOptions()
    {
        if (annoOptions != null)
            return annoOptions;
        
        int annoActual = this.getAnnoActual().intValue();
        int cantidad = (annoActual - 2008) + 1;
        annoOptions = new LinkedHashMap(cantidad);
        for (int i=2008; i <= annoActual; i++)
        {
            annoOptions.put(String.valueOf(i), String.valueOf(i));
        }
        return annoOptions;
    }
    
    
    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "index.jsp")
    })
    
    protected Forward begin(ActualizarPContabForm form)
    {	
    	
        PeriodosContablesResult periodos = new PeriodosContablesResult();
        	
        conditionOptions = this.getConditionOptions();
        annoOptions = this.getAnnoOptions();
        
        if (form.getSeleccion() != null)
            anno = new BigDecimal(form.getSeleccion());
        
        if (anno == null)
            anno = this.getAnnoActual();
            
        form.setSeleccion(anno.toString());
        
        this.getPeriodosContables();
        
        if (rolUsuario == null)
            rolUsuario = (String)getRequest().getAttribute("rolUsuario");
        
        getRequest().setAttribute("rolUsuario", rolUsuario);
        
        return new Forward("success");
    }

    
    
    
    
    /**
     * @jpf:action
     * @jpf:forward name="success" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "index.jsp")
    })
    protected Forward cambiarAnno(ActualizarPContabForm form)
    {

        anno = new BigDecimal(form.getSeleccion());
        form.setSeleccion(anno.toString());
        
        this.getPeriodosContables();

        return new Forward("success");
    }
    
    private void getPeriodosContables() 
    {
        PeriodosContablesResult periodos = new PeriodosContablesResult();
        try
        {
            periodos = locator.getPkgConsultasMonExRemote().getPeriodosContables(anno);  
            rowSet = periodos.getRowSet(0);            
            rowSet.last();
            int nrows = rowSet.getRow();
            if (nrows == 0)
                getRequest().setAttribute("errorMessage","No existen datos para la consulta");
                    
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo PcontabConsultar.getPeriodosContables() : " + e);
            getRequest().setAttribute("errorMessage", e.getMessage());
        }
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="begin.do"
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "success", path = "begin.do")
		}
	)
    protected Forward consulta()
    {
        rolUsuario = "ConConMonExt";
        getRequest().setAttribute("rolUsuario", rolUsuario);
        
        return new Forward("success");
    }
	
    /**
     * @jpf:action
     * @jpf:forward name="success" path="../consultar/begin.do"
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "success", path = "begin.do")
		}
	)
    protected Forward administrar()
    {
        rolUsuario = "explotador";
        getRequest().setAttribute("rolUsuario", rolUsuario);
        
        return new Forward("success");
    }
    
    

    /**
     * BaseActionForm get and set methods may be overwritten by the Form Bean editor.
     */
    public static class ActualizarPContabForm extends BaseActionForm
    {

		private String seleccion;

        private String estado;

        private String pcontab;

        public void setPcontab(String pcontab)
        {
            this.pcontab = pcontab;
        }

        public String getPcontab()
        {
            return this.pcontab;
        }

        public void setEstado(String estado)
        {
            this.estado = estado;
        }

        public String getEstado()
        {
            return this.estado;
        }

        public void setSeleccion(String seleccion)
        {
            this.seleccion = seleccion;
        }

        public String getSeleccion()
        {
            return this.seleccion;
        }
    }

	public RowSet getRowSet() {
		return rowSet;
	}


	public void setRowSet(RowSet rowSet) {
		this.rowSet = rowSet;
	}


	public String getRolUsuario() {
		return rolUsuario;
	}


	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}


	public void setAnnoOptions(LinkedHashMap annoOptions) {
		this.annoOptions = annoOptions;
	}
}