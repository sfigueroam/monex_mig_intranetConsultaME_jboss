package cl.tesoreria.monex.pkgconsultasmonex; 

import java.math.BigDecimal;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import cl.tesoreria.monex.utiles.Constantes;

@Stateless(name = "PkgConsultasMonEx", mappedName = "cl.tesoreria.monex.pkgconsultasmonex.PkgConsultasMonEx")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PkgConsultasMonEx implements PkgConsultasMonExRemote,
		PkgConsultasMonExLocal {

	Constantes.cargarArchivoME();
	logger.info("Seguimiento ------ JNDI_DATASOURCE_SII=" + Constantes.JNDI_DATASOURCE_SII);            
		
	@Resource(lookup = Constantes.JNDI_DATASOURCE_SII) 
	private DataSource dataSource;
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.PkgConsultasMonEx");
	
	@Override
	public AutorizadosResult autorizados(BigDecimal rutIn, BigDecimal formIn)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return AutorizadosCaller.execute(conn, rutIn, formIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
        	ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.autorizados() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public ConsultasResult consultas(BigDecimal rutIn, String dvIn,
			BigDecimal formIn, BigDecimal folioIn, String desdeIn,
			String hastaIn, String vencIn) throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return ConsultasCaller.execute(conn, rutIn, dvIn, formIn,
						folioIn, desdeIn, hastaIn, vencIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.consultas() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public CuadraturaResult cuadratura(BigDecimal cod9927Aux)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return CuadraturaCaller.execute(conn, cod9927Aux);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.cuadratura() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public EgresosResult egresos(BigDecimal agnoIn, BigDecimal rutIn)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return EgresosCaller.execute(conn, agnoIn, rutIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.egresos() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public ExpFormResult expForm(BigDecimal rutIn, String dvIn,
			BigDecimal formIn, BigDecimal folioIn, String desdeIn,
			String hastaIn, String vencIn) throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return ExpFormCaller.execute(conn, rutIn, dvIn, formIn,
						folioIn, desdeIn, hastaIn, vencIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.expForm() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public GeneraHuinchaResult generaHuincha(BigDecimal cod9927Aux)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return GeneraHuinchaCaller.execute(conn, cod9927Aux);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.generaHuincha() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public GeneraLibroContabmeResult generaLibroContabme(String periodocontab)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return GeneraLibroContabmeCaller.execute(conn, periodocontab);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.generaLibroContabme() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public MovimientosResult movimientos(BigDecimal idIn, BigDecimal numtrxIn)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return MovimientosCaller.execute(conn, idIn, numtrxIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.movimientos() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public RectificadosResult rectificados(BigDecimal desdeIn,
			BigDecimal hastaIn, BigDecimal rutIn, BigDecimal idmovIn)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return RectificadosCaller.execute(conn, desdeIn, hastaIn,
						rutIn, idmovIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.rectificados() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public RecuperaArchResult recuperaArch(BigDecimal fechaIn,
			String tipoarchIn, BigDecimal idIn)
			throws PkgConsultasMonExException {
		
		System.out.println("dentro de recuperaArch");
		try {
			Connection conn = dataSource.getConnection();
			try {
				return RecuperaArchCaller.execute(conn, fechaIn, tipoarchIn,
						idIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.recuperaArch() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public PeriodosContablesResult getPeriodosContables(BigDecimal anno)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				return PeriodosContablesCaller.execute(conn, anno);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.getPeriodosContables() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}

	@Override
	public void actPeriodosContables(String periodoIn)
			throws PkgConsultasMonExException {
		try {
			Connection conn = dataSource.getConnection();
			try {
				ActPContablesCaller.execute(conn, periodoIn);
			} finally {
				conn.close();
			}
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgConsultasMonEx.actPeriodosContables() : " + ex);
			throw new PkgConsultasMonExException(ex);
		}
	}
}