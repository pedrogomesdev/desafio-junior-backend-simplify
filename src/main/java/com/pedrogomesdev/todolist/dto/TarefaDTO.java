package com.pedrogomesdev.todolist.dto;

import com.pedrogomesdev.todolist.entities.Prioridade;
import com.pedrogomesdev.todolist.entities.Realizado;
import com.pedrogomesdev.todolist.entities.Tarefa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

	private Long id;	
	private String nome;
	private String descricao;
	private Realizado realizado;
	private Prioridade prioridade;
		
	public TarefaDTO(Tarefa entity) {
		id = entity.getId();
		nome = entity.getNome();
		descricao = entity.getDescricao();
		realizado = entity.getRealizado();
		prioridade = entity.getPrioridade();		
	}
}
