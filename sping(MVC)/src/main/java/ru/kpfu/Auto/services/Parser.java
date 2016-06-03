package ru.kpfu.Auto.services;




public interface Parser {
	public abstract void InitializeDocument(String URI) throws Exception;

	public abstract void InitializeXPath(String EXPRESSION) throws Exception;

	public abstract Object[] Parse() throws Exception;
}
