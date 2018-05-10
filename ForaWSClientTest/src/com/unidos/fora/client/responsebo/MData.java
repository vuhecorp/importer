package com.unidos.fora.client.responsebo;

public class MData
{
    private String MValue1;

    private String MType;

    private String MSlot;

    private String MNote;

    private String MValue2;

    private String MValue3;

    private String MDateTime;

    private String MDataID;

    public String getMValue1 ()
    {
        return MValue1;
    }

    public void setMValue1 (String MValue1)
    {
        this.MValue1 = MValue1;
    }

    public String getMType ()
    {
        return MType;
    }

    public void setMType (String MType)
    {
        this.MType = MType;
    }

    public String getMSlot ()
    {
        return MSlot;
    }

    public void setMSlot (String MSlot)
    {
        this.MSlot = MSlot;
    }

    public String getMNote ()
    {
        return MNote;
    }

    public void setMNote (String MNote)
    {
        this.MNote = MNote;
    }

    public String getMValue2 ()
    {
        return MValue2;
    }

    public void setMValue2 (String MValue2)
    {
        this.MValue2 = MValue2;
    }

    public String getMValue3 ()
    {
        return MValue3;
    }

    public void setMValue3 (String MValue3)
    {
        this.MValue3 = MValue3;
    }

    public String getMDateTime ()
    {
        return MDateTime;
    }

    public void setMDateTime (String MDateTime)
    {
        this.MDateTime = MDateTime;
    }

    public String getMDataID ()
    {
        return MDataID;
    }

    public void setMDataID (String MDataID)
    {
        this.MDataID = MDataID;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [MValue1 = "+MValue1+", MType = "+MType+", MSlot = "+MSlot+", MNote = "+MNote+", MValue2 = "+MValue2+", MValue3 = "+MValue3+", MDateTime = "+MDateTime+", MDataID = "+MDataID+"]";
    }
}