package ru.kpfu.Auto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	protected String entity = "page";

	public NotFoundException() {
		super();
	}

	public NotFoundException(String entity) {
		super();
		this.entity = entity;
	}

	public String getEntity() {
		return entity;
	}
}
