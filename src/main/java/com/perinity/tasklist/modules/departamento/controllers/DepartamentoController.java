package com.perinity.tasklist.modules.departamento.controllers;

import com.perinity.tasklist.modules.departamento.dto.CreateDepartmentDTO;
import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import com.perinity.tasklist.modules.departamento.useCases.CreateDepartamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DepartamentoEntity createDepartamento(@RequestBody CreateDepartmentDTO dto) {
        return this.createDepartamentoUseCase.execute(dto);
    }

}
