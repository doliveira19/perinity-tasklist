package com.perinity.tasklist.modules.tarefas.controllers;

import com.perinity.tasklist.modules.tarefas.dto.CreateTarefaDTO;
import com.perinity.tasklist.modules.tarefas.useCases.CloseTarefaUseCase;
import com.perinity.tasklist.modules.tarefas.useCases.CreateTarefaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private CreateTarefaUseCase createTarefaUseCase;

    @Autowired
    private CloseTarefaUseCase closeTarefaUseCase;

    @PostMapping
    private ResponseEntity<Object> createTarefa(@RequestBody CreateTarefaDTO dto) throws Exception {
        try {
            var result = this.createTarefaUseCase.execute(dto);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/finalizar/{id}")
    private ResponseEntity<Object> closeTarefa(@PathVariable int id) throws Exception {
        try {
            var result = this.closeTarefaUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
