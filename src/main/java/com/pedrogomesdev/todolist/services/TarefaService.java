package com.pedrogomesdev.todolist.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedrogomesdev.todolist.dto.TarefaDTO;
import com.pedrogomesdev.todolist.entities.Tarefa;
import com.pedrogomesdev.todolist.repositories.TarefaRepository;
import com.pedrogomesdev.todolist.services.exceptions.NaoEncontradoExpection;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;

	private final ModelMapper modelMapper = new ModelMapper();

	@Transactional(readOnly = true)
	public TarefaDTO methodGet(Long id) {
		Tarefa entity = repository.findById(id).orElseThrow();
		return new TarefaDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<TarefaDTO> methodGetAll(Pageable page) {
		Page<Tarefa> entity = repository.findAll(page);
		return entity.map(x -> new TarefaDTO(x));
	}

	@Transactional
	public TarefaDTO insert(TarefaDTO dto) {
		Tarefa entity = modelMapper.map(dto, Tarefa.class);
		entity = repository.save(entity);
		return new TarefaDTO(entity);
	}

	@Transactional
	public TarefaDTO update(Long id, TarefaDTO dto) {
		Tarefa entity = repository.getReferenceById(id);
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.map(dto, entity);
		entity = repository.save(entity);
		return new TarefaDTO(entity);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NaoEncontradoExpection("Tarefa Inexistente!");
		}
		repository.deleteById(id);
	}
	
	

}
