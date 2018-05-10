package com.unidos.fora.client.bom.querybo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryBuilder {
	
	public static final String FORACARE_ACCOUNT = "UNIDOSADMIN";
	public static final String FORACARE_PASSWORD = "AAUHCGP01";
	
	public static final String API_IDATA_HEADER =  "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
												   "<QueryData>\r\n" + 
												   "<Account>" + FORACARE_ACCOUNT + "</Account>\r\n" + 
												   "<Password>" + FORACARE_PASSWORD + "</Password>\r\n";
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public QueryBuilder() {
		
	}
	
	
	/**
	 * Builds the generic query type.
	 * @param pids
	 * @return
	 */
	public static String GenericBuilder(List<String> pids) {
		if (pids == null) {
			pids = new ArrayList<String>();
		}
		StringBuilder query = new StringBuilder();
		
		//attach header
		query.append(API_IDATA_HEADER);
		
		//build iData
		query.append("<QCase>");
		
		//append pid list of provided
		if (!pids.isEmpty()) {
			for (String pid : pids) {
				query.append("<PID>" + pid  + "</PID>");
			}
		}
		
		query.append("</QCase>");
		query.append("</QueryData>");
		
		return query.toString();
	}
	
	/**
	 * Patient Reading query builder
	 * 
	 * @param startDate
	 * @param endDate
	 * @param QMType
	 * @param pids
	 * @return
	 */
	public static String Q0001Builder(Date startDate , Date endDate, int QMType, List<String> pids) {
		
		if (pids == null) {
			pids = new ArrayList<String>();
		}
		
		StringBuilder query = new StringBuilder();
		
		//attach header
		query.append(API_IDATA_HEADER);
		
		//build iData
		query.append("<QSDate>"+ sdf.format(startDate)+ "</QSDate>"); 
		query.append("<QEDate>"+ sdf.format(endDate)+ "</QEDate>");
		query.append("<QMType>" + QMType +"</QMType>");
		query.append("<QCase>");
		
		//append pid list of provided
		if (!pids.isEmpty()) {
			for (String pid : pids) {
				query.append("<PID>" + pid  + "</PID>");
			}
		}
		
		query.append("</QCase>");
		query.append("</QueryData>");
		
		return query.toString();
	}
	
	
	
	/**
	 * Returns a list of patient profiles. 
	 * Pass null to retrieve all or 
	 * pass a list of PIDs.
	 * @param pids
	 * @return
	 */
	public static String Q0002Builder(List<String> pids) {
		return GenericBuilder(pids);
	}
	
	/**
	 * Returns a list of patient target ranges. 
	 * Pass 0 for all types or specify an int type.
	 * Pass null for PIDs to retrieve all or 
	 * pass a list of PIDs.
	 * @param QMType
	 * @param pids
	 * @return
	 */
	public static String Q0003Builder(int QMType, List<String> pids) {
		
		if (pids == null) {
			pids = new ArrayList<String>();
		}
		
		StringBuilder query = new StringBuilder();
		
		//attach header
		query.append(API_IDATA_HEADER);
		query.append("<QMType>" + QMType +"</QMType>");
		//build iData
		query.append("<QCase>");
		
		//append pid list of provided
		if (!pids.isEmpty() || pids == null) {
			for (String pid : pids) {
				query.append("<PID>" + pid  + "</PID>");
			}
		}
		
		query.append("</QCase>");
		query.append("</QueryData>");
		
		return query.toString();
	}

	/**
	 * Returns a list of meter mappings. 
	 * Pass null to retrieve all or 
	 * pass a list of PIDs.
	 * @param pids
	 * @return
	 */
	public static String Q0004Builder(List<String> pids) {
		return GenericBuilder(pids);
	}
	
		
	/**
	 * Generic Q0006 builder
	 * @param QIDType
	 * @param ids
	 * @return
	 */
	public static String Q0006Builder(String QIDType, List<String> ids) {
		
		if (ids == null) {
			ids = new ArrayList<String>();
		}
		
		StringBuilder query = new StringBuilder();
		
		//attach header
		query.append(API_IDATA_HEADER);
		
		//build iData

		query.append("<QIDType>" + QIDType +"</QIDType>");
		query.append("<QCase>");
		
		//append pid list
		for (String id : ids) {
			query.append("<QID>" + id  + "</QID>");
		}
		
		query.append("</QCase>");
		query.append("</QueryData>");
		
		return query.toString();
	}
	
	
	/**
	 * Returns patient care-givers.
	 * @param ids
	 * @return
	 */
	public static String QOOO6PBuilder(List<String> pids) {
		return Q0006Builder("PID", pids);
	}
	
	/**
	 * Returns caregiver's patients.
	 * @param cids
	 * @return
	 */
	public static String QOOO6CBuilder(List<String> cids) {
		return Q0006Builder("CID", cids);
	}

	/**
	 * Returns patient profiles.
	 * @param pids
	 * @return
	 */
	public static String Q0007Builder(List<String> pids) {
		return GenericBuilder(pids);
	}

}
