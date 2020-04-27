/*
 * File: RecuperaArchResult.java  2008/09/02 15:05:55
 * User: Daniel Hernandez N. (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.236.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:Rsna8sSphkfY7zoOc0pDwj>>.
 */

package cl.tesoreria.monex.pkgconsultasmonex;

import javax.sql.RowSet;

/**
 * Output parameters of procedure "PKG_CONSULTAS_MON_EX.RECUPERA_ARCH".
 */
public class RecuperaArchResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private String myArchclob;
    private Object objecto;
    private RowSet[] myRowSets;

    
    public Object getObjecto() {  
		return objecto;
	}

	public void setObjecto(Object objecto) {
		this.objecto = objecto;
	}

	/**
     * Constructor.
     */
    public RecuperaArchResult()
    {
    }

    /**
     * Returns the value of the "Archclob" field.
     */
    public String getArchclob()
    {
        return myArchclob;
    }

    /**
     * Changes the value of the "Archclob" field.
     */
    public void setArchclob(String value)
    {
        myArchclob = value;
    }

    /**
     * Changes the value of the "RowSets" field.
     */
    void setRowSets(RowSet[] value)
    {
        myRowSets = value;
    }

    /**
     * Returns the value of the "RowSetCount" field.
     */
    public int getRowSetCount()
    {
        return (myRowSets != null) ? myRowSets.length : 0;
    }

    /**
     * Returns the "RowSet" at the specified index.
     */
    public RowSet getRowSet(int index)
    {
        if (index < 0 || index >= getRowSetCount())
            throw new ArrayIndexOutOfBoundsException(index);
        return myRowSets[index];
    }
}
