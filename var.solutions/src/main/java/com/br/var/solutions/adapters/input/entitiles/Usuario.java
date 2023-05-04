package com.br.var.solutions.adapters.input.entitiles;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Usuario {

    private int id;

    private String nome;

    private String usuario;

    private  String senha;

}
