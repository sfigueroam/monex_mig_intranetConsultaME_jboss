package cl.tesoreria.monex.utilesVO; 

import java.io.Serializable;

public class EtiquetaCodeVO implements Serializable
{ 
	private static final long serialVersionUID = -6958259188407976737L;
	private String code;
    private String msgDesc;

    
    public EtiquetaCodeVO(){
    }
    
    public String getMsgDesc() {
        return this.msgDesc;
    }
    
    public void setMsgDesc(String newMsgDesc) {
        this.msgDesc = newMsgDesc;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String newCode) {
        this.code = newCode;
    }

} 
