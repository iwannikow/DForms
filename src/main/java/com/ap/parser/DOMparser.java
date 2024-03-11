package com.ap.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DOMparser {
	
	Document doc;
	
	public Document parseFile (File file)
	{
	
	try {
	
	File xmlDatei = file;
	DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuild = dbFact.newDocumentBuilder();
	doc = dBuild.parse(xmlDatei);
	
	
	}
	catch (Exception e) {}
	
	return doc;
	
	}
}
