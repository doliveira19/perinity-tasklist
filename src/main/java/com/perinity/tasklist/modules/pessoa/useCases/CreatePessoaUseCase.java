package com.perinity.tasklist.modules.pessoa.useCases;

import com.perinity.tasklist.modules.departamento.repositories.DepartamentoRepository;
import com.perinity.tasklist.modules.pessoa.dto.CreatePessoaDTO;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePessoaUseCase {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public PessoaEntity execute(CreatePessoaDTO dto) throws Exception {

        var departamento = this.departamentoRepository.findById(dto.getIdDepartamento());
        if (departamento.isEmpty()) {
            throw new Exception("Departamento não existe");
        }

        var pessoaCreated = PessoaEntity.builder()
                .nome(dto.getNome())
                .idDepartamento(dto.getIdDepartamento())
                .build();

        return this.pessoaRepository.save(pessoaCreated);

    }
}
