package cl.tesoreria.me.locator; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cl.tesoreria.monex.pkgconsultasmonex.PkgConsultasMonExRemote;

public class PkgConsultasMonExLocator 
{ 
	private PkgConsultasMonExRemote pkgConsultasMonExRemote;
	
    public PkgConsultasMonExRemote getPkgConsultasMonExRemote() throws NamingException,Exception
    {
        if (pkgConsultasMonExRemote==null){
            Context ctx = new InitialContext();            
            pkgConsultasMonExRemote = (PkgConsultasMonExRemote) ctx.lookup("java:global/intranetConsultasME/PkgConsultasMonExEJB/PkgConsultasMonEx!cl.tesoreria.monex.pkgconsultasmonex.PkgConsultasMonExRemote");
        }
        return pkgConsultasMonExRemote;
    }       
}