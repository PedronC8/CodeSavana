package ProjetoCodeSavana;


import java.io.FileNotFoundException;

import static ProjetoCodeSavana.Funcoes_Menus.*;
import static ProjetoCodeSavana.Funcionalidades.*;
import static ProjetoCodeSavana.CriacaoMatrizes.*;

public class Projeto {


    public static void main(String[] args) throws FileNotFoundException {

        String[][] matrizAnimais = lerFicheiroMatriz("Ficheiros/animais.csv");
        String[][] matrizClientes = lerFicheiroMatriz("Ficheiros/clientes.csv");
        String[][] matrizInteracoes = lerFicheiroMatriz("Ficheiros/interacoes.csv");


        loginMenu(matrizAnimais,matrizClientes,matrizInteracoes);

    }
}
