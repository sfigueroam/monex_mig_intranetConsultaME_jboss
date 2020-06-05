package cl.tesoreria.monex.controller; 

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import cl.tesoreria.monex.dao.PkgCMonExDAO;
import cl.tesoreria.monex.utilesVO.DatosRutVO;
import cl.tesoreria.monex.utilesVO.EtiquetaCodeVO;
import cl.tesoreria.monex.utilesVO.FormCmexVO;
import cl.tesoreria.monex.utilesVO.GetResult;
import cl.tesoreria.monex.utilesVO.IraCmexVO;
import cl.tesoreria.monex.utilesVO.LLaveCmexVO;
import cl.tesoreria.monex.utiles.Constantes;
import cl.tesoreria.monex.utiles.XMLProcesosME;



@Stateless(name = "PkgCMonEx", mappedName = "cl.tesoreria.monex.controller.PkgCMonEx")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PkgCMonEx implements PkgCMonExRemote, PkgCMonExLocal {
	
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.PkgCMonEx");
	Constantes.cargarArchivoME();
	logger.info("Seguimiento ------ JNDI_DATASOURCE_SII=" + Constantes.JNDI_DATASOURCE_SII);     

	@Resource(lookup = Constantes.JNDI_DATASOURCE_SII) 

	private DataSource dataSource;	
	private PkgCMonExDAO pkgCMonExDAO;

	private PkgCMonExDAO getPkgCMonExDAO() {
		if (pkgCMonExDAO == null) {
			pkgCMonExDAO = new PkgCMonExDAO();
		}
		return pkgCMonExDAO;
	}

	@Override
	public DatosRutVO getDatosRut(BigDecimal rut) throws Exception {
		try {
			return getPkgCMonExDAO().getDatosRut(rut, dataSource);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getDatosRut() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public GetResult getFormularios() throws Exception {
		try {
			return getPkgCMonExDAO().getFormularios(dataSource);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getFormularios() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public GetResult getIras() throws Exception {
		try {
			return getPkgCMonExDAO().getIras(dataSource);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getIras() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public String getSeqNumTrx() throws Exception {
		try {
			return getPkgCMonExDAO().getSeqNumTrx(dataSource);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getSeqNumTrx() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public EtiquetaCodeVO buscarTipoMov(String nemo) throws Exception {
		try {
			return getPkgCMonExDAO().buscarTipoMov(nemo, dataSource);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.buscarTipoMov() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public String buscaCode(BigDecimal form, String signo) throws Exception {
		try {
			return getPkgCMonExDAO().buscaCode(form, signo, dataSource);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.buscaCode() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public ArrayList getFormulariosTodos() throws Exception {
		try {
			return getPkgCMonExDAO().getFormulariosTodos(dataSource);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getFormulariosTodos() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public BigDecimal insFormularios(FormCmexVO vo) throws Exception {
		try {
			return getPkgCMonExDAO().insFormularios(vo, dataSource);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.insFormularios() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public String delFormulario(FormCmexVO vo) throws Exception {
		try {
			return getPkgCMonExDAO().delFormulario(vo, dataSource);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.delFormulario() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public BigDecimal insIra(IraCmexVO vo) throws Exception {
		try {
			return getPkgCMonExDAO().insIra(vo, dataSource);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.insIra() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public String delIra(IraCmexVO vo) throws Exception {
		try {
			return getPkgCMonExDAO().delIra(vo, dataSource);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.delIra() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public ArrayList getMovimientos(LLaveCmexVO vo) throws Exception {
		try {
			return getPkgCMonExDAO().getMovimientos(dataSource, vo);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getMovimientos() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public ArrayList getFormularioME() throws Exception {
		try {
			return getPkgCMonExDAO().getFormularioME(dataSource);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getFormularioME() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public FormCmexVO getGlosaFormulario(String code, BigDecimal id)
			throws Exception {
		try {
			return getPkgCMonExDAO().getGlosaFormulario(dataSource, code,
					id);
		} catch (SQLException ex) {	
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.getGlosaFormulario() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public int cargaAutorizados(ArrayList autorizados) throws Exception {
		try {
			return getPkgCMonExDAO().cargaAutorizados(dataSource,
					autorizados);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.cargaAutorizados() : " + ex);
			throw new Exception(ex);
		}
	}

	@Override
	public String insAuditoriaME(BigDecimal rut, String dv, BigDecimal id)
			throws Exception {
		try {
			return getPkgCMonExDAO().insAuditoriaME(rut, dv, id,
					dataSource);
		} catch (SQLException ex) {
			ex.printStackTrace();
        	logger.error("Error en el metodo PkgCMonEx.insAuditoriaME() : " + ex);
			throw new Exception(ex);
		}
	}
}