package com.perinity.tasklist.modules.departamento.repositories;

import com.perinity.tasklist.modules.departamento.dto.DepartamentoWithQtdePessoasAndTarefasDTO;
import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {
    List<DepartamentoEntity> findByTitulo(String titulo);

    @Query(value = "SELECT d.id AS id, d.titulo AS titulo, resultPessoas.qtdePessoas AS qtdePessoas, resultTarefas.qtdeTarefas AS qtdeTarefas FROM departamentos d\n" +
            "LEFT JOIN (\n" +
            "  SELECT p.id_departamento, count(*) as qtdePessoas from pessoas p\n" +
            "  group by p.id_departamento\n" +
            ") resultPessoas on d.id = resultPessoas.id_departamento\n" +
            "LEFT JOIN (\n" +
            "  SELECT t.id_departamento, count(*) as qtdeTarefas from tarefas t\n" +
            "  group by t.id_departamento\n" +
            ") as resultTarefas on d.id = resultTarefas.id_departamento", nativeQuery = true)
    List<DepartamentoWithQtdePessoasAndTarefasDTO> findDepartamentoWithQtdePessoasAndTarefas();

}
