package com.perinity.tasklist.modules.departamento.useCases;

import com.perinity.tasklist.modules.departamento.dto.CreateDepartmentDTO;
import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import com.perinity.tasklist.modules.departamento.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDepartamentoUseCase {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoEntity execute(CreateDepartmentDTO dto) {

        var departamentoCreated = DepartamentoEntity.builder()
                .titulo(dto.getTitulo())
                .build();

        return this.departamentoRepository.save(departamentoCreated);

    }
}
