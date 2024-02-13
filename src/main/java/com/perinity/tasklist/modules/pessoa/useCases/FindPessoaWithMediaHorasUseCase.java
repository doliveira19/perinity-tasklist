package com.perinity.tasklist.modules.pessoa.useCases;

import com.perinity.tasklist.modules.pessoa.dto.PessoasWithMediaHorasDTO;
import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import com.perinity.tasklist.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPessoaWithMediaHorasUseCase {

    @Autowired
    private PessoaRepository pessoaRepository;
    public PessoasWithMediaHorasDTO execute(String nome, String dataInicial, String dataFinal) {

        var fDataInicial = DateUtils.converterStringToLocalDate(dataInicial);
        var fDataFinal = DateUtils.converterStringToLocalDate(dataFinal);

        System.out.println(fDataInicial);
        System.out.println(fDataFinal);

        return this.pessoaRepository.findPessoaWithMediaHoras(nome, fDataInicial, fDataFinal);

    }
}
