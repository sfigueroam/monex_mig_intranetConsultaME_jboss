package cl.tesoreria.monex.utiles; 

import cl.tesoreria.sii.msgSII.MessageDocument;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import java.util.ArrayList;

public class XMLProcesosME 
{ 
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.XMLProcesosME");	
	public XMLProcesosME(){
    }
    
    /**
     * Parsea mensaje XML de Cierre
     * 
     */
    public MessageDocument ParserMessage(String MensajeIN)
    {
        // Declaración de Variables
        boolean isValid = false;
        MessageDocument messageIn = MessageDocument.Factory.newInstance();
        XmlOptions validateOptions = new XmlOptions();
        ArrayList listaErrores = new ArrayList();
        String mensajesErrores = "";
        String respuesta ="";
        
        MensajeIN = MensajeIN.replaceAll("<Message>","<Message xmlns=\"http://tesoreria.cl/sii/MsgSII.xsd\">");
        //logger.info(MensajeIN);
        
        
        try
        {
            // Parse String to MessageDocument
            messageIn = MessageDocument.Factory.parse(MensajeIN);
            
            // Intancia XmlOptions con un Array para almacenar errores
            validateOptions.setErrorListener(listaErrores);
            
            // Valida XML e ingresar los errores en el Array
            isValid = messageIn.validate(validateOptions);
            
            // Si XML no es valido
            if (!isValid)
            {
                // Loop del Array con los errores    
                for (int i = 0; i < listaErrores.size(); i++){
                    // Obtien el error en un XmlError
                    XmlError error      = (XmlError) listaErrores.get(i);
                    // Posiciona cursor sobre el error
                    XmlCursor cursor    = error.getCursorLocation();
                    cursor.toParent();
                    // Concatena los errroes en un String
                    mensajesErrores     = mensajesErrores 
                                          + "El Valor ( "+ cursor.getTextValue() + " ) no es valido para el tag: " 
                                          + cursor.xmlText() 
                                          + " Error: " + error.getMessage() + "\n";
                }
                
                logger.info("ERRORES ParserMessage --> " + mensajesErrores);
                return null;
            }
            
        }
        catch( Exception ex)
        {
        	ex.printStackTrace();
        	logger.error("Error en el metodo ParserMessage.Begin() : " + ex);
        	//throw new RuntimeException(this.getClass() + " Error en ParserMessage : ",ex); 
            logger.info(ex.getMessage());
            return null;
        }
        return messageIn;
    }
    
    /**
     * Extraer los errores del Mensaje
     * 
     */
    public String[] ExtraerErrores(MessageDocument messageIn) {
        try 
        {
            // Declaración de variables
            String[] listaErrores = null;
                
            //Extrae datos etiqueta "<Error>" 
            MessageDocument.Message.Errores.Error errores[] = messageIn.getMessage().getErrores().getErrorArray();
            listaErrores = new String[errores.length];
            // Para 1 o más Formularios
            for (int ini = 0; ini < errores.length; ini++)
            {
                MessageDocument.Message.Errores.Error error = errores[ini];
                String err = error.getCodigo().toString() + " - " + error.getGlosa();
                //String err = error.getGlosa();
                listaErrores[ini] = err;
            }            
            return listaErrores;
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        	logger.error("Error en el metodo ParserMessage.ExtraerErrores() : " + ex);
            return null;
        }
    }
} 
