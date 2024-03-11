package com.ap.bibliothek;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ap.model.TextFormular;
import com.ap.parser.DOMparser;

public class Generator {
	
	File xmlDatei = new File("src/main/resources/XML/formular1.xml");;
	String htmlDatei;
	Document domDoc;
	
	public String generateForm() throws IOException
	{
		
	DOMparser parser = new DOMparser();
	domDoc = parser.parseFile(xmlDatei);
	TextFormular tForm = new TextFormular();
	NodeList nList = domDoc.getElementsByTagName("formularfeld");
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append("<form>");
	
	for (int i = 0; i < nList.getLength(); i++)
	{
		Node nNode = nList.item(i);
		System.out.println("Node name: " + nNode.getNodeName());
		if(nNode.getNodeType() == Node.ELEMENT_NODE)
		{
			Element eElement = (Element) nNode;
			String typ = eElement.getAttribute("typ");
			
			if (typ.equals("text"))
			{
			String label = eElement.getElementsByTagName("titel").item(0).getTextContent();
			stringBuilder.append("<label>" + label + "</label>");
			stringBuilder.append("<br>");
			stringBuilder.append("<input type=\"" + typ + "\">");
			stringBuilder.append("<br>");
			}
		}
	}
	stringBuilder.append("</form>");
	stringBuilder.append("<input type=\"submit\">");
	String htmlDatei = stringBuilder.toString();
	
	return htmlDatei;
	
	}
}
