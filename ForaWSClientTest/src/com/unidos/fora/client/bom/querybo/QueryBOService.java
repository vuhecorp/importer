package com.unidos.fora.client.bom.querybo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.unidos.fora.bom.ApplicationContext;


/**
 * @author vuhernandez
 */
public class QueryBOService {

	List<QueryBO> queryList;
	
	public QueryBOService() {
		queryList = new ArrayList<QueryBO>();
		loadQueryList();
	}

	public void loadQueryList() {
		
		this.queryList = new ArrayList<QueryBO>();
		
		QueryBO patientReadings = new QueryBO();
		patientReadings.setName("patientReadings");
		patientReadings.setDesc("meter readings");
		patientReadings.setqCode(ApplicationContext.Q0001);
		patientReadings.setiData(QueryBuilder.Q0001Builder(stringToDate("2017/01/01"), stringToDate("2017/06/01"), 0, null));
		patientReadings.setFileName("Q0001_Patient_Reading");
		patientReadings.setResponseObject("com.unidos.fora.client.responsebo.PatientReadingResponse");
		queryList.add(patientReadings);
	
		QueryBO patientProfiles = new QueryBO();
		patientProfiles.setName("patientProfiles");
		patientProfiles.setDesc("patient profiles");
		patientProfiles.setqCode(ApplicationContext.Q0002);
		patientProfiles.setiData(QueryBuilder.Q0002Builder(null));
		patientProfiles.setFileName("Q0002_Patient_Profile");
		queryList.add(patientProfiles);
		
		QueryBO patientTargetRange = new QueryBO();
		patientTargetRange.setName("patientTargetRange");
		patientTargetRange.setDesc("patient target range");
		patientTargetRange.setqCode(ApplicationContext.Q0003);
		patientTargetRange.setiData(QueryBuilder.Q0003Builder(0, null));
		patientTargetRange.setFileName("Q0003_Patient_Target_Range");
		queryList.add(patientTargetRange);
		
		QueryBO meterMappings = new QueryBO();
		meterMappings.setName("meterMappings");
		meterMappings.setDesc("meter mapping info");
		meterMappings.setqCode(ApplicationContext.Q0004);
		meterMappings.setiData(QueryBuilder.Q0004Builder(null));
		meterMappings.setFileName("Q0004_Meter_Mapping");
		queryList.add(meterMappings);
		
		QueryBO patientCaregiver = new QueryBO();
		patientCaregiver.setName("patientCaregivers");
		patientCaregiver.setDesc("patient caregiver info");
		patientCaregiver.setqCode(ApplicationContext.Q0006);
		patientCaregiver.setiData(QueryBuilder.Q0006PBuilder(new ArrayList<String>(Arrays.asList("502001088"))));
		patientCaregiver.setFileName("Q0006_Patient_Caregiver");
		queryList.add(patientCaregiver);
		
		QueryBO caregiverPatients = new QueryBO();
		caregiverPatients.setName("careGiverPatients");
		caregiverPatients.setDesc("caregiver patient info");
		caregiverPatients.setqCode(ApplicationContext.Q0006);
		caregiverPatients.setiData(QueryBuilder.Q0006CBuilder(new ArrayList<String>(Arrays.asList("UNIDOSADMIN"))));
		caregiverPatients.setFileName("Q0006_Caregiver_Patient");
		queryList.add(caregiverPatients);
		
		QueryBO caregiverProfiles = new QueryBO();
		caregiverProfiles.setName("caregiverProfiles");
		caregiverProfiles.setDesc("caregiver profiles");
		caregiverProfiles.setqCode(ApplicationContext.Q0007);
		caregiverProfiles.setiData(QueryBuilder.Q0007Builder(null));
		caregiverProfiles.setFileName("Q0007_Caregiver_Profile");
		queryList.add(caregiverProfiles);
		
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
