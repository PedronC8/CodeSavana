package TESTES;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

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





    public static int animalMaisPopular (String [][] matri)






    public static void main(String[] args) throws FileNotFoundException {





       String[][] matrizAnimais= lerFicheiroMatriz("Ficheiros/animais.csv");
       String[][] matrizClientes= lerFicheiroMatriz("Ficheiros/clientes.csv");
       String[][] matrizInteracoes= lerFicheiroMatriz("Ficheiros/interacoes.csv");

        estatisticasInteracoes(matrizInteracoes);

    }
}
