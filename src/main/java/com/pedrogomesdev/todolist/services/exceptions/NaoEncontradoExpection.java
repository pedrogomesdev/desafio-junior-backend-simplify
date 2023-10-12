package com.pedrogomesdev.todolist.services.exceptions;
@SuppressWarnings("serial")
public class NaoEncontradoExpection extends RuntimeException {
	
	public NaoEncontradoExpection (String msg) {
		super(msg);
	}
}
