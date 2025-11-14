package ProjetoCodeSavana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Funcionalidades {



    /* Funções destinadas ao menu Admin  */


    // 1. Listar conteúdos dos Ficheiros

    //Imprimir lista de ficheiro

    public static void listarFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);

        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
    }


    //Função para listar os ficheiros

    public static void menuListarFicheiro() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n\n \uD83D\uDCD6 -*-*-*-*-*- MENU LISTAGEM + -*-*-*-*-*- \uD83D\uDCD6");
            System.out.println("1. Animais");
            System.out.println("2. Clientes");
            System.out.println("3. Interações");
            System.out.println("0. SAIR");

            System.out.print("Selecione a opção pretendida: ");
            opcao = input.nextInt();

            switch (opcao) {

                case 1: // Listar o ficheiro dos animais

                    listarFicheiro("Ficheiros/animais.csv");
                    break;

                case 2: // Listar os ficheiros de clientes
                    listarFicheiro("Ficheiros/clientes.csv");

                    break;

                case 3: // Listar os ficheiros de interações
                    listarFicheiro("Ficheiros/interacoes.csv");
                    break;

                case 0: // SAIR
                    System.out.println("\n \uD83D\uDD19 Obrigado! CodeSavana espera por si! \uD83D\uDD19");
                    break;

                default:
                    System.out.println("\nOpção Inválida");
                    break;
            }

        } while (opcao != 0);

    }





    // 2.  Estatísticas gerais de interações



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
        System.out.println("ALIMENTAÇÃO: "+contadorAlimentacao);
        System.out.println("APADRINHAMENTOS: " + contadorApadrinhamento);
    }




    // 3. Receita total por tipo de interação



    public static double valorReceitasInteracoes(String[][] matriz, String tipoInteracao) throws  FileNotFoundException {

        double soma = 0.0;


        for (int i = 0; i < matriz.length; i++) {
            if (matriz [i][2].equals(tipoInteracao)) {
                soma += Double.parseDouble(matriz [i][5]);
                i++;
            }
        }
        return soma;
    }

    public static void receitasInteracoes(String[][] matrizInteracoes) throws FileNotFoundException {
        double receitasVisitas = valorReceitasInteracoes(matrizInteracoes, "VISITA");
        double receitasEspetaculos = valorReceitasInteracoes(matrizInteracoes, "ESPETACULO");
        double receitasAlimentacao = valorReceitasInteracoes(matrizInteracoes, "ALIMENTACAO");
        double receitasApadrinhamento = valorReceitasInteracoes(matrizInteracoes, "APADRINHAMENTO");

        double receitasInteracoes = receitasAlimentacao + receitasApadrinhamento + receitasVisitas + receitasEspetaculos;

        System.out.println("Receita Total das Interações: " + receitasInteracoes);
        System.out.println("VISITAS: " + receitasVisitas);
        System.out.println("ESPETACULOS: "+receitasEspetaculos);
        System.out.println("ALIMENTAÇÃO: "+receitasAlimentacao);
        System.out.println("APADRINHAMENTOS: " + receitasApadrinhamento);
    }
}


