package com.pedrogomesdev.todolist.dto;

import com.pedrogomesdev.todolist.entities.Prioridade;
import com.pedrogomesdev.todolist.entities.Realizado;
import com.pedrogomesdev.todolist.entities.Tarefa;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String nome;
	@NotBlank(message = "Campo requerido")
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
