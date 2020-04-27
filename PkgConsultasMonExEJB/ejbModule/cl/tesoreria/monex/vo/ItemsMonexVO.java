/*
---------------------------------------------------------------------------
 Archive: ItemsMonexVO.java
 Author : Daniel Hernández Navarro
 Date   : 18-11-2009
 
 Modif  : 19-03-2010 Daniel Hernández N.
 
---------------------------------------------------------------------------
*/

package cl.tesoreria.monex.vo; 

import java.io.Serializable;

public class ItemsMonexVO implements Serializable
{ 

	private static final long serialVersionUID = 7914904423718434078L;
	private String Codigo;
    private String Signo;
    private String DatoTipo;
    private String Valor;
            
    
    public ItemsMonexVO() {
    }            

    public String getCodigo() {
        return this.Codigo;
    }
    
    public void setCodigo(String newCodigo) {
        this.Codigo = newCodigo;
    } 
    
    public String getSigno() 
    {
        if (this.Signo == null)
        {
            return "&nbsp;";
        }
        return this.Signo;
    }
    
    public void setSigno(String newSigno) {
        this.Signo = newSigno;
    } 
    
    public String getDatoTipo() {
        return this.DatoTipo;
    }
    
    public void setDatoTipo(String newDatoTipo) {
        this.DatoTipo = newDatoTipo;
    } 
    
    public String getValor() 
    {
        if (this.Valor == null || this.Valor.equals(" "))
        {
            return "&nbsp;";
        }
        
        return this.Valor;
    }
    
    public void setValor(String newValor) {
        this.Valor = newValor;
    } 
    
    
} 
