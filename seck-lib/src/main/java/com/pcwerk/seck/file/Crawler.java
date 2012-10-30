package com.pcwerk.seck.file;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 

import java.io.*;
import java.util.HashMap;


public class Crawler {
	
	//Variables retrieving from App.java
	HashMap<String,String> params;
	String rootUrl;
	int depth;

	//Variables that are being collected to go into xml
	String url;
	String contentTitle;
	String contentBody;
	Elements linkAndAnchor;
	
	public Crawler(HashMap<String, String> params){
		this.params = params;
		this.rootUrl = params.get("root-url");
		this.depth = Integer.parseInt(params.get("depth"));
	}
	
	 public void crawl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		 try
		 {
		 
		    Document doc = Jsoup.connect(rootUrl).get();	
		    
		    //URL, Content, Link and Anchor
		    url = doc.baseUri();
		    contentTitle = doc.title();
		    contentBody = doc.body().text();
	        linkAndAnchor = doc.select("a[href]");
         
	               
	        /*Format to xml*/
	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// sites elements
			org.w3c.dom.Document xml = docBuilder.newDocument();
			org.w3c.dom.Element sitesElement = xml.createElement("sites");
			xml.appendChild(sitesElement);
			
			//site elements
			org.w3c.dom.Element site = xml.createElement("site");
			sitesElement.appendChild(site);
			
			//url elements
			org.w3c.dom.Element urlElement = xml.createElement("url");
			urlElement.appendChild(xml.createTextNode(url));
			site.appendChild(urlElement);
			
			//content elements
			org.w3c.dom.Element contentElement = xml.createElement("content");
			contentElement.appendChild(xml.createTextNode(contentTitle));
			contentElement.appendChild(xml.createTextNode(contentBody));
			site.appendChild(contentElement);
			
			//Write link and anchor elements
			for (Element la : linkAndAnchor) {
				org.w3c.dom.Element laElement = xml.createElement("link");
				laElement.appendChild(xml.createTextNode(la.text()));
				site.appendChild(laElement);
		    }
			
			
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			StreamResult result = new StreamResult(new File("C:\\Users\\home\\Desktop\\file.xml"));
	 
		
			
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			//printXml();
	 
			transformer.transform(source, result);
			
			
	        
		 } 
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 } 
		   
	}
	 
	 public void printXml(){
	        System.out.println("<sites>");
	        System.out.println("<site>");
	        System.out.println("<url>" + url + "</url>");
	        System.out.println("<links>");
	        for (Element la : linkAndAnchor) {
	            System.out.println("<link>" + la + "</link>");
	        }
	        System.out.println("</links>");
	        System.out.println("<content>");
	        System.out.println(contentTitle);
	        System.out.println(contentBody);
	        System.out.println("</content>");
	        System.out.println("</site>");
	        System.out.println("</sites>"); 	 
	 }
	 
}


//and when done... do i just commit? exactly. bascially you will submit a pull request from you to me ()
//arrow pointing at me) then i can publish. ok
