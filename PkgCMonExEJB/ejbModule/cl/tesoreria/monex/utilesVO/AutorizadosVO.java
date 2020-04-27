package cl.tesoreria.monex.utilesVO; 

import java.io.Serializable;
import java.math.BigDecimal;

public class AutorizadosVO implements Serializable
{     
	private static final long serialVersionUID = 8417304943038820919L;
	private BigDecimal Rut;
    private String Dv;
    private BigDecimal FechaInicio;
    private BigDecimal FechaFin;
    private String Moneda;
    private BigDecimal Formulario;
    private String Movimiento;

    
    public AutorizadosVO(){
    }
    
    public BigDecimal getRut() {
        return this.Rut;
    }
    
    public void setRut(BigDecimal newRut) {
        this.Rut = newRut;
    }
    
    public String getDv() {
        return this.Dv;
    }
    
    public void setDv(String newDv) {
        this.Dv = newDv;
    }
    
    public BigDecimal getFechaInicio() {
        return this.FechaInicio;
    }
    
    public void setFechaInicio(BigDecimal newFechaInicio) {
        this.FechaInicio = newFechaInicio;
    }
    
    public BigDecimal getFechaFin() {
        return this.FechaFin;
    }
    
    public void setFechaFin(BigDecimal newFechaFin) {
        this.FechaFin = newFechaFin;
    }
    
    public String getMoneda() {
        return this.Moneda;
    }
    
    public void setMoneda(String newMoneda) {
        this.Moneda = newMoneda;
    }
    
    public BigDecimal getFormulario() {
        return this.Formulario;
    }
    
    public void setFormulario(BigDecimal newFormulario) {
        this.Formulario = newFormulario;
    }
    
    public String getMovimiento() {
        return this.Movimiento;
    }
    
    public void setMovimiento(String newMovimiento) {
        this.Movimiento = newMovimiento;
    }
} 
