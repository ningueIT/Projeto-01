package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.SaldoEmDolarUseCase;
import org.springframework.stereotype.Service;

@Service
public class SaldoEmDolarUseCaseImpl implements SaldoEmDolarUseCase {

    public String SaldoEmDolar(double saldo){
        return converterSaldoEmDolar(saldo);
    }
    private String converterSaldoEmDolar(double saldo) {
        return String.valueOf(saldo / 5.11);
    }
}
