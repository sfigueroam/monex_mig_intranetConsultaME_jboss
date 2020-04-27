package cl.tesoreria.monex.utilesVO; 

import java.io.Serializable;

public class DatosRutVO implements Serializable
{ 
	private static final long serialVersionUID = 7844741098924090952L;
	private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String rut;

    
    public DatosRutVO(){
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }
    
    public String getAPaterno() {
        return this.aPaterno;
    }
    
    public void setAPaterno(String newAPaterno) {
        this.aPaterno = newAPaterno;
    }
    
    public String getAMaterno() {
        return this.aMaterno;
    }
    
    public void setAMaterno(String newAMaterno) {
        this.aMaterno = newAMaterno;
    }
    
    public String getRut() {
        return this.rut;
    }
    
    public void setRut(String newRut) {
        this.rut = newRut;
    }
} 
