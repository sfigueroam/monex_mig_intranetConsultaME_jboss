package consultaCuentas;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.sql.RowSet;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;

import cl.tesoreria.me.locator.PkgCMonExLocator;
import cl.tesoreria.me.locator.PkgConsultasMonExLocator;
import cl.tesoreria.monex.pkgconsultasmonex.AutorizadosResult;
import cl.tesoreria.monex.pkgconsultasmonex.ConsultasResult;
import cl.tesoreria.monex.pkgconsultasmonex.ExpFormResult;
import cl.tesoreria.monex.pkgconsultasmonex.MovimientosResult;
import cl.tesoreria.monex.pkgconsultasmonex.RectificadosResult;
import cl.tesoreria.monex.vo.FormsMonexVO;
import cl.tesoreria.monex.vo.ItemsMonexVO;
import cl.tesoreria.monex.vo.MovMonexVO;

/**
 * @jpf:controller
 *  */
@Jpf.Controller()
public class Controller extends PageFlowController
{	
	PkgCMonExLocator locator1 = new PkgCMonExLocator();
	PkgConsultasMonExLocator locator2 = new PkgConsultasMonExLocator();	
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.Controller");

    // Uncomment this declaration to access Global.app.
    // 
    //     protected global.Global globalApp;
    // 

