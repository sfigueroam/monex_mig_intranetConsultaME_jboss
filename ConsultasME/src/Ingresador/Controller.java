package Ingresador;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.RowSet;
import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;

import cl.teso.reca.cajasrv.pkgcajaservices.GetItemdescripcionResult;
import cl.teso.reca.cajasrv.pkgcajaservices.PkgCajaServicesRemote;
import cl.teso.reca.pkgcutservicestrx.AdfValidaCaller;
import cl.teso.reca.pkgcutservicestrx.AdfValidaResult;
import cl.teso.reca.pkgcutservicestrx.PkgCutServicesTrxException;
import cl.teso.reca.pkgcutservicestrx.PkgCutServicesTrxRemote;
import cl.teso.reca.pkgcutservicestrx.classes.Messages.ContextADF;
import cl.teso.reca.pkgcutservicestrx.classes.Messages.ItemsADF;
import cl.teso.reca.pkgcutservicestrx.classes.Messages.PagoDeudaPortalResult;
import cl.teso.reca.pkgcutservicestrx.classes.Messages.RecaItems;
import cl.teso.reca.pkgcutservicestrx.classes.Messages.RecaMensajes;
import cl.teso.reca.pkgcutservicestrx.classes.Messages.ValidaADFResult;
import cl.teso.reca.pkgcutservicestrx.classes.Util.TypesUtil;
import cl.tesoreria.me.locator.PkgCMonExLocator;
import cl.tesoreria.me.ws.client.WSRentaMasivaME;
import cl.tesoreria.me.ws.client.WSRentaMasivaMELocator;
import cl.tesoreria.me.ws.client.WSRentaMasivaMESoap;
import cl.tesoreria.monex.utiles.Constantes;
import cl.tesoreria.monex.utiles.XMLProcesosME;
import cl.tesoreria.monex.utilesVO.DatosRutVO;
import cl.tesoreria.monex.utilesVO.EtiquetaCodeVO;
import cl.tesoreria.monex.utilesVO.LLaveCmexVO;
import cl.tesoreria.sii.msgSII.MessageDocument;


