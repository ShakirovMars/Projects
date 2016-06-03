package ru.kpfu.Auto.services;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
@Service
public class ParserXml implements Parser {

	private Document doc;
	private XPathExpression expr;
	private NodeList nodeList;
	public void InitializeDocument(String URI) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException ex) {
			throw new Exception("Can't crate DocumentBuilder");
		}

		// Load XML document from WWW
		try {
			doc = builder.parse(URI);
		} catch (IOException ex) {
			throw new Exception("Can't get XML by URL " + URI);
		} catch (SAXException ex) {
			throw new Exception("Can't read downloaded XML.");
		}

	}

	public void InitializeXPath(String EXPRESSION) throws Exception {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		javax.xml.xpath.XPath xpath = xPathfactory.newXPath();

		try {
			expr = ((javax.xml.xpath.XPath) xpath).compile(EXPRESSION);
		} catch (XPathExpressionException ex) {
			throw new Exception("Can't parse xPath expression " + EXPRESSION);
		}

	}

	public Object[] Parse() throws Exception {
		try {
			nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

		} catch (XPathExpressionException ex) {
			throw new Exception("Can't evaluate exression");
		}
		Object[] data = new Object[nodeList.getLength()];
		for (int i = 0; i < nodeList.getLength(); i++) {

			data[i] = nodeList.item(i).getTextContent();
		}
		return data;
	}

}



