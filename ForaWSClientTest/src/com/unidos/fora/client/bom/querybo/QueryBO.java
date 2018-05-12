package com.unidos.fora.client.bom.querybo;

/**
 * @author vuhernandez
 */
public class QueryBO {

	private String name;
	private String qCode;
	private String desc;
	private String iData;
	private String XMLResponse;
	private String JSONResponse;
	private String fileName;
	private String responseObject;
	
	public QueryBO() {
		this.responseObject = null;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getiData() {
		return iData;
	}

	public void setiData(String iData) {
		this.iData = iData;
	}

	public String getqCode() {
		return qCode;
	}

	public void setqCode(String qCode) {
		this.qCode = qCode;
	}
	public String getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(String responseObject) {
		this.responseObject = responseObject;
	}

	public String getXMLResponse() {
		return XMLResponse;
	}

	public void setXMLResponse(String xMLResponse) {
		XMLResponse = xMLResponse;
	}

	public String getJSONResponse() {
		return JSONResponse;
	}

	public void setJSONResponse(String jSONResponse) {
		JSONResponse = jSONResponse;
	}

	


}
