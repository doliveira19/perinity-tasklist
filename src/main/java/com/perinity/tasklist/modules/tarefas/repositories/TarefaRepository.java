package com.perinity.tasklist.modules.tarefas.repositories;

import com.perinity.tasklist.modules.tarefas.entites.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Integer> {
    @Query("SELECT t FROM tarefas t\n" +
            "WHERE t.idPessoa IS NULL AND t.finalizado = false ORDER BY t.prazo ASC limit 3")
    List<TarefaEntity> findTop3TarefasWithoutPessoa();

}
