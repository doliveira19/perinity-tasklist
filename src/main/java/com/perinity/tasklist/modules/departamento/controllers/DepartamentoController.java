package com.perinity.tasklist.modules.departamento.controllers;

import com.perinity.tasklist.modules.departamento.dto.CreateDepartmentDTO;
import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import com.perinity.tasklist.modules.departamento.useCases.CreateDepartamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private CreateDepartamentoUseCase createDepartamentoUseCase;

    @PostMapping
    public ResponseEntity<Object> createDepartamento(@RequestBody CreateDepartmentDTO dto) {
        try {
            var result = this.createDepartamentoUseCase.execute(dto);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
