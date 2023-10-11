package com.pedrogomesdev.todolist.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedrogomesdev.todolist.dto.TarefaDTO;
import com.pedrogomesdev.todolist.services.TarefaService;

import jakarta.validation.Valid;

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

	@GetMapping
	public ResponseEntity<Page<TarefaDTO>> getIdAll(Pageable page) {
		Page<TarefaDTO> dto = service.methodGetAll(page);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> insert(@Valid @RequestBody TarefaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> insert(@PathVariable Long id, @Valid @RequestBody TarefaDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
}