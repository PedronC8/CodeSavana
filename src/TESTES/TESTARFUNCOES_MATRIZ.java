package TESTES;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class TESTARFUNCOES_MATRIZ {


    public static String[][] lerFicheiroMatriz(String caminho) throws FileNotFoundException {

        // Declarar variáveis
        int linhaAtual = 0;

        // Contar as linhas do ficheiro (para saber quantas linhas temos)
        int contadorLinhas = contarLinhasFicheiro(caminho) - 1;
        int contadorColunas = contarColunasFicheiro(caminho);

        // Criar a matriz à medida (linhas e colunas)
        String[][] matrizCompleta = new String[contadorLinhas][contadorColunas];

        File ficheiroAnimais = new File(caminho);
        Scanner sc = new Scanner(ficheiroAnimais);

        // Avançar o cabeçalho
        String linha = sc.nextLine();

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int coluna = 0; coluna < matrizCompleta[0].length; coluna++) {
                matrizCompleta[linhaAtual][coluna] = linhaSeparada[coluna];
            }

            linhaAtual++;
        }

        return matrizCompleta;
    }

    public static int contarLinhasFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contadorLinhas = 0;

        while (sc.hasNextLine()) {
            contadorLinhas++;
            sc.nextLine();
        }

        return contadorLinhas;

    }

    public static int contarColunasFicheiro(String caminho) throws  FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        String linha = sc.nextLine();
        String[] linhaSeparada= linha.split(";");

        return linhaSeparada.length;

    }

    public static int contarTiposInteracoes(String[][] matriz, String tipoInteracao) throws  FileNotFoundException {

        int contador=0;


        for (int i = 0; i < matriz.length; i++) {
            if (matriz [i][2].equals(tipoInteracao)) {
                contador++;
            }

        }

        return contador;
    }

    public static void estatisticasInteracoes(String[][] matrizInteracoes) throws FileNotFoundException {
        int contadorVisitas = contarTiposInteracoes(matrizInteracoes, "VISITA");
        int contadorEspetaculos = contarTiposInteracoes(matrizInteracoes, "ESPETACULO");
        int contadorAlimentacao = contarTiposInteracoes(matrizInteracoes, "ALIMENTACAO");
        int contadorApadrinhamento = contarTiposInteracoes(matrizInteracoes, "APADRINHAMENTO");

        int contadorInteracoes = contadorVisitas + contadorEspetaculos + contadorAlimentacao + contadorApadrinhamento;

        System.out.println("Total de Interações: " + contadorInteracoes);
        System.out.println("VISITAS: " + contadorVisitas);
        System.out.println("ESPETACULOS: "+contadorEspetaculos);
        System.out.println("ALIMENTAÇÃO: "+contadorEspetaculos);
        System.out.println("APADRINHAMENTOS: " + contadorApadrinhamento);
    }





  public static int interacoesPorAnimal (String [][] matrizInteracoes, String idDoAnimal) {

        int contador = 0;
        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes [i][3].equals(idDoAnimal)) {
                contador++;
            }
        }

        return contador;

  }

    public static void animalMaisPopular (String [][] matrizInteracoes, String [][] matrizAnimais) throws FileNotFoundException {

        String idMaisPopular = " " ;
        int maximoInteracoes = 0;


        for (int i = 0; i < matrizAnimais.length; i++) {

            String idDoAnimal = matrizAnimais[i][0];
            int totalInteracoes = interacoesPorAnimal(matrizInteracoes, idDoAnimal);
            if (totalInteracoes > maximoInteracoes) {
                maximoInteracoes = totalInteracoes;
                idMaisPopular = idDoAnimal;
            }
        }

        String Nome = " ";
        String Especie = " ";
        String Habitat = " ";


        for (int i = 0; i < matrizAnimais.length; i++) {
            if (matrizAnimais [i][0].equals(idMaisPopular)) {
                Nome = matrizAnimais[i][1];
                Especie = matrizAnimais[i][2];
                Habitat = matrizAnimais[i][3];

            }
        }

        System.out.println("Nome: " + Nome);
        System.out.println("Especie: " + Especie);
        System.out.println("Habitat: " + Habitat);
        System.out.println("Toal das Interações do animal é de: " +  maximoInteracoes);
    }





    // Problema nº6 listar os padrinhos

    public static boolean verificarAnimal(String[][] matrizAnimais, String idAnimal) {

        for (int i = 0; i < matrizAnimais.length; i++) {
            if (matrizAnimais[i][0].equals(idAnimal)) {
                return true;
            }
        }
        return false;
    }


    // Função Mostrar o Cliente

    public static String [] cliente (String[][] matrizClientes, String idCliente) {


        String[] dadosDoCLiente = null;
        for (int i = 0; i < matrizClientes.length; i++) {
            if (matrizClientes [i][0].equals(idCliente)) {
                dadosDoCLiente = new String [] {matrizClientes [i][1], matrizClientes[i][3]};
            }
        }
        return dadosDoCLiente;
    }

    public static void padrinhosDeAnimais (String[][] matrizAnimais, String [][] matrizInteracoes, String [][] matrizClientes, String idAnimal) {


        if (verificarAnimal(matrizAnimais, idAnimal) == false) {
            System.out.println("O id" + idAnimal + "que inseriu não existe no nosso ZOO");
            return;
        }

        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes [i][2].equals("APADRINHAMENTO") && matrizInteracoes[i][3].equals(idAnimal)) {

                String idDoCliente = matrizInteracoes [i][1];
                String valorPago =  matrizInteracoes [i][5];
                String interacao = matrizInteracoes [i][2];


                String [] informacoesCliente = cliente(matrizClientes, idDoCliente);
                String nomedoCliente = informacoesCliente[0];
                String emailCliente = informacoesCliente[1];

                System.out.println("\nCliente " + nomedoCliente);
                System.out.println("Email: " + emailCliente);
                System.out.println("Valor Pago Mensalmente: " + valorPago + "€");
                System.out.println("Interacao: " + interacao);

            }
        }
    }



    // Problema nº7 Espetáculo mais rentavel

    public static double valorTotalInteracao (String [][] matrizInteracoes, String nomeDoEvento) {

        double soma = 0;

        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes [i][4].equals(nomeDoEvento) &&  matrizInteracoes [i][2].equals("ESPETACULO")) {
                soma += Double.parseDouble(matrizInteracoes [i][5]);

            }
        }
        return soma;
    }

    public static String [] animalPrincipal (String[][] matrizAnimais, String [][] matrizInteracoes, String nomeDoEvento) {

        String idAnimalPrincipal =  "";
        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes[i][2].equals("ESPETACULO") && matrizInteracoes[i][4].equals(nomeDoEvento)){
                idAnimalPrincipal =  matrizInteracoes [i][3];
            }
        }

        for (int j = 0; j < matrizAnimais.length; j++) {
            if (matrizAnimais[j][0].equals(idAnimalPrincipal)) {
                return new String [] {matrizAnimais[j][1], matrizAnimais[j][2]};
            }
        }
        return new String [] {"", ""};
    }


    public static void espetaculoMaisRentavel (String [][] matrizInteracoes, String [][] matrizAnimais) {

        String [] nomesEspetaculos = new String [matrizInteracoes.length];
        int contador = 0;

        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes [i][2].equals("ESPETACULO")) {
                String nomesDosEventos = matrizInteracoes [i][4];

                boolean eventoRepetido = false;
                for (int j = 0; j < contador; j++) {
                    if (nomesEspetaculos [j].equals(nomesDosEventos)) {
                        eventoRepetido = true;

                    }
                }

                if (eventoRepetido == false) {
                    nomesEspetaculos[contador] = nomesDosEventos;
                    contador++;
                }
            }
        }

        double receitaTotal = 0;
        String eventoMaisRentavel = "";


        for (int i = 0; i < contador; i++) {
            double receita = valorTotalInteracao(matrizInteracoes, nomesEspetaculos[i]);
            if (receita >= receitaTotal) {
                receitaTotal = receita;
                eventoMaisRentavel = nomesEspetaculos[i];
            }
        }

        String [] animal = animalPrincipal(matrizAnimais, matrizInteracoes, eventoMaisRentavel);
        String nomeAnimal = animal[0];
        String especie =  animal[1];

        System.out.println("\n ***** ESPETÁCULO MAIS RENTÁVEL *****");
        System.out.println("Nome Espetáculo: " + eventoMaisRentavel);
        System.out.println("Receita Total: " + receitaTotal + " €");
        System.out.println("Animal Principal: " + nomeAnimal + " Espécie: " + especie);

    }




    // 3. Simular Apadrinhamento de um animal (MENU CLIENTE)

    public static String [] encontrarAnimalPorID(String[][] matrizAnimais, String idAnimal) {

        for (int i = 0; i < matrizAnimais.length; i++) {
            if (matrizAnimais[i][0].equals(idAnimal)) {
                return new String [] {matrizAnimais[i][1], matrizAnimais[i][2], matrizAnimais[i][3]};
            }
        }
        return new String [] {"", ""};
    }

    public static String planoApadrinhamentoNovo (double custo) {
        if (custo <= 25.0) {
            return "Apadrinhamento Simples";
        }else if (custo <= 50.0) {
            return "Apadrinhamento Gold";
        }else {
            return "Apadrinhamento Diamond";
        }

    }

    public static void apadrinhamentoNovo (String [][] matrizAnimais) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do Cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();

        System.out.println("Selecione o ID do animal que pretende adotar: ");
        String idAnimal = sc.nextLine();

        String [] informacoesAnimal = encontrarAnimalPorID (matrizAnimais, idAnimal);

        if (informacoesAnimal[0].equals("")) {
            System.out.println("O id que inseriu não existe no nosso Zoo");
            return;
        }


        String nomeDoAnimal = informacoesAnimal[0];
        String especie = informacoesAnimal[1];
        String habitat = informacoesAnimal[2];

        System.out.println("Valor mensal a pagar: ");
        double custo = sc.nextDouble();

        String plano = planoApadrinhamentoNovo(custo);


        System.out.println("\n **** Detalhes do seu Apadrinhamento **** ");
        System.out.println("Padrinho: " + nomeCliente + " (" + email + ")");
        System.out.println("Animal: " + nomeDoAnimal + " (" + especie + ") " + habitat);
        System.out.println("Plano de Apadrinhamento: " + plano);
        System.out.println("Custo: " + custo + "€/ mês");
    }





    // 4. Jogo de Adivinhar a Espécie (MENU CLIENTE)


    public static void jogoAdivinhar (String [][] matrizAnimais) {
        Scanner input = new Scanner(System.in);
        Random sorteio = new Random();


        int linhaAnimal = sorteio.nextInt(matrizAnimais.length);

        String pista1 = matrizAnimais[linhaAnimal][3];
        String pista2 = matrizAnimais[linhaAnimal][4];
        String extincao = matrizAnimais[linhaAnimal][5];


        if (extincao.equals("Sim")) {
            extincao = "Está em perigo de extinção";
        } else {
            extincao = "Não está em perigo de extinção";
        }

        System.out.println("PISTA 1: " + pista1);
        System.out.println("PISTA 2: " + pista2);
        System.out.println("PISTA 3: " + extincao);


        int tentativas = 0;
        String palpite ="";
        String especie = matrizAnimais[linhaAnimal][2];



        do {
            System.out.println("Qual é a espécie correta? :");
            palpite = input.next();
            tentativas++;

            if (palpite.equals(especie) == false) {
                System.out.println("Falhou! Tente Novamente");

            }
        } while (palpite.equals(especie) == false);

        System.out.println("Parabéns, acertou na espécie!" + especie);
        System.out.println("Número de tentativas: " + tentativas);

    }





    public static void main(String[] args) throws FileNotFoundException {





       String[][] matrizAnimais= lerFicheiroMatriz("Ficheiros/animais.csv");
       String[][] matrizClientes= lerFicheiroMatriz("Ficheiros/clientes.csv");
       String[][] matrizInteracoes= lerFicheiroMatriz("Ficheiros/interacoes.csv");

//        estatisticasInteracoes(matrizInteracoes);
//
//        animalMaisPopular(matrizInteracoes, matrizAnimais);
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Digite o nome do animal: ");
//        String idAnimal = sc.nextLine();
//
//        padrinhosDeAnimais(matrizAnimais, matrizInteracoes, matrizClientes, idAnimal);
//
//        espetaculoMaisRentavel(matrizInteracoes, matrizAnimais);
//
//        apadrinhamentoNovo(matrizAnimais);

        jogoAdivinhar(matrizAnimais);

    }



}
