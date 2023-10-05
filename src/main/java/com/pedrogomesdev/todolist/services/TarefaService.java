package com.pedrogomesdev.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedrogomesdev.todolist.dto.TarefaDTO;
import com.pedrogomesdev.todolist.entities.Tarefa;
import com.pedrogomesdev.todolist.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	@Transactional(readOnly = true)
	public TarefaDTO methodGet(Long id) {
		Tarefa entity = repository.findById(id).orElseThrow();
		return new TarefaDTO(entity);
	}
	
}
