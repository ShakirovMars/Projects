package ru.kpfu.Auto.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.kpfu.AutoFx.application.MainApp;
import ru.kpfu.AutoFx.models.Auto;

public class AutoService {
	

	
	
	// Ссылка на главное приложение.
		private MainApp mainApp;

		// Вызывается главным приложением, которое даёт на себя ссылку.

		public void setMainApp(MainApp mainApp) {
			this.mainApp = mainApp;
		}

	
	
	public String helloServer() {
		String url = "http://localhost:8080/RestService/Auto/hello";
		return  mainApp.getHttpService().sendGet(url);
		
	}

	public String add(Auto auto) throws Exception {
		if (auto != null) {
			String url = "http://localhost:8080/RestService/Auto/new_auto";
			List<BasicNameValuePair> params = new ArrayList();
			params.add(new BasicNameValuePair("model", auto.getModel()));
			params.add(new BasicNameValuePair("yearAuto", auto.getYearAuto() + ""));
			params.add(new BasicNameValuePair("cost", auto.getCost() + " "));
			params.add(new BasicNameValuePair("typeAuto", auto.getTypeAuto()));
			return mainApp.getHttpService().sendPost(url, params);
		} else
			return "Ошибка";
		
	}

	public List<Auto> getCars() {
		String url = "http://localhost:8080/RestService/Auto/cars";
		String response = mainApp.getHttpService().sendGet(url);

		try {
			ObjectMapper mapper = new ObjectMapper();
			List<Auto> cars = mapper.readValue(response, new TypeReference<List<Auto>>() {
			});
			return cars;
		} catch (IOException e) {
			return null;
		}
	}

	public String delete(Auto auto) throws Exception {
		if (auto != null) {
			String url = "http://localhost:8080/RestService/Auto/delete/auto";

			List<BasicNameValuePair> params = new ArrayList();
			params.add(new BasicNameValuePair("id", auto.getId() + ""));
			return mainApp.getHttpService().sendPost(url, params);

		} else
			return "Ошибка";
		
	}

	public String update(Auto auto) throws Exception {
		if (auto != null) {
			String url = "http://localhost:8080/RestService/Auto/auto/edit";

			List<BasicNameValuePair> params = new ArrayList();
			params.add(new BasicNameValuePair("id", auto.getId() + ""));
			params.add(new BasicNameValuePair("model", auto.getModel()));
			params.add(new BasicNameValuePair("yearAuto", auto.getYearAuto() + ""));
			params.add(new BasicNameValuePair("cost", auto.getCost() + ""));
			params.add(new BasicNameValuePair("typeAuto", auto.getTypeAuto()));
			 return mainApp.getHttpService().sendPost(url, params);
		} else
			return "Ошибка";
		
	}

}
