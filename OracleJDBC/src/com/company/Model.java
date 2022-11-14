package com.company;

public class Model
{
    protected String EID;
    protected String ENAME;
    protected String EMPLOYEEDEPT;

    public Model(){}

    public Model(String EID, String ENAME, String EMPLOYEEDEPT)
    {
        this.EID=EID;
        this.EMPLOYEEDEPT=EMPLOYEEDEPT;
        this.ENAME=ENAME;
    }

    public String getEID()
    {
        return this.EID;
    }
    public String getENAME()
    {
        return this.ENAME;
    }
    public String getEMPLOYEEDEPT()
    {
        return this.EMPLOYEEDEPT;
    }
    public void setEID(String EID)
    {
        this.EID = EID;
    }
    public void setENAME(String ENAME)
    {
        this.ENAME = ENAME;
    }
    public void setEMPLOYEEDEPT(String EMPLOYEEDEPT)
    {
        this.EMPLOYEEDEPT = EMPLOYEEDEPT;
    }
}
