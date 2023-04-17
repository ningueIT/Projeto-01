package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.adapters.input.entitiles.PessoaRequest;
import com.br.var.solutions.adapters.input.entitiles.PessoaResponse;
import com.br.var.solutions.application.entities.InformacoesIMC;

public interface MontandoFrontEndUseCase {
    PessoaResponse mapper (PessoaRequest pessoa, InformacoesIMC imc, int anoNacimento, String inpostoDeResnda,
                           String validaMundial, String saldoEmDolar);

}
