package cl.tesoreria.monex.utilesVO; 

import java.io.Serializable;
import javax.sql.RowSet;

public class GetResult implements Serializable
{
    private static final long serialVersionUID = 1L;
    private RowSet[] myRowSets;

    /**
     * Constructor.
     */
    public GetResult()
    {
    }

    /**
     * Changes the value of "RowSets".
     */
    public void setRowSets(RowSet[] value)
    {
        this.myRowSets = value;
    }

    /**
     * Returns the value of "RowSetCount".
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
