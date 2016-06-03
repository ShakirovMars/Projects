package ru.kpfu.Auto.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class SearchXpath implements SearchXpathService {

	private Parser parser;

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public ArrayList<String> search(String xpath, String Url) throws Exception {

		ArrayList<String> results = new ArrayList<String>();
		parser.InitializeDocument(Url);
		parser.InitializeXPath(xpath);
		Object[] data = parser.Parse();

		for (int i = 0; i < data.length; i++) {
			results.add(data[i].toString());

		}
		return results;
	}

}
