package cl.tesoreria.monex.dao; 

import cl.tesoreria.monex.utilesVO.AutorizadosVO;
import cl.tesoreria.monex.utilesVO.DatosRutVO;
import cl.tesoreria.monex.utilesVO.EtiquetaCodeVO;
import cl.tesoreria.monex.utilesVO.FormCmexVO;
import cl.tesoreria.monex.utilesVO.GetResult;
import cl.tesoreria.monex.utilesVO.IraCmexVO;
import cl.tesoreria.monex.utilesVO.LLaveCmexVO;
import cl.tesoreria.utiles.sql.TypesExt;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
//import weblogic.jdbc.rowset.RowSetFactory;
//import weblogic.jdbc.rowset.WLCachedRowSet;

public class PkgCMonExDAO 
{ 
    /**
     * Executes procedure "SII.PKG_CMONEX.Get_Datos_Rut"
     *
     * RutIn        IN      NUMBER,
     * CursorOut    OUT     sys_refcursor
     * 
     **/
    public DatosRutVO getDatosRut  (BigDecimal rut,
                                    DataSource dataSource) throws SQLException
    {
        DatosRutVO datos = new DatosRutVO();
        Connection conn = null;
        boolean flag = false;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.Get_Datos_Rut(?,?)}");
                cstmt.setBigDecimal(1, rut);
                cstmt.registerOutParameter(2, TypesExt.CURSOR);
                cstmt.execute();
                ResultSet rs = null;
                try {
                    rs = (ResultSet) cstmt.getObject(2);
                    while (rs.next()) {
                        datos.setNombre(rs.getString("NOMBRES"));
                        datos.setAPaterno(rs.getString("APELLIDO_PATERNO"));
                        datos.setAMaterno(rs.getString("APELLIDO_MATERNO"));
                        flag = true;
                    } // End while
                } finally {
                    rs.close();
                } //End try                
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        if (flag){
            return datos;
        }else{
            return null;
        }
    } 
    
    /**
     * Executes procedure "SII.PKG_CMONEX.Sel_Glosas"
     *
     * Cursor_RS    OUT     sys_refcursor
     * 
     **/
    public GetResult getFormularios(DataSource dataSource) throws SQLException
    {
        GetResult result = new GetResult();
        ArrayList formularios = new ArrayList();
        Connection conn = null;
        boolean flag = false;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.Sel_Glosas(?)}");
                cstmt.registerOutParameter(1, TypesExt.CURSOR);
                cstmt.execute();
                formularios.add(toRowSet((ResultSet) cstmt.getObject(1)));              
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try
        
        if (formularios.size() > 0)
        {
            RowSet[] rowSets = new RowSet[formularios.size()];
            result.setRowSets((RowSet[]) formularios.toArray(rowSets));
        }
        return result;
    }   
    
    /**
     * Executes procedure "SII.PKG_CMONEX.Sel_Iras"
     *
     * Cursor_RS    OUT     sys_refcursor
     * 
     **/
    public GetResult getIras(DataSource dataSource) throws SQLException
    {
        GetResult result = new GetResult();
        ArrayList iras = new ArrayList();
        Connection conn = null;
        boolean flag = false;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.Sel_Iras(?)}");
                cstmt.registerOutParameter(1, TypesExt.CURSOR);
                cstmt.execute();
                iras.add(toRowSet((ResultSet) cstmt.getObject(1)));
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        if (iras.size() > 0)
        {
            RowSet[] rowSets = new RowSet[iras.size()];
            result.setRowSets((RowSet[]) iras.toArray(rowSets));
        }
        return result;
    }  
    
    /**
     * Executes  SII.SEQ_SII_NUMTRX_MSGME 
     * 
     **/
    public String getSeqNumTrx(DataSource dataSource) throws SQLException
    {
        String id = null;
        Connection conn = null;
        //SeqIdtrxResult result = new SeqIdtrxResult();
        try
        {
            conn = dataSource.getConnection();
            Statement stm = null;
            ResultSet resultSets = null;
            try 
            {
                stm = conn.createStatement();
                resultSets = stm.executeQuery("SELECT SII.SEQ_SII_NUMTRX_MSGME.NEXTVAL FROM DUAL");
                while (resultSets.next())
                {
                    //result.setSeqIdtrx(resultSets.getString("NEXTVAL"));
                    id = resultSets.getString("NEXTVAL");
                }
                //id = result.getSeqIdtrx();
            }
            finally
            {
                stm.close();
            } //End try
        } 
        finally 
        {
            conn.close();
        }//End try
        
        return id;        
    }   
    
    
    /**
     * Executes procedure "SII.PKG_CMONEX.buscarTipoMov"
     *
     * dNemoIN   IN varchar
     * glosaOUT  out varchar
     * 
     **/
    public EtiquetaCodeVO buscarTipoMov (String nemo,
                                         DataSource dataSource) throws SQLException
    {
        EtiquetaCodeVO vo = new EtiquetaCodeVO();
        String descr = null;
        Connection conn = null;
        boolean flag = false;
        try
        {
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try 
            {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.buscarTipoMov(?,?)}");
                cstmt.setString(1, nemo);
                cstmt.registerOutParameter(2, Types.VARCHAR);
                cstmt.execute();
                descr = (String) cstmt.getString(2);
                flag = true;
            } 
            finally
            {
                cstmt.close();
            } //End try
        } 
        finally 
        {
            conn.close();
        }//End try

        if (flag){
            vo.setCode(nemo);
            vo.setMsgDesc(descr);
            return vo;
        }else{
            return null;
        }
    }
    
    
    /**
     * Executes procedure "SII.PKG_CMONEX.buscaCode"
     *
     * formIN    In   Number,
     * codeOUT    Out  Varchar2
     * 
     **/
    public String buscaCode (BigDecimal form,
                             String signo,
                             DataSource dataSource) throws SQLException
    {
        String code = " ";
        Connection conn = null;
        try
        {
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try 
            {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.buscaCode(?,?,?)}");
                cstmt.setBigDecimal(1, form);
                cstmt.setString(2, signo);
                cstmt.registerOutParameter(3, Types.VARCHAR);
                cstmt.execute();
                code = (String) cstmt.getString(3);
            } 
            finally
            {
                cstmt.close();
            } //End try
        } 
        finally 
        {
            conn.close();
        }//End try

        return code;
    }
    
    
    /**
     * Executes procedure "WEBTGR.PKG_BONO_POST_LAB.DatosPersonales".
     *
     * Cursor_RS   OUT sys_refcursor
     * 
     * 
     **/
    public ArrayList getFormulariosTodos (DataSource dataSource) throws SQLException
    {
        ArrayList formularios = new ArrayList();
        Connection conn = null;
        boolean flag = false;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.getFormulariosTodos(?)}");
                cstmt.registerOutParameter(1, TypesExt.CURSOR);
                cstmt.execute();
                ResultSet rs = null;
                try 
                {
                    rs = (ResultSet) cstmt.getObject(1);
                    while (rs.next()) {
                        FormCmexVO vo = new FormCmexVO();
                        vo.setIdForm(rs.getBigDecimal("Id"));
                        vo.setCodigo(rs.getBigDecimal("Form"));
                        vo.setDescripcion(rs.getString("Descripcion"));
                        vo.setSigno(rs.getString("Signo"));
                        vo.setVersion(rs.getString("Glosa"));                        
                        vo.setCode(rs.getString("Code")); 
                        formularios.add(vo);
                        flag = true;
                    } // End While
                } finally {
                    rs.close();
                } //End try                
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        if (flag){
            return formularios;
        }else{
            return null;
        }
    }   
    
    /**
     * Executes procedure "SII.PKG_CMONEX.insFormularios".
     *
     * glosaIn     IN  NVarchar2
     * descripIn   IN  NVarchar2
     * signoIn     IN  NVarchar2
     * formIn      IN  Number
     * resOut      OUT NVarchar2 
     * 
     **/
    public BigDecimal insFormularios (FormCmexVO vo,
                                      DataSource dataSource) throws SQLException
    {
        BigDecimal resp = null;
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.insFormularios(?,?,?,?,?,?)}");
                String glosa = vo.getCodigo().toString() + vo.getVersion();
                cstmt.setString(1, glosa);
                cstmt.setString(2, vo.getDescripcion());
                cstmt.setString(3, vo.getSigno());
                cstmt.setBigDecimal(4, vo.getCodigo());
                cstmt.setString(5, vo.getCode());
                cstmt.registerOutParameter(6, Types.NUMERIC);
                cstmt.execute();
                resp = (BigDecimal) cstmt.getBigDecimal(6);            
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        return resp;
    }
    
    /**
     * Executes procedure "SII.PKG_CMONEX.delFormulario".
     *
     * formId      IN  Number
     * resOut      OUT Varchar 
     * 
     **/
    public String delFormulario(FormCmexVO vo,
                                DataSource dataSource) throws SQLException
    {
        String resp = "NOK";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.delFormulario(?,?)}");
                cstmt.setBigDecimal(1, vo.getIdForm());
                cstmt.registerOutParameter(2, Types.VARCHAR);
                cstmt.execute();
                resp = (String) cstmt.getString(2);            
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        return resp;
    }
    
    /**
     * Executes procedure "SII.PKG_CMONEX.insIra".
     *
     * glosaIn      IN  NVarchar2
     * descripIn    IN  NVarchar2
     * rutIn        IN  Number
     * idOut        OUT Number
     * 
     **/
    public BigDecimal insIra (IraCmexVO vo,
                              DataSource dataSource) throws SQLException
    {
        BigDecimal resp = null;
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.insIra(?,?,?,?)}");
                cstmt.setString(1, vo.getGlosa());
                cstmt.setString(2, vo.getDescripcion());
                cstmt.setBigDecimal(3, vo.getRutIra());
                cstmt.registerOutParameter(4, Types.NUMERIC);
                cstmt.execute();
                resp = (BigDecimal) cstmt.getBigDecimal(4);            
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        return resp;
    }
    
    /**
     * Executes procedure "SII.PKG_CMONEX.delIra".
     *
     * firaId      IN  Number
     * resOut      OUT Varchar 
     * 
     **/
    public String delIra(IraCmexVO vo,
                         DataSource dataSource) throws SQLException
    {
        String resp = "NOK";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.delIra(?,?)}");
                cstmt.setBigDecimal(1, vo.getIdIra());
                cstmt.registerOutParameter(2, Types.VARCHAR);
                cstmt.execute();
                resp = (String) cstmt.getString(2);            
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        return resp;
    }  
    
    
    /**
     * Executes procedure "SII.PKG_CMONEX.Get_Movimientos".
     *
     * RutIn       IN  NUMBER
     * FormIn      IN  NUMBER
     * FolioIn     IN  NUMBER
     * FVenc       IN  VARCHAR2
     * Resp        OUT VARCHAR2
     * CursorOut   OUT sys_refcursor
     * 
     * 
     **/
    public ArrayList getMovimientos (DataSource dataSource, LLaveCmexVO vo) throws SQLException
    {
        ArrayList result = new ArrayList();
        ArrayList movs = new ArrayList();
        Connection conn = null;
        boolean flag = false;
        try
        {
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try 
            {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.Get_Movimientos(?,?,?,?,?,?)}");
                cstmt.setBigDecimal(1, vo.getRut());
                cstmt.setBigDecimal(2, vo.getFormulario());
                cstmt.setBigDecimal(3, vo.getFolio());
                cstmt.setString(4, vo.getFvenc().toString());
                cstmt.registerOutParameter(5, Types.VARCHAR);
                cstmt.registerOutParameter(6, TypesExt.CURSOR);
                cstmt.execute();
                String resp = (String) cstmt.getString(5); 
                if (resp.equals("OK"))
                {
                    ResultSet rs = null;
                    try 
                    {
                        rs = (ResultSet) cstmt.getObject(6);
                        while (rs.next()) 
                        {
                                String[] datos = new String[]
                                                 {
                                                    rs.getString("CODIGO"), 
                                                    rs.getString("VALOR_ALFA")
                                                 };
                                result.add(datos);
                                flag = true;
                        }
                    } finally {
                        rs.close();
                    } //End try  
                }
            } 
            finally
            {
                cstmt.close();
            } //End try
        } 
        finally 
        {
            conn.close();
        }//End try
        
        if (flag){
            return result;
        }else{
            return null;
        }
        
    }   
    
    
    /**
     * Executes procedure "SII.PKG_CMONEX.GetGlosaFormulario".
     *
     * CodeIn      IN  NUMBER
     * CuentaIn    IN  NUMBER
     * SignoIn     IN  VARCHAR2
     * GlosaOut    OUT VARCHAR2
     * 
     **/
    public FormCmexVO getGlosaFormulario (DataSource dataSource, 
                                            String code,
                                            BigDecimal id) throws SQLException
    {
        FormCmexVO vo = new FormCmexVO();
        String glosa = null;
        String signo = null;
        Connection conn = null;
        boolean flag = false;
        try
        {
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try 
            {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.GetGlosaFormulario(?,?,?,?)}");
                cstmt.setString(1, code);
                cstmt.setBigDecimal(2, id);
                cstmt.registerOutParameter(3, Types.VARCHAR);
                cstmt.registerOutParameter(4, Types.VARCHAR);
                cstmt.execute();
                signo = (String) cstmt.getString(3);
                glosa = (String) cstmt.getString(4); 
            } 
            finally
            {
                cstmt.close();
            } //End try
        } 
        finally 
        {
            conn.close();
        }//End try
        
        vo.setSigno(signo);
        vo.setDescripcion(glosa);
        
        return vo;
        
    }  
    
    /**
     * Executes procedure "SII.PKG_CMONEX.CargaAutorizados".
     *
     * RutIn         IN  NUMBER
     * DvIn          IN  VARCHAR2
     * FechaInicioIn IN  NUMBER
     * FechaFinIn    IN  NUMBER
     * MonedaIn      IN  VARCHAR2
     * FormularioIn  IN  NUMBER
     * MovimientoIn  IN  VARCHAR2
     * RespOut       OUT VARCHAR2
     * 
     **/
    public int cargaAutorizados (DataSource dataSource,
                                    ArrayList autorizados) throws SQLException
    {
        String resp = null;
        int nok = 0;
        Connection conn = null;
        boolean flag = false;
        try
        {
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try 
            {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.BorraAutorizados}");
                cstmt.execute();
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.CargaAutorizados(?,?,?,?,?,?,?,?)}");
                for (int i=0; i<autorizados.size(); i++)
                {
                    AutorizadosVO vo = (AutorizadosVO)autorizados.get(i);
                    cstmt.setBigDecimal(1, vo.getRut());
                    cstmt.setString(2, vo.getDv());
                    cstmt.setBigDecimal(3, vo.getFechaInicio());
                    cstmt.setBigDecimal(4, vo.getFechaFin());
                    cstmt.setString(5, vo.getMoneda());
                    cstmt.setBigDecimal(6, vo.getFormulario());
                    cstmt.setString(7, vo.getMovimiento());
                    cstmt.registerOutParameter(8, Types.VARCHAR);
                    cstmt.execute();
                    resp = (String) cstmt.getString(8); 
                    if (resp == "NOK")
                    {
                        nok++;
                    }
                }
            } 
            finally
            {
                cstmt.close();
            } //End try
        } 
        finally 
        {
            conn.close();
        }//End try

        return nok;
    } 
    
    /**
     * Executes procedure "SII.PKG_CMONEX.insAuditoriaME".
     *
     * NumberIn    IN  Number
     * RutIn       IN  Number
     * DvIn        IN  NVarchar2
     * resOut      OUT NVarchar2
     * 
     **/
    public String insAuditoriaME (BigDecimal rut,
                                  String dv,
                                  BigDecimal id,
                                  DataSource dataSource) throws SQLException
    {
        String resp = null;
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.insAuditoriaME(?,?,?,?)}");
                cstmt.setBigDecimal(1, id);
                cstmt.setBigDecimal(2, rut);
                cstmt.setString(3, dv);
                cstmt.registerOutParameter(4, Types.VARCHAR);
                cstmt.execute();
                resp = (String) cstmt.getString(4);            
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        return resp;
    }
    
    /**
     * Executes procedure "SII.PKG_CMONEX.Get_FormulariosME"
     *  (CursorOut OUT sys_refcursor) 
     * 
     **/
    public ArrayList getFormularioME  (DataSource dataSource) throws SQLException
    {
        ArrayList datos = new ArrayList();
        Connection conn = null;
        boolean flag = false;
        try{
            conn = dataSource.getConnection();
            CallableStatement cstmt = null;
            try {
                cstmt = conn.prepareCall("{call SII.PKG_CMONEX.Get_FormulariosME(?)}");
                cstmt.registerOutParameter(1, TypesExt.CURSOR);
                cstmt.execute();
                ResultSet rs = null;
                try {
                    rs = (ResultSet) cstmt.getObject(1);
                    while (rs.next()) {
                        datos.add(rs.getString("Formulario"));
                        flag = true;
                    } // End while
                } finally {
                    rs.close();
                } //End try                
            } finally{
                cstmt.close();
            } //End try
        } finally {
            conn.close();
        }//End try

        if (flag){
            return datos;
        }else{
            return null;
        }
    }
    
    
    //------------------------------------------------------------
    //-- ResultSet methods ---------------------------------------
    //------------------------------------------------------------

    /**
     * Builds a RowSet from the supplied ResultSet.
     */
    protected static RowSet toRowSet(ResultSet resultSet)
        throws java.sql.SQLException
    {
    	//RowSetFactory factory = RowSetFactory.newInstance();
    	//WLCachedRowSet rowSet = factory.newCachedRowSet();
    	CachedRowSet rowSet = new CachedRowSetImpl();
        rowSet.populate(resultSet);
        return rowSet;
    }
} 
