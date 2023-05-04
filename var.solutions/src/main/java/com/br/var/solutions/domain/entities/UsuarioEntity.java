package com.br.var.solutions.domain.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name = "tabUsuario")
@JsonInclude(JsonInclude.Include. NON_NULL)
@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nomeUser;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "senha")
    private  String senha;
}
