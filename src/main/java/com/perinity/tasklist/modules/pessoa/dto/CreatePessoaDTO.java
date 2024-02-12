package com.perinity.tasklist.modules.pessoa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePessoaDTO {
    private String nome;
    private int idDepartamento;
}
