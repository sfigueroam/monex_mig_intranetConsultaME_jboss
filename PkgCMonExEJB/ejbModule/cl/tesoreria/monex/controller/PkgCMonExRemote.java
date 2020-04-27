package cl.tesoreria.monex.controller; 

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.ejb.Remote;

import cl.tesoreria.monex.utilesVO.DatosRutVO;
import cl.tesoreria.monex.utilesVO.EtiquetaCodeVO;
import cl.tesoreria.monex.utilesVO.FormCmexVO;
import cl.tesoreria.monex.utilesVO.GetResult;
import cl.tesoreria.monex.utilesVO.IraCmexVO;
import cl.tesoreria.monex.utilesVO.LLaveCmexVO;

@Remote
public interface PkgCMonExRemote {

    public DatosRutVO getDatosRut(BigDecimal rut) throws Exception;
    public GetResult getFormularios() throws Exception;
    public GetResult getIras() throws Exception;
    public String getSeqNumTrx() throws Exception;
    public EtiquetaCodeVO buscarTipoMov(String nemo) throws Exception;
    public String buscaCode(BigDecimal form, String signo) throws Exception;
    public ArrayList getFormulariosTodos() throws Exception;
    public BigDecimal insFormularios(FormCmexVO vo) throws Exception;
    public String delFormulario(FormCmexVO vo) throws Exception;
    public BigDecimal insIra(IraCmexVO vo) throws Exception;
    public String delIra(IraCmexVO vo) throws Exception;
    public ArrayList getMovimientos(LLaveCmexVO vo) throws Exception;
    public ArrayList getFormularioME() throws Exception;
    public FormCmexVO getGlosaFormulario(String code, BigDecimal id) throws Exception;
    public int cargaAutorizados(ArrayList autorizados) throws Exception;
    public String insAuditoriaME(BigDecimal rut,
                                 String dv,
                                 BigDecimal id) throws Exception;

}
