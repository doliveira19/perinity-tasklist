package com.perinity.tasklist.modules.pessoa.repositories;

import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

}
