package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.AnoNacimentoUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AnoNacimentoUseCaseImpl implements AnoNacimentoUseCase {

    public int calculoAnoNasc(int idade){
        return calcularAnoNacimento(idade);
    }
    private int calcularAnoNacimento(int idade) {
        LocalDate datalocal = LocalDate.now();
        int anoAtual = datalocal.getYear();
        return anoAtual - idade;
    }
}
