package com.br.var.solutions.application.services.impl;


import com.br.var.solutions.application.services.useCase.ImpostoDeRendaUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImpostoDeRendaUseCaseImpl implements ImpostoDeRendaUseCase {

    public String ImpsotoDeRenda(double salario){
        return calcularFaixaDoImpostoDeRenda(salario);
    }
    private String calcularFaixaDoImpostoDeRenda(double salario) {
        log.info("Iniciando o calculo do Inposto de renda" + salario);
        String novoSalarioCalculo;

        if (salario < 1093.98) {

            return "isento";

        } else if (salario > 1093.98 && salario < 2826.65) {

            double calculoIRF = 142.80 - ((salario * 0.075) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculo = String.valueOf(novoSalario);

            return novoSalarioCalculo;

        } else if (salario > 2826.66 && salario < 3751.05) {

            double calculoIRF = 354.80 - ((salario * 0.15) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculo = String.valueOf(novoSalario);

            return novoSalarioCalculo;

        } else if (salario >= 3751.05 && salario < 3751.05) {

            double calculoIRF = 636.13 - ((salario * 0.225) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculo = String.valueOf(novoSalario);

            return novoSalarioCalculo;

        } else {

            double calculoIRF = 869.36 - ((salario * 275) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculo = String.valueOf(novoSalario);

            return novoSalarioCalculo;
        }
    }
}
