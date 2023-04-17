//Nome da Classe ( Departamento )
import java.util.ArrayList;
import  java.util.List;
import java.util.Scanner;
public class Main {
    //Nome do Método - Recursos dento da classe (O que o departamento faz)
    public static void main(String[] args) {
        System.out.println("1_ Olá Mundo!");
        System.out.println("2_ Este e o meu primeiro código em java");
        //         1                 2             3
        // Tipo da variável   Nome da variável  Valor da variável

        String olaMundo = "3_ Olá mundo denovo";
        System.out.println(olaMundo);

        String nome = "Kayke";
        String Sobrenome = "Ricarti lima";
        String Idade = "15";

        // sount = System.out.println();

        System.out.println(nome);
        System.out.println(Sobrenome);
        System.out.println(Idade);

        //Juntar as Variáveis:

        System.out.println(nome + " " + Sobrenome + ".");
        System.out.println("e minha idade é " + Idade);

        String retornoMetodo = buscaSobrenome();
        System.out.println(retornoMetodo);

        String retornoMetodo2 = inserirNome();
        System.out.println(retornoMetodo2);

        double imc = calcularIMC();

        String retornoMensagem = resumoDeUmaPessoa();
        System.out.println(retornoMensagem);
    }


    //       1               2               3               4
    //tipo acesso / tipo de retorno / nome do método / parâmetros

    public static String buscaSobrenome() {
        String sobrenome = "Ricarti lima";
        return sobrenome;
    }

    public static String inserirNome() {


        Scanner ler = new Scanner(System.in);

        System.out.printf("Digite seu nome: ");
        String nome = ler.next();

        System.out.printf("Digite seu sobrenome: ");
        String sobrenome = ler.next();

        System.out.println(nome + " " + sobrenome);
        String nomeCompleto = nome + " " + sobrenome;
        return nomeCompleto;
    }

    public static double calcularIMC() {

        Scanner ler = new Scanner(System.in);

        System.out.printf("Digite sua Altura");
        double altura = ler.nextDouble();

        System.out.printf("Digite sua Peso");
        double peso = ler.nextDouble();
        double calculoIMC = peso / (altura * altura);
        System.out.println("O seu IMC é: " + calculoIMC);

        if (calculoIMC < 19.0) {
            System.out.println("Você está abaixo do peso! ");
        } else {
            System.out.println("você está acima do peso");
        }
        return calculoIMC;
    }

    public static int calcularAniversario(int anoNacimento) {
        Scanner ler = new Scanner(System.in);

        List<String> nomesResumo = new ArrayList<>();

        System.out.printf("Digite o ano de Nacimento ");
        int anoDeNacimento = ler.nextInt();
        System.out.printf("Digite o ano atual ");

        int anoAtual = ler.nextInt();

        int calcularQuantosAnos = anoAtual - anoDeNacimento;


        System.out.println("O seu ano de nacimento é: " + calcularQuantosAnos);

        if (calcularQuantosAnos > 18) {
            System.out.println("Você tem mais do que 18 anos");
        } else {
            System.out.println("Você tem menos de 18 anos");
        }

        return calcularAniversario();
    }

    private static int calcularAniversario() {
        return 0;
    }

    public static String resumoDeUmaPessoa(){

        Scanner ler = new Scanner(System.in);

        list<String> nomesResumo;
        nomesResumo = new list<String>();

        //      1     ;   2  ;   3;
        for (int i = 1; i < 5; i ++) {


            //Pergunta ao usuario o nome da peesoa;
            System.out.printf("Digite seu nome: ");
            String nome = ler.next();

            //Pergunta ao usuario o sobrenome da pessoa;
            System.out.printf("Digite seu sobrenome: ");
            String sobrenome = ler.next();

            //Pergunta ao usuario a idade da pessoa;
            System.out.printf("Digite a sua idade:: ");
            int idade = ler.nextInt();

            //criar os nomes juntos nome + sobrenome
            String nomeCompleto = nome + " " + sobrenome;

            String tipoDePessoa = "";


            // = é se quiser que seja IGUAL; == e se a pessoa quiser comparar
            //verificar se a idade é menor ou igual a 17 anos.
            if (idade <= 17) {
                //se for maior ou igual a 17 anos atribui menor de idade na mensagem
                tipoDePessoa = "menor de idade.";
            } else {
                //se for maior do que 17 anos atribui menor de idade na mensagem
                tipoDePessoa = "maior de idade.";
            }
            String resumo = "O nome completo é: " + nomeCompleto + ", e ele é: " + tipoDePessoa;

            nomesResumo.add(resumo);

        }
            return nomesResumo.toString();
    }
}
