package com.unidos.fora.client.responsebo;

public class ReData
{
    private CaseMData[] CaseMData;

   

    public CaseMData[] getCaseMData() {
		return CaseMData;
	}



	public void setCaseMData(CaseMData[] caseMData) {
		CaseMData = caseMData;
	}



	@Override
    public String toString()
    {
        return "ClassPojo [CaseMData = "+CaseMData+"]";
    }
}