package com.perinity.tasklist.modules.pessoa.entities;

import com.perinity.tasklist.modules.departamento.entities.DepartamentoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="pessoas")
@Builder
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nome;

    @Column(name = "idDepartamento")
    private int idDepartamento;

    @ManyToOne
    @JoinColumn(name = "idDepartamento", insertable=false, updatable=false)
    private DepartamentoEntity departamento;
}
