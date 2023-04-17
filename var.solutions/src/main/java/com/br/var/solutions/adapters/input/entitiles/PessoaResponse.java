package com.br.var.solutions.adapters.input.entitiles;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PessoaResponse {

    public String nome;
    public int idade;
    public String imc;
    public String ClassificacaoIMC;
    public String IR;
    public String aliquata;
    public String saldoEmDolar;
    public String anoNacimento;
    public String mundialClubes;
    public String SobreNome;
    public String Endereco;
    public double Peso;
    public String Time;
    public String Salario;
    public double Altura;
    public double Saldo;
    public String ImpostoDeRenda;
}