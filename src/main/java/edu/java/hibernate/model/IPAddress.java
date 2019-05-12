package edu.java.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

public class IPAddress implements Serializable
{
    final String address;

    public IPAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public int hashCode()
    {
        return Objects.hashCode(address);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
        {
            return false;
        }
        IPAddress address = (IPAddress)obj;
        return getAddress().equals(address.getAddress());
    }

    @Override
    public String toString()
    {
        return getAddress();
    }
}
