package com.pedrogomesdev.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrogomesdev.todolist.entities.Tarefa;
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	

}
