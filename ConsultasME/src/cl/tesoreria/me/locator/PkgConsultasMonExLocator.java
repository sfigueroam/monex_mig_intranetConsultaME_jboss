package cl.tesoreria.me.locator; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import cl.tesoreria.monex.utiles.Constantes;

import cl.tesoreria.monex.pkgconsultasmonex.PkgConsultasMonExRemote;

public class PkgConsultasMonExLocator 
{ 
    private PkgConsultasMonExRemote pkgConsultasMonExRemote;
    private static Logger logger = Logger.getLogger("cl.tesoreria.me.locator.PkgConsultasMonExLocator");
	
    public PkgConsultasMonExRemote getPkgConsultasMonExRemote() throws NamingException,Exception
    {
        if (pkgConsultasMonExRemote==null){
            Constantes.cargarArchivoME();
            logger.info("Seguimiento ------ JNDI_EJB_PKGCONSULTASMONEXREMOTE=" + Constantes.JNDI_EJB_PKGCONSULTASMONEXREMOTE);            
               
            Context ctx = new InitialContext();            
            pkgConsultasMonExRemote = (PkgConsultasMonExRemote) ctx.lookup(Constantes.JNDI_EJB_PKGCONSULTASMONEXREMOTE);
        }
        return pkgConsultasMonExRemote;
    }       
}