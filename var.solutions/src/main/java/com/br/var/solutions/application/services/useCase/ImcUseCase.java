package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.application.entities.InformacoesIMC;

public interface ImcUseCase {

    InformacoesIMC calculoImc(double peso, double altura);
}
