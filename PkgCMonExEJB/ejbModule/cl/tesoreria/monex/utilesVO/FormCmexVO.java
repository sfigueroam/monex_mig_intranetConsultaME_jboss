package cl.tesoreria.monex.utilesVO; 

import java.io.Serializable;
import java.math.BigDecimal;

public class FormCmexVO implements Serializable
{ 
	private static final long serialVersionUID = 1945066517482994098L;
	private BigDecimal idForm;
    private BigDecimal codigo;
    private String version;
    private String signo;
    private String code;
    private String descripcion;

    
    public FormCmexVO(){
    }
    
    public BigDecimal getIdForm() {
        return this.idForm;
    }
    
    public void setIdForm(BigDecimal newIdForm) {
        this.idForm = newIdForm;
    }
    
    public BigDecimal getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(BigDecimal newCodigo) {
        this.codigo = newCodigo;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(String newVersion) {
        this.version = newVersion;
    }
    
    public String getSigno() {
        return this.signo;
    }
    
    public void setSigno(String newSigno) {
        this.signo = newSigno;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String newCode) {
        this.code = newCode;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String newDescripcion) {
        this.descripcion = newDescripcion;
    }
} 
