package cl.tesoreria.monex.utilesVO; 

import java.io.Serializable;
import java.math.BigDecimal;

public class LLaveCmexVO implements Serializable
{ 

	private static final long serialVersionUID = -7158395355829042363L;
	private BigDecimal Rut;
    private BigDecimal Folio;
    private BigDecimal Formulario;
    private BigDecimal Fvenc;

    
    public LLaveCmexVO(){
    }
    
    public BigDecimal getRut() {
        return this.Rut;
    }
    
    public void setRut(BigDecimal newRut) {
        this.Rut = newRut;
    }
    
    public BigDecimal getFolio() {
        return this.Folio;
    }
    
    public void setFolio(BigDecimal newFolio) {
        this.Folio = newFolio;
    }
    
    public BigDecimal getFormulario() {
        return this.Formulario;
    }
    
    public void setFormulario(BigDecimal newFormulario) {
        this.Formulario = newFormulario;
    }
    
    public BigDecimal getFvenc() {
        return this.Fvenc;
    }
    
    public void setFvenc(BigDecimal newFvenc) {
        this.Fvenc = newFvenc;
    }
    
} 
