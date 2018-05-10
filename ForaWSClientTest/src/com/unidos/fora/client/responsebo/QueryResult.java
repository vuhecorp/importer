package com.unidos.fora.client.responsebo;

public class QueryResult
{
    private String ReCode;

    private ReData ReData;

    public String getReCode ()
    {
        return ReCode;
    }

    public void setReCode (String ReCode)
    {
        this.ReCode = ReCode;
    }

    public ReData getReData ()
    {
        return ReData;
    }

    public void setReData (ReData ReData)
    {
        this.ReData = ReData;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ReCode = "+ReCode+", ReData = "+ReData+"]";
    }
}