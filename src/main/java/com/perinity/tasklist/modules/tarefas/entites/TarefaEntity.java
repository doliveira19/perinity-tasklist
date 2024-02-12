package com.perinity.tasklist.modules.tarefas.entites;

import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date Prazo;

    private int duracao;

    private boolean finalizado;

    @Column(name = "idDepartamento")
    private int idDepartamento;

    @ManyToOne
    @JoinColumn(name = "idDepartamento", insertable=false, updatable=false)
    private DepartamentoEntity departamento;

    @Column(name = "idPessoa")
    private int idPessoa;

    @ManyToOne
    @JoinColumn(name = "idPessoa", insertable=false, updatable=false)
    private PessoaEntity pessoa;
}
