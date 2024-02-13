package com.perinity.tasklist.modules.tarefas.useCases;

import com.perinity.tasklist.modules.departamento.repositories.DepartamentoRepository;
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

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public TarefaEntity execute(CreateTarefaDTO dto) throws Exception {

        Integer idPessoa = null;
        Integer idDepartamento = null;
        if (dto.getIdPessoa() != 0) {

            var pessoa = pessoaRepository.findById(dto.getIdPessoa());
            if (pessoa.isEmpty()) {
                throw new Exception("Pessoa com ID {" + dto.getIdPessoa() + "} não encontrada");
            }
            idPessoa = pessoa.get().getId();
            idDepartamento = pessoa.get().getIdDepartamento();
        }
        if (dto.getIdDepartamento() != 0) {
            var departamento = departamentoRepository.findById(dto.getIdDepartamento());
            if (departamento.isEmpty()) {
                throw new Exception("Departamento com ID {" + dto.getIdDepartamento() + "} não encontrado");
            }
            idDepartamento = departamento.get().getId();
        }

        var tarefaCreated = TarefaEntity.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .prazo(DateUtils.converterStringToLocalDate(dto.getPrazo()))
                .duracao(dto.getDuracao())
                .build();
        if (idPessoa != null) {
            tarefaCreated.setIdPessoa(idPessoa);
        }
        if (idDepartamento != null) {
            tarefaCreated.setIdDepartamento(idDepartamento);
        }

        return this.tarefaRepository.save(tarefaCreated);

    }

}
