/*
 * Prints out the extracted metadata from a multimedia file
 * use jpeg, png, mp3, wav, midi,... files
 * 
 */

package com.pcwerk.seck.file;

import java.io.File;
import java.io.FileInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

public class MediaExtractor {

	public void extract(String fileName){	
		try{  

			File file = new File(fileName);

			Parser parser = new AutoDetectParser();
			Metadata metadata = new Metadata();
			ParseContext parseContext = new ParseContext();

			ContentHandler handler = new BodyContentHandler();
			parser.parse(new FileInputStream(file), handler, metadata, parseContext);

			for (String name : metadata.names()) 
				System.out.println("metadata: " + name + " - " + metadata.get(name));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
     
//	public static void main( String[] args )
//	{
//		MediaExtractor app = new MediaExtractor();
//		app.extract("/Users/macbook/Documents/lion.jpg");
//
//	}

}