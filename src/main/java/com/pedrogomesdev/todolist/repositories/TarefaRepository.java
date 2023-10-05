package com.pedrogomesdev.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrogomesdev.todolist.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	

}
