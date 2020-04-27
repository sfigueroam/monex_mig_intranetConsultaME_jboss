/*
---------------------------------------------------------------------------
 Archive: PContabVO.java
 Author : Daniel Hernández Navarro
 Date   : 25-09-2015 
 
---------------------------------------------------------------------------
*/

package cl.tesoreria.monex.vo; 

import java.io.Serializable;

public class PContabVO implements Serializable
{ 
	private static final long serialVersionUID = 6734139395296629743L;
	private String Periodo;
    private String Abierto;
    private boolean Seleccion;
     
    
    public PContabVO() {
    } 
            

    public String getPeriodo() {
        return this.Periodo;
    }
    
    public void setPeriodo(String newPeriodo) {
        this.Periodo = newPeriodo;
    } 
    
    public String getAbierto() {
        return this.Abierto;
    }
    
    public void setAbierto(String newAbierto) {
        this.Abierto = newAbierto;
    } 
    
    public boolean getSeleccion() {
        return this.Seleccion;
    }
    
    public void setSeleccion(boolean newSeleccion) {
        this.Seleccion = newSeleccion;
    } 
    
} 
