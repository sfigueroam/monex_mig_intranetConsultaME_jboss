/*
---------------------------------------------------------------------------
 Archive: FormsMonexVO.java
 Author : Daniel Hernández Navarro
 Date   : 19-03-2010 
 
---------------------------------------------------------------------------
*/

package cl.tesoreria.monex.vo; 

import java.io.Serializable;

public class FormsMonexVO implements Serializable
{ 
  
	private static final long serialVersionUID = 3409737495942976170L;
	private String Id;
    private String Rut;
    private String Formulario;  	
    private String Folio;
    private String FechaRecepcion;
    private String Vencimiento;
    private String Saldo;
    private String Moneda;      
    
    public FormsMonexVO() {
    } 
    
    public String getId() {
        return this.Id;
    }
    
    public void setId(String newId) {
        this.Id = newId;
    }           

    public String getRut() {
        return this.Rut;
    }
    
    public void setRut(String newRut) {
        this.Rut = newRut;
    } 
    
    public String getFormulario() {
        return this.Formulario;
    }
    
    public void setFormulario(String newFormulario) {
        this.Formulario = newFormulario;
    } 
    
    public String getFolio() {
        return this.Folio;
    }
    
    public void setFolio(String newFolio) {
        this.Folio = newFolio;
    } 
    
    public String getFechaRecepcion() {
        return this.FechaRecepcion;
    }
    
    public void setFechaRecepcion(String newFechaRecepcion) {
        this.FechaRecepcion = newFechaRecepcion;
    } 
    
    public String getVencimiento() 
    {
        if (this.Vencimiento == null)
        {
            return "&nbsp;";
        }
        return this.Vencimiento;
    }
    
    public void setVencimiento(String newVencimiento) {
        this.Vencimiento = newVencimiento;
    } 
    
    public String getSaldo() {
        return this.Saldo;
    }
    
    public void setSaldo(String newSaldo) {
        this.Saldo = newSaldo;
    }
    
    public String getMoneda() {
        return this.Moneda;
    }
    
    public void setMoneda(String newMoneda) {
        this.Moneda = newMoneda;
    }
} 
