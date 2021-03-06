/*
 * File: CuadraturaResult.java  2008/09/02 15:05:55
 * User: Daniel Hernandez N. (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.236.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:fmyYW67XpXXH25ZS0n9sks>>.
 */

package cl.tesoreria.monex.pkgconsultasmonex;

import java.math.BigDecimal;
import javax.sql.RowSet;

/**
 * Output parameters of procedure "PKG_CONSULTAS_MON_EX.CUADRATURA".
 */
public class CuadraturaResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;
    private String myArchivo1;
    private String myArchivo2;
    private String myArchivo3;
    private RowSet[] myRowSets;

    /**
     * Constructor.
     */
    public CuadraturaResult()
    {
    }

    /**
     * Returns the value of the "OCodError" field.
     */
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }

    /**
     * Changes the value of the "OCodError" field.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }

    /**
     * Returns the value of the "Archivo1" field.
     */
    public String getArchivo1()
    {
        return myArchivo1;
    }

    /**
     * Changes the value of the "Archivo1" field.
     */
    public void setArchivo1(String value)
    {
        myArchivo1 = value;
    }

    /**
     * Returns the value of the "Archivo2" field.
     */
    public String getArchivo2()
    {
        return myArchivo2;
    }

    /**
     * Changes the value of the "Archivo2" field.
     */
    public void setArchivo2(String value)
    {
        myArchivo2 = value;
    }

    /**
     * Returns the value of the "Archivo3" field.
     */
    public String getArchivo3()
    {
        return myArchivo3;
    }

    /**
     * Changes the value of the "Archivo3" field.
     */
    public void setArchivo3(String value)
    {
        myArchivo3 = value;
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
