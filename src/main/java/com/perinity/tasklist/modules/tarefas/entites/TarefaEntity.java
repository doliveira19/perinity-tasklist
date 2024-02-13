package com.perinity.tasklist.modules.tarefas.entites;

import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tarefas")
@Builder
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String titulo;

    @Column(length = 100)
    private String descricao;

    @Temporal(TemporalType.DATE)
    private LocalDate prazo;

    private int duracao;

    private boolean finalizado;

    @Column(name = "id_departamento")
    private Integer idDepartamento;

    @ManyToOne
    @JoinColumn(name = "id_departamento", insertable=false, updatable=false)
    private DepartamentoEntity departamento;

    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", insertable=false, updatable=false)
    private PessoaEntity pessoa;
}
