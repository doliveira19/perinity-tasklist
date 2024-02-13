package com.perinity.tasklist.modules.pessoa.repositories;

import com.perinity.tasklist.modules.pessoa.dto.PessoasWithHorasGastasDTO;
import com.perinity.tasklist.modules.pessoa.dto.PessoasWithMediaHorasDTO;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    @Query("SELECT p.nome AS nome, d.titulo AS departamento, t.duracao AS horasGastas\n" +
            "FROM pessoas p\n" +
            "LEFT JOIN tarefas t ON p.id = t.id\n" +
            "LEFT JOIN departamentos d ON p.idDepartamento = d.id")
    List<PessoasWithHorasGastasDTO> findPessoasWithHorasGastas();

    @Query("SELECT p.nome AS nome, AVG(t.duracao) AS mediaPorTarefa FROM pessoas p \n" +
            "LEFT JOIN tarefas t ON t.idPessoa = p.id\n" +
            "WHERE p.nome = :nome AND t.prazo BETWEEN :dataInicial and :dataFinal\n" +
            "GROUP BY p.nome")
    PessoasWithMediaHorasDTO findPessoaWithMediaHoras(String nome, LocalDate dataInicial, LocalDate dataFinal);
}
