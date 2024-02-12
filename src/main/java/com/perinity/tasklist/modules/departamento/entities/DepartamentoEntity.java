package com.perinity.tasklist.modules.departamento.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "departamentos")
@Builder
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String titulo;

    @OneToMany(mappedBy = "departamento")
    @JsonManagedReference
    private List<PessoaEntity> pessoas;
}
