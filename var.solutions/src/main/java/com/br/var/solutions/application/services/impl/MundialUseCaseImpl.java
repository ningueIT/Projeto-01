package com.br.var.solutions.application.services.impl;


import com.br.var.solutions.application.services.useCase.MundialUseCase;
import org.springframework.stereotype.Service;

@Service
public class MundialUseCaseImpl implements MundialUseCase {

    public String calculoMundial(String time){
        return calculaMundial(time);
    }

    private String calculaMundial(String time) {

        if (time.equalsIgnoreCase("São_Paulo")) {
            return "Parabéns, o seu time possui 3 mundiais de clubes conforme a FIFA.";
        } else if (time.equalsIgnoreCase("Corinthians")) {
            return "Parabéns, o seu time possui 2 mundiais de clubes conforme a FIFA.";
        } else if (time.equalsIgnoreCase("Santos")) {
            return "Parabéns, o seu time possui 2 mundiais de clubes conforme a FIFA.";
        } else {
            return "Poxa, que pena. continue torcendo para seu time ganahr um mundial.";
        }
    }
}
