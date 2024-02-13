package com.perinity.tasklist.modules.tarefas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTarefaDTO {
    private String titulo;
    private String descricao;
    private String prazo;
    private int duracao;
    private int idPessoa;
}
