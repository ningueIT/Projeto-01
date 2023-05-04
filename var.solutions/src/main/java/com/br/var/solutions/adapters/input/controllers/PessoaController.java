package com.br.var.solutions.adapters.input.controllers;

import com.br.var.solutions.application.entities.InformacoesIMC;
import com.br.var.solutions.adapters.input.entitiles.PessoaRequest;
import com.br.var.solutions.adapters.input.entitiles.PessoaResponse;
import com.br.var.solutions.application.services.useCase.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController //avisando que ela é uma controler
@RequestMapping("/pessoa") // é a rota que ela está
@CrossOrigin(origins = "*") // leberando qualquer tipo de chamada para essa rota especifica
@Slf4j //é a nossa anotação para conseguir criar logs
public class PessoaController {

    /*     1                 2                3              4
     Publico/Privado//tipo de retorno // nome do Método //Parâmetros                    */

    @Autowired
    private MundialUseCase mundialUseCase;

    @Autowired
    private ImcUseCase imcUseCase;

    @Autowired
    private AnoNacimentoUseCase anoNacimentoUseCase;

    @Autowired
    private ImpostoDeRendaUseCase impostoDeRendaUseCase;

    @Autowired
    private SaldoEmDolarUseCase saldoEmDolarUseCase;

    @Autowired
    private MontandoFrontEndUseCase montandoFrontEndUseCase;

    //EndPoint
    @GetMapping
    public ResponseEntity<Object> get() {
        PessoaRequest pessoaRequest1 = new PessoaRequest();
        pessoaRequest1.setNome("Kayke");
        pessoaRequest1.setSobreNome("Ricarti");
        pessoaRequest1.setEndereco("Avenida Batatais 375");
        pessoaRequest1.setIdade(17);
        pessoaRequest1.setTelefone(913175638);
        pessoaRequest1.setPeso(79.6);
        pessoaRequest1.setAltura(1.89);
        pessoaRequest1.setSalario(20000);
        pessoaRequest1.setTime("São_Paulo");
        pessoaRequest1.setSaldo(4131102);

        return ResponseEntity.ok(pessoaRequest1);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoinha, @RequestParam(value = "valida_mundial") Boolean DesejaValidarMundial) {
        InformacoesIMC imc = InformacoesIMC.builder().build();
        int anoNacimento = 0;
        String ImpostoDeResnda = null;
        String ValidaMundial = null;
        String saldoEmDolar = null;

        if (!pessoinha.getNome().isEmpty()) {

            log.info("Iniciando o processo de resumo da pessoa", pessoinha);

            if (Objects.nonNull(pessoinha.getPeso()) && Objects.nonNull(pessoinha.getAltura())) {
                log.info("Iniando o calculo do IMC");
                imc = imcUseCase.calculoImc(pessoinha.getPeso(), pessoinha.getAltura());
            }

            if (Objects.nonNull(pessoinha.getIdade())) {
                log.info("Iniciando o calculo do ano de nacimento");
                anoNacimento = anoNacimentoUseCase.calculoAnoNasc(pessoinha.getIdade());
            }

            if (Objects.nonNull(pessoinha.getSalario())) {
                log.info("Iniciando o calculo do imposto de renda");
                ImpostoDeResnda = impostoDeRendaUseCase.ImpsotoDeRenda(pessoinha.getSalario());
            }

            if (Boolean.TRUE.equals(DesejaValidarMundial)) {
                if (Objects.nonNull(pessoinha.getTime())) {
                    log.info("Validando se o time de coração tem Mundial");
                    ValidaMundial = mundialUseCase.calculoMundial(pessoinha.getTime());
                }
            }

            if (Objects.nonNull(pessoinha.getSaldo())) {
                log.info("convertendo real para dolar ");
                saldoEmDolar = saldoEmDolarUseCase.SaldoEmDolar(pessoinha.getSaldo());
            }

            log.info("Montando Objeto de retono para o front-end");
            PessoaResponse resumo = montandoFrontEndUseCase.mapper(pessoinha, imc, anoNacimento, ImpostoDeResnda, ValidaMundial, saldoEmDolar);
//não sei fazer o frontend
            return ResponseEntity.ok(resumo);
        }

        return ResponseEntity.noContent().build();
    }
}