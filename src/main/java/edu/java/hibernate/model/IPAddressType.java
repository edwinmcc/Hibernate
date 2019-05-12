package edu.java.hibernate.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class IPAddressType implements UserType
{
    public IPAddressType()
    {
        super();
    }

    @Override
    public int[] sqlTypes()
    {
        return new int[] {Types.VARCHAR};
    }

    @Override
    public Class returnedClass()
    {
        return IPAddress.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException
    {
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException
    {
        IPAddress address = (IPAddress)o;
        return address.getAddress().hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException
    {
        if(resultSet.wasNull())
        {
            return null;
        }
        String address = resultSet.getString(strings[0]);
        return new IPAddress(address);
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, Object value, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException
    {
        if(value==null)
        {
            ps.setNull(i, Types.VARCHAR);
        }
        else
        {
            String address=value.toString();

        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException
    {
        return null;
    }

    @Override
    public boolean isMutable()
    {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException
    {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException
    {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException
    {
        return null;
    }
}
