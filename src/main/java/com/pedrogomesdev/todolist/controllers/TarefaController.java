package com.pedrogomesdev.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrogomesdev.todolist.dto.TarefaDTO;
import com.pedrogomesdev.todolist.services.TarefaService;

@RestController
@RequestMapping(value = "tarefas")
public class TarefaController {

	@Autowired
	private TarefaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> getID(@PathVariable Long id) {
		TarefaDTO dto = service.methodGet(id);
		return ResponseEntity.ok(dto);
	}
	
}
