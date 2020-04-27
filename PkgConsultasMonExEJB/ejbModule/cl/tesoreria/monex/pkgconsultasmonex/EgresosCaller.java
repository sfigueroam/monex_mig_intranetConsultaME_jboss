/*
 * File: EgresosCaller.java  2008/09/02 15:05:55
 * User: Daniel Hernandez N. (Tesoreria General de la Republica)
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.236.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:5IS3+5cObupzL+0T2O-Mgs>>.
 */

package cl.tesoreria.monex.pkgconsultasmonex;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.RowSet;

/**
 * Implements a caller of procedure "SII.PKG_CONSULTAS_MON_EX.EGRESOS".
 */
public class EgresosCaller extends ProcedureCaller
{
    /**
     * Executes procedure "SII.PKG_CONSULTAS_MON_EX.EGRESOS".
     *
     * AGNO_IN            NUMBER             Input
     * RUT_IN             NUMBER             Input
     * CURSOR             REF CURSOR         Output
     */
    public static EgresosResult execute(Connection conn, BigDecimal agnoIn, BigDecimal rutIn)
        throws java.sql.SQLException
    {
        EgresosResult result = new EgresosResult();
        ArrayList resultSets = new ArrayList();
        if (conn.getMetaData().getURL().startsWith("jdbc:oracle:"))
        {
            CallableStatement call = conn.prepareCall("{call SII.PKG_CONSULTAS_MON_EX.EGRESOS(?,?,?)}");
            try
            {
                call.setBigDecimal(1, agnoIn);
                call.setBigDecimal(2, rutIn);
                call.registerOutParameter(3, ORACLE_CURSOR);
                call.execute();
                resultSets.add(toRowSet((ResultSet) call.getObject(3)));
            }
            finally
            {
                call.close();
            }
        }
        else
        {
            CallableStatement call = conn.prepareCall("{call SII.PKG_CONSULTAS_MON_EX.EGRESOS(?,?)}");
            try
            {
                call.setBigDecimal(1, agnoIn);
                call.setBigDecimal(2, rutIn);
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
            }
            finally
            {
                call.close();
            }
        }
        if (resultSets.size() > 0)
        {
            RowSet[] rowSets = new RowSet[resultSets.size()];
            result.setRowSets((RowSet[]) resultSets.toArray(rowSets));
        }
        return result;
    }
}
