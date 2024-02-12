package com.perinity.tasklist.modules.pessoa.useCases;

import com.perinity.tasklist.modules.pessoa.dto.CreatePessoaDTO;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePessoaUseCase {
    @Autowired
    private PessoaRepository pessoaRepository;
    public PessoaEntity execute(int id, CreatePessoaDTO dto) throws Exception {
        Optional<PessoaEntity> pessoa = pessoaRepository.findById(id);

        if (pessoa.isEmpty()) {
            throw new Exception(String.format("Pessoa com ID %d não encontrada", id));
        }

        PessoaEntity updatedPessoa = pessoa.get();
        if (dto.getNome() != null) {
            updatedPessoa.setNome(dto.getNome());
        }
        if (dto.getIdDepartamento() != 0 ) {
            updatedPessoa.setIdDepartamento(dto.getIdDepartamento());
        }

        return this.pessoaRepository.save(updatedPessoa);
    }
}
