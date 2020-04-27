package cl.tesoreria.monex.utilesVO; 

import java.io.Serializable;
import java.math.BigDecimal;

public class IraCmexVO implements Serializable
{ 
	private static final long serialVersionUID = 890343460068855309L;
	private BigDecimal idIra;
    private BigDecimal rutIra;
    private String dvIra;
    private String glosa;
    private String descripcion;

    
    public IraCmexVO(){
    }
    
    public BigDecimal getIdIra() {
        return this.idIra;
    }
    
    public void setIdIra(BigDecimal newIdIra) {
        this.idIra = newIdIra;
    }
    
    public BigDecimal getRutIra() {
        return this.rutIra;
    }
    
    public void setRutIra(BigDecimal newRutIra) {
        this.rutIra = newRutIra;
    }
    
    public String getDvIra() {
        return this.dvIra;
    }
    
    public void setDvIra(String newDvIra) {
        this.dvIra = newDvIra;
    }
    
    public String getGlosa() {
        return this.glosa;
    }
    
    public void setGlosa(String newGlosa) {
        this.glosa = newGlosa;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String newDescripcion) {
        this.descripcion = newDescripcion;
    }
} 
