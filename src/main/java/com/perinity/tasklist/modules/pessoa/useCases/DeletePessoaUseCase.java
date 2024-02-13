package com.perinity.tasklist.modules.pessoa.useCases;

import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePessoaUseCase {
    @Autowired
    private PessoaRepository pessoaRepository;

    public String execute(int id) throws Exception {
        Optional<PessoaEntity> pessoa = pessoaRepository.findById(id);
        if (!pessoa.isEmpty()) {
            this.pessoaRepository.deleteById(id);
            return String.format("Pessoa com ID {%d} deletada", id);
        }
        throw new Exception(String.format("Pessoa com ID {%d} não encontrada", id));
    }
}
