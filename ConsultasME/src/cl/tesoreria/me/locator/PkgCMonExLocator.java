package cl.tesoreria.me.locator; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import cl.tesoreria.monex.controller.PkgCMonExRemote;
import org.apache.log4j.Logger;
import cl.tesoreria.monex.utiles.Constantes;

public class PkgCMonExLocator 
{ 
	private PkgCMonExRemote pkgCMonExRemote;
	
    public PkgCMonExRemote getPkgCMonExRemote() throws NamingException,Exception
    {
        if (pkgCMonExRemote==null){
            Constantes.cargarArchivoME();
            logger.info("Seguimiento ------ JNDI_EJB_PKGCMONEXREMOTE=" + .JNDI_EJB_PKGCMONEXREMOTE);            
      
            Context ctx = new InitialContext();            
            pkgCMonExRemote = (PkgCMonExRemote) ctx.lookup(Constantes.JNDI_EJB_PKGCMONEXREMOTE);
        }
        return pkgCMonExRemote;
    }       
}