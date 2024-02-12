package com.perinity.tasklist.modules.pessoa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "id_departamento")
    private int idDepartamento;

    @ManyToOne
    @JoinColumn(name = "id_departamento", insertable=false, updatable=false)
    @JsonBackReference
    private DepartamentoEntity departamento;
}