/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{
    PkgCMonExLocator locator = new PkgCMonExLocator();    
    private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.ControllerIngresador");
    
    //Llamada al ejb Clientes RECA
    private PkgCutServicesTrxRemote pkgCutServicesTrxRemote;
    private PkgCajaServicesRemote PkgCajaServicesRemote;
    
    public ArrayList            tuplas = new ArrayList(500);
    public String[]             errorArr;
    public String               TotalPlazo;
    public Calendar             fechaHoy;
    
    private transient RowSet    formularios;
    private transient RowSet    iras;
    private String              CODForm = null;
    private String              IDForm = null;
    private String              IRA = null;
    private String              Signo = null;
    private String              Folio = ""; 
    private String              Codigo_Form = null;
    private Long                Rut;
    private String              RutDv;
    private String              paterno;
    private String              materno;
    private String              nombres;
    private String              clienteEncontrado = "";
    private String              validarCliente = "0";
    private String              validarADF = "0";
    private String              respME = "";
    private String              Form_Descripcion = null;
    private String              touplesTGF = "";
    private String              Code;
    private String              MsgDesc;

    public String               fechaHoyFormateada = new String();
    private String              codForm;
    private String              verForm;
    public String              Usuario;
    public String               Tesoreria;
    
    
    
    public ArrayList getTuplas() {
		return tuplas;
	}

	public void setTuplas(ArrayList tuplas) {
		this.tuplas = tuplas;
	}

	public String[] getErrorArr() {
		return errorArr;
	}

	public void setErrorArr(String[] errorArr) {
		this.errorArr = errorArr;
	}

	/**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="ShowFilter.do"
     * @jpf:forward name="error" path="../error.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "ShowFilter.do"), 
        @Jpf.Forward(name = "error",
                     path = "../error.jsp")
    })
    protected Forward begin()
    {
        //ArrayList formularios = new ArrayList();
        //ArrayList iras = new ArrayList();
        
        try
        {
            //formularios = ejbCmexFormularios.GetFormularios();
            //getRequest().setAttribute("FORMS", formularios);   
            formularios = locator.getPkgCMonExRemote().getFormularios().getRowSet(0);
            
            //iras = ejbCmexIras.getTodos();
            iras = locator.getPkgCMonExRemote().getIras().getRowSet(0);
            //getRequest().setAttribute("IRAS", iras); 
                
            
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.Begin() : " + e);
            String msg = "Error en la Aplicacion: " +
                         e.getMessage();
            getRequest().setAttribute("msgerr", msg);
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
    protected Forward IngresaItem(ItemForm form)
    {
        Forward fwd = new Forward("success");
        boolean  existe = false;
        ItemForm itemForm = new ItemForm();
        itemForm.setCodigo(form.getCodigo());
        //if (form.getValor()!=null && form.getValor().trim().length() > 0)
        itemForm.setValor(form.getValor().trim().toUpperCase());
        //else
        //    itemForm.setValor(" ");
        itemForm.setSelecc(true);
        respME = "";
        validarADF = "0";
        
        if (validarCliente.equals("0"))
        {
            CODForm = form.getCodform();
            IRA = form.getIra();
        }
        
        if (!CODForm.equals("") && !IRA.equals(""))
        {
            if (form.getValor() != null && form.getValor().trim().length() > 0)  //(!form.getValor().equals("")) 
            {
                try
                {
                    
                    IDForm = getIDForm(CODForm);
                    Codigo_Form = form.RetornaGlosaCombo(formularios, "Glosa", "Glosa", CODForm);
                    //Codigo_Form = form.getCodform();
                    form.setFormulario(IDForm);
                    
                    String form_code = (String)Codigo_Form;
                    codForm = form_code.substring(0, form_code.length() - 1);
                    verForm = form_code.substring(form_code.length() - 1, form_code.length());
                    
                    BigDecimal itmCod = form.getCodigo();                    
                    
                    
//                    PkgCajaServicesRemote ejbCajaServices = this.locatorPkgCajaServices();                                                           
//                    GetItemdescripcionResult res = ejbCajaServices.getItemdescripcion(new BigDecimal(IDForm), verForm, itmCod);
                    
                    GetItemdescripcionResult res = this.locatorPkgCajaServices(new BigDecimal(IDForm), verForm, itmCod);
                    
                    System.out.println("res: " + res);
                    
                    
                    String itmDesc = res.getOutItemdescripcion();
                    String itemtype = res.getOutItemtype().trim();
                    //logger.info(itmDesc + " : getOutItemtype ==> [" + itemtype + "]");
                    String itmUsage = res.getOutItemusage();
                    String itmPrint = res.getOutItemprint();
                    String itmRep = res.getOutItemrep();
                    itemForm.setDescripcion(itmDesc);
                    itemForm.setItmUsage(itmUsage);
                    itemForm.setItmPrint(itmPrint);
                    
                    if (itmUsage.equals("ApPaterno") || itmUsage.equals("ApMaterno") || itmUsage.equals("Nombres") || itmUsage.equals("Rut"))	
                    //if (itmUsage.equals("Rut"))
                    {
                        if (form.getSwIngresaRut() == 0)
                        {
                            String msg = "Items correspondientes a Datos del Cliente <br> Ingresados en el Cuadro Superior";
                            getRequest().setAttribute("msgerrIng", msg);
                            return new Forward("success");
                        }
                    }
                    
                    for (Iterator it = tuplas.iterator(); it.hasNext(); )
                    {
                        ItemForm tp = (ItemForm)it.next();
                        int intCodigo = tp.getCodigo().intValue(); // Integer.parseInt(tp.getCodigo());
                        int intitmCod = itmCod.intValue(); //Integer.parseInt(itmCod);
                        if (intCodigo == intitmCod && itmRep.equals("0"))
                        {
                            //tp.setValor(form.getValor());
                            existe = true;
                        }  
                    }
                    
                    if (itmUsage.equals("ApPaterno") || itmUsage.equals("ApMaterno") || itmUsage.equals("Nombres"))	
                    {
                        if (form.getSwIngresaRut() == 0)
                        {
                            String msg = "Items correspondientes a Datos del CLiente deben ser ingresados en Cuadro Superior";
                            getRequest().setAttribute("msgerrIng", msg);
                        }
                        else if (!existe)
                        {
                            tuplas.add(itemForm);
                        }
                    }
                    else
                    { 
                        if (!existe)
                        {                        
                            
                            // Valida Decimales
                            if (itemtype.equals("Decimal"))
                            {
                                String val = itemForm.getValor();
                                val = val.replaceAll(",", ".");
                                int punto = val.indexOf(".");
                                if (punto < 1)
                                {
                                    val = val + ".00";
                                }
                                try
                                {
                                    BigDecimal vbd = new BigDecimal(val); 
                                    val = vbd.toString();
                                }
                                catch (Exception e)
                                {
                                	e.printStackTrace();
                                	logger.error("Error en el metodo Ingresador.IngresaItem()1 : " + e);
                                	String msg = "Valor debe ser numero en decimal";
                                    getRequest().setAttribute("msgerrIng", msg);
                                    return new Forward("success");
                                }
                                itemForm.setValor(val);
                                itemForm.setSigno("+");
                            }
                            
                            // Valida tipo Rut
                            if (itemtype.equals("Rut"))
                            {
                                String valRut = itemForm.getValor();
                                valRut = valRut.replaceAll("[.]", "");
                                int punto = valRut.indexOf("-");
                                if (punto < 1)
                                {
                                    String dv = valRut.substring(valRut.length() - 1, valRut.length());
                                    valRut = valRut.substring(0, valRut.length() - 1) + "-" + dv;
                                }
                                itemForm.setValor(valRut);
                                itemForm.setSigno("R");
                            }
                            
                            // Valida tipo Entero
                            if (itemtype.equals("Entero"))
                            {
                                String val = itemForm.getValor();
                                int punto = val.indexOf(".");
                                if (punto >= 1)
                                {
                                    String msg = "Valor debe ser numero entero";
                                    getRequest().setAttribute("msgerrIng", msg);
                                    return new Forward("success");
                                }
                                try
                                {
                                    BigDecimal vbd = new BigDecimal(itemForm.getValor()); 
                                    val = vbd.toString();
                                }
                                catch (Exception e)
                                {
                                	e.printStackTrace();
                                	logger.error("Error en el metodo Ingresador.IngresaItem()2 : " + e);
                                	String msg = "Valor debe ser numero entero";
                                    getRequest().setAttribute("msgerrIng", msg);
                                    return new Forward("success");
                                }
                                itemForm.setSigno("+");
                            }
                            
                            // Valida tipo Fecha
                            if (itemtype.equals("Fecha"))
                            {
                                try
                                {
                                    String val = itemForm.getValor();
                                    val = this.validaFechaStr(val);
                                    itemForm.setValor(val);
                                }
                                catch (Exception e)
                                {
                                	e.printStackTrace();
                                	logger.error("Error en el metodo Ingresador.IngresaItem()3 : " + e);
                                	String msg = "Valor debe tener formato Fecha (DD-MM-AAAA)";
                                    getRequest().setAttribute("msgerrIng", msg);
                                    return new Forward("success");
                                }
                            }
                            
                            // Valida tipo Periodo
                            if (itemtype.equals("Periodo"))
                            {
                                try 
                                {
                                    String val = itemForm.getValor();
                                    val = this.validaPeriodoStr(val);
                                    itemForm.setValor(val);
                                }
                                catch (Exception e)
                                {
                                	e.printStackTrace();
                                	logger.error("Error en el metodo Ingresador.IngresaItem()4 : " + e);
                                	String msg = "Valor debe tener formato de Periodo (MM-AAAA)";
                                    getRequest().setAttribute("msgerrIng", msg);
                                    return new Forward("success");
                                }
                            }
                            
                            
                            tuplas.add(itemForm);
                            
                            if (itemForm.getCodigo().intValue() == 7)
                            {
                                Folio = itemForm.getValor().trim();
                            }
                        }
                        else
                        {
                            String msg = "Codigo ingresado anteriormente";
                            getRequest().setAttribute("msgerrIng", msg);
                            return new Forward("success");
                        }
                    }  
                }
                catch (Exception e)
                {
                	e.printStackTrace();
                	logger.error("Error en el metodo Ingresador.IngresaItem()5 : " + e);
                    String msg = "Error -  Item no definido en el formulario";
                    getRequest().setAttribute("msgerrIng", msg);
                }
                
            }
            else
            { 
                getRequest().setAttribute("msgerrIng", "Ingresar Valor");
            }
        }
        else
        { 
            getRequest().setAttribute("msgerrIng", "Ingresar Formulario");
        }
        
        Collections.sort(tuplas, new ComparadorNumeros());        
        fwd.addOutputForm(form);
        return fwd;
        
        //return new Forward("success");
    }


    /**
     * @jpf:action
     * @jpf:forward name="success" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "index.jsp")
    })
    protected Forward ShowFilter(ItemForm form)
    {
        getRequest().setAttribute("validarCliente", validarCliente);
        getRequest().setAttribute("clienteEncontrado", clienteEncontrado);
        getRequest().setAttribute("validarADF", validarADF);
        getRequest().setAttribute("respME", respME);
        
        try 
        {
            if (formularios == null)
            {
                formularios = locator.getPkgCMonExRemote().getFormularios().getRowSet(0);
            }
            if (iras == null)
            {
                iras = locator.getPkgCMonExRemote().getIras().getRowSet(0);
            }
            
            form.setCodformOptions(new ResultSetMap(formularios, "Glosa", "Glosa", false));
            form.setIraOptions(new ResultSetMap(iras, "Glosa", "Descripcion", false));
            getRequest().setAttribute("validarCliente", validarCliente);
            getRequest().setAttribute("clienteEncontrado", clienteEncontrado);
            form.setCodigo(null);
            form.setValor("");
            respME = "";
            
            if (CODForm != null)
            {		
                form.setCodform(CODForm);
                form.setFormulario(getIDForm(CODForm));
            }
            if (IRA != null)
            {		
                form.setIra(IRA);
            }
            if (Signo != null)
            {
                form.setSigno(Signo);
            }
            if (paterno != null)
            {		
                form.setPaterno(paterno);
            }
            if (materno != null)
            {		
                form.setMaterno(materno);
            }
            if (nombres != null)
            {		
                form.setNombres(nombres);
            }
            if (Rut != null)
            {		
                form.setRut(Rut);
            }
            if (RutDv != null)
            {		
                form.setDv(RutDv);
            }
            
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.ShowFilter() : " + e);
            String msg = "Error en la Aplicacion: " +
                         e.getMessage();
            getRequest().setAttribute("msgerr", msg);
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
    protected Forward IngresaRut(ItemForm form)
    {
        Forward fwd = new Forward("success");
        CODForm = form.getCodform();
        IRA = form.getIra();
        Signo = form.getSigno();
        String msg = "";
        try
        {
            if (!CODForm.equals("") && !IRA.equals(""))
            {
                // Valida Formulario y Signo
                EtiquetaCodeVO etiquetaCodeVO = this.getEtiquetaCode(CODForm, Signo);
                if (!etiquetaCodeVO.getCode().equals(" "))
                {
                    Code = etiquetaCodeVO.getCode();
                    MsgDesc = etiquetaCodeVO.getMsgDesc();    
                       
                    IDForm = getIDForm(CODForm);
                    //String codPaterno = ejbCajaServices.getItmCodeUsage(new BigDecimal(IDForm), "ApPaterno").getReturnValue().toString();
                    Rut = form.getRut();
                    RutDv = form.getDv();
                    if (RutDv.trim().equals("k"))
                    {
                        RutDv = "K";
                    }
                    
                    String digitoVerificador;
                    if (Rut != null)
                    {
                        if (!RutDv.equals(""))
                        {
                            String rutStr = Rut.toString();
                            digitoVerificador = getDV(rutStr);
                            if (digitoVerificador.equals(RutDv))
                            {
                                DatosRutVO datosRutVO = locator.getPkgCMonExRemote().getDatosRut(new BigDecimal(Rut.toString()));
                                if (datosRutVO != null)
                                {
                                    paterno = datosRutVO.getAPaterno();
                                    materno = datosRutVO.getAMaterno();			
                                    nombres = datosRutVO.getNombre();
                                    clienteEncontrado = "1";
                                }	
                                else 
                                {
                                    clienteEncontrado = "0";
                                    paterno = form.getPaterno();
                                    materno = form.getMaterno();				
                                    nombres = form.getNombres();
                                }
                                if (paterno == null)
                                {
                                    paterno = "";
                                }
                                if (materno == null)
                                {
                                    materno = "";
                                }
                                if (nombres == null)
                                {
                                    nombres = "";
                                }
                                if (!paterno.trim().equals(""))
                                {
                                    validarCliente = "1";
                                }
                                if (clienteEncontrado.equals("0") && paterno.equals(""))
                                {
                                    getRequest().setAttribute("msgerrIng", "Cliente no encontrado en la base de datos. Ingrese datos de identificación");                                
                                }
                                
                                if (validarCliente.equals("1"))
                                {
                                    
                                    //if (!codPaterno.equals("-1") && !paterno.equals("") && paterno != null)
                                    if (!paterno.equals("") && paterno != null)
                                    {
                                        //form.setCodigo(codPaterno);
                                        form.setCodigo(new BigDecimal(1));
                                        form.setValor(paterno);
                                        form.setSwIngresaRut(1);
                                        IngresaItem(form);
                                    }
                                    
                                    //if (!codMaterno.equals("-1") && !materno.equals("") && materno != null)
                                    if (!materno.equals("") && materno != null)
                                    {
                                        form.setCodigo(new BigDecimal(2));
                                        form.setValor(materno);
                                        form.setSwIngresaRut(1);
                                        IngresaItem(form);
                                    }
                                    
                                    form.setCodigo(new BigDecimal(3));
                                    form.setValor(Rut + "-" + RutDv);
                                    form.setSwIngresaRut(1);
                                    IngresaItem(form);
                                    
                                    //if (!codNombres.equals("-1") && !nombres.equals("") && nombres != null)
                                    if (!nombres.equals("") && nombres != null)
                                    {
                                        form.setCodigo(new BigDecimal(5));
                                        form.setValor(nombres);
                                        form.setSwIngresaRut(1);
                                        IngresaItem(form);	
                                    }	
                                }
                            }
                            else
                            { 
                                getRequest().setAttribute("msgerrIng", "Rut Invalido");
                                //form = quitardatosRut(form, codPaterno, codMaterno, codNombres, codRut);
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
                }
                else
                {
                    getRequest().setAttribute("msgerrIng", "Formulario y Signo no coinciden con los registros");
                }
            }
            else
            {  
                getRequest().setAttribute("msgerrIng", "Ingresar Formulario y/o IRA");
            }
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.IngresaRut() : " + e);
            msg = "Error al tratar de Ingresar Rut";
            getRequest().setAttribute("msgerrIng", msg);
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
    protected Forward Actualizar(ItemForm form)
    {
        Iterator it = tuplas.iterator();
        validarADF = "0";
        while (it.hasNext())
        {
            ItemForm tp = (ItemForm)it.next();
            if (!tp.isSelecc())
            {
                if (tp.getItmUsage().equals("ApPaterno") || tp.getItmUsage().equals("ApMaterno") || tp.getItmUsage().equals("Nombres") || tp.getCodigo().equals("3"))
                {
                    tp.setSelecc(true);

                    String msg = "Error -  Item correspondiente a Datos del Cliente no puede ser modificado";
                    getRequest().setAttribute("msgerrIng", msg);
                }
                else
                {
                    it.remove();
                }
            }
        }        
        return new Forward("success");
    }

    /**
     * @jpf:action
     * 
     * @jpf:forward name="error"  path="ShowFilter.do"
     * @jpf:forward name="success" path="ShowFilter.do"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "error",
                     path = "ShowFilter.do"), 
        @Jpf.Forward(name = "success",
                     path = "ShowFilter.do")
    })
    protected Forward ValidaADF(ItemForm form)
    {
        // Incorpora item 8860 -> MANUAL
        form.setCodigo(new BigDecimal(8860));
        form.setValor("MANUAL");
        IngresaItem(form);
        
        String newMsg;
        errorArr = null;        
        String msg = "";    
        Iterator it = tuplas.iterator();
        //Validation validation = new Validation();
        form.setFormdescr(Form_Descripcion);
        form.setFrm_name(Codigo_Form);
        
        double valorItm;
        if (!it.hasNext())
        {
            msg = "Ingresar Item";
            getRequest().setAttribute("msgerr", msg);
            return new Forward("error");
        }
        
        
        fechaHoy = Calendar.getInstance();
        String form_code = (String)Codigo_Form;
        codForm = form_code.substring(0, form_code.length() - 1);
        verForm = form_code.substring(form_code.length() - 1, form_code.length());
            
        form.setFormulario(codForm);
        
        ContextADF contextADF = new ContextADF();
        logger.info("ContextADF ==>");
        contextADF.setFechaCaja(fechaHoy);
        logger.info("getFechaCaja: " +
                    contextADF.getFechaCaja().getTime().toLocaleString());
        contextADF.setFormCod(new BigDecimal(codForm));
        logger.info("getFormCod: " +
                    contextADF.getFormCod().toString());
        contextADF.setFormVer(verForm);
        logger.info("getFormVer: " +
                    contextADF.getFormVer());
        //contextADF.setFormVig(fechaHoy);
        //logger.info("getFormVig: " + contextADF.getFormVig().getTimeZone().toString());
        
        RecaItems[] recaItems = new RecaItems[tuplas.size()];
        logger.info("RecaItems ==>");
        
        
        for (int i = 0; it.hasNext(); i++)
        {                 
            ItemForm tp = (ItemForm)it.next();
            recaItems[i] = new RecaItems();
            recaItems[i].setCodigo(tp.getCodigo());
            recaItems[i].setValor(tp.getValor());              
            logger.info("[" +
                        recaItems[i].getCodigo().toString() +
                        "] : " +
                        recaItems[i].getValor());
        }    
        
        try 
        {
        	
        	System.out.println("VALIDA SIIIII 2!!!!!!!!!!!!!!!");
        	
//        	PkgCutServicesTrxRemote cutServices = this.locatorPkgCutServices();        
        	logger.info("Conectado a PkgCutServicesTrxRemote...");
        	
            // Se ejecuta EJB procesar 
//            ValidaADFResult result= cutServices.validaADF("TGR", contextADF, recaItems);
        	
        	ValidaADFResult result= validaADF("TGR", contextADF, recaItems);
            
            logger.info("ValidaADF OK");
            
            int resultado = result.getResultCode().intValue();
            String mensaje = result.getResultMessage();
            logger.info("Mensaje ValidaADFResult: [" +
                        resultado +
                        "] " +
                        mensaje);
            
            RecaMensajes[] recaMensajes = result.getRecaMensajes();

            if (recaMensajes != null) 
            {
                errorArr = new String[recaMensajes.length];
                for (int i=0; i < recaMensajes.length; i++) 
                {
                    //String glosaErr = recaMensajes[i].getGlosa();
                    //BigDecimal tipoErr = recaMensajes[i].getTipo();
                    //BigDecimal codErr = recaMensajes[i].getCodigo();
                    String objName = recaMensajes[i].getObjName();
                    String objValue = recaMensajes[i].getObjValue();
                    //logger.info("getErrMsg: " + recaMensajes[i].getErrMsg());
                    //logger.info("getGlosa: " + recaMensajes[i].getGlosa());
                    //logger.info("getObjDescrip: " + recaMensajes[i].getObjDescrip());
                    //logger.info("getObjValue: " + recaMensajes[i].getObjValue());
                    //logger.info("getObjName: " + recaMensajes[i].getObjName());
                    //String error = tipoErr.toString()+" - "+codErr.toString()+" - "+glosaErr+" - "+objName+" - "+objValue;
                    //logger.info(error);
                    String error = objName + " - " + recaMensajes[i].getObjDescrip();
                    //String error = "["+i+1+"] " + recaMensajes[i].getObjDescrip();
                    //logger.info(error);
                    errorArr[i] = error;
                }
            }
            
            if (resultado > 1)
            {         
                msg = " ";
                getRequest().setAttribute("msgerr", msg);
                return new Forward("error");
            }  
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.ValidaADF() : " + e);
            msg = "Problemas de conexión con los Servicios CUT";
            getRequest().setAttribute("msgerr", msg);
            return new Forward("error");
        }     
        
        validarADF = "1";
        //getRequest().setAttribute("validarADF", validarADF);        
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
    protected Forward NuevoFormulario(ItemForm form)
    {
        ItemForm itemForm = new ItemForm();
        try
        {
            if (formularios == null)
            {
                formularios = locator.getPkgCMonExRemote().getFormularios().getRowSet(0);
            }
            if (iras == null)
            {
                iras = locator.getPkgCMonExRemote().getIras().getRowSet(0);
            }
            
            itemForm.setCodformOptions(new ResultSetMap(formularios, "Glosa", "Glosa", false));
            itemForm.setIraOptions(new ResultSetMap(iras, "Glosa", "Descripcion", false));
            CODForm = null;
            Codigo_Form = null;
            Rut = null;
            RutDv = null;
            Signo = null;
            respME = "";
            paterno = null;
            materno = null;
            nombres = null;
            codForm = null;
            touplesTGF = "";
            verForm = null;
            Code = null;
            MsgDesc = null;
            //ErrLevel = null;
            //MessagesTgf = null;
            tuplas.clear();
            //arEnviado = "0";	
            validarCliente = "0";
            getRequest().setAttribute("validarCliente", validarCliente);
            clienteEncontrado = "";
            getRequest().setAttribute("clienteEncontrado", clienteEncontrado);
            //in_codigobarras = "0";
            //itemsCut = "";            
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.NuevoFormulario() : " + e);    
            String msg = "Error en la Aplicacion: " +
                         e.getMessage();
            getRequest().setAttribute("msgerr", msg);
        } 
        
        Forward fwd = new Forward("success");
        fwd.addOutputForm(itemForm);
        return fwd;
    }

    /**
     * @jpf:action
     * 
     * @jpf:forward name="success" path="ShowFilter.do"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "ShowFilter.do")
    })
    protected Forward EnviaForm(ItemForm form)
    {
        // Declaracion de Variables
        String xmlOut = null;
        String aprobacion = "OK";
        String numberTrx = null;
        //String xXx = "???";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        SimpleDateFormat pcontable = new SimpleDateFormat("yyyyMM");
        
        // Obtiene el Numero de Transaccion ME
        try
        {
            numberTrx = locator.getPkgCMonExRemote().getSeqNumTrx();
        }
        catch (Exception e) 
        { 
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.EnviaForm() : " + e);
            String msg = "Problemas al Generar XML etiqueta Number";
            getRequest().setAttribute("msgerr", msg);
        }
        
        if (numberTrx != null)
        {
        
            // Obtiene el Periodo
            String periodo = this.getPeriodo();
            
            // Obtiene etiquetas Code y MsgDesc
            //EtiquetaCodeVO etiquetaCodeVO = new EtiquetaCodeVO();
            //logger.info("EnviaForm --> CODForm: " + CODForm);
            //etiquetaCodeVO = this.getEtiquetaCode(CODForm, Signo);
            
            // Obtiene el RUT de la IRA
            String rutIra = this.getRutIRA(IRA);
            String dvIra = this.getDV(rutIra);
            
            // Signo
            if (Signo == null)
            {
                Signo = " ";
            }
            
            // Comienza el XML <Message> 
            xmlOut = "<Message>";
                    
            // Agrega XML <MessageId> 
            xmlOut = xmlOut + " <MessageId>";
            xmlOut = xmlOut + "  <Code>" + Code + "</Code>";
            xmlOut = xmlOut + "  <MsgDesc>" + MsgDesc + "</MsgDesc>";
            xmlOut = xmlOut + "  <Version>" + 1 + "</Version>";
            xmlOut = xmlOut + "  <FechaVersion>" + formatter.format(new Date()) + "</FechaVersion>";
            xmlOut = xmlOut + "  <FromAddress>TGR</FromAddress>";
            xmlOut = xmlOut + "  <ToAddress>TESORERIA</ToAddress>";
            xmlOut = xmlOut + "  <RefAddress>000</RefAddress>";
            xmlOut = xmlOut + "  <DateTime>" + formatter.format(new Date()) + "</DateTime>";
            xmlOut = xmlOut + "  <Validado>INT</Validado>";
            xmlOut = xmlOut + "  <Number>" + numberTrx + "</Number>";
            xmlOut = xmlOut + "  <PeriodoContable>" + pcontable.format(new Date()) + "</PeriodoContable>";
            xmlOut = xmlOut + " </MessageId>";
            
            // Abre XML <Formulario> 
            xmlOut = xmlOut + " <Formulario nro='1'>";
            
            // Agrega XML <Identificacion> 
            xmlOut = xmlOut + "  <Identificacion>";
            xmlOut = xmlOut + "   <RutIra>" + rutIra + "</RutIra>";
            xmlOut = xmlOut + "   <DvIra>" + dvIra + "</DvIra>";
            xmlOut = xmlOut + "   <FolioF01>0000000000</FolioF01>";
            xmlOut = xmlOut + "   <Formulario>" + getCodForm(CODForm, Signo) + "</Formulario>";
            xmlOut = xmlOut + "   <Periodo>" + periodo + "</Periodo>";
            xmlOut = xmlOut + "   <FolioDecl>" + Folio + "</FolioDecl>";
            xmlOut = xmlOut + "   <Signo>" + Signo + "</Signo>";
            xmlOut = xmlOut + "   <RutContr>" + form.getRut() + "</RutContr>";
            xmlOut = xmlOut + "   <DvContr>" + form.getDv() + "</DvContr>";
            xmlOut = xmlOut + "   <MarcaFisc>0</MarcaFisc>";
            xmlOut = xmlOut + "   <GlosaFisc> </GlosaFisc>";
            xmlOut = xmlOut + "   <MontoRet>00000000000000</MontoRet>";
            xmlOut = xmlOut + "   <SignoMontoImp>+</SignoMontoImp>";
            xmlOut = xmlOut + "   <MontoImp>00000000000000</MontoImp>";
            xmlOut = xmlOut + "   <SignoMontoPag>+</SignoMontoPag>";
            xmlOut = xmlOut + "   <MontoPago>00000000000000</MontoPago>";
            xmlOut = xmlOut + "  </Identificacion>";
            
            // Agrega XML <ListaCodigos> 
            xmlOut = xmlOut + "  <ListaCodigos>";
                        
            // Agrega XML <Codigos>
            Iterator it = tuplas.iterator();
            int i;
            for (i = 1; it.hasNext(); i++)
            {                 
                ItemForm tp = (ItemForm)it.next();
                
                String signo = " ";
                String contenido = this.quitarCaracExt(tp.getValor().trim());
                BigDecimal valor = new BigDecimal(0);
                if (tp.getSigno() != null)
                {
                    try 
                    {
                    	System.out.println("tp.getValor(): "+tp.getValor());
                    	if (tp.getSigno() == "R")
                        {
                            contenido = this.rutToNumber(contenido);
                             valor = new BigDecimal(contenido);
                        } 
                    	else
                    	{
                    		 valor = new BigDecimal(tp.getValor().trim());
                    	}
                        if (valor.signum() == 1 || valor.signum() == 0) 
                        { 
                            signo = "+"; 
                        }
                        if (valor.signum() == -1)
                        { 
                            contenido = valor.abs().toString();// contenido.substring(1,contenido.length());
                            signo = "-"; 
                        }
                    } 
                    catch (Exception ex) 
                    {
                    	ex.printStackTrace();
                    	logger.error("Error en el metodo Ingresador.EnviaForm()1 : " + ex);
                    	signo = " ";
                    }
                }  
                
                //BigDecimal tpCod = new BigDecimal(tp.getCodigo());
                if (tp.getSigno() == "R")
                {
                    contenido = this.rutToNumber(contenido);
                }              
                
                int largo = contenido.length();
                String contenido2 = null;
                for (int fin = contenido.length(); fin > 0; fin = fin - 15)
                {     

                    xmlOut = xmlOut + "   <Codigos nro='" + i + "'>";
                    xmlOut = xmlOut + "    <Codigo>" + tp.getCodigo() + "</Codigo>";
                    xmlOut = xmlOut + "    <Signo>" + signo + "</Signo>";
                                                                            
                    if (largo > 15)
                    {
                        contenido2 = contenido.substring(0, 15);
                        contenido = contenido.substring(15, largo);                        
                        largo = contenido.length();
                        i++;
                    }
                    else
                    {
                        contenido2 = contenido;
                    }
                    
                    if (signo.equals(" "))
                    {
                        contenido2 = rellenarDatosDer(contenido2, 15, " ");
                    }
                    else
                    {
                        contenido2 = rellenarDatosIzq(contenido2, 15, "0");
                    }
                    
                    xmlOut = xmlOut + "    <Contenido>" + contenido2 + "</Contenido>";
                    xmlOut = xmlOut + "   </Codigos>"; 
                    
                }               
            }             
            
            // Cierra XML <ListaCodigos>
            xmlOut = xmlOut + "  </ListaCodigos>";
            
            // Cierra XML <Formulario>
            xmlOut = xmlOut + " </Formulario>";
            
            // Cierra XML <Message> 
            xmlOut = xmlOut + "</Message>";
            
            // Reemplaze los simbolos \\B6 por salto de lineas
            //xmlOut = xmlOut.replaceAll("\\B6","\n");
//            xmlOut = xmlOut.replaceAll("\\B6", "");
            
            // Se envia Mensaje a CUT AIX ME
            //String resp = EnviaMensajeME.enviador(xmlOut);
            //String resp = controlRentaMasivaME.receiverXML(xmlOut);
            String resp = invocarRentaMonexClient(xmlOut);
            logger.info("Respuesta WSRentaMasivaME ==> " +
                        resp);
            
            if (resp == null)
            {
                respME = "Problemas en el envio a la CUT AIX ME <br> Favor de intentar nuevamente";
            } 
            else if (resp.equals("NOK") || resp.equals("ok"))
            {
                respME = "Formulario no definido <br> Contactar al Administrador del Sistema ";                
            } 
            else
            {
                // Se valida estructura del XML
                MessageDocument xmlResp = null;
                boolean parser;
                XMLProcesosME procesos = new XMLProcesosME();
                String msg = null;
                
                try 
                {
                    //Parsea y carga XML dentro de un MessageDocument
                    xmlResp = procesos.ParserMessage(resp);
                } 
                catch (Exception ex) 
                {    
                	ex.printStackTrace();
                	logger.error("Error en el metodo Ingresador.EnviaForm()2 : " + ex);
                    respME = "Estructura XML es invalida: " +
                             ex +
                             "<br> Contactar al Administrador del Sistema";
                }
                 
                // Procesamiento del XML
                try
                {
                    if (xmlResp != null)
                    {
                    
                        //Extrae dato etiqueta "<Resultado>"
                        MessageDocument.Message.Resultado resultado = xmlResp.getMessage().getResultado();
                        respME = resultado.getAprobacion();
                        logger.info("resultado.getAprobacion() => " +
                                    respME);
                        
                        try
                        {
                            // Variables de usuario Intranet conectado
                            Usuario = this.getRequest().getRemoteUser();
                            String UsuarioDv = this.getDV(Usuario);
                            logger.info("Usuario TGR: [" +
                                        Usuario +
                                        "-" +
                                        UsuarioDv +
                                        "]");
                            // Inserta datos de Auditoria Tabla SII_AUDITORIA_ME
                            String Auditoria = locator.getPkgCMonExRemote().insAuditoriaME(new BigDecimal(Usuario), UsuarioDv, new BigDecimal(numberTrx));
                            logger.info("Auditoria: [" +
                                        Auditoria +
                                        "]");
                        }
                        catch (Exception ex)
                        {
                        	ex.printStackTrace();
                        	logger.error("Error en el metodo Ingresador.EnviaForm()3 : " + ex);
                        }
                    
                        // Se extraen lo errores
                        if (respME.equals("NOK"))
                        {
                            errorArr = procesos.ExtraerErrores(xmlResp);
                            
                            if (errorArr == null) 
                            {
                                respME = "No se puede interpretar la Respuesta del Envio";
                            } 
                            else
                            {
                                msg = " ";
                                getRequest().setAttribute("msgerr", msg);
                                
                            }
                        }
                    }
                    else
                    {
                        respME = "Respuesta del sistema con error de sintaxis <br> Intentelo nuevamente";
                    }
                }    
                catch (Exception ex)
                {
                	ex.printStackTrace();
                	logger.error("Error en el metodo Ingresador.EnviaForm()4 : " + ex);
                	respME = "Error interno del servicio TGR para enviar el Formulario <br> Intentelo nuevamente";
                }
            } 
    
            getRequest().setAttribute("respME", respME);
        }
        
        //logger.info("respME ==> " + respME);
        Forward fwd = new Forward("success");
        fwd.addOutputForm(form);
        return fwd;
    }
    
    private String invocarRentaMonexClient(String msg)
    {
    	
    	logger.info("\n------------------------------------------>>>>>>>>>>>invocarRentaMonexClient<<<<<<<<<<<------------------------\n");
        String msgOut="";
        logger.info("Mensaje Salida: " + msg);
        
        try
        {        	
        	/*
        	
            WSRentaMasivaME_Impl impl = new WSRentaMasivaME_Impl(Constantes.URL_WS);
            WSRentaMasivaMESoap msoap = impl.getWSRentaMasivaMESoap();
            msgOut = msoap.receiverXML(msg);
            */
        	Constantes.cargarArchivoME();
            logger.info("WS_ENDPOINT_URL_WSRENTAMASIVAME=" + Constantes.WS_ENDPOINT_URL_WSRENTAMASIVAME);            
            
			WSRentaMasivaME service = new WSRentaMasivaMELocator();				
			WSRentaMasivaMESoap port = service.getWSRentaMasivaMESoap(new URL(Constantes.WS_ENDPOINT_URL_WSRENTAMASIVAME));
//			WSRentaMasivaMESoap port = service.getWSRentaMasivaMESoap(new URL(Constantes.URL_WS));			
        	msgOut = port.receiverXML(msg);            
        }        
        catch(Exception ex)
        {
        	ex.printStackTrace();
        	logger.error("Error en el metodo Ingresador.invocarRentaMonexClient() : " + ex);
        }                
        return msgOut;
    }     

    /**
     * @jpf:action
     * @jpf:forward name="success" path="ShowFilter.do"
     * @jpf:forward name="error" path="NuevoFormulario.do"
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "success", path = "ShowFilter.do"), 
			@Jpf.Forward(name = "error", path = "NuevoFormulario.do")
		}
	)
    protected Forward goLLaves(ItemForm form)
    {
        Forward fwd = new Forward("success");
        
        Folio = form.getFolio();
        String Fvenc = form.getFvenc();
        
        if (validarCliente.equals("0"))
        {
            CODForm = form.getCodform();
            IRA = form.getIra();
        }
        Signo = form.getSigno();
        String msg = "";
        
        if (!CODForm.equals("") && !IRA.equals(""))
        {
            // Valida Formulario y Signo
            EtiquetaCodeVO etiquetaCodeVO = this.getEtiquetaCode(CODForm, Signo);
            if (!etiquetaCodeVO.getCode().equals(" "))
            {
                Code = etiquetaCodeVO.getCode();
                MsgDesc = etiquetaCodeVO.getMsgDesc();       
                
                if (Code.equals("RECAINME") && Signo.equals("-"))
                {
                    Code = "RECTIF";
                    MsgDesc = "RECTIFICATORIA";
                }
                    
                IDForm = getIDForm(CODForm);
                
                Rut = form.getRut();
                RutDv = form.getDv();
                if (RutDv.trim().equals("k"))
                {
                    RutDv = "K";
                }
                
                String digitoVerificador;
                if (Rut != null)
                {
                    if (!RutDv.equals(""))
                    {
                        String rutStr = Rut.toString();
                        digitoVerificador = getDV(rutStr);
                        if (digitoVerificador.equals(RutDv))
                        {
                            if (!Folio.equals("") && !Fvenc.equals(""))
                            {
                                // se valida el formato de la Fecha como AAAAMMDD
                                try 
                                {
                                    if (Fvenc.length() >= 8)
                                    {
                                        Fvenc = validaFechaStr(Fvenc);
                                    }
                                    else
                                    {
                                        Fvenc = validaPeriodoStr(Fvenc);
                                    }
                                } 
                                catch (Exception e)
                                {
                                	e.printStackTrace();
                                	logger.error("Error en el metodo Ingresador.goLllaves() : " + e);
                                	msg = "Fecha Vencimiento debe tener formato Fecha (DD-MM-AAAA)";
                                    getRequest().setAttribute("msgerrIng", msg);
                                    return new Forward("success");
                                }
                                
                                LLaveCmexVO vo = new LLaveCmexVO();
                                vo.setRut(new BigDecimal(Rut.toString()));
                                vo.setFormulario(new BigDecimal(IDForm));
                                vo.setFolio(new BigDecimal(Folio));
                                vo.setFvenc(new BigDecimal(Fvenc));

                                try
                                {
                                    ArrayList result = locator.getPkgCMonExRemote().getMovimientos(vo);
                                    if (result != null)
                                    {
                                        for (int i=0; i < result.size(); i++)
                                        {
                                            String[] valores = (String[]) result.get(i);
                                            logger.info("getCodigo: " + valores[0]);
                                            form.setCodigo(new BigDecimal(valores[0]));
                                            if (form.getCodigo().intValue() != 9939) {
                                                logger.info("getValor: [" + valores[1] + "]");
                                                form.setValor(valores[1]);
                                                form.setSwIngresaRut(1);
                                                IngresaItem(form);
                                            }
                                        }
                                        validarCliente = "1";
                                        clienteEncontrado = "1";
                                    } 
                                    else 
                                    {
                                        msg = "No existe la primitiva";
                                        getRequest().setAttribute("msgerrIng", msg);
                                        return new Forward("error");
                                    } 
                                }
                                catch (Exception e) 
                                { 
                                	e.printStackTrace();
                                	logger.error("Error en el metodo Ingresador.goLllaves()1 : " + e);
                                    msg = "Problemas al obtener la primitiva, vuelva a intentarlo";
                                    getRequest().setAttribute("msgerrIng", msg);
                                    return new Forward("error");
                                } 
                            }
                            else
                            {
                                getRequest().setAttribute("msgerrIng", "Debe ingresar todos los datos solicitados");
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
            }
            else
            {
                getRequest().setAttribute("msgerrIng", "Formulario y Signo no coinciden con los registros");
            }
            
        }
        else
        {  
            getRequest().setAttribute("msgerrIng", "Ingresar Formulario y/o IRA");
        }
        
        Collections.sort(tuplas, new ComparadorNumeros());        
        fwd.addOutputForm(form);
        return fwd;
        //return new Forward("success");

    }

    /**
     * BaseActionForm get and set methods may be overwritten by the Form Bean editor.
     */
    public static class ItemForm extends BaseActionForm
    {
        private String fvenc;

        private String folio;

        private String rut2;

        private String folio01;

        private String frm_name;

        private String formdescr;

        private String itmPrint;

        private String itmUsage;

        private String descripcion;

        private boolean selecc;

        private int swIngresaRut;

        private String paterno;

        private String materno;

        private String nombres;

        private String aMaterno;

        private String aPaterno;

        private BigDecimal codigo;

        private Map iraOptions;

        private String valor;

        private String codform;

        private String ofForm;

        private Map codformOptions;

        private String ira;

        private String dv;

        private Long rut;

        private String signo;

        private String formulario;

        private List numForm;
              
		public void setFormulario(String formulario)
        {
            this.formulario = formulario;
        }

        public String getFormulario()
        {
            return this.formulario;
        }

        public void setSigno(String signo)
        {
            this.signo = signo;
        }

        public String getSigno()
        {
            return this.signo;
        }

        public void setRut(Long rut)
        {
            this.rut = rut;
        }

        public Long getRut()
        {
            return this.rut;
        }

        public void setDv(String dv)
        {
            this.dv = dv;
        }

        public String getDv()
        {
            return this.dv;
        }
        
        public String RetornaGlosaCombo
                (ResultSet RS,
                String CampoID,
                String CampoGlosa,
                String ValBuscar)  throws SQLException
        {
            Object RecordSetID;
            Object RecordSetGlosa;
            int icolBound = RS.findColumn(CampoID);
            int icolDisplay = RS.findColumn(CampoGlosa);
            //BigDecimal LlaveRS = new BigDecimal("0");
            String LlaveRS = "0";
            //BigDecimal LlaveCM = new BigDecimal(ValBuscar);
            String LlaveCM = ValBuscar; 
            RS.first();
            do
            {
                RecordSetID = RS.getObject(icolBound);
                RecordSetGlosa = RS.getObject(icolDisplay);
                LlaveRS = (String) RecordSetID;
                if (LlaveRS.compareTo(LlaveCM) == 0)
                {
                    return (String) RecordSetGlosa; 
                }                                                        
            } while (RS.next());
            return "";
        }

        public void setIra(String ira)
        {
            this.ira = ira;
        }

        public String getIra()
        {
            return this.ira;
        }

        public void setCodformOptions(Map codformOptions)
        {
            this.codformOptions = codformOptions;
        }

        public Map getCodformOptions()
        {
            // For data binding to be able to post data back, complex types and
            // arrays must be initialized to be non-null.
            if(this.codformOptions == null)
            {
                this.codformOptions = new HashMap();
            }

            return this.codformOptions;
        }

        public void setCodform(String codform)
        {
            this.codform = codform;
        }

        public String getCodform()
        {
            return this.codform;
        }

        public void setValor(String valor)
        {
            this.valor = valor;
        }

        public String getValor()
        {
            return this.valor;
        }

        public void setIraOptions(Map iraOptions)
        {
            this.iraOptions = iraOptions;
        }

        public Map getIraOptions()
        {
            // For data binding to be able to post data back, complex types and
            // arrays must be initialized to be non-null.
            if(this.iraOptions == null)
            {
                this.iraOptions = new HashMap();
            }

            return this.iraOptions;
        }

        public void setCodigo(BigDecimal codigo)
        {
            this.codigo = codigo;
        }

        public BigDecimal getCodigo()
        {
            return this.codigo;
        }

        public void setNombres(String nombres)
        {
            this.nombres = nombres;
        }

        public String getNombres()
        {
            return this.nombres;
        }

        public void setMaterno(String materno)
        {
            this.materno = materno;
        }

        public String getMaterno()
        {
            return this.materno;
        }

        public void setPaterno(String paterno)
        {
            this.paterno = paterno;
        }

        public String getPaterno()
        {
            return this.paterno;
        }

        public void setSwIngresaRut(int swIngresaRut)
        {
            this.swIngresaRut = swIngresaRut;
        }

        public int getSwIngresaRut()
        {
            return this.swIngresaRut;
        }

        public void setSelecc(boolean selecc)
        {
            this.selecc = selecc;
        }

        public boolean isSelecc()
        {
            return this.selecc;
        }

        public void setDescripcion(String descripcion)
        {
            this.descripcion = descripcion;
        }

        public String getDescripcion()
        {
            return this.descripcion;
        }

        public void setItmUsage(String itmUsage)
        {
            this.itmUsage = itmUsage;
        }

        public String getItmUsage()
        {
            return this.itmUsage;
        }

        public void setItmPrint(String itmPrint)
        {
            this.itmPrint = itmPrint;
        }

        public String getItmPrint()
        {
            return this.itmPrint;
        }

        public void setFormdescr(String formdescr)
        {
            this.formdescr = formdescr;
        }

        public String getFormdescr()
        {
            return this.formdescr;
        }

        public void setFrm_name(String frm_name)
        {
            this.frm_name = frm_name;
        }

        public String getFrm_name()
        {
            return this.frm_name;
        }

        public void setRut2(String rut2)
        {
            this.rut2 = rut2;
        }

        public String getRut2()
        {
            return this.rut2;
        }

        public void setFolio(String folio)
        {
            this.folio = folio;
        }

        public String getFolio()
        {
            return this.folio;
        }

        public void setFvenc(String fvenc)
        {
            this.fvenc = fvenc;
        }

        public String getFvenc()
        {
            return this.fvenc;
        }
    }
    
    public class ResultSetMap extends AbstractMap {
        Set _setEntries;
        class _Entry implements Entry {
            Object _key;
            Object _value;
            _Entry
                    (Object key,
                    Object value)
            {
                _key = key;
                _value = value;
            }


            public Object getKey
                    ()
            {
                return _key;
            }


            public Object getValue
                    ()
            {
                return _value;
            }


            public Object setValue
                    (Object o)
            {
                throw new UnsupportedOperationException();
            }
        }
        public ResultSetMap
                (ResultSet rs,
                String strBoundColumn,
                String strDisplayColumn,
                boolean isNull) throws SQLException
        {
            int icolBound = rs.findColumn(strBoundColumn);
            int icolDisplay = rs.findColumn(strDisplayColumn);
            _setEntries = new LinkedHashSet();
            rs.first();
            do
            {
                _setEntries.add(new _Entry(rs.getObject(icolBound), rs.getObject(icolDisplay)));
            } while (rs.next());
            if (isNull)
            {
                _setEntries.add(new _Entry("0", ""));
            }
        }

 
        public Set entrySet
                ()
        {
            return _setEntries;
        }
    }
    
    class ComparadorNumeros implements Comparator {
        public int compare
                (Object o1,
                Object o2)
        {
            int p1,
                    p2;
            ItemForm I1 = (ItemForm) o1;
            ItemForm I2 = (ItemForm) o2;
            p1 = I1.getCodigo().intValue(); //Integer.parseInt(I1.getCodigo());
            p2 = I2.getCodigo().intValue(); //Integer.parseInt(I2.getCodigo());
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
    
    /**
     * Obtiene el Id Formulario
     */
    private String getIDForm(String codForm){
        int largo = codForm.length();
        codForm = codForm.substring(0, largo - 1);
        return codForm;
    }
    
    /**
     * Obtiene el Cod Formulario
     */
    private String getCodForm(String codForm, String signo){
        int largo = codForm.length();
        codForm = codForm.substring(0, largo - 1);
        BigDecimal cod = new BigDecimal(codForm);
        if (signo.equals("-") && cod.intValue() > 200)
        {
            cod = cod.add(new BigDecimal(100));
        }    
        return cod.toString();
    }
    
    
    /**
     * Obtiene etiqueta CODE del Formulario
     */
    private EtiquetaCodeVO getEtiquetaCode(String codForm, String signo)
    {
        int largo = codForm.length();
        codForm = codForm.substring(0, largo - 1);
        logger.info("getEtiquetaCode --> codForm: " + codForm + ", [" + signo + "]");
        EtiquetaCodeVO vo = new EtiquetaCodeVO();
        try 
        {
            String code = locator.getPkgCMonExRemote().buscaCode(new BigDecimal(codForm), signo);
            vo = locator.getPkgCMonExRemote().buscarTipoMov(code);
            /*
            if (codForm.equals("21") || codForm.equals("22") || codForm.equals("45") || codForm.equals("50"))
            {
                vo = locator.getPkgCMonExRemote().buscarTipoMov("RECAINME");
            }
            if (codForm.equals("221"))
            {
                vo = locator.getPkgCMonExRemote().buscarTipoMov("GIRO21ME");
            }
            if (codForm.equals("245"))
            {
                vo = locator.getPkgCMonExRemote().buscarTipoMov("GIRO45ME");
            }
            if (codForm.equals("74"))
            {
                vo = locator.getPkgCMonExRemote().buscarTipoMov("EGRESO");
            }
            */
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.getEtiquetaCode() : " + e);
        }
        
        return vo;
    }
    
    /**
     * Obtiene Rut IRA
     */
    private String getRutIRA(String ira)
    {
        String rutIRA = "0";
        boolean isData = false;
        try 
        {
            iras = locator.getPkgCMonExRemote().getIras().getRowSet(0);
            while (iras.next())
            {
                String glosa = iras.getString("Glosa");
                if (glosa.equals(ira))
                {
                    rutIRA = iras.getString("RUT");
                    break;
                }
            }
        } 
        catch (Exception e) 
        {	
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.getRutIRA() : " + e);
            logger.error(e);
        }
        
        return rutIRA;
    }
    
    
    ItemForm quitardatosRut (   ItemForm form,
                                String codPaterno,
                                String codMaterno,
                                String codNombres,
                                String Rut          )
    {
        ItemForm formOut = form;
        Iterator it = tuplas.iterator();
        while (it.hasNext())
        {
            ItemForm tp = (ItemForm) it.next();
            if (tp.codigo.equals(codPaterno))
            {
                it.remove();		
                formOut.setPaterno(tp.valor);
            }
            if (tp.codigo.equals(codMaterno))
            {
                it.remove();		
                formOut.setMaterno(tp.valor);
            }
            if (tp.codigo.equals(codNombres))
            {
                it.remove();	
                formOut.setNombres(tp.valor);
            }
            if (tp.codigo.equals("3"))
            {
                it.remove();
            }	
            paterno = "";
            materno = "";
            nombres = "";	 
            Rut = "";
            RutDv = "";  
        }
        return formOut;
    }
    
    private String rellenarDatosDer (String datoEntrada,int size,String token)
    {
        StringBuffer dato = new StringBuffer();
        if (datoEntrada.length() < size) 
        {
            dato.append(datoEntrada);
            for (int i = size; i > datoEntrada.length(); i--) 
            {
                dato.append(token);
            }
        }
        else{
            dato.append(datoEntrada.substring(0,size));
        }
      return dato.toString();  
    }
    
    private String rellenarDatosIzq (String datoEntrada,int size,String token)
    {
        StringBuffer dato = new StringBuffer();
        if (datoEntrada.length() < size) 
        {
            for (int i = size; i > datoEntrada.length(); i--) 
            {
                dato.append(token);
            }
            dato.append(datoEntrada);
        }
        else{
            dato.append(datoEntrada.substring(0,size));
        }
      return dato.toString();  
    }
    
    // Obtiene etiqueta Periodo
    private String getPeriodo()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        java.util.Date p = new Date();
        String valor = null;
        
        Iterator it = tuplas.iterator();
        for (int i = 1; it.hasNext(); i++)
        {                 
            ItemForm tp = (ItemForm) it.next();
            if (tp.getCodigo().equals("15"))
            {
                valor = tp.getValor();
                break;
            }
            if (tp.getCodigo().equals("915"))
            {
                valor = tp.getValor();
                break;
            }
        }
        
        if (valor != null)
        {
            try
            {
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
                sdf1.setLenient(false);
                java.util.Date date = sdf1.parse(valor);
                return sdf.format(date);
                //return sdf.format(dt1);
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            	logger.error("Error en el metodo Ingresador.getPeriodo() : " + e);
            }
            
            try
            {
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
                sdf1.setLenient(false);
                java.util.Date date = sdf1.parse(valor);
                return sdf.format(date);
                //return sdf.format(dt1);
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            	logger.error("Error en el metodo Ingresador.getPeriodo()1 : " + e);
            }
            
        }  
        return sdf.format(p);
    }
    
    // Obtiene Respuesta desde CUT AIX ME
    /*
    public String enviaCUTAIXME (String xml)
    {
        String resp = EnviaMensajeME.enviador(xml);
        MessageDocument msgSII = null;
        try
        {
            // Parse String to MessageDocument
            msgSII = MessageDocument.Factory.parse(xml);
            MessageDocument.Message.Resultado resultado = msgSII.getMessage().getResultado();
            resp = resultado.getAprobacion();
            if (!resp.equals("OK"))
            {
                MessageDocument.Message.Errores.Error[] errores = msgSII.getMessage().getErrores().getErrorArray();
                
                for (int ini = 0; ini < errores.length; ini++)
                {
                    String error = "[" + errores[ini].getCodigo().toString() + "] " + errores[ini].getGlosa();
                    errorArr[ini] = error;
                } 
                
                String msg = " ";
                getRequest().setAttribute("msgerr", msg);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return resp; 
    }*/
    
    private String quitarCaracExt (String conComa){
       String sinComa = conComa;
       if (sinComa!=null){
        sinComa =  conComa.replace("\\C1","A");
        sinComa =  sinComa.replace("\\E1","a");
        sinComa =  sinComa.replace("\\C9","E");
        sinComa =  sinComa.replace("\\E9","e");  
        sinComa =  sinComa.replace("\\CD","I");
        sinComa =  sinComa.replace("\\ED","i");
        sinComa =  sinComa.replace("\\D3","O");
        sinComa =  sinComa.replace("\\F3","o");
        sinComa =  sinComa.replace("\\DA","U");
        sinComa =  sinComa.replace("\\FA","u");
        sinComa =  sinComa.replace("\\D1","N");
        sinComa =  sinComa.replace("\\F1","n");
       }
       return sinComa;   
    }
    
    private String validaFechaStr
            (String fecha) throws Exception
    {
        java.util.Date date = new Date();
        SimpleDateFormat sdfOk = new SimpleDateFormat("yyyyMMdd");
        try
        {
            String fdt = "yyyyMMdd";
            SimpleDateFormat sdf = new SimpleDateFormat(fdt);
            sdf.setLenient(false);
            java.util.Date dt1 = sdf.parse(fecha);
            return sdfOk.format(dt1);
            //return sdf.format(dt1);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.validaFechaStr() : " + e);

        }
        
        try
        {
            String fdt = "dd-MM-yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(fdt);
            sdf.setLenient(false);
            java.util.Date dt2 = sdf.parse(fecha);
            return sdfOk.format(dt2);
            //return sdf.format(dt2);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.validaFechaStr()1 : " + e);
        }
        
        try
        {
            String fdt = "dd.MM.yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(fdt);
            sdf.setLenient(false);
            java.util.Date dt2 = sdf.parse(fecha);
            return sdfOk.format(dt2);
            //return sdf.format(dt2);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.validaFechaStr()2 : " + e);
        }
        
	 
        String fdt = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(fdt);
        sdf.setLenient(false);
        java.util.Date dt2 = sdf.parse(fecha);
    
        return sdfOk.format(dt2);
    }
    
    private String validaPeriodoStr
            (String fecha) throws Exception
    {
        java.util.Date date = new Date();
        SimpleDateFormat sdfOk = new SimpleDateFormat("yyyyMM");
        try
        {
            String fdt = "yyyyMM";
            SimpleDateFormat sdf = new SimpleDateFormat(fdt);
            sdf.setLenient(false);

            java.util.Date dt1 = sdf.parse(fecha);
            return sdfOk.format(dt1);
            //return sdf.format(dt1);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.validaPeriodoStr() : " + e);
        }
        
        try
        {
            String fdt = "MM-yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(fdt);
            sdf.setLenient(false);
            java.util.Date dt2 = sdf.parse(fecha);
            return sdfOk.format(dt2);
            //return sdf.format(dt2);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.validaPeriodoStr()1 : " + e);
        }
        
        try
        {
            String fdt = "MM.yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(fdt);
            sdf.setLenient(false);
            java.util.Date dt2 = sdf.parse(fecha);
            return sdfOk.format(dt2);
            //return sdf.format(dt2);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo Ingresador.validaPeriodoStr()2 : " + e);
        }
	 
        String fdt = "MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(fdt);
        sdf.setLenient(false);
        java.util.Date dt2 = sdf.parse(fecha);
    
        return sdfOk.format(dt2);
    }
    
    //private void imprimir(String texto)
    //{
    //    logger.info(texto);
    //} 
    
    private String rutToNumber(String rut)
    {
        rut = rut.replaceAll("-","");
        rut = rellenarDatosIzq(rut,15,"0");
        return rut;
    }
            
    // DHN 24-0-2017: Obsoleto
//    private PkgCutServicesTrxRemote locatorPkgCutServices() throws Exception {
//    	
//        //logger.info("Empezando conexion PkgCutServices...");
//        Properties env = new Properties();
//        env.setProperty("java.naming.factory.initial","weblogic.jndi.WLInitialContextFactory");
//        Constantes.cargarArchivo();
//        env.setProperty("java.naming.provider.url",  Constantes.URL_CUT);//
//        Context context = new InitialContext(env);
//        Class remoteClass = PkgCutServicesTrxRemote.class;
//        String jndiName   = remoteClass.getName();
//        //String jndiName = "ejb.InterfazCUTAIXRemoteHome";
//        //logger.info("JNDI Name: " + jndiName);
//        
//        pkgCutServicesTrxRemote = (PkgCutServicesTrxRemote) context.lookup("cl.teso.reca.pkgcutservicestrx.PkgCutServicesTrx#cl.teso.reca.pkgcutservicestrx.PkgCutServicesTrxRemote");
//        
//        return pkgCutServicesTrxRemote;
//                                
//    }   
    
//    private PkgCutServicesTrxRemote locatorPkgCutServices() throws Exception {
//    	
//    	Context context = new InitialContext();
//        pkgCutServicesTrxRemote = (PkgCutServicesTrxRemote) context.lookup("java:global/PortalSrvEJB3/PkgCutServicesTrxEJB/PkgCutServicesTrx!cl.teso.reca.pkgcutservicestrx.PkgCutServicesTrxRemote");
//        
//        return pkgCutServicesTrxRemote;
//                                
//    } 
    
    private GetItemdescripcionResult locatorPkgCajaServices(BigDecimal inFormtipo, String inFormversion, BigDecimal inItmCode) throws Exception {
    	    	
//    	Properties props = new Properties();
//    	InitialContext ctx = new InitialContext(props);
//    	PkgCajaServicesRemote = (PkgCajaServicesRemote) ctx.lookup("java:global/CajaSrvEAR/PkgCajaServicesEJB/PkgCajaServices!cl.teso.reca.cajasrv.pkgcajaservices.PkgCajaServicesRemote");    	

    	GetItemdescripcionResult result = new GetItemdescripcionResult();
		Connection conn = null;
		CallableStatement call = null;
		ArrayList resultSets = new ArrayList();
            try
            {
                Constantes.cargarArchivoME();
                logger.info("Seguimiento ------ JNDI_DATASOURCE_RECA=" + Constantes.JNDI_DATASOURCE_RECA);            
                
            	Context ctx = new InitialContext();
        		DataSource dataSource = (DataSource)ctx.lookup(Constantes.JNDI_DATASOURCE_RECA);
        		conn = dataSource.getConnection();
        		
            	
                
                call = conn.prepareCall("{call RECA.PKG_CAJA_SERVICES.GET_ITEMDESCRIPCION(?,?,?,?,?,?,?,?,?,?)}");
                    
                    
                call.setBigDecimal(1, inFormtipo);
                call.setString(2, inFormversion);
                call.setBigDecimal(3, inItmCode);
                call.registerOutParameter(4, Types.VARCHAR);
                call.registerOutParameter(5, Types.VARCHAR);
                call.registerOutParameter(6, Types.VARCHAR);
                call.registerOutParameter(7, Types.VARCHAR);
                call.registerOutParameter(8, Types.VARCHAR);
                call.registerOutParameter(9, Types.VARCHAR);
                call.registerOutParameter(10, Types.NUMERIC);
                int updateCount = 0;
                boolean haveRset = call.execute();
                while (haveRset || updateCount != -1)
                {
                    if (!haveRset)
                        updateCount = call.getUpdateCount();
                    else
                        resultSets.add(call.getResultSet());
                    haveRset = call.getMoreResults();
                }
                
                System.out.println("call.getString(4): "+call.getString(4));
                System.out.println("call.getString(5): "+call.getString(5));
                System.out.println("call.getString(6): "+call.getString(6));
                result.setOutItemdescripcion(call.getString(4));
                result.setOutItemdescripcionLarga(call.getString(5));
                result.setOutItemtype(call.getString(6));
                result.setOutItemusage(call.getString(7));
                result.setOutItemprint(call.getString(8));
                result.setOutItemrep(call.getString(9));
                result.setOutResultado(call.getBigDecimal(10));
                
            }
            finally
            {
            	conn.close();
                call.close();
            }
//            if (resultSets.size() > 0)
//            {
//                RowSet[] rowSets = new RowSet[resultSets.size()];
//                result.getRowSet(index) 
//                result.set
//                result.setRowSets((RowSet[]) resultSets.toArray(rowSets));
//            }
            return result;
        
    	
    }
    
    
    
    
    
    
    
    
    
    
    
	public static final char LS = TypesUtil.LS;
	public static final char CS = TypesUtil.CS;
	public static final char RS = TypesUtil.RS;
    
	private static BigDecimal BigDecimal$1 = new BigDecimal(1);
    
    private static final String errorParametrosMsg = "No se procesa Transaccion. Campo Obligatorio Nulo: ";
    
	public ValidaADFResult validaADF(String usuario, ContextADF contextADF,
			RecaItems[] items) throws PkgCutServicesTrxException {
		ValidaADFResult validaADFResult = new ValidaADFResult();

		// -----------Inicializacion y Validacion Variables Entrada------------
		if (items == null || contextADF == null
				|| contextADF.getFormCod() == null
				|| contextADF.getFormVer() == null) {
			String campoNulo = null;

			if (contextADF == null) {
				campoNulo = "contextADF";
			} else {
				if (contextADF.getFormCod() == null) {
					campoNulo = "contextADF.getFormCod()";
				} else if (contextADF.getFormVer() == null) {
					campoNulo = "contextADF.getFormVer()";
				} else if (contextADF.getFechaCaja() == null) {
					campoNulo = "contextADF.getFechaCaja()";
				}
			}
			if (items == null) {
				campoNulo = "items";
			}
			validaADFResult.setResultCode(PagoDeudaPortalResult.TRX_ERROR);
			validaADFResult.setResultMessage(errorParametrosMsg + campoNulo);
			return validaADFResult;
		}
		// --------------------------------------------------------

		try {
			String contextAdfIn = "";
			String touplesAdfIn;
			String traceLevelAdf = "3";
			String flagDigitacionAdf = "1";

			// Formamos la tuplas del formulario
			touplesAdfIn = RecaItems.PackTouplesReca(items);
			// Formamos el contexto del ADF
			contextAdfIn = TypesUtil.addCharCS("fecha_caja")
					+ TypesUtil.addCharLS(Integer.toString(TypesUtil
							.calendarToInt(contextADF.getFechaCaja())));
			contextAdfIn = contextAdfIn + TypesUtil.addCharCS("form_cod")
					+ TypesUtil.addCharLS(contextADF.getFormCod().toString());
			contextAdfIn = contextAdfIn + TypesUtil.addCharCS("form_ver")
					+ TypesUtil.addCharLS(contextADF.getFormVer());
			contextAdfIn = contextAdfIn
					+ TypesUtil.addCharCS("form_vig")
					+ TypesUtil.addCharLS(Integer.toString(TypesUtil
							.calendarToInt(contextADF.getFechaCaja())));
			if (contextADF.getTraceLvl() != null)
				contextAdfIn = contextAdfIn
						+ TypesUtil.addCharCS("trace_lvl")
						+ TypesUtil.addCharLS(contextADF.getTraceLvl()
								.toString());
			else
				contextAdfIn = contextAdfIn + TypesUtil.addCharCS("trace_lvl")
						+ TypesUtil.addCharLS(traceLevelAdf);

			if (contextADF.getFlagDigitacion() != null)
				contextAdfIn = contextAdfIn
						+ TypesUtil.addCharCS("flag_digitacion")
						+ TypesUtil.addCharLS(contextADF.getFlagDigitacion()
								.toString());
			else
				contextAdfIn = contextAdfIn
						+ TypesUtil.addCharCS("flag_digitacion")
						+ TypesUtil.addCharLS(flagDigitacionAdf);

			TypesUtil.addCharRS(contextAdfIn);

			AdfValidaResult adfValidaResult = adfValida(touplesAdfIn,
					contextAdfIn);
			ContextADF contextADFOut = new ContextADF();
			RecaMensajes[] messagesADF = null;
			String contextTgfOut = adfValidaResult.getContexttgfout();
			String messagesTgfOut = adfValidaResult.getMessagestgf();
			String itemsCutOut = adfValidaResult.getItemsOut();
			String splitPattern1 = LS + "|" + RS;
			// String[] contexto = contextTgfOut.split(splitPattern1);
			// String[] liquida = null;

			// Extraemos el contexto del ADF
			contextADFOut = ContextADF.SplitContextADF(contextTgfOut);
			// Extraemos los mensajes del ADF
			if (messagesTgfOut != null) {
				String[] errorArrTmp = messagesTgfOut.split(splitPattern1);
				int nroMessagesADF = errorArrTmp.length;

				if (nroMessagesADF > 0) {
					messagesADF = new RecaMensajes[nroMessagesADF];

					RecaMensajes mensaje;

					for (int j = 0; j < errorArrTmp.length; j++) {
						mensaje = new RecaMensajes();

						String[] msgTmp = errorArrTmp[j].split(String
								.valueOf(CS));

						mensaje.setTipo(BigDecimal$1); // FALTA
						mensaje.setCodigo(TypesUtil.parseBigDecimal(msgTmp[2])); // /FALTA
						mensaje.setSeveridad(TypesUtil
								.parseBigDecimal(msgTmp[1]));
						mensaje.setGlosa("SACAR DE TABLA"); // FALTA
						mensaje.setErrCode(TypesUtil.parseBigDecimal(msgTmp[2]));
						mensaje.setErrTgr(TypesUtil.parseBigDecimal(msgTmp[2]));
						if (msgTmp.length >= 6)
							mensaje.setErrMsg(msgTmp[5]);
						if (msgTmp.length >= 4)
							mensaje.setObjName(msgTmp[3]);
						if (msgTmp.length >= 5)
							mensaje.setObjValue(msgTmp[4]);
						if (msgTmp.length >= 7)
							mensaje.setObjDescrip(msgTmp[6]);
						messagesADF[j] = mensaje;
					}
				}

				validaADFResult.setResultCode(adfValidaResult.getResultado());
				validaADFResult.setContextADF(contextADFOut);
				validaADFResult.setRecaMensajes(messagesADF);
				validaADFResult
						.setItemsADF(ItemsADF.SplitItemsCut(itemsCutOut));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error validaADF", e);
			validaADFResult.setResultCode(ValidaADFResult.SEVERITY_FATAL);
			validaADFResult.setResultMessage(formatException(e,
					"Excepcion en validaADF:", true, 0));
		}
		return validaADFResult;
	}
    
    
    
    
    
	AdfValidaResult adfValida(String touplestgf, String contexttgfin)
			throws PkgCutServicesTrxException {
		
		Connection conn = null;
		AdfValidaResult result = new AdfValidaResult();
		try {
			
            Constantes.cargarArchivoME();
            logger.info("Seguimiento ------ JNDI_DATASOURCE_BEA=" + Constantes.JNDI_DATASOURCE_BEA);            
                        
        	Context ctx = new InitialContext();
    		DataSource dataSource = (DataSource)ctx.lookup(Constantes.JNDI_DATASOURCE_BEA);
    		conn = dataSource.getConnection();
			
//	        AdfValidaResult result = new AdfValidaResult();
	        ArrayList resultSets = new ArrayList();
	        CallableStatement call = conn.prepareCall("{call RECA.PKG_CUT_SERVICES_TRX.ADF_VALIDA(?,?,?,?,?,?)}");
	        try {
	            call.setString(1, touplestgf);
	            call.setString(2, contexttgfin);
	            call.registerOutParameter(3, Types.VARCHAR);
	            call.registerOutParameter(4, Types.VARCHAR);
	            call.registerOutParameter(5, Types.VARCHAR);
	            call.registerOutParameter(6, Types.NUMERIC);
	            int updateCount = 0;
	            boolean haveRset = call.execute();
	            while (haveRset || updateCount != -1) {
	                if (!haveRset)
	                    updateCount = call.getUpdateCount();
	                else
	                    resultSets.add(call.getResultSet());
	                haveRset = call.getMoreResults();
	            }
	            result.setItemsOut(call.getString(3));
	            result.setContexttgfout(call.getString(4));
	            result.setMessagestgf(call.getString(5));
	            result.setResultado(call.getBigDecimal(6));
	        } finally {
	        	conn.close();
	            call.close();
	        }
	        if (resultSets.size() > 0) {
	            RowSet[] rowSets = new RowSet[resultSets.size()];
//	            result.setRowSets((RowSet[]) resultSets.toArray(rowSets));
	        }
			
			
//			return AdfValidaCaller
//					.execute(dataSource, touplestgf, contexttgfin);
		} catch (Exception ex) {
			throw new PkgCutServicesTrxException(ex);
		}
		
		return result;
	}
	
	
	
	private String formatException(Exception e, String method,
			boolean printStackTrace, long stackTraceLevel) {
		// Valores por defecto
		printStackTrace = true;
		stackTraceLevel = 2;

		int messageMaxLength = 500;
		String exceptionMessage;
		// --------------------

		String message = null;

		try {
			exceptionMessage = e.toString();
			if (exceptionMessage.length() > messageMaxLength) {
				exceptionMessage = exceptionMessage.substring(0,
						messageMaxLength);
			}
			message = (method + " " + exceptionMessage);
			if (stackTraceLevel > 0) {
				StackTraceElement[] stk = e.getStackTrace();
				String stkElement;
				int stkIdx = 0;

				for (int j = 0; j < stk.length; j++) {
					String thisClassName = "cl.teso.reca.pkgcutservicestrx"; // MEJORAR

					if (stk[j].getClassName().startsWith(thisClassName)) {
						stkElement = ". at " + stk[j].getMethodName() + "("
								+ stk[j].getFileName() + ":"
								+ stk[j].getLineNumber() + ")";
						message = message + stkElement;
						stkIdx = stkIdx + 1;
					}
					if (stkIdx >= stackTraceLevel) {
						break;
					}
				}
			}
			if (printStackTrace) {
				e.printStackTrace();
			}
		} catch (Exception f) {
			f.printStackTrace();
			logger.error("Error formatException", f);
			message = "Method: " + method + ". Exception: " + e;
		}
		return message;
	}
	
    
    	
}