package Administrar.IRAs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.sql.RowSet;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;

import cl.tesoreria.me.locator.PkgCMonExLocator;
import cl.tesoreria.monex.utilesVO.IraCmexVO;

/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{	
	PkgCMonExLocator locator = new PkgCMonExLocator();    
    public ArrayList tuplas = new ArrayList(500);
    private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.ControllerAdministrarIras");
    
    public ArrayList getTuplas() {
		return tuplas;
	}

	public void setTuplas(ArrayList tuplas) {
		this.tuplas = tuplas;
	}

	private String              iraIngresado = "0";
    private String              iraEliminado = "0";

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
    protected Forward begin(IraForm form)
    {
        RowSet iras = null;
        tuplas = new ArrayList(500);
        
        try
        {
            iras = locator.getPkgCMonExRemote().getIras().getRowSet(0);
            boolean isData = iras.first();
            if (isData)
            {
                while (isData) 
                {
                    form.setDescripcion(iras.getString("Descripcion"));
                    String rutIra = iras.getString("Rut");
                    form.setRutIra(rutIra);
                    form.setDvIra(this.getDV(rutIra));
                    form.setIdIra(iras.getString("Id"));
                    form.setIra(iras.getString("Glosa"));
                    IngresaIra(form);
                    isData = iras.next();
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
     * @jpf:forward name="success" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "index.jsp")
    })
    protected Forward ShowFilter(IraForm form)
    {
        getRequest().setAttribute("iraIngresado", iraIngresado);
        getRequest().setAttribute("iraEliminado", iraEliminado);
        
        if (iraIngresado.equals("1") || iraIngresado.equals("0"))
        {
            form.setDescripcion("");
            form.setDvIra("");
            form.setIdIra("");
            form.setRutIra("");
            form.setIra(""); 
        }
        
        iraIngresado = "0";
        iraEliminado = "0";
        
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
    protected Forward IngresaIra(IraForm form)
    {
        Forward fwd = new Forward("success");
        boolean existe = false;
        IraForm iraForm = new IraForm();
        iraForm.setRutIra(form.getRutIra());
        iraForm.setDvIra(form.getDvIra());
        iraForm.setDescripcion(form.getDescripcion().trim());
        iraForm.setIdIra(form.getIdIra());
        iraForm.setIra(form.getIra());
        iraForm.setSelecc(false);
        
        for (Iterator it = tuplas.iterator(); it.hasNext(); )
        {
            IraForm tp = (IraForm)it.next();
            String auxIra = tp.getIra();
            String ira = iraForm.getIra();
            if (auxIra == ira)
            {
                tp.setIra(form.getIra());
                existe = true;
            } 
        }
        if (!existe)
        {
            tuplas.add(iraForm);
        } 
        
        Collections.sort(tuplas, new ComparadorNumeros());
        fwd.addOutputForm(form);
        return fwd;
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="ShowFilter.do"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "ShowFilter.do")
    })
    protected Forward InsertIRAs(IraForm form)
    {
        // Declaración de variables
        IraCmexVO vo = new IraCmexVO();
        BigDecimal resp = null;
        iraIngresado = "2";
        
        // Validación de RUT    
        String Rut = form.getRutIra();
        String RutDv = form.getDvIra();
        if (RutDv.trim().equals("k"))
        {
            RutDv = "K";
        }
        String digitoVerificador;
        if (!Rut.equals(""))
        {
            if (!RutDv.equals(""))
            {
                digitoVerificador = getDV(Rut);
                if (digitoVerificador.equals(RutDv))
                {
                    if (form.getIra().equals("") == false && form.getDescripcion().equals("") == false) 
                    {            
                        vo.setRutIra(new BigDecimal(form.getRutIra()));
                        vo.setDvIra(form.getDvIra());
                        vo.setDescripcion(form.getDescripcion());
                        vo.setGlosa(form.getIra());
                                    
                        try
                        {
                            resp = locator.getPkgCMonExRemote().insIra(vo);
                            if (resp.equals(null) == false)
                            {
                                form.setIdIra(resp.toString());
                                IngresaIra(form);
                                iraIngresado = "1";
                            }
                            else
                            {
                                getRequest().setAttribute("msgerrIng", "No se pudo ingresar IRA, vuelva a intentarlo");
                            }
                        }
                        catch (Exception e) 
                        {
                            e.printStackTrace();
                            logger.error("Error en el metodo AdministrarFormularios.InsertIRAs() : " + e);
                            getRequest().setAttribute("msgerrIng", "Problemas de conexión al ingresar IRA");
                        }
                        
                    }
                    else 
                    {
                        getRequest().setAttribute("msgerrIng", "IRA y Descripción son obligatorios");
                    }                    
                
                }
                else
                { 
                    getRequest().setAttribute("msgerrIng", "Rut Invalido");
                }
            }
            else
            { 
                getRequest().setAttribute("msgerrIng", "Ingresar Digito Verificador");
            }
        }
        else
        { 
            getRequest().setAttribute("msgerrIng", "Ingresar Rut");
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
    protected Forward EliminarIRA(IraForm form)
    {
        Iterator it = tuplas.iterator();
        while (it.hasNext())
        {
            IraForm tp = (IraForm) it.next();
            if (tp.isSelecc())
            {
                try 
                {
                    IraCmexVO vo = new IraCmexVO();
                    vo.setIdIra(new BigDecimal(tp.getIdIra()));
                    String resp = locator.getPkgCMonExRemote().delIra(vo);
                    if (resp.equals("OK"))
                    {
                        iraEliminado = "1";                        
                        it.remove();
                    }
                    else
                    {
                        getRequest().setAttribute("msgerrIng", "No se pudo eliminar IRA, vuelva a intentarlo");
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    logger.error("Error en el metodo AdministrarFormularios.EliminarIRA() : " + e);
                    getRequest().setAttribute("msgerrIng", "Problemas de conexión al eliminar IRA");
                }
            }
        }
        return new Forward("success");
    }

    class ComparadorNumeros implements Comparator 
    {
        public int compare  (Object o1,  Object o2)
        {
            String p1, p2;
            IraForm I1 = (IraForm) o1;
            IraForm I2 = (IraForm) o2;
            p1 = I1.getIra();
            p2 = I2.getIra();
            if (p1.equals(p2))
            {
                return 0;
            }
            if (p1.compareTo(p2) > 0)
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
     * BaseActionForm get and set methods may be overwritten by the Form Bean editor.
     */
    public static class IraForm extends BaseActionForm
    {
        private boolean selecc;

        private String idIra;

        private String dvIra;

        private String descripcion;

        private String rutIra;

        private String ira;        

		public void setIra(String ira)
        {
            this.ira = ira;
        }

        public String getIra()
        {
            return this.ira;
        }

        public void setRutIra(String rutIra)
        {
            this.rutIra = rutIra;
        }

        public String getRutIra()
        {
            return this.rutIra;
        }

        public void setDescripcion(String descripcion)
        {
            this.descripcion = descripcion;
        }

        public String getDescripcion()
        {
            return this.descripcion;
        }

        public void setDvIra(String dvIra)
        {
            this.dvIra = dvIra;
        }

        public String getDvIra()
        {
            return this.dvIra;
        }

        public void setIdIra(String idIra)
        {
            this.idIra = idIra;
        }

        public String getIdIra()
        {
            return this.idIra;
        }

        public void setSelecc(boolean selecc)
        {
            this.selecc = selecc;
        }

        public boolean isSelecc()
        {
            return this.selecc;
        }
    }
    
    /**
     * Se obtiene el Digito Verificador
     */
    public String getDV(String mantisa)
    {
        int x = 0;    
        int ind = 1;//multiplicador
        int Sum = 0;    
        int i = mantisa.length(); 
        while ( i >= 1 )
        {
            ind = ind + 1;
            if (ind == 8)
                ind = 2;
            char n = mantisa.charAt( i-1 );
            String s = new Character(n).toString();
            if ( !(new Double (s)).isNaN() )
                Sum = Sum + Integer .parseInt(s) * ind;
            else
                ind = ind - 1;
            i = i-1;
        }
            
        int resultado = Math.abs(Sum - ((Sum / 11) + 1) * 11);
        String Digito=new String();
        if (resultado==11) 
            Digito = "0";
        else if(resultado==10)
            Digito = "K";
        else
            Digito = (new Integer (resultado)).toString();
        return Digito;
    }
}
