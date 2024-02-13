package com.perinity.tasklist.modules.tarefas.useCases;

import com.perinity.tasklist.modules.tarefas.entites.TarefaEntity;
import com.perinity.tasklist.modules.tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloseTarefaUseCase {
    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaEntity execute(int id) throws Exception {
        var tarefa = this.tarefaRepository.findById(id);

        if (tarefa.isEmpty()) {
            throw new Exception("Tarefa não encontrada");
        }
        TarefaEntity closedTarefa = tarefa.get();
        closedTarefa.setFinalizado(true);

        return this.tarefaRepository.save(closedTarefa);

    }
}
