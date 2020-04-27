package pcontab.actualizar;
import java.math.BigDecimal;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.log4j.Logger;

import pcontab.consultar.Controller.ActualizarPContabForm;
import cl.tesoreria.me.locator.PkgConsultasMonExLocator;


/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{    
	PkgConsultasMonExLocator locator = new PkgConsultasMonExLocator();
    private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.pcontabActualizar");
    
    public String rolUsuario;
    public BigDecimal anno;

    // Uncomment this declaration to access Global.app.
    // 
    //     protected global.Global globalApp;
    // 

    // For an example of page flow exception handling see the example "catch" and "exception-handler"
    // annotations in {project}/WEB-INF/src/global/Global.app

    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="../consultar/begin.do"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "../consultar/begin.do")
    })
    protected Forward begin(ActualizarPContabForm form)
    {        
        rolUsuario = (String)getSession().getAttribute("rolUsuario");
        anno = new BigDecimal(form.getSeleccion());
        form.setSeleccion(anno.toString());
        
        
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

    /**
     * @jpf:action
     * @jpf:forward name="success" path="../consultar/begin.do"
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "success", path = "../consultar/begin.do")
		}
	)
    protected Forward administrar()
    {
        rolUsuario = "explotador";
        getRequest().setAttribute("rolUsuario", rolUsuario);
        
        return new Forward("success");
    }
    
}