    // For an example of page flow exception handling see the example "catch" and "exception-handler"
    // annotations in {project}/WEB-INF/src/global/Global.app

    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action
     * @jpf:forward name="success" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "index.jsp")
    })
    protected Forward begin()
    {
        System.out.println("Seguimiento -------> Entre a begin()");
        ArrayList formularios = new ArrayList();
        try
        { 
            formularios = locator1.getPkgCMonExRemote().getFormularioME();
            
            /*boolean f76 = true;
            boolean f29 = true;
            for (int i=0; i<formularios.size(); i++) {
                String f = (String) formularios.get(i);
                if (Integer.parseInt(f) == 76) f76 = false;
                if (Integer.parseInt(f) == 29) f29 = false;
            }
            if (f29) formularios.add("29");
            if (f76) formularios.add("76");
            
            ArrayList formOrdenados = new ArrayList();
            BigDecimal anterior = new BigDecimal(0);
            BigDecimal actual = null;
            
            for (int i=0; i<formularios.size(); i++) {
                String f = (String) formularios.get(i);
                actual = new BigDecimal(f); 
                
                if (actual.intValue()                
                
                if (Integer.parseInt(f) == 76) f76 = false;
                if (Integer.parseInt(f) == 29) f29 = false;
            }
            */
               
            
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo consultaCuentas.Begin() : " + e);
            String msg = "No se puede conectar a la Base de Datos: " +
                         e.getMessage();
            getRequest().setAttribute("errorMessage", msg);
        } 
        
        getRequest().setAttribute("formularios", formularios);
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="cuentas.jsp"
     * @jpf:forward name="error" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "cuentas.jsp"), 
        @Jpf.Forward(name = "index",
                     path = "index.jsp")
    })
    protected Forward goCuentas(GoCuentasForm form)
    {
        System.out.println("Seguimiento -------> Entre a goCuentas()");
    	System.out.println("form: "+form);
    	if (form.getRut() == null) {
    		System.out.println("pasando por sesion 1");
    		form = (GoCuentasForm) getSession().getAttribute("formSessionCuentas");
    	}else {
    		System.out.println("pasando por sesion 2");
    		getSession().setAttribute("formSessionCuentas", form);
    	}
    	System.out.println("pasando por sesion 3");
        
        // Declaración de variables
        String rut = form.getRut();
        String dv = form.getDv();
        String formulario = form.getFormulario();
        String folio = form.getFolio();
        String vencimiento = form.getAgnoVenc() + form.getMesVenc() + form.getDiaVenc();
        String desde = form.getAnoDesde() + form.getMesDesde() + form.getDiaDesde();
        String hasta = form.getAnoHasta() + form.getMesHasta() + form.getDiaHasta();
        
        System.out.println("Seguimiento -------> formulario: " + formulario.toString());

        if (rut.equals(""))
        {
            rut = "0";
        }
        if (folio.equals(""))
        {
            folio = "0";
        }
        if (formulario.equals(""))
        {
            formulario = "0";
        }
        
        System.out.println("Seguimiento -------> formulario:" + formulario.toString());
        this.getRequest().setAttribute("RUT_AUX", rut);
        this.getRequest().setAttribute("DV_AUX", dv);
        this.getRequest().setAttribute("FORM_AUX", formulario);
        this.getRequest().setAttribute("FOLIO_AUX", folio);
        this.getRequest().setAttribute("VENC_AUX", vencimiento);
        this.getRequest().setAttribute("DESDE_AUX", desde);
        this.getRequest().setAttribute("HASTA_AUX", hasta);
        
        
        /*
        if (rut.equals("0") && folio.equals("0") && vencimiento.equals("")) {
            this.getRequest().setAttribute("msje", "Debe ingresar por lo menos uno de los datos");
            return new Forward("error");
        }  */
        
        try
        {
            ConsultasResult result = locator2.getPkgConsultasMonExRemote().consultas(new BigDecimal(rut), new String(dv), new BigDecimal(formulario), new BigDecimal(folio), desde, hasta, new String(vencimiento));
            //ConsultasResult result = controlMonExEJB.consultas(new BigDecimal (rut), new String (dv), new BigDecimal (formulario), new BigDecimal (folio), new String (""), new String (""), new String (vencimiento));
            RowSet rs = result.getRowSet(0); 
            boolean isData = rs.first();
            if (isData) 
            {
                ArrayList lista = this.getDatosCuentas(rs);
                this.getRequest().setAttribute("lista", lista);
                return new Forward("success");
            }
            else
            {
                this.getRequest().setAttribute("msje", "No se registran datos para la consulta");
                return new Forward("index"); 
            }            
            
        } 
        catch (Exception e)
        {
//        	e.printStackTrace();
        	logger.error("Error en el metodo consultaCuentas.goCuentas() : " + e);
//        	System.out.println("Error en:" +
//                               " --> " +
//                               form +
//                               " --> " +
//                               e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");           
        }            
        
        
        
        return new Forward("index");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="detalles.jsp"
     * @jpf:forward name="error" path="error.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "detalles.jsp"), 
        @Jpf.Forward(name = "error",
                     path = "error.jsp")
    })
    protected Forward goMovimiento(GoMovimientoForm form)
    {
        System.out.println("Seguimiento -------> Entre a goMovimiento()");
    	
    	System.out.println("form.getItem(): "+form.getItem());
    	if (form.getItem() == null) {
    		System.out.println("GoMovimientoForm pasando por sesion 1");
    		form = (GoMovimientoForm) getSession().getAttribute("GoMovimientoFormSession");
    	}else {
    		System.out.println("GoMovimientoForm pasando por sesion 2");
    		getSession().setAttribute("GoMovimientoFormSession", form);
    	}
    	
        //ArrayList consulta = new ArrayList();
        ArrayList lista = new ArrayList();
        String idConsulta = null;
        idConsulta = form.getItem();
        String numtrx = "0";

        try 
        {
            MovimientosResult result = locator2.getPkgConsultasMonExRemote().movimientos(new BigDecimal(idConsulta), new BigDecimal(numtrx));
            RowSet rs = result.getRowSet(0);
            boolean isData = rs.first();
            if (isData) 
            {
                Locale local = new Locale("es", "CL");
                NumberFormat formatNum = NumberFormat.getInstance(local);
                formatNum.setMinimumFractionDigits(2);
                formatNum.setMinimumIntegerDigits(1);
                
                String id = null;
                String idAux = null;
                
                while (isData)
                {
                    id = rs.getString("ID");
                    idAux = rs.getString("ID");
                    MovMonexVO vo =  new MovMonexVO();
                    vo.setId(rs.getString("ID"));
                    vo.setTipoMov(rs.getString("GLOSA_TIPO"));
                    vo.setSignoMov(rs.getString("SIGNO_FORM")); // MAN000000426: DHN (15-01-2016)
                    while (idAux.equals(id)) 
                    {
                        int cod = rs.getInt("COD"); 
                        
                        if (cod == 87)
                            vo.setCod87(formatNum.format(rs.getDouble("ALFA")));  
                        if (cod == 91)
                            vo.setCod91(formatNum.format(rs.getDouble("ALFA"))); 
                        if (cod == 92)
                            vo.setCod92(formatNum.format(rs.getDouble("ALFA")));
                        if (cod == 93)
                            vo.setCod93(formatNum.format(rs.getDouble("ALFA")));
                        if (cod == 94)
                            vo.setCod94(formatNum.format(rs.getDouble("ALFA")));
                        
                        if (cod == 315)
                        {
                            String fecha = rs.getString("ALFA");
                            if (fecha.length() == 8)
                            {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                                sdf.setLenient(false);
                                java.util.Date dt = sdf.parse(rs.getString("ALFA"));
                                sdf = new SimpleDateFormat("dd-MM-yyyy");
                                vo.setCod315(sdf.format(dt));
                            }
                            else
                            {
                                vo.setCod315(fecha);
                            }
                        }
                        
                        if (cod == 8866)
                            vo.setCod8866(formatNum.format(rs.getDouble("ALFA")));
                        
                        isData = rs.next(); 
                        if (isData)
                        {
                            idAux = rs.getString("ID");
                        }
                        else
                        {
                            idAux = "X";
                        }
                    }
                    
                    /* MAN000000426: DHN (15-01-2016)
                    try
                    {
                        String signo = null;
                        /* DHN: 2012-04-27 . Signo desde BBDD
                        if (vo.getTipoMov().equals("RECTIF"))
                        {
                            signo = "-";
                            vo.setTipoMov("RECAINME");
                        } 
                        else if (vo.getTipoMov().equals("RECAINME"))
                        {
                            signo = "+";
                        }* /

                        //String tipoMov = ejbPkgCMonEx.getGlosaFormulario(vo.getTipoMov(),new BigDecimal(id), signo);
                        FormCmexVO Fvo = new FormCmexVO();
                        Fvo = ejbPkgCMonEx.getGlosaFormulario(vo.getTipoMov(), new BigDecimal(id));
                        vo.setTipoMov(Fvo.getDescripcion());;
                        if (Fvo.getSigno() == null)
                            vo.setSignoMov(" ");
                        else
                            vo.setSignoMov(Fvo.getSigno());
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                        this.getRequest().setAttribute("msje","No se pueden obtener los detalles. Vuelva a intentarlo.");              
                        return new Forward("error");
                    }*/
                    
                    lista.add(vo);
                }
                                
            }
            else
            {
                this.getRequest().setAttribute("msje", "No se encuentran datos en la consulta");
                return new Forward("error"); 
            }             
        }
        catch (Exception e)
        {
            System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");              
        }         

        getSession().setAttribute("whereBack","goMovimiento");
        this.getRequest().setAttribute("lista", lista);
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="item.jsp"
     * @jpf:forward name="error" path="error.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "item.jsp"), 
        @Jpf.Forward(name = "error",
                     path = "error.jsp")
    })
    protected Forward goItem(GoMovimientoForm form)
    {
        System.out.println("Seguimiento -------> Entre a goItem()");

    	System.out.println("form.getItem(): "+form.getItem());
    	if (form.getItem() == null) {
    		System.out.println("GoMovimientoForm pasando por sesion 1");
    		form = (GoMovimientoForm) getSession().getAttribute("GoMovimientoFormSession");
    	}else {
    		System.out.println("GoMovimientoForm pasando por sesion 2");
    		getSession().setAttribute("GoMovimientoFormSession", form);
    	}
        
        String idItem = form.getItem();
        String numtrx = "0";
        boolean hayDatos = false;
        
        this.getRequest().setAttribute("item", form.getItem());
                        
        try 
        {
            MovimientosResult result = locator2.getPkgConsultasMonExRemote().movimientos(new BigDecimal(0), new BigDecimal(idItem));
            RowSet rs = result.getRowSet(0);
            boolean isData = rs.first();
            if (isData) 
            {
                ArrayList lista = new ArrayList(); 
                Locale local = new Locale("es", "CL");
                NumberFormat formatNum = NumberFormat.getInstance(local);
                formatNum.setMinimumIntegerDigits(1);               
                while (isData)
                {
                    ItemsMonexVO vo = new ItemsMonexVO();
                    vo.setCodigo(rs.getString("CODIGO"));
                    vo.setDatoTipo(rs.getString("DATO_TIPO"));
                    vo.setValor(rs.getString("ALFA"));
                    
                    if (vo.getDatoTipo().equals("E") || vo.getDatoTipo().equals("D"))
                    {
                        // Si viene con datos
                        if (rs.getString("ALFA").length() > 0 && !rs.getString("ALFA").equals(" "))
                        {
                            // Para asignar signo a valor numérico
                            BigDecimal valor = new BigDecimal(rs.getDouble("ALFA"));
                            if (valor.signum() == 1)
                                vo.setSigno("+"); 
                            if (valor.signum() == -1)
                                vo.setSigno("-"); 
                            if (valor.signum() == 0)
                                vo.setSigno("0"); 
                            if (vo.getDatoTipo().equals("D"))
                                formatNum.setMinimumFractionDigits(2);
                            if (vo.getDatoTipo().equals("E"))
                                formatNum.setMinimumFractionDigits(0);
                            vo.setValor(formatNum.format(rs.getDouble("ALFA")));    
                        } 
                    }
                    
                    // Tipo Dato RUT
                    if (vo.getDatoTipo().equals("R"))
                    {
                        vo.setValor(toRut(rs.getString("ALFA")));
                    }
                    
                    // Tipo Dato Fecha
                    if (vo.getDatoTipo().equals("F"))
                    {
                        String fecha = rs.getString("ALFA");
                        if (fecha.length() == 6)
                        {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
                            sdf.setLenient(false);
                            java.util.Date dt = sdf.parse(fecha);
                            sdf = new SimpleDateFormat("MM-yyyy");
                            vo.setValor(sdf.format(dt));
                        }
                        else
                        {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                            sdf.setLenient(false);
                            java.util.Date dt = sdf.parse(fecha);
                            sdf = new SimpleDateFormat("dd-MM-yyyy");
                            vo.setValor(sdf.format(dt));
                        }
                    }
                    
                    // Tipo Dato Periodo?
                    if (vo.getDatoTipo().equals("P"))
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
                        sdf.setLenient(false);
                        java.util.Date dt = sdf.parse(rs.getString("ALFA"));
                        sdf = new SimpleDateFormat("MM-yyyy");
                        vo.setValor(sdf.format(dt));
                    }
                    
                    // Tipo Dato S: que viene con Signo
                    if (vo.getDatoTipo().equals("S"))
                    {
                        // Para asignar signo a valor numérico
                        BigDecimal valor = new BigDecimal(rs.getDouble("ALFA"));
                        if (valor.signum() == 1)
                            vo.setSigno("+"); 
                        if (valor.signum() == -1)
                            vo.setSigno("-"); 
                        if (valor.signum() == 0)
                            vo.setSigno("0"); 
                        formatNum.setMinimumFractionDigits(2);
                        vo.setValor(formatNum.format(rs.getDouble("ALFA"))); 
                    }
                    
                    lista.add(vo);         
                    isData = rs.next();         
                }
                
                //this.getRequest().setAttribute("items", items);
                //this.getRequest().setAttribute("RES", rs);
                getSession().setAttribute("whereBack","goItem");
                this.getRequest().setAttribute("lista", lista);
                return new Forward("success");
            }
            else
            {
                this.getRequest().setAttribute("msje", "No se encuentran datos en la consulta");
                return new Forward("error"); 
            }             
                         
        }
        catch (Exception e)
        {
            System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");            
        }         
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="cuentas.jsp"
     * @jpf:forward name="error" path="envios.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "cuentas.jsp"), 
        @Jpf.Forward(name = "error",
                     path = "envios.jsp")
    })
    protected Forward goEnvios(GoEnviosForm form)
    {
        System.out.println("Seguimiento -------> Entre a goEnvios()");
        String desde = form.getAgnoDesde() + form.getMesDesde() + form.getDiaDesde();
        String hasta = form.getAgnoHasta() + form.getMesHasta() + form.getDiaHasta();
        String rut = "0";
        String dv = "";
        String formulario = "0";
        String folio = "0";
        String vencimiento = "";
        
        
        
        if (desde.equals("") && hasta.equals(""))
        {
            this.getRequest().setAttribute("msje", "Debe ingresar por lo menos la Fecha Recepción desde");
            return new Forward("error");
        }  

        this.getRequest().setAttribute("RUT_AUX", rut);
        this.getRequest().setAttribute("DV_AUX", dv);
        this.getRequest().setAttribute("FORM_AUX", formulario);
        this.getRequest().setAttribute("FOLIO_AUX", folio);
        this.getRequest().setAttribute("VENC_AUX", vencimiento);
        this.getRequest().setAttribute("DESDE_AUX", desde);
        this.getRequest().setAttribute("HASTA_AUX", hasta);        
        
        try
        {
            ConsultasResult result = locator2.getPkgConsultasMonExRemote().consultas(new BigDecimal(0), new String(""), new BigDecimal(0), new BigDecimal(0), new String(desde), new String(hasta), new String(""));
            //ConsultasResult result = controlMonExEJB.consultas(new BigDecimal (0), new String (""), new BigDecimal (0), new BigDecimal (0), new String (desde), new String (hasta), new String (""));
            RowSet rs = result.getRowSet(0);
            boolean isData = rs.first();
            if (isData) 
            {
                ArrayList lista = this.getDatosCuentas(rs);
                this.getRequest().setAttribute("lista", lista);
                return new Forward("success");
            }
            else
            {
                this.getRequest().setAttribute("msje", "No se registran datos para la consulta");
                return new Forward("error"); 
            }             
        } 
        catch (Exception e)
        {
            System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");                      
        }            
        
        
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="/excel.jsp" 
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "/excel.jsp")
    })
    protected Forward goExportar(GoExportarForm form)
    {
        System.out.println("Seguimiento -------> Entre a goExportar()");
        String rut = form.getRut();
        String dv = form.getDv();
        String formulario = form.getFormulario();
        String folio = form.getFolio();
        String vencimiento = form.getVencimiento();
        String desde = form.getDesde();
        String hasta = form.getHasta();
        
        ArrayList consultas = new ArrayList();
        
        String dvAux = "";
        String formAux = "";
        String formAux1 = "";
        String folioAux = "";
        String folioAux1 = "";
        String envioAux = "";
        String vencAux = "";
        String monAux = "";
        String c8844 = "";
        String c87 = "";
        String f315 = "";
        String c8866 = "0";
        String c91 = "";
        String codigo;
        String rut1 = "";
        String rut2 = "";
        
        int sw = 0;
        boolean isData = false;

        try
        { 
            ExpFormResult result = locator2.getPkgConsultasMonExRemote().expForm(new BigDecimal(rut), new String(dv), new BigDecimal(formulario), new BigDecimal(folio), new String(desde), new String(hasta), new String(vencimiento));
            RowSet rss = result.getRowSet(0);
            isData = rss.first();
            
            if (isData)
            {
                rut1 = rss.getString("RUT_ROL");
                formAux1 = rss.getString("FORM_TIPO");
                folioAux1 = rss.getString("FORM_FOLIO");
            }
            
            while (isData)
            {
                
                rut2 = rss.getString("RUT_ROL");
                formAux = rss.getString("FORM_TIPO");
                folioAux = rss.getString("FORM_FOLIO");

                if (rut2.equals(rut1) && formAux.equals(formAux1) && folioAux.equals(folioAux1))
                {
                    rut1 = rss.getString("RUT_ROL");
                    codigo = rss.getString("COD");
                    dvAux = rss.getString("RUT_DV");
                    formAux = rss.getString("FORM_TIPO");
                    folioAux = rss.getString("FORM_FOLIO");
                    envioAux = rss.getString("FECHA_ACTUALIZA");
                    vencAux = rss.getString("FECHA_VCTO");
                    monAux = rss.getString("NEMO");
                    if (codigo.equals("8844"))
                    {
                        c8844 = rss.getString("ALFA");
                    }
                    if (codigo.equals("87"))
                    {
                        c87 = rss.getString("ALFA");
                    }
                    if (codigo.equals("315"))
                    {
                        f315 = rss.getString("ALFA");
                    }
                    if (codigo.equals("8866"))
                    {
                        c8866 = rss.getString("ALFA");
                    }
                    if (codigo.equals("91"))
                    {
                        c91 = rss.getString("ALFA");
                    }
                    sw = 0;
                    isData = rss.next();
                }
                else
                {
                    sw = 1;
                }
                
                if (sw == 1)
                {
                    String[] dato = new String[]{ rut1, 
                                                  dvAux,
                                                  formAux1,
                                                  folioAux1, 
                                                  envioAux,
                                                  vencAux,
                                                  monAux,
                                                  c8844,
                                                  c87,
                                                  c8866,
                                                  f315,
                                                  c91};
                    consultas.add(dato); 
                    c8844 = "";
                    c87 = "";
                    f315 = "";
                    c8866 = "0";
                    c91 = "";
                    rut1 = rss.getString("RUT_ROL");
                    formAux1 = rss.getString("FORM_TIPO");
                    folioAux1 = rss.getString("FORM_FOLIO");
                }
                

                
            }

            String[] dato = new String[]{ rut1, 
                                          dvAux,
                                          formAux1,
                                          folioAux1, 
                                          envioAux,
                                          vencAux,
                                          monAux,
                                          c8844,
                                          c87,
                                          c8866,
                                          f315,
                                          c91};
            consultas.add(dato);             
            
            String[] titulos = {"RUT",
                                "DV",
                                "FORMULARIO",
                                "FOLIO",
                                "FECHA DE RECEPCION",
                                "VENCIMIENTO",
                                "MONEDA",
                                "CODIGO 8844",
                                "CODIGO 87",
                                "CAMBIO SII",
                                "FECHA CODIGO 315",
                                "VALOR 91"};//Segera lo titulos de la tabla 
            this.getRequest().setAttribute("titulos",titulos);//se pasan los titulos de la tabla       
            this.getRequest().setAttribute("resp",consultas);//se pasan los parametros para llenar la tabla               
        }
        catch (Exception e)
        {
            System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());   
        }
        return new Forward("success");

    }

    /**
     * @jpf:action
     * @jpf:forward name="error" path="autorizados.jsp"
     * @jpf:forward name="success" path="autoResult.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "cuentas.jsp")
    })
    protected Forward backDetalles()
    {
        return new Forward("success");
    }
    
    
    
    
    /**
     * @jpf:action
     * @jpf:forward name="error" path="autorizados.jsp"
     * @jpf:forward name="success" path="autoResult.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "error",
                     path = "autorizados.jsp"), 
        @Jpf.Forward(name = "success",
                     path = "autoResult.jsp")
    })
    protected Forward goAutorizados(GoAutorizadosForm form)
    {
        System.out.println("Seguimiento -------> Entre a goAutorizados()");
        String formu = form.getForm();
        String rut = form.getRut();
        
        if (rut.equals(""))
        {
            rut = "0";
        }
        if (formu.equals(""))
        {
            formu = "0";
        }
       
        try
        {
            AutorizadosResult result = locator2.getPkgConsultasMonExRemote().autorizados(new BigDecimal(rut), new BigDecimal(formu));
            RowSet rs = result.getRowSet(0);
            
            if (rs.first())
            {
                this.getRequest().setAttribute("RESULT", rs);
            }
            else
            {
                this.getRequest().setAttribute("msje", "No se encuentran datos en la consulta realizada");
            }            
            
        } 
        catch (Exception e)
        {
            System.out.println("Error en:" +
                               " --> " +
                               form +
                               " --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");                     
        }          
        
        
        return new Forward("success");
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="rectificaResult.jsp"
     * @jpf:forward name="error" path="rectificados.jsp"
     * @jpf:forward name="success1" path="rectificaParticular.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "rectificaResult.jsp"), 
        @Jpf.Forward(name = "error",
                     path = "rectificados.jsp"), 
        @Jpf.Forward(name = "success1",
                     path = "rectificaParticular.jsp")
    })
    protected Forward goRectificados(rectificadosForm form)
    {
        System.out.println("Seguimiento -------> Entre a goRectificados()");
    	
    	System.out.println("1");
    	if (form.getRut() == null) {
    		System.out.println("2");
    		form = (rectificadosForm) getSession().getAttribute("rectificadosFormSession");
    		
    		 if (form.getFlagRectificaParticular() != null) {
    			 System.out.println("3");
    			 form.setItem("0");    			 
    		 }
    		 
    		 if (getRequest().getParameter("flagRectificarResult")!= null) {
    			 System.out.println("3.1");
    			 form.setItem("0");    			 
    		 }    
    		 
    		 if (form.getRutTmp()!=null)
    			 if (form.getRutTmp().equals(""))
    				 form.setRut("");
    		 
    	}else {
    		
    		System.out.println("form.getRut(): "+form.getRut());
    		
    		if (form.getRut().equals("0")) {
    			form.setRutTmp("");
    		}
    		
    		form.setFlagRectificaParticular(getRequest().getParameter("flagRectificaParticular"));
    		getSession().setAttribute("rectificadosFormSession", form);
    	}
    	
    	
    	
        String fechaDesde = form.getAnoDesde() + form.getMesDesde() + form.getDiaDesde();
        String fechaHasta = form.getAnoHasta() + form.getMesHasta() + form.getDiaHasta();
        String rut = form.getRut();
        String dv = form.getDv();
        String idMov = form.getItem();
        
        System.out.println("idMov: "+idMov);
        
        
        this.getRequest().setAttribute("DV", dv);
        this.getRequest().setAttribute("RUT", rut);
        this.getRequest().setAttribute("anoDesde", form.getAnoDesde());
        this.getRequest().setAttribute("mesDesde", form.getMesDesde());
        this.getRequest().setAttribute("diaDesde", form.getDiaDesde());
        this.getRequest().setAttribute("anoHasta", form.getAnoHasta());
        this.getRequest().setAttribute("mesHasta", form.getMesHasta());
        this.getRequest().setAttribute("diaHasta", form.getDiaHasta());
        
        String msje = null;

        
        if (fechaDesde.equals("") && rut.equals("")) 
        {
            this.getRequest().setAttribute("msje","Debe ingresar a lo menos Rut y/o Fecha envio desde.");                     
            return new Forward("error");
        }

        if (rut.equals(""))
        {
            rut = "0";
        }
        if (fechaDesde.equals(""))
        {
            fechaDesde = "20080101";
        }
        if (fechaHasta.equals("")) 
        { 
            java.util.Date sysdate = null;
            sysdate = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd"); 
            fechaHasta = formatoFecha.format(sysdate); 
        }
        
        try 
        {
//        	new BigDecimal(fechaDesde), new BigDecimal(fechaHasta), new BigDecimal(rut), new BigDecimal(idMov)
        	
        	System.out.println("fechaDesde: "+fechaDesde);
        	System.out.println("fechaHasta: "+fechaHasta);
        	System.out.println("rut: "+rut);
        	System.out.println("idMov: "+idMov);
            RectificadosResult result = locator2.getPkgConsultasMonExRemote().rectificados(new BigDecimal(fechaDesde), new BigDecimal(fechaHasta), new BigDecimal(rut), new BigDecimal(idMov));
            RowSet rs = result.getRowSet(0);
            if (rs.first())
            {
                this.getRequest().setAttribute("RESULT", rs);
            }
            else
            {                
                this.getRequest().setAttribute("msje", "No se encuentran datos en la consulta realizada");
                return new Forward("error");
            }                 
        }
        catch (Exception e) 
        {
            System.out.println("Error [goRectificados] --> " +
                               e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");                     
            return new Forward("error");
        }

        getSession().setAttribute("whereBack","goRectificados");
        if (idMov.equals("0"))
        {
        	System.out.println("6");
            return new Forward("success");
        }
        else
        {
        	System.out.println("7");
            return new Forward("success1");
        }
    }

    /**
     * @jpf:action
     * @jpf:forward name="success" path="/excel.jsp" 
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "/excel.jsp")
    })
    protected Forward goExpRect(rectificadosForm form)
    {
        System.out.println("Seguimiento -------> Entre a goExpRect()");
        String fechaDesde = form.getAnoDesde() + form.getMesDesde() + form.getDiaDesde();
        String fechaHasta = form.getAnoHasta() + form.getMesHasta() + form.getDiaHasta();
        String rut = form.getRut();
        String dv = form.getDv();
        String idMov = "0";
        
        ArrayList consultas = new ArrayList();

        if (rut.equals(""))
        {
            rut = "0";
        }
        if (fechaDesde.equals(""))
        {
            fechaDesde = "20080101";
        }
        if (fechaHasta.equals("")) 
        { 
            java.util.Date sysdate = null;
            sysdate = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd"); 
            fechaHasta = formatoFecha.format(sysdate); 
        }
        
        try 
        {
            RectificadosResult result = locator2.getPkgConsultasMonExRemote().rectificados(new BigDecimal(fechaDesde), new BigDecimal(fechaHasta), new BigDecimal(rut), new BigDecimal(idMov));
            RowSet rs = result.getRowSet(0);
            boolean isData = rs.first();
            
            while (isData)
            {
                String formTipo = rs.getString("FORM_TIPO");
                String aTrib = " ";
                String ano = "";
                String mes = "";
                String fVenc = rs.getString("valor_15");
                int rutIn = rs.getInt("RUT_ROL");
                dv = calcula_dv(rutIn); 
                rut = rutIn + "-" + dv;
                
                if (formTipo.equals("22")) 
                {
                    aTrib = fVenc.substring(0, 4);
                }
                        
                String fVcto = rs.getString("valor_15");
                if (fVcto.length() > 6)
                {
                    String dia = fVcto.substring(6, 8);
                    mes = fVcto.substring(4, 6);
                    ano = fVcto.substring(0, 4);
                    fVenc = dia + '/' + mes + '/' + ano;
                }
                else
                {
                    mes = fVcto.substring(4, 6);
                    ano = fVcto.substring(0, 4);                            
                    fVenc = mes + '/' + ano;
                }
                
                String fEnvio = rs.getString("COD9927");
                String dia = fEnvio.substring(6, 8);
                mes = fEnvio.substring(4, 6);
                ano = fEnvio.substring(0, 4);
                fEnvio = dia + '/' + mes + '/' + ano;

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); 
                Date fPkg = rs.getDate("FECHA_PACKAGE");
                
                        
                String[] dato = new String[]{ rs.getString("SIGNO_FORM"), 
                                              rs.getString("FORM_TIPO"),
                                              aTrib,
                                              rut, 
                                              rs.getString("FORM_FOLIO"),
                                              fVenc,
                                              fEnvio,
                                              formatoFecha.format(fPkg),
                                              rs.getString("valor_9901"),
                                              rs.getString("valor_9902"),
                                              rs.getString("NEMO"),
                                              rs.getString("valor_91"),
                                              rs.getString("valor_87"),
                                              rs.getString("valor_9916"),
                                              rs.getString("valor_9907")};
                consultas.add(dato); 
                isData = rs.next();              
            }
            
            String[] titulos = {"SIGNO",
                                "FORM",
                                "AÑO TRIBUTARIO",
                                "RUT",
                                "FOLIO",
                                "VCTO",
                                "FECHA ENVIO (9927)",
                                "FECHA RECEPCIÓN",
                                "9901",
                                "9902",
                                "MONEDA",
                                "91",
                                "87",
                                "9916",
                                "9907"};//Segera lo titulos de la tabla 
                                
            this.getRequest().setAttribute("titulos",titulos);//se pasan los titulos de la tabla       
            this.getRequest().setAttribute("resp",consultas);//se pasan los parametros para llenar la tabla                           
                             
        } catch (Exception e) 
        {
            System.out.println("Error [goExpRect] --> " + e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");                     
            return new Forward("error");
        }        
                
        return new Forward("success");
    }
    
    public static String calcula_dv (int rutIn)
    {
        int rutInt = rutIn;
        int aux=rutInt;
        int digito;
        int factor=2;
        int suma=0;
        int dv2;
        String dv = "";
                
        while (aux!=0){
            digito = aux % 10;
            suma = suma + factor * digito;
            aux /= 10;
            factor++;
            if (factor==8) factor = 2;
        }
        dv2=11-suma%11;
        if (dv2 == 11)      { dv= "0"; }
        else if (dv2==10)   { dv = "K"; }
            else            { dv = ""+dv2; } 
        return dv;
    }   

    /**
     * @jpf:action
     * @jpf:forward name="success" path="/excel.jsp" 
     */
	@Jpf.Action(
		forwards = { 
			@Jpf.Forward(name = "success", path = "/excel.jsp")
		}
	)
    protected Forward goExpRect2(rectificadosForm form)
    {
        System.out.println("Seguimiento -------> Entre a goExpRect2()");
        String fechaDesde = form.getAnoDesde()+form.getMesDesde()+form.getDiaDesde();
        String fechaHasta = form.getAnoHasta()+form.getMesHasta()+form.getDiaHasta();
        String rut = form.getRut();
        String dv = form.getDv();
        String idMov = form.getNumtrx();
        
        ArrayList consultas = new ArrayList();

        if (rut.equals("")) {rut="0";}
        if (fechaDesde.equals("")) {fechaDesde="20080101";}
        if (fechaHasta.equals("")) 
        { 
            java.util.Date sysdate = null;
            sysdate = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd"); 
            fechaHasta = formatoFecha.format(sysdate); 
        }
        
        try 
        {
            RectificadosResult result = locator2.getPkgConsultasMonExRemote().rectificados(new BigDecimal(fechaDesde),new BigDecimal(fechaHasta),new BigDecimal(rut),new BigDecimal(idMov));
            RowSet rs = result.getRowSet(0);
            boolean isData = rs.first();
            
            while(isData)
            {
                String formTipo = rs.getString("FORM_TIPO");
                String aTrib = " ";
                String mes ="";
                String ano = "";
                String fVenc = rs.getString("valor_15");
                int rutIn = rs.getInt("RUT_ROL");
                dv = calcula_dv(rutIn); 
                rut = rutIn+"-"+dv;
                
                if (formTipo.equals("22")) 
                    { aTrib = fVenc.substring(0,4); }
                        
                String fVcto = rs.getString("valor_15");
                if (fVcto.length()>6) {
                    String dia = fVcto.substring(6,8);
                    mes = fVcto.substring(4,6);
                    ano = fVcto.substring(0,4);
                    fVenc = dia+'/'+mes+'/'+ano;
                }else{
                    mes = fVcto.substring(4,6);
                    ano = fVcto.substring(0,4);                            
                    fVenc = mes+'/'+ano;
                }
                
                String fEnvio = rs.getString("COD9927");
                String dia = fEnvio.substring(6,8);
                mes = fEnvio.substring(4,6);
                ano = fEnvio.substring(0,4);
                fEnvio = dia+'/'+mes+'/'+ano;
                
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); 
                Date fMovto = rs.getDate("FECHA");                
                        
                String[] dato = new String[]{ rs.getString("SIGNO_FORM"), 
                                              rs.getString("FORM_TIPO"),
                                              aTrib,
                                              rut, 
                                              rs.getString("FORM_FOLIO"),
                                              fVenc,
                                              formatoFecha.format(fMovto),
                                              rs.getString("valor_9901"),
                                              rs.getString("valor_9902"),
                                              rs.getString("NEMO"),
                                              rs.getString("valor_91"),
                                              rs.getString("valor_87"),
                                              rs.getString("valor_9916"),
                                              rs.getString("valor_9907")};
                consultas.add(dato); 
                isData = rs.next();              
            }
            
            String[] titulos = {"SIGNO",
                                "FORM",
                                "AÑO TRIBUTARIO",
                                "RUT",
                                "FOLIO",
                                "VCTO",
                                "MOVTO",
                                "9901",
                                "9902",
                                "MONEDA",
                                "91",
                                "87",
                                "9916",
                                "9907"};//Segera lo titulos de la tabla 
                                
            this.getRequest().setAttribute("titulos",titulos);//se pasan los titulos de la tabla       
            this.getRequest().setAttribute("resp",consultas);//se pasan los parametros para llenar la tabla                           
                             
        } catch (Exception e) 
        {
            System.out.println("Error [goExpRect2] --> " + e.getMessage());
            this.getRequest().setAttribute("msje","Problemas de conexión, por favor vuelva a intentarlo.");                     
            return new Forward("error");
        }        
                
        return new Forward("success");
    }
    
    private ArrayList getDatosCuentas(RowSet rs) throws Exception
    {
        System.out.println("Seguimiento -------> Entre a getDatosCuentas()");
        boolean isData = rs.first();
        ArrayList lista = new ArrayList();
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        SimpleDateFormat sdfVcto = new SimpleDateFormat("dd-MM-yyyy");
        while (isData)
        {
            FormsMonexVO vo =  new FormsMonexVO();
            String rutRol = rs.getString("RUT_ROL") + "-" + rs.getString("RUT_DV");
            vo.setRut(rutRol);
            vo.setFormulario(rs.getString("FORM_TIPO"));
            vo.setFolio(rs.getString("FORM_FOLIO"));
            
            // Formato a Fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setLenient(false);
            String fecha = rs.getString("FECHA_ACTUALIZA");
            fecha = fecha.substring(0, fecha.length()-2);
            java.util.Date dt = sdf.parse(fecha);                
            vo.setFechaRecepcion(sdfFecha.format(dt));
            
            // Formato Vencimiento
            fecha = rs.getString("FECHA_VCTO");
            /*
            if (fecha.length() == 6) 
            {
                sdf = new SimpleDateFormat("yyyyMM");
                sdfVcto = new SimpleDateFormat("MM-yyyy");
                sdf.setLenient(false);
                dt = sdf.parse(fecha);
                vo.setVencimiento(sdfVcto.format(dt));
            }
            */
            //if (fecha.length() == 8) 
            //{
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdfVcto = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            dt = sdf.parse(fecha);
            vo.setVencimiento(sdfVcto.format(dt));
            //}
            //vo.setVencimiento(fecha);
            vo.setSaldo(rs.getString("SALDO"));
            vo.setMoneda(rs.getString("NEMO"));
            vo.setId(rs.getString("ID"));
            isData = rs.next();
            lista.add(vo);
        }
        return lista;
    }
    
    private String toRut (String rut) 
    {
        System.out.println("Seguimiento -------> Entre a toRut()");
        int largo = rut.length();  
        Locale local = new Locale("es", "CL");
        NumberFormat formatNum = NumberFormat.getInstance(local);
        double numero = Double.valueOf(rut.substring(0, largo-1)).doubleValue(); 
        rut = formatNum.format(numero) + "-" + rut.substring(largo-1);
        //rut = rut.substring(0, largo-1) + "-" + rut.substring(largo-1);        
        return rut;
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoCuentasForm extends BaseActionForm
    {
        private String anoHasta;

        private String mesHasta;

        private String diaHasta;

        private String anoDesde;

        private String mesDesde;

        private String diaDesde;

        private String agnoVenc;

        private String mesVenc;

        private String diaVenc;

        private String folio;

        private String formulario;

        private String dv;

        private String rut;

        public void setRut(String rut)
        {
            this.rut = rut;
        }

        public String getRut()
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

        public void setFormulario(String formulario)
        {
            this.formulario = formulario;
        }

        public String getFormulario()
        {
            return this.formulario;
        }

        public void setFolio(String folio)
        {
            this.folio = folio;
        }

        public String getFolio()
        {
            return this.folio;
        }

        public void setDiaVenc(String diaVenc)
        {
            this.diaVenc = diaVenc;
        }

        public String getDiaVenc()
        {
            return this.diaVenc;
        }

        public void setMesVenc(String mesVenc)
        {
            this.mesVenc = mesVenc;
        }

        public String getMesVenc()
        {
            return this.mesVenc;
        }

        public void setAgnoVenc(String agnoVenc)
        {
            this.agnoVenc = agnoVenc;
        }

        public String getAgnoVenc()
        {
            return this.agnoVenc;
        }

        public void setDiaDesde(String diaDesde)
        {
            this.diaDesde = diaDesde;
        }

        public String getDiaDesde()
        {
            return this.diaDesde;
        }

        public void setMesDesde(String mesDesde)
        {
            this.mesDesde = mesDesde;
        }

        public String getMesDesde()
        {
            return this.mesDesde;
        }

        public void setAnoDesde(String anoDesde)
        {
            this.anoDesde = anoDesde;
        }

        public String getAnoDesde()
        {
            return this.anoDesde;
        }

        public void setDiaHasta(String diaHasta)
        {
            this.diaHasta = diaHasta;
        }

        public String getDiaHasta()
        {
            return this.diaHasta;
        }

        public void setMesHasta(String mesHasta)
        {
            this.mesHasta = mesHasta;
        }

        public String getMesHasta()
        {
            return this.mesHasta;
        }

        public void setAnoHasta(String anoHasta)
        {
            this.anoHasta = anoHasta;
        }

        public String getAnoHasta()
        {
            return this.anoHasta;
        }
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoMovimientoForm extends BaseActionForm
    {
        private String idForm;

        private String item;

        public void setItem(String item)
        {
            this.item = item;
        }

        public String getItem()
        {
            return this.item;
        }
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoEnviosForm extends BaseActionForm
    {
        private String agnoHasta;

        private String mesHasta;

        private String diaHasta;

        private String agnoDesde;

        private String mesDesde;

        private String diaDesde;

        public void setDiaDesde(String diaDesde)
        {
            this.diaDesde = diaDesde;
        }

        public String getDiaDesde()
        {
            return this.diaDesde;
        }

        public void setMesDesde(String mesDesde)
        {
            this.mesDesde = mesDesde;
        }

        public String getMesDesde()
        {
            return this.mesDesde;
        }

        public void setAgnoDesde(String agnoDesde)
        {
            this.agnoDesde = agnoDesde;
        }

        public String getAgnoDesde()
        {
            return this.agnoDesde;
        }

        public void setDiaHasta(String diaHasta)
        {
            this.diaHasta = diaHasta;
        }

        public String getDiaHasta()
        {
            return this.diaHasta;
        }

        public void setMesHasta(String mesHasta)
        {
            this.mesHasta = mesHasta;
        }

        public String getMesHasta()
        {
            return this.mesHasta;
        }

        public void setAgnoHasta(String agnoHasta)
        {
            this.agnoHasta = agnoHasta;
        }

        public String getAgnoHasta()
        {
            return this.agnoHasta;
        }
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoExportarForm extends BaseActionForm
    {
        private String hasta;

        private String desde;

        private String vencimiento;

        private String folio;

        private String formulario;

        private String dv;

        private String rut;

        public void setRut(String rut)
        {
            this.rut = rut;
        }

        public String getRut()
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

        public void setFormulario(String formulario)
        {
            this.formulario = formulario;
        }

        public String getFormulario()
        {
            return this.formulario;
        }

        public void setFolio(String folio)
        {
            this.folio = folio;
        }

        public String getFolio()
        {
            return this.folio;
        }

        public void setVencimiento(String vencimiento)
        {
            this.vencimiento = vencimiento;
        }

        public String getVencimiento()
        {
            return this.vencimiento;
        }

        public void setDesde(String desde)
        {
            this.desde = desde;
        }

        public String getDesde()
        {
            return this.desde;
        }

        public void setHasta(String hasta)
        {
            this.hasta = hasta;
        }

        public String getHasta()
        {
            return this.hasta;
        }
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class GoAutorizadosForm extends BaseActionForm
    {
        private String rut;

        private String form;

        public void setForm(String form)
        {
            this.form = form;
        }

        public String getForm()
        {
            return this.form;
        }

        public void setRut(String rut)
        {
            this.rut = rut;
        }

        public String getRut()
        {
            return this.rut;
        }
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class rectificadosForm extends BaseActionForm
    {
    	
    	private String rutTmp;
    	
    	private String flagRectificaParticular;
    	
    	private String flagRectificarResult;
    	
        private String numtrx;

        private String item;

        private String idMov;

        private String anoHasta;

        private String mesHasta;

        private String diaHasta;

        private String anoDesde;

        private String mesDesde;

        private String diaDesde;

        private String dv;

        private String rut;
        

		public String getRutTmp() {
			return rutTmp;
		}

		public void setRutTmp(String rutTmp) {
			this.rutTmp = rutTmp;
		}

		public String getFlagRectificarResult() {
			return flagRectificarResult;
		}

		public void setFlagRectificarResult(String flagRectificarResult) {
			this.flagRectificarResult = flagRectificarResult;
		}

		public String getFlagRectificaParticular() {
			return flagRectificaParticular;
		}

		public void setFlagRectificaParticular(String flagRectificaParticular) {
			this.flagRectificaParticular = flagRectificaParticular;
		}

		public void setRut(String rut)
        {
            this.rut = rut;
        }

        public String getRut()
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

        public void setDiaDesde(String diaDesde)
        {
            this.diaDesde = diaDesde;
        }

        public String getDiaDesde()
        {
            return this.diaDesde;
        }

        public void setMesDesde(String mesDesde)
        {
            this.mesDesde = mesDesde;
        }

        public String getMesDesde()
        {
            return this.mesDesde;
        }

        public void setAnoDesde(String anoDesde)
        {
            this.anoDesde = anoDesde;
        }

        public String getAnoDesde()
        {
            return this.anoDesde;
        }

        public void setDiaHasta(String diaHasta)
        {
            this.diaHasta = diaHasta;
        }

        public String getDiaHasta()
        {
            return this.diaHasta;
        }

        public void setMesHasta(String mesHasta)
        {
            this.mesHasta = mesHasta;
        }

        public String getMesHasta()
        {
            return this.mesHasta;
        }

        public void setAnoHasta(String anoHasta)
        {
            this.anoHasta = anoHasta;
        }

        public String getAnoHasta()
        {
            return this.anoHasta;
        }

        public void setItem(String item)
        {
            this.item = item;
        }

        public String getItem()
        {
            return this.item;
        }

        public void setNumtrx(String numtrx)
        {
            this.numtrx = numtrx;
        }

        public String getNumtrx()
        {
            return this.numtrx;
        }
    }
}
