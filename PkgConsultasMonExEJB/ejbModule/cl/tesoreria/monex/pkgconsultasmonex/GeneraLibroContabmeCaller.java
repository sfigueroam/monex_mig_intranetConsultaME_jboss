/*
 * File: GeneraLibroContabmeCaller.java  2008/09/02 15:05:55
 * User: Daniel Hernandez N. (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.236.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:bfGwkKjqSa6ZPhT11Ge7Pt>>.
 */

package cl.tesoreria.monex.pkgconsultasmonex;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import javax.sql.RowSet;

/**
 * Implements a caller of procedure "SII.PKG_CONSULTAS_MON_EX.GENERA_LIBRO_CONTABME".
 */
public class GeneraLibroContabmeCaller extends ProcedureCaller
{
    /**
     * Executes procedure "SII.PKG_CONSULTAS_MON_EX.GENERA_LIBRO_CONTABME".
     *
     * CODOUT             NUMBER             Output
     * ARCHIVO1           VARCHAR2(4000)     Output
     * PERIODOCONTAB      VARCHAR2(4000)     Input
     */
    public static GeneraLibroContabmeResult execute(Connection conn, String periodocontab)
        throws java.sql.SQLException
    {
        GeneraLibroContabmeResult result = new GeneraLibroContabmeResult();
        ArrayList resultSets = new ArrayList();
        CallableStatement call = conn.prepareCall("{call SII.PKG_CONSULTAS_MON_EX.GENERA_LIBRO_CONTABME(?,?,?)}");
        try
        {
            call.registerOutParameter(1, Types.NUMERIC);
            call.registerOutParameter(2, Types.VARCHAR);
            call.setString(3, periodocontab);
            int updateCount = 0;
            boolean haveRset = call.execute();
            while (haveRset || updateCount != -1)
            {
                if (!haveRset)
                    updateCount = call.getUpdateCount();
                else
                    resultSets.add(toRowSet(call.getResultSet()));
                haveRset = call.getMoreResults();
            }
            result.setCodout(call.getBigDecimal(1));
            result.setArchivo1(call.getString(2));
        }
        finally
        {
            call.close();
        }
        if (resultSets.size() > 0)
        {
            RowSet[] rowSets = new RowSet[resultSets.size()];
            result.setRowSets((RowSet[]) resultSets.toArray(rowSets));
        }
        return result;
    }
}
