package com.perinity.tasklist.modules.departamento.repositories;

import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {
    public List<DepartamentoEntity> findByTitulo(String titulo);

}
