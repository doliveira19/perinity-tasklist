package com.perinity.tasklist.modules.tarefas.useCases;

import com.perinity.tasklist.modules.departamento.repositories.DepartamentoRepository;
import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import com.perinity.tasklist.modules.tarefas.dto.AllocatePessoaToTarefaDTO;
import com.perinity.tasklist.modules.tarefas.entites.TarefaEntity;
import com.perinity.tasklist.modules.tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocatePessoaToTarefaUseCase {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public TarefaEntity execute(int id, AllocatePessoaToTarefaDTO dto) throws Exception {
        Integer idDepartamento;
        Integer idPessoa;
        var tarefa = this.tarefaRepository.findById(id);

        if (tarefa.isEmpty()) {
            throw new Exception("Tarefa com ID {id} não encontrada");
        }

        if (dto.getIdPessoa() == 0) {
            throw new Exception("ID da pessoa não informado");
        }

        var pessoa = this.pessoaRepository.findById(dto.getIdPessoa());
        if (pessoa.isEmpty()) {
            throw new Exception("Pessoa com ID {" + dto.getIdPessoa() + "} não encontrado");
        }
        idPessoa = pessoa.get().getId();

        if (tarefa.get().getIdDepartamento() == null) {
            idDepartamento = pessoa.get().getIdDepartamento();
        } else {
            idDepartamento = tarefa.get().getIdDepartamento();
        }

        if (idDepartamento != pessoa.get().getIdDepartamento()) {
            throw new Exception("Pessoa com ID {" + dto.getIdPessoa() + "} não pertence ao departamento");
        }

        TarefaEntity updatedTarefa = tarefa.get();
        updatedTarefa.setIdPessoa(idPessoa);
        updatedTarefa.setIdDepartamento(idDepartamento);

        return this.tarefaRepository.save(updatedTarefa);
    }

}
