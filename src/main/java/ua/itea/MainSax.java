package ua.itea;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MainSax {
	
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		DefaultHandler handler = new MySaxParser();
		File file = new File("pom.xml");
		if (file.exists()) {
			parser.parse(file, handler); 
		} else {
			System.out.println(file.getName() + " не найден");
		}
	}
}
