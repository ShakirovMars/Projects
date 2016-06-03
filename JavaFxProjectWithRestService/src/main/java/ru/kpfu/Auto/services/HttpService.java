package ru.kpfu.Auto.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpService {

	// HTTP GET request
	public String sendGet(String url) {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			StringBuffer result = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			return "Ошибка соединения с сервером";
		}

	}

	// HTTP POST request
	public String sendPost(String url, List<BasicNameValuePair> params)  throws Exception {

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		try {
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";

			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			return "Ошибка соединения с сервером";
		}
	}

}
