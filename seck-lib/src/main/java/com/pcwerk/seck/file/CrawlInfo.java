package com.pcwerk.seck.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class CrawlInfo {

	List data = null;
	
	public CrawlInfo(){}
	
	public CrawlInfo( String fileName ) {
		
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("Files/" + fileName);
		
		try {
			
			Document document = (Document) builder.build(xmlFile);
			
			Element rootNode = document.getRootElement();
			
			data = rootNode.getChildren("site");
			
//			new XMLOutputter().output(document, System.out);
			
		} catch (JDOMException e) {

			e.printStackTrace();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			
		}		
		
	}
	
	public void printData() {
		
		if(data != null) {
			
			for( Object site : data ) {

				System.out.println( "URL: " + ((Element)site).getChildText("url") );
				System.out.println( "Content: " + ((Element)site).getChildText("content") );
				System.out.println( "Links: " );
		
				Element linksNode = ((Element)site).getChild("links");				
				
				for( Object link : linksNode.getChildren("link") ) {
					
					System.out.println("  " + ((Element)link).getValue());
					
				}
				
			}
			
		}
		
	}	
	
}
