package com.pedrogomesdev.todolist.dto;

import com.pedrogomesdev.todolist.entities.Prioridade;
import com.pedrogomesdev.todolist.entities.Realizado;
import com.pedrogomesdev.todolist.entities.Tarefa;

public class TarefaDTO {

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Realizado realizado;
	private Prioridade prioridade;
	
	public TarefaDTO() {}

	public TarefaDTO(Long id, String nome, String descricao, Realizado realizado, Prioridade prioridade) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.realizado = realizado;
		this.prioridade = prioridade;
	}
	
	public TarefaDTO(Tarefa entity) {
		id = entity.getId();
		nome = entity.getNome();
		descricao = entity.getDescricao();
		realizado = entity.getRealizado();
		prioridade = entity.getPrioridade();		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Realizado getRealizado() {
		return realizado;
	}

	public void setRealizado(Realizado realizado) {
		this.realizado = realizado;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
	
}
