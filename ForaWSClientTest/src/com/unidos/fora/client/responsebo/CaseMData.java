package com.unidos.fora.client.responsebo;

import java.util.ArrayList;


public class CaseMData
{
    private String PID;

    private MData[] MData;

    public String getPID ()
    {
        return PID;
    }

    public void setPID (String PID)
    {
        this.PID = PID;
    }
    
	public MData[] getMData() {
		return MData;
	}

	public void setMData(MData[] mData) {
		MData = mData;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [PID = "+PID+", MData = "+MData+"]";
    }
}