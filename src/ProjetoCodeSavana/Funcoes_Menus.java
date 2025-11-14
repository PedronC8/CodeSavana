package ProjetoCodeSavana;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static ProjetoCodeSavana.Funcionalidades.*;

public class Funcoes_Menus {


    public static void loginMenu(String[][] matrizAnimais, String[][] matrizClientes, String[][] matrizInteracoes) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcaoLogin;
        String user, password;

        do {

            System.out.println("\n\n-*-*-*-*-*- MENU LOGIN -*-*-*-*-*-");
            System.out.println("1. ADMINISTRADOR");
            System.out.println("2. CLIENTE");
            System.out.println("0. SAIR");

            System.out.print("Selecione a sua função: ");
            opcaoLogin = input.nextInt();

            switch (opcaoLogin) {

                case 1: // Administrador

                    System.out.print("\n Indique o seu username: ");
                    user = input.next();

                    System.out.print("Indique a sua password: ");
                    password = input.next();

                    if (user.equals("admin") && password.equals("code")) {
                        // Login válido
                        adminMenu(matrizAnimais,matrizClientes,matrizInteracoes);
                    } else {
                        System.out.println("\uD83D\uDD10 Login incorreto. Por favor insira as suas credenciais! \uD83D\uDD10");
                    }

                    break;


                case 2: // CLIENTE
                    clienteMenu();
                    break;

                case 0: // SAIR
                    System.out.println("\n \uD83D\uDC4B Obrigado! CodeSavana espera por si! \uD83D\uDC4B ");
                    break;

                default:
                    System.out.println("\nOpção Inválida");
                    break;
            }

        } while (opcaoLogin != 0);
    }









    public static void adminMenu(String[][] matrizAnimais, String[][] matrizClientes, String[][] matrizInteracoes) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n\n\uD83D\uDC17 -*-*-*-*-*- MENU ADMIN CODESAVANNA  + -*-*-*-*-*- \uD83D\uDC17");
            System.out.println("1. Listar conteúdo dos ficheiros");
            System.out.println("2. Estatísticas gerais de interação");
            System.out.println("3. Receita total por tipo de interação");
            System.out.println("4. Animal mais popular");
            System.out.println("5. Top 3 espécies com mais apadrinhamento");
            System.out.println("6. Listar padrinhos de um animal");
            System.out.println("7. Espetáculo mais rentável");
            System.out.println("8. Ranking de animais em perigo de extinção");
            System.out.println("9. Estatísticas por habitat");
            System.out.println("0. SAIR");

            System.out.print("Selecione a opção pretendida: ");
            opcao = input.nextInt();

            switch (opcao) {

                case 1: // Listar conteúdo dos ficheiros

                    menuListarFicheiro();


                    break;


                case 2: // Estatísticas gerais de interação
                    estatisticasInteracoes(matrizInteracoes);

                    break;

                case 3: // Receita total por tipo de interação
                    receitasInteracoes(matrizInteracoes);

                    break;

                case 4: // Animal mais popular

                    break;

                case 5: // Top 3 espécies com mais apadrinhamento

                    break;

                case 6: // Listar padrinhos de um animal

                    break;

                case 7: // Espetáculo mais rentável

                    break;

                case 8: // Ranking de animais em perigo de extinção

                    break;

                case 9: // Estatísticas por habitat

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







    public static void clienteMenu() {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n\n-*-*-*-*-*- MENU LOGIN -*-*-*-*-*-");
            System.out.println("1. Ver catálogo de animais por habitat");
            System.out.println("2. Ver atividades de um animal");
            System.out.println("3. Simular apadrinhamento de um animal");
            System.out.println("4. Encontrar 'amigos de zoo'");
            System.out.println("5. Jogo: adivinha a espécie");
            System.out.println("0. SAIR");

            System.out.print("Selecione a opção pretendia: ");
            opcao = input.nextInt();

            switch (opcao) {

                case 1: // Ver catálogo de animais por habitat

                    break;


                case 2: // Ver atividades de um animal
                    break;

                case 3: // Simular apadrinhamento de um animal
                    break;

                case 4: // Encontrar 'amigos de zoo'
                    break;

                case 5: // Jogo: adivinha a espécie
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







}

