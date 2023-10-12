package com.pedrogomesdev.todolist.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ValidandoErrorDTO extends ErrorCustomizado {

	@Autowired
	private List<ErrosDTO> errors = new ArrayList<>();

	public ValidandoErrorDTO(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public List<ErrosDTO> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new ErrosDTO(fieldName, message));
	}

}
