package ru.kpfu.Auto.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.springframework.stereotype.Service;
@Service
public class ParserHtml implements Parser {

    private String ContentOfHTTPPage;
    private final String cod="utf-8";
    private String EXPRESSION = "";
	

	public void InitializeDocument(String URI) throws Exception {
		StringBuilder sb = new StringBuilder();
		URL pageURL = new URL(URI);
		URLConnection uc = pageURL.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), cod));
		try {
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine + "\n");
			}
		} finally {
			br.close();
		}
		ContentOfHTTPPage=sb.toString();
		
	}


	public void InitializeXPath(String EXPRESSION) throws Exception {
		this.EXPRESSION=EXPRESSION;
		
	}


	public Object[] Parse() throws Exception {
		String page = ContentOfHTTPPage;
		   HtmlCleaner cleaner = new HtmlCleaner();
			TagNode html = cleaner.clean(page);
			Object[] data = html.evaluateXPath(EXPRESSION);
			
			ArrayList<String> res= new ArrayList<String>();
			if (data.length != 0) {
				if (data[0].getClass().equals(StringBuffer.class) || data[0].getClass().equals(String.class)) {
					for (Object item : data) {
						res.add(item.toString());
					}
				} else if (data[0].getClass().equals(TagNode.class)) {
					TagNode tempTagNode;
					for (Object item : data) {
						tempTagNode = (TagNode) item;
						res.add(tempTagNode.getText().toString());
					}
				} else {
					throw new IllegalArgumentException(
							"Can't process given xpath (result type is " + data[0].getClass() + ")");
				}
			}
			Object[] results= new Object[res.size()];
			for(int i=0;i<res.size();i++){
				results[i]=res.get(i);
				
			}
		
		return results;
	}
}