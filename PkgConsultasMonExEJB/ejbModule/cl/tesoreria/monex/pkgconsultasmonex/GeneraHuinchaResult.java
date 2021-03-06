/*
 * File: GeneraHuinchaResult.java  2008/09/02 15:05:55
 * User: Daniel Hernandez N. (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.236.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:3dGtft0NzDYcvBnywjq00V>>.
 */

package cl.tesoreria.monex.pkgconsultasmonex;

import javax.sql.RowSet;

/**
 * Output parameters of procedure "PKG_CONSULTAS_MON_EX.GENERA_HUINCHA".
 */
public class GeneraHuinchaResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private String myMensajeRetorno;
    private RowSet[] myRowSets;

    /**
     * Constructor.
     */
    public GeneraHuinchaResult()
    {
    }

    /**
     * Returns the value of the "MensajeRetorno" field.
     */
    public String getMensajeRetorno()
    {
        return myMensajeRetorno;
    }

    /**
     * Changes the value of the "MensajeRetorno" field.
     */
    public void setMensajeRetorno(String value)
    {
        myMensajeRetorno = value;
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
