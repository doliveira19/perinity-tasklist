package com.perinity.tasklist.modules.departamento.controllers;

import com.perinity.tasklist.modules.departamento.dto.CreateDepartmentDTO;
import com.perinity.tasklist.modules.departamento.dto.DepartamentoWithQtdePessoasAndTarefasDTO;
import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import com.perinity.tasklist.modules.departamento.repositories.DepartamentoRepository;
import com.perinity.tasklist.modules.departamento.useCases.CreateDepartamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private CreateDepartamentoUseCase createDepartamentoUseCase;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/{id}")
    private Optional<DepartamentoEntity> getDepartamentoById(@PathVariable int id) {
        return this.departamentoRepository.findById(id);
    }

    @GetMapping("/all")
    private List<DepartamentoEntity> getAllDepartamentos() {
        return this.departamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> createDepartamento(@RequestBody CreateDepartmentDTO dto) {
        try {
            var result = this.createDepartamentoUseCase.execute(dto);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<DepartamentoWithQtdePessoasAndTarefasDTO> findDepartamentoWithQtdePessoasAndTarefas() {
        return departamentoRepository.findDepartamentoWithQtdePessoasAndTarefas();
    }

}
