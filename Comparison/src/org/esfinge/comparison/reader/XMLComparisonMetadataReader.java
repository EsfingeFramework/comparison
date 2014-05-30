package org.esfinge.comparison.reader;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.esfinge.comparison.ComparisonDescriptor;

import net.sf.jColtrane.handler.JColtraneXMLHandler;

public class XMLComparisonMetadataReader implements ComparisonMetadataReader{

	@Override
	public void populateContainer(Class c, ComparisonDescriptor descriptor){
		try {
			SAXParser parser= SAXParserFactory.newInstance().newSAXParser();
			File file=new File(c.getSimpleName()+".xml");
			ComparisonXMLHandler handler = new ComparisonXMLHandler();
			handler.setDescriptor(descriptor);
			parser.parse(file,new JColtraneXMLHandler(handler));
		} catch (Exception e) {
			throw new RuntimeException("Can't read metadata",e);
		}
	}
	

}
