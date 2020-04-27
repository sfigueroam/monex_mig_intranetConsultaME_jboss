/*
---------------------------------------------------------------------------
 Archive: FormsMonexVO.java
 Author : Daniel Hernández Navarro
 Date   : 19-03-2010 
 
---------------------------------------------------------------------------
*/

package cl.tesoreria.monex.vo; 

import java.io.Serializable;

public class MovMonexVO implements Serializable
{ 

	private static final long serialVersionUID = -8476170026527985188L;
	private String Id;
    private String TipoMov;
    private String Cod315;  	
    private String SignoMov;
    private String Codigo;
    private String Cod87;
    private String Cod91;
    private String Cod92;
    private String Cod93; 
    private String Cod94; 
    private String Cod8866;
    
    public MovMonexVO() {
    } 
    
    public String getId() {
        return this.Id;
    }
    
    public void setId(String newId) {
        this.Id = newId;
    }           

    public String getTipoMov() {
        return this.TipoMov;
    }
    
    public void setTipoMov(String newTipoMov) {
        this.TipoMov = newTipoMov;
    } 
    
    public String getCod315() 
    {
        if (this.Cod315 == null) {
            return "&nbsp;";
        }
        return this.Cod315;
    }
    
    public void setCod315(String newCod315) {
        this.Cod315 = newCod315;
    } 
    
    public String getSignoMov() {
        return this.SignoMov;
    }
    
    public void setSignoMov(String newSignoMov) {
        this.SignoMov = newSignoMov;
    } 
    
    public String getCod87() 
    {
        if (this.Cod87 == null) {
            return "&nbsp;";
        }
        return this.Cod87;
    }
    
    public void setCod87(String newCod87) {
        this.Cod87 = newCod87;
    } 
    
    public String getCodigo() {
        return this.Codigo;
    }
    
    public void setCodigo(String newCodigo) {
        this.Codigo = newCodigo;
    } 
    
    public String getCod91() 
    {
        if (this.Cod91 == null) {
            return "&nbsp;";
        }
        return this.Cod91;
    }
    
    public void setCod91(String newCod91) {
        this.Cod91 = newCod91;
    } 
    
    public String getCod92() 
    {
        if (this.Cod92 == null) {
            return "&nbsp;";
        }
        return this.Cod92;
    }
    
    public void setCod92(String newCod92) {
        this.Cod92 = newCod92;
    }
    
    public String getCod93() 
    {
        if (this.Cod93 == null) {
            return "&nbsp;";
        }
            return this.Cod93;
    }
    
    public void setCod93(String newCod93) {
        this.Cod93 = newCod93;
    }
    
    public String getCod94()
    {
        if (this.Cod94 == null) {
            return "&nbsp;";
        }
        return this.Cod94;
    }
    
    public void setCod94(String newCod94) {
        this.Cod94 = newCod94;
    }
    
    public String getCod8866() 
    {
        if (this.Cod8866 == null) {
            return "&nbsp;";
        }
        return this.Cod8866;
    }
    
    public void setCod8866(String newCod8866) {
        this.Cod8866 = newCod8866;
    }
} 
