package com.unidos.fora.client.responsebo;

public class PatientReadingResponse
{
    private QueryResult QueryResult;

    public QueryResult getQueryResult ()
    {
        return QueryResult;
    }

    public void setQueryResult (QueryResult QueryResult)
    {
        this.QueryResult = QueryResult;
    }

    @Override
    public String toString()
    {
        return "PatientReadingResponse [QueryResult = "+QueryResult+"]";
    }
}
