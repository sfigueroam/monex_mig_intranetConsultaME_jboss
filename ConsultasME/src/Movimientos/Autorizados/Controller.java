package Movimientos.Autorizados;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.internal.BaseActionForm;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import cl.tesoreria.me.locator.PkgCMonExLocator;
import cl.tesoreria.monex.utilesVO.AutorizadosVO;

/**
 * @jpf:controller
 *  */
@Jpf.Controller(multipartHandler = Jpf.MultipartHandler.memory)
public class Controller extends PageFlowController
{	
	PkgCMonExLocator locator = new PkgCMonExLocator();
    public FormFile archivo;
    private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.ControllerMovimientosAutorizados");    
    
    /**
     * @jpf:action
     * @jpf:forward name="success" path="index.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "index.jsp")
    })
    protected Forward begin()
    {
        return new Forward("success");
    }


    /**
     * @jpf:action
     * @jpf:forward name="success" path="resumenCarga.jsp"
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "resumenCarga.jsp")
		}
	)
    protected Forward goCargarArchivo(ArchivoForm form)
    {
    	logger.info("Entro al do..");
        ArrayList autorizados = null;
        int incorrectos = 0;
        int correctos = 0;
        archivo = form.getArchivo();
        String msje = "Su sesión ha expirado, vuelva a cargar el sistema.";        
        
        try
        {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            
            byte[] bytes = archivo.getFileData();
            int filas = bytes.length / 36;
            autorizados = new ArrayList(filas);
            
            for (int i=0; i < bytes.length; i++)
            {
                AutorizadosVO vo = new AutorizadosVO();
                int valido = 0; //NOK
                
                for (int j=0; j<8; j++) 
                {
                    buffer.write(bytes[i]); 
                    i++;
                }
                String RutStr = buffer.toString();
                buffer.reset();
                
                buffer.write(bytes[i]);
                String RutDv = buffer.toString();        
                buffer.reset();
                i++;
                
                String digitoVerificador = getDV(RutStr);
                if (digitoVerificador.equals(RutDv))
                {
                    vo.setRut(new BigDecimal(RutStr));
                    vo.setDv(RutDv);
                    valido = 1; //OK
                }
                
                
                for (int j=0; j<8; j++) 
                {
                    buffer.write(bytes[i]); 
                    i++;
                } 
                vo.setFechaInicio(new BigDecimal(buffer.toString()));
                buffer.reset();
                
                for (int j=0; j<8; j++) 
                {
                    buffer.write(bytes[i]); 
                    i++;
                } 
                if (buffer.toString().trim().length() > 0)
                {
                    vo.setFechaFin(new BigDecimal(buffer.toString()));
                } else {
                    vo.setFechaFin(new BigDecimal(0));
                }
                buffer.reset();
                
                
                for (int j=0; j<3; j++) 
                {
                    buffer.write(bytes[i]); 
                    i++;
                } 
                vo.setMoneda(buffer.toString());
                buffer.reset();
                
                for (int j=0; j<3; j++) 
                {
                    buffer.write(bytes[i]); 
                    i++;
                } 
                vo.setFormulario(new BigDecimal(buffer.toString().trim()));
                buffer.reset();
                
                for (int j=0; j<3; j++) 
                {
                    buffer.write(bytes[i]); 
                    i++;
                } 
                vo.setMovimiento(buffer.toString());
                buffer.reset();
                
                i=i+2;
                
                if (valido == 1) 
                {
                    autorizados.add(vo);
                    correctos++;
                } 
                else 
                {
                    incorrectos++;
                }    
            }
            try
            {
                int result = locator.getPkgCMonExRemote().cargaAutorizados(autorizados);
                correctos = correctos - result;
                incorrectos = incorrectos + result;
                int total = incorrectos+correctos;
                
                msje = "Total Leídos: " + total + "<br>";
                msje = msje + "Total Correctos: " + correctos + "<br>";
                msje = msje + "Total Incorrectos: " + incorrectos;
            }  
            catch (Exception e) 
            {
            	e.printStackTrace();
            	logger.error("Error en el metodo MovimientosAutorizados.goCargarArchivo() : " + e);
            	msje = "Error en la conexión al almacenar.<br>Si el problema persiste, comunicarse con el Administrador.";
            }
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        	logger.error("Error en el metodo MovimientosAutorizados.goCargarArchivo()1 : " + e);
        	msje = "Problema en la lectura del Archivo.<br>El archivo puede tener errores, favor de revisar.";
        }
        
        this.getRequest().setAttribute("msje",msje); 
        return new Forward("success");
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

    public static class ArchivoForm extends BaseActionForm
    {
        private FormFile archivo;

        public void setArchivo(FormFile archivo)
        {
            this.archivo = archivo;
        }

        public FormFile getArchivo()
        {
            return this.archivo;
        }
    }

	public FormFile getArchivo() {
		return archivo;
	}


	public void setArchivo(FormFile archivo) {
		this.archivo = archivo;
	}	
}
