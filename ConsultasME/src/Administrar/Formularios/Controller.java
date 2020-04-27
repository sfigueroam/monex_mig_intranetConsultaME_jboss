package Administrar.Formularios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;

import cl.tesoreria.me.locator.PkgCMonExLocator;
import cl.tesoreria.monex.controller.PkgCMonExLocal;
import cl.tesoreria.monex.utilesVO.FormCmexVO;

/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{
	PkgCMonExLocator locator = new PkgCMonExLocator();    
    private List            tuplas = new ArrayList(500);
    private String          formIngresado = "0";
    private String          formEliminado = "0";
    private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.ControllerAdministrarFormularios");
    
    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="ShowFilter.do"
     * @jpf:forward name="error" path="/error.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "ShowFilter.do"), 
        @Jpf.Forward(name = "error",
                     path = "/error.jsp")
    })
    protected Forward begin(FormularioForm form)
    {
        ArrayList formularios = new ArrayList();
        tuplas = new ArrayList(500);
        
        try
        {
            formularios = locator.getPkgCMonExRemote().getFormulariosTodos();
            //verForm = form_code.substring(form_code.length() - 1, form_code.length());
            if (formularios != null)
            {
                for (int i=0; i < formularios.size(); i++)
                {
                    FormCmexVO vo = (FormCmexVO)formularios.get(i); 
                    form.setCodigo(vo.getCodigo().toString());
                    form.setDescripcion(vo.getDescripcion());
                    form.setId(vo.getIdForm().toString());
                    form.setSigno(vo.getSigno());
                    form.setCode(vo.getCode());
                    String verForm = vo.getVersion();
                    verForm = verForm.substring(verForm.length() - 1, verForm.length());
                    form.setVersion(verForm);
                    IngresaForm(form);
                }
            }
            
        }
        catch (Exception e) 
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo AdministrarFormularios.Begin() : " + e);
        	getRequest().setAttribute("errorMessage", e.getMessage());
            return new Forward("error");
        } 
        
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="ShowFilter.do"      
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "ShowFilter.do")
    })
    protected Forward IngresaForm(FormularioForm form)
    {
        Forward fwd = new Forward("success");
        boolean existe = false;
        FormularioForm formularioForm = new FormularioForm();
        formularioForm.setId(form.getId());
        formularioForm.setDescripcion(form.getDescripcion().trim());
        formularioForm.setSigno(form.getSigno());
        formularioForm.setCodigo(form.getCodigo().trim());
        formularioForm.setVersion(form.getVersion().trim());
        formularioForm.setCode(form.getCode().trim());
        formularioForm.setSelecc(false);
        
        for (Iterator it = tuplas.iterator(); it.hasNext(); )
        {
            FormularioForm tp = (FormularioForm)it.next();
            int intCodigo = Integer.parseInt(tp.getCodigo());
            String version = tp.getVersion();
            String signo = tp.getSigno();
            int intitmCod = Integer.parseInt(formularioForm.getCodigo());
            String itmVer = formularioForm.getVersion();
            String itmSig = formularioForm.getSigno();
            //String itmCode = formularioForm.getCode();
            if (intCodigo == intitmCod && version == itmVer && signo == itmSig)
            {
                tp.setCodigo(form.getCodigo());
                existe = true;
            } 
        }
        if (!existe)
        {
            tuplas.add(formularioForm);
        } 
        
        Collections.sort(tuplas, new ComparadorNumeros());        
        fwd.addOutputForm(form);
        getRequest().setAttribute("tuplas", tuplas);//obs
        return fwd;
    }
    
    /**
     * @jpf:action
     * @jpf:forward name="success" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "index.jsp")
    })
    protected Forward ShowFilter(FormularioForm form)
    {
        getRequest().setAttribute("formIngresado", formIngresado);
        getRequest().setAttribute("formEliminado", formEliminado);
        
        if (formIngresado.equals("1") || formIngresado.equals("0"))
        {
            form.setCodigo("");
            form.setDescripcion("");
            form.setId("");
            form.setSigno("");
            form.setVersion(""); 
            form.setCode("");
        }
        
        formEliminado = "0";
        formIngresado = "0";
        
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="ShowFilter.do"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "ShowFilter.do")
    })
    protected Forward InsertForm(FormularioForm form)
    {
        FormCmexVO vo = new FormCmexVO();
        BigDecimal resp = null;
        formIngresado = "2";
        
        if (form.getCodigo().equals("") == false && form.getDescripcion().equals("") == false && form.getVersion().equals("") == false && form.getCode().equals("") == false) 
        {
            vo.setCodigo(new BigDecimal(form.getCodigo()));
            vo.setDescripcion(form.getDescripcion());
            vo.setSigno(form.getSigno());
            vo.setVersion(form.getVersion().toUpperCase());
            vo.setCode(form.getCode().toUpperCase());
            
            try
            {
                resp = locator.getPkgCMonExRemote().insFormularios(vo);
                if (resp.equals(null) == false)
                {
                    form.setId(resp.toString());
                    IngresaForm(form);
                    formIngresado = "1";
                }
                else
                {
                    getRequest().setAttribute("msgerrIng", "No se pudo ingresar Formulario, vuelva a intentarlo");
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
                logger.error("Error en el metodo AdministrarFormularios.InsertForm() : " + e);
                getRequest().setAttribute("msgerrIng", "Problemas de conexión al ingresar Formulario");
            }            
        }
        else 
        {
            getRequest().setAttribute("msgerrIng", "Formulario, Versión y Descripción son obligatorios");
        }
        
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="ShowFilter.do"
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "success", path = "ShowFilter.do")
		}
	)
    protected Forward EliminarForm(FormularioForm form)
    {
        Iterator it = tuplas.iterator();
        while (it.hasNext())
        {
            FormularioForm tp = (FormularioForm) it.next();
            if (tp.isSelecc())
            {
                try 
                {
                    FormCmexVO vo = new FormCmexVO();
                    vo.setIdForm(new BigDecimal(tp.getId()));
                    String resp = locator.getPkgCMonExRemote().delFormulario(vo);
                    if (resp.equals("OK"))
                    {
                        formEliminado = "1";                        
                        it.remove();
                    }
                    else
                    {
                        getRequest().setAttribute("msgerrIng", "No se pudo eliminar Formulario, vuelva a intentarlo");
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();                   
                    logger.error("Error en el metodo AdministrarFormularios.EliminarForm() : " + e);
                    getRequest().setAttribute("msgerrIng", "Problemas de conexión al eliminar Formulario");
                }
            }
        }
        FormularioForm formularioForm = new FormularioForm();        
        getRequest().setAttribute("tuplas", tuplas);//obs
        return new Forward("success");
    }

    class ComparadorNumeros implements Comparator {
        public int compare
                (Object o1,
                Object o2)
        {
            int p1,
                    p2;
            FormularioForm I1 = (FormularioForm) o1;
            FormularioForm I2 = (FormularioForm) o2;
            p1 = Integer.parseInt(I1.getCodigo());
            p2 = Integer.parseInt(I2.getCodigo());
            if (p1 == p2)
            {
                return 0;
            }
            if (p1 > p2)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class FormularioForm extends BaseActionForm
    {
        private String code;

        private String codigo;

        private boolean selecc;

        private boolean select;

        private String signo;

        private String descripcion;

        private String version;

        private String formulario;

        private String id;

		public void setId(String id)
        {
            this.id = id;
        }

        public String getId()
        {
            return this.id;
        }

        public void setVersion(String version)
        {
            this.version = version;
        }

        public String getVersion()
        {
            return this.version;
        }

        public void setDescripcion(String descripcion)
        {
            this.descripcion = descripcion;
        }

        public String getDescripcion()
        {
            return this.descripcion;
        }

        public void setSigno(String signo)
        {
            this.signo = signo;
        }

        public String getSigno()
        {
            return this.signo;
        }
        
        public void setSelecc(boolean selecc)
        {
            this.selecc = selecc;
        }

        public boolean isSelecc()
        {
            return this.selecc;
        }

        public void setCodigo(String codigo)
        {
            this.codigo = codigo;
        }

        public String getCodigo()
        {
            return this.codigo;
        }

        public void setCode(String code)
        {
            this.code = code;
        }

        public String getCode()
        {
            return this.code;
        }
    }

	public List getTuplas() {
		return tuplas;
	}

	public void setTuplas(List tuplas) {
		this.tuplas = tuplas;
	}
}