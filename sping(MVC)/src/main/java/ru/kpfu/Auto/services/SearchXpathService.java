package ru.kpfu.Auto.services;

import java.util.ArrayList;


public interface SearchXpathService {
	public abstract ArrayList<String> search(String xpath,String Url) throws Exception;
}
