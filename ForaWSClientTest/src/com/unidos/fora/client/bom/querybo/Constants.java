package com.unidos.fora.client.bom.querybo;

import java.util.Date;

public class Constants {

	
	public static final String Q0001 	= "Q0001";
	public static final String Q0002 	= "Q0002";
	public static final String Q0003 	= "Q0003";
	public static final String Q0004 	= "Q0004";
	public static final String Q0006 	= "Q0006";
	public static final String Q0007	= "Q0007";
	
	public static final String FORACARE_ACCOUNT = "";
	public static final String FORACARE_PASSWORD = "";
	
	public static final String API_USERNAME = "";
	public static final String API_PASSWORD = "";
	
	
	
	//Authentication variables.
	
	/*============================
	 * iData Queries
	 * ============================*/
	
	

	


	public static final String IDATA_Q0002 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
											"<QueryData>\r\n" + 
											"<Account>"+ FORACARE_ACCOUNT +"</Account>\r\n" + 
											"<Password>"+ FORACARE_PASSWORD +"</Password>\r\n" + 
											"<QCase></QCase>\r\n" + 
											"</QueryData>";
	
	public static final String IDATA_Q0003 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
											"<QueryData>\r\n" + 
											"<Account>"+ FORACARE_ACCOUNT +"</Account>\r\n" + 
											"<Password>"+ FORACARE_PASSWORD +"</Password>\r\n" + 
											"<QMType>0</QMType>\r\n" + 
											"<QCase></QCase>\r\n" + 
											"</QueryData>";
	
	public static final String IDATA_Q0004 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
											"<QueryData>\r\n" + 
											"<Account>"+ FORACARE_ACCOUNT +"</Account>\r\n" + 
											"<Password>"+ FORACARE_PASSWORD +"</Password>\r\n" +  
											"<QCase></QCase>\r\n" + 
											"</QueryData>";
	
	public static final String IDATA_Q0006P = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
											"<QueryData>\r\n" + 
											"<Account>"+ FORACARE_ACCOUNT +"</Account>\r\n" + 
											"<Password>"+ FORACARE_PASSWORD +"</Password>\r\n" + 
											"<QIDType>PID</QIDType>\r\n" + 
											"<QCase>\r\n" + 
											"	<QID>502001088" + 
											"</QID>\r\n" + 
											"</QCase>\r\n" + 
											"</QueryData>";
	
	public static final String IDATA_Q0006C = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
											"<QueryData>\r\n" + 
											"<Account>"+ FORACARE_ACCOUNT +"</Account>\r\n" + 
											"<Password>"+ FORACARE_PASSWORD +"</Password>\r\n" + 
											"<QIDType>CID</QIDType>\r\n" + 
											"<QCase>\r\n" + 
											"	<QID>" + FORACARE_ACCOUNT + "</QID>\r\n" + 
											"</QCase>\r\n" + 
											"</QueryData>";
	
	public static final String IDATA_Q0007 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
											"<QueryData>\r\n" + 
											"<Account>"+ FORACARE_ACCOUNT +"</Account>\r\n" + 
											"<Password>"+ FORACARE_PASSWORD +"</Password>\r\n" + 
											"<QCase></QCase>\r\n" + 
											"</QueryData>";
	

}
