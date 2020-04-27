package cl.tesoreria.me.locator; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import cl.tesoreria.monex.controller.PkgCMonExRemote;

public class PkgCMonExLocator 
{ 
	private PkgCMonExRemote pkgCMonExRemote;
	
    public PkgCMonExRemote getPkgCMonExRemote() throws NamingException,Exception
    {
        if (pkgCMonExRemote==null){
            Context ctx = new InitialContext();            
            pkgCMonExRemote = (PkgCMonExRemote) ctx.lookup("java:global/intranetConsultasME/PkgCMonExEJB/PkgCMonEx!cl.tesoreria.monex.controller.PkgCMonExRemote");
        }
        return pkgCMonExRemote;
    }       
}