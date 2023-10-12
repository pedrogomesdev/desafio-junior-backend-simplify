package com.pedrogomesdev.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrosDTO {
	
	private String fieldName;
    private String message;
}
