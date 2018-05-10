package com.unidos.fora.client.bom.querybo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryBOService {

	List<QueryBO> queryList;
	
	public QueryBOService() {
		queryList = new ArrayList<QueryBO>();
		loadQueryList();
	}

	public void loadQueryList() {
		
		
		this.queryList = new ArrayList<QueryBO>();
		
		
		QueryBO o1 = new QueryBO();
		o1.setName("patientReadings");
		o1.setDesc("meter readings");
		o1.setqCode(Constants.Q0001);
		o1.setiData(QueryBuilder.Q0001Builder(stringToDate("2017/01/01"), stringToDate("2017/06/01"), 0, null));
		o1.setFileName("Q0001_Patient_Reading");
		o1.setResponseObject("com.unidos.fora.client.responsebo.PatientReadingResponse");
		queryList.add(o1);
		
		QueryBO o2 = new QueryBO();
		o2.setName("patientProfiles");
		o2.setDesc("patient profiles");
		o2.setqCode(Constants.Q0002);
		o2.setiData(Constants.IDATA_Q0002);
		o2.setFileName("Q0002_Patient_Profile");
		queryList.add(o2);
		
		QueryBO o3 = new QueryBO();
		o3.setName("patientTargetRange");
		o3.setDesc("patient target range");
		o3.setqCode(Constants.Q0003);
		o3.setiData(Constants.IDATA_Q0003);
		o3.setFileName("Q0003_Patient_Target_Range");
		queryList.add(o3);
		
		QueryBO o4 = new QueryBO();
		o4.setName("meterMappings");
		o4.setDesc("meter mapping info");
		o4.setqCode(Constants.Q0004);
		o4.setiData(Constants.IDATA_Q0004);
		o4.setFileName("Q0004_Meter_Mapping");
		queryList.add(o4);
		
		QueryBO o5 = new QueryBO();
		o5.setName("patientCaregivers");
		o5.setDesc("patient caregiver info");
		o5.setqCode(Constants.Q0006);
		o5.setiData(Constants.IDATA_Q0006P);
		o5.setFileName("Q0006_Patient_Caregiver");
		queryList.add(o5);
		
		QueryBO o6 = new QueryBO();
		o6.setName("careGiverPatients");
		o6.setDesc("caregiver patient info");
		o6.setqCode(Constants.Q0006);
		o6.setiData(Constants.IDATA_Q0006C);
		o6.setFileName("Q0006_Caregiver_Patient");
		queryList.add(o6);
		
		QueryBO o7 = new QueryBO();
		o7.setName("caregiverProfiles");
		o7.setDesc("caregiver profiles");
		o7.setqCode(Constants.Q0007);
		o7.setiData(Constants.IDATA_Q0007);
		o7.setFileName("Q0007_Caregiver_Profile");
		queryList.add(o7);
		
	}
	public List<QueryBO> getQueryList() {
		return queryList;
	}

	public void setQueryList(List<QueryBO> queryList) {
		this.queryList = queryList;
	}
	
	private static Date stringToDate(String sDate) {
	    Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return date;
	}
}
