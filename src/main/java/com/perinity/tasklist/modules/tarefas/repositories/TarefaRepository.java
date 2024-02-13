package com.perinity.tasklist.modules.tarefas.repositories;

import com.perinity.tasklist.modules.tarefas.entites.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Integer> {

}
