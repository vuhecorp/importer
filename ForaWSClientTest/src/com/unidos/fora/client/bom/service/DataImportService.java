package com.unidos.fora.client.bom.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tdcare.bom.DataInterchangeResponse;
import com.tdcare.www.WS_DataInterchangeServiceLocator;
import com.tdcare.www.WS_DataInterchangeServiceSoapStub;
import com.unidos.fora.bom.ApplicationContext;
import com.unidos.fora.client.bom.querybo.QueryBO;
import com.unidos.fora.client.bom.querybo.QueryBOService;
import com.unidos.fora.client.responsebo.MData;
import com.unidos.fora.client.responsebo.MDataDeserializer;
import com.unidos.fora.client.responsebo.PatientReadingResponse;

public class DataImportService {
	static Logger log = Logger.getLogger(DataImportService.class.getName());
	
	static String DATA_DIRECTORY = new String();
	static String CONFIG_FILE_LOCATION = new String();
	private static ApplicationContext context = null;
	
	public static void main(String[] args) {
		
		//validate for required arguments
		
		/*if (args.length != 1) {
			log.error("No configuration file specified. Exit..");
			System.exit(1);
		}*/
		
		/*CONFIG_FILE_LOCATION = args[0];*/
		CONFIG_FILE_LOCATION = "E:\\config.properties";
		
		try {
			setConfigPorperties();
			
			//create Foracare web service objects.
			WS_DataInterchangeServiceLocator locator = new WS_DataInterchangeServiceLocator();
			WS_DataInterchangeServiceSoapStub stub = new WS_DataInterchangeServiceSoapStub(new URL(locator.getWS_DataInterchangeServiceSoapAddress()), locator);
			
			//generate the required soap header element
			stub.setHeader(generateSoapHeaderElem());
			
			//execute imports.
			List<QueryBO> queries = executeDataImports(stub);
			
			//extract responses to objects.
			extractToObjects(queries);
			
			log.info("Import successful");
			
		} catch (RemoteException e) {
			log.error(e.getMessage());
		} catch (SOAPException e) {
			log.error(e.getMessage());
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		} catch (SAXException e) {
			log.error(e.getMessage());
		} catch (ParserConfigurationException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (TransformerException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	private static void setConfigPorperties() throws Exception {
		//set configuration file information and extract properties.
		context = ApplicationContext.getInstance();
		context.setPropertiesLocation(CONFIG_FILE_LOCATION);
		context.loadProperties();
		
		//set location where data will be stored
		DATA_DIRECTORY = context.getProperties().getProperty(ApplicationContext.DATA_STORAGE_LOCATION);
	}

	private static void extractToObjects(List<QueryBO> queries) {
		try {
			for (QueryBO queryBO : queries) {
				if (queryBO.getResponseObject() != null) {
					parseToObject(queryBO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<QueryBO> executeDataImports(WS_DataInterchangeServiceSoapStub stub) throws SAXException, ParserConfigurationException, IOException, TransformerException {
		QueryBOService queryService = new QueryBOService();
		List<QueryBO> queryList = queryService.getQueryList();
		for (QueryBO query : queryList) {
			log.info("Importing: " + query.getDesc());
			String response = stub.dataInterchange(query.getqCode(), query.getiData());
			query.setXMLResponse(response);
			stringToDocument(query);
		}
		return queryList;
	}

	
	public static void stringToDocument(QueryBO query) 
	        throws SAXException, ParserConfigurationException, IOException, TransformerException {
		stringToXMLDocument(query);
	    stringToJSONDocument(query);
	}
	
	@SuppressWarnings("unchecked")
	private static void stringToJSONDocument(QueryBO query) {
		log.info("Writing to JSON Document..");
		JSONObject xmlJSONObj = XML.toJSONObject(query.getXMLResponse());
		String jsonResponse = xmlJSONObj.toString();
		query.setJSONResponse(jsonResponse);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) new Gson().fromJson(jsonResponse, map.getClass());
		
		try (FileWriter file = new FileWriter(DATA_DIRECTORY + query.getFileName() + ".json")) {
			file.write(jsonResponse);
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void parseToObject(QueryBO query) {
		try {
		 	GsonBuilder gsonBuilder = new GsonBuilder();
		    gsonBuilder.registerTypeAdapter(MData[].class, new MDataDeserializer());
		    Gson gson = gsonBuilder.create();
		    PatientReadingResponse responseObject = gson.fromJson(query.getJSONResponse(), PatientReadingResponse.class);
		    log.info(responseObject.toString());
		} catch (Exception e) {
			throw e;
		}
	}

	private static void stringToXMLDocument(QueryBO query) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		log.info("Writing to XML Document..");
		// Parse the given input
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.parse(new InputSource(new StringReader(query.getXMLResponse())));

	    // Write the parsed document to an xml file
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    StreamResult result =  new StreamResult(new File(DATA_DIRECTORY + query.getFileName() + ".xml"));
	   
	    transformer.transform(source, result);
	}

	/**
	 * Generates Soap Header for API call.
	 * @return
	 * @throws SOAPException
	 */
	public static SOAPHeaderElement generateSoapHeaderElem() throws SOAPException {
		
		String username = context.getProperties().getProperty(ApplicationContext.FORACARE_API_USERNAME);
		String password = context.getProperties().getProperty(ApplicationContext.FORACARE_API_PASSWORD);
		
		log.info("Generating header soap object.");
		String targetNamespace = "http://www.tdcare.com/";
		QName qname = new QName(targetNamespace, "sValidationSoapHeader", new String());
		SOAPHeaderElement sValidationSoapHeader = new SOAPHeaderElement(qname);
		SOAPElement userName = sValidationSoapHeader.addChildElement("Username");
		userName.addTextNode(username);
		SOAPElement headerPassword = sValidationSoapHeader.addChildElement("Password");
	    headerPassword.addTextNode(password);
	    return sValidationSoapHeader;
	}
	
	public static void clear() {

		 try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			;;
		}
	}
	
}
