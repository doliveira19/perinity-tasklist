package com.perinity.tasklist.modules.tarefas.useCases;

import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import com.perinity.tasklist.modules.tarefas.dto.CreateTarefaDTO;
import com.perinity.tasklist.modules.tarefas.entites.TarefaEntity;
import com.perinity.tasklist.modules.tarefas.repositories.TarefaRepository;
import com.perinity.tasklist.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTarefaUseCase {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public TarefaEntity execute(CreateTarefaDTO dto) throws Exception {

        if (dto.getIdPessoa() == 0) {
            throw new Exception("ID da pessoa não fornecido ou é inválido");
        }

        var pessoa = pessoaRepository.findById(dto.getIdPessoa());
        if (pessoa.isEmpty()) {
            throw new Exception("Pessoa com ID {" + dto.getIdPessoa() + "} não encontrada");
        }

        var tarefaCreated = TarefaEntity.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .prazo(DateUtils.converterStringToLocalDate(dto.getPrazo()))
                .duracao(dto.getDuracao())
                .idDepartamento(pessoa.get().getIdDepartamento())
                .idPessoa(dto.getIdPessoa())
                .build();

        return this.tarefaRepository.save(tarefaCreated);

    }

}
