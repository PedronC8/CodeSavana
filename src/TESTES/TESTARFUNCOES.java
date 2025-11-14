package TESTES;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TESTARFUNCOES {


    public static int contarInteracoes(String caminho, String tipoInteracao) throws FileNotFoundException {

        File ficheiroInteracoes = new File(caminho);
        Scanner sc = new Scanner(ficheiroInteracoes);

        int contador = 0;
        String linha;


        while (sc.hasNextInt()) {
            linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            if (linhaSeparada[2].equals(tipoInteracao)) {
                contador++;
            }


        }

        return contador;

    }

    public static void estatisticasInteracoes(String caminhoInteracoes) throws FileNotFoundException {
        int contadorVisitas = contarInteracoes(caminhoInteracoes, "VISITA");
        int contadorEspetaculos = contarInteracoes(caminhoInteracoes, "ESPETACULO");
        int contadorAlimentacao = contarInteracoes(caminhoInteracoes, "ALIMENTACAO");
        int contadorApadrinhamento = contarInteracoes(caminhoInteracoes, "APADRINHAMENTO");

        int contadorInteracoes = contadorVisitas + contadorEspetaculos + contadorAlimentacao + contadorApadrinhamento;

        System.out.println("Total de Interações: " + contadorInteracoes);
        System.out.println("VISITAS: " + contadorVisitas);
        System.out.println("ESPETACULOS: "+contadorEspetaculos);
        System.out.println("ALIMENTAÇÃO: "+contadorEspetaculos);
        System.out.println("APADRINHAMENTOS: " + contadorApadrinhamento);
    }


    public static void main(String[] args) throws FileNotFoundException {
        String caminhoInteracoes = "Ficheiros/interacoes.csv";

        estatisticasInteracoes(caminhoInteracoes);
    }
}
