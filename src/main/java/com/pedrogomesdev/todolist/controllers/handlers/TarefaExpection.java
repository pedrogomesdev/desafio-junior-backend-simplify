package com.pedrogomesdev.todolist.controllers.handlers;

import java.time.Instant;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.pedrogomesdev.todolist.dto.ErrorCustomizado;
import com.pedrogomesdev.todolist.dto.ValidandoErrorDTO;
import com.pedrogomesdev.todolist.services.exceptions.NaoEncontradoExpection;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TarefaExpection {
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorCustomizado> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorCustomizado error = new ErrorCustomizado(Instant.now(), status.value(), "Tipo de entrada invalido!", request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(NaoEncontradoExpection.class)
	public ResponseEntity<ErrorCustomizado> naoEncontradoExpection(NaoEncontradoExpection e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorCustomizado error = new ErrorCustomizado(Instant.now(), status.value(), "Tarefa inexistente!", request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorCustomizado> noSuchElementException(NoSuchElementException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorCustomizado error = new ErrorCustomizado(Instant.now(), status.value(), "Recurso inexistente", request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorCustomizado> argumentoInvalido(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidandoErrorDTO error = new ValidandoErrorDTO(Instant.now(), status.value(), "Dados invalidos", request.getRequestURI());
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			error.addError(f.getField(), f.getDefaultMessage());
        }
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorCustomizado> entityNotFoundException(EntityNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ErrorCustomizado error = new ErrorCustomizado(Instant.now(), status.value(), "Entindade não existe", request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	
}
