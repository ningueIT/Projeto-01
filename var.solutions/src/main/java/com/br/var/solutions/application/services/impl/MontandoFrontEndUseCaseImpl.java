package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.adapters.input.entitiles.PessoaRequest;
import com.br.var.solutions.adapters.input.entitiles.PessoaResponse;
import com.br.var.solutions.application.entities.InformacoesIMC;
import com.br.var.solutions.application.services.useCase.MontandoFrontEndUseCase;
import org.springframework.stereotype.Service;

@Service
public class MontandoFrontEndUseCaseImpl implements MontandoFrontEndUseCase {

    public PessoaResponse mapper(PessoaRequest pessoa, InformacoesIMC imc, int anoNacimento, String inpostoDeResnda,
                                                 String validaMundial, String saldoEmDolar){

        return montarRespostaFrontEnd(pessoa,imc,anoNacimento,inpostoDeResnda,validaMundial,saldoEmDolar);
        }

        private PessoaResponse montarRespostaFrontEnd(PessoaRequest pessoa, InformacoesIMC imc, int anoNacimento, String inpostoDeResnda,
                                                      String validaMundial, String saldoEmDolar) {

        return PessoaResponse.builder()
                .nome(pessoa.getNome())
            .imc(imc.getImc())
            .ClassificacaoIMC(imc.getClassificacao())
            .Salario(inpostoDeResnda)
            .anoNacimento(String.valueOf(anoNacimento))
            .mundialClubes(validaMundial)
            .saldoEmDolar(saldoEmDolar)
            .idade(pessoa.getIdade())
            .Time(pessoa.getTime())
            .SobreNome(pessoa.getSobreNome())
            .Endereco(pessoa.getEndereco())
            .Altura(pessoa.getAltura())
            .Peso(pessoa.getPeso())
            .Saldo(pessoa.getSaldo())
            .build();

        }
}
