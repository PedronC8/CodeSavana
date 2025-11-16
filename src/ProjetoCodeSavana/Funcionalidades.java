package ProjetoCodeSavana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
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





    // 4. Animal mais popular

    public static int interacoesPorAnimal (String [][] matrizInteracoes, String idDoAnimal) {

        // Função que itera sobre a matriz dos animasi e contabiliza as interações dos animais, através do id do animal que recebe na função
        int contador = 0;
        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes [i][3].equals(idDoAnimal)) {
                contador++;
            }
        }

        return contador;

    }

    public static void animalMaisPopular (String [][] matrizInteracoes, String [][] matrizAnimais) throws FileNotFoundException {


        // Função que analisa o animal mais popular, iterando sobre a matriz dso animais e coloca no id mais popular o id desse animal com mais popularidade

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

        // Dpois de identificado o id do animal mais popular aqui passamos a indicar os dados do animal
        for (int i = 0; i < matrizAnimais.length; i++) {
            if (matrizAnimais [i][0].equals(idMaisPopular)) {
                Nome = matrizAnimais[i][1];
                Especie = matrizAnimais[i][2];
                Habitat = matrizAnimais[i][3];

            }
        }



        System.out.println("***** APRESENTAMOS O ANIMAL MAIS POPULAR DA NOSSA CODESAVANA ***** ");
        System.out.println("Nome: " + Nome);
        System.out.println("Especie: " + Especie);
        System.out.println("Habitat: " + Habitat);
        System.out.println("Toal das Interações do animal é de: " +  maximoInteracoes);
    }






    // 6. Listar os padrinhos

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
            System.out.println("O id " + idAnimal + " que inseriu não existe no nosso ZOO");
        }

        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes [i][2].equals("APADRINHAMENTO") && matrizInteracoes[i][3].equals(idAnimal)) {

                String idDoCliente = matrizInteracoes [i][1];
                String valorPago =  matrizInteracoes [i][5];
                String interacao = matrizInteracoes [i][2];


                String [] informacoesCliente = cliente(matrizClientes, idDoCliente);
                String nomedoCliente = informacoesCliente[0];
                String emailCliente = informacoesCliente[1];

                System.out.println("***** PADRINHO: *****");
                System.out.println("\nCliente " + nomedoCliente);
                System.out.println("Email: " + emailCliente);
                System.out.println("Valor Pago Mensalmente: " + valorPago + "€");
                System.out.println("Interacao: " + interacao);

            }
        }
    }




    // 7. Espetáculo mais rentavel

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













    // 9. Estatísticas por Habitat

    public static String[] habitatsUnicos(String[][] matrizAnimais) {

        String[] arrayHabitatsTotal = new String[matrizAnimais.length];
        int indexDisponivel = 0;

        // Este ciclo itera para cada animal da matriz
        for (int linhaAnimais = 0; linhaAnimais < matrizAnimais.length; linhaAnimais++) {

            boolean encontrei = false;

            // matrizAnimais[linhaAnimais][3] é o habitat do animal atual

            // Este ciclo itera para cada habitat do meu array sem duplicados
            for (int habitatAtual = 0; habitatAtual < arrayHabitatsTotal.length; habitatAtual++) {
                if (matrizAnimais[linhaAnimais][3].equals(arrayHabitatsTotal[habitatAtual])) {
                    encontrei = true;
                }
            }

            if (!encontrei) { // encontrei == false
                arrayHabitatsTotal[indexDisponivel] = matrizAnimais[linhaAnimais][3];
                indexDisponivel++;
            }

        }

        int quantidadeDeHabitats = indexDisponivel;

        // Limpeza - colocar o array à medida
        String[] arrayHabitatsMedida = new String[quantidadeDeHabitats];

        for (int i = 0; i < arrayHabitatsMedida.length; i++) {
            arrayHabitatsMedida[i] = arrayHabitatsTotal[i];
        }

        return arrayHabitatsMedida;

    }

    public static int numeroAnimaisHabitat(String[][] matrizAnimais, String habitat) {

        int contagemAnimais = 0;

        for (int linha = 0; linha < matrizAnimais.length; linha++) {
            if (matrizAnimais[linha][3].equals(habitat)) {
                contagemAnimais++;
            }
        }
        return contagemAnimais;
    }

    public static String[] animaisDeUmHabitat(String[][] matrizAnimais, String habitat) {
        String[] animaisDoHabitat = new String[matrizAnimais.length];
        int indexDisponivel = 0;

        for (int linhaAnimal = 0; linhaAnimal < matrizAnimais.length; linhaAnimal++) {
            if (matrizAnimais[linhaAnimal][3].equals(habitat)) {
                // Encontramos um animal deste Habitat
                animaisDoHabitat[indexDisponivel] = matrizAnimais[linhaAnimal][0];
                indexDisponivel++;
            }
        }

        int quantidadeAnimais = indexDisponivel;

        String[] animaisDoHabitatMedida = new String[quantidadeAnimais];

        for (int i = 0; i < animaisDoHabitatMedida.length; i++) {
            animaisDoHabitatMedida[i] = animaisDoHabitat[i];
        }

        return animaisDoHabitatMedida;
    }

    public static int interacoesAnimal(String[][] matrizInteracoes, String idAnimal) {
        int contagemInteracoes = 0;

        for (int linhaInteracao = 0; linhaInteracao < matrizInteracoes.length; linhaInteracao++) {

            if (matrizInteracoes[linhaInteracao][3].equals(idAnimal)) {
                // Contar a interação
                contagemInteracoes++;
            }
        }
        return contagemInteracoes;
    }

    public static double rendimentosAnimal(String[][] matrizInteracoes, String idAnimal) {
        double rendimentoTotal = 0;

        for (int linhaInteracao = 0; linhaInteracao < matrizInteracoes.length; linhaInteracao++) {

            if (matrizInteracoes[linhaInteracao][3].equals(idAnimal)) {
                // Incrementar ao rendimento
                rendimentoTotal += Double.parseDouble(matrizInteracoes[linhaInteracao][5]);
            }
        }
        return rendimentoTotal;
    }

    public static void estatisticasPorHabitat(String[][] matrizAnimais, String[][] matrizInteracoes) {

        String[] habitatsSemDuplicados = habitatsUnicos(matrizAnimais);

        for (int i = 0; i < habitatsSemDuplicados.length; i++) {
            System.out.println("\nHabitat: " + habitatsSemDuplicados[i]);
            System.out.println("  Nº de Animais: " + numeroAnimaisHabitat(matrizAnimais, habitatsSemDuplicados[i]));

            int numInteracoesTotal = 0;
            double receitaTotal = 0;

            String[] idsAnimaisHabitatAtual = animaisDeUmHabitat(matrizAnimais, habitatsSemDuplicados[i]);

            for (int indexAnimal = 0; indexAnimal < idsAnimaisHabitatAtual.length; indexAnimal++) {
                numInteracoesTotal += interacoesAnimal(matrizInteracoes, idsAnimaisHabitatAtual[indexAnimal]);
                receitaTotal += rendimentosAnimal(matrizInteracoes, idsAnimaisHabitatAtual[indexAnimal]);

            }

            System.out.println("  Nº de Interações: " + numInteracoesTotal);
            System.out.println("  Receita Associada: " + receitaTotal + " €");


        }
    }

    public static String nomeAnimal(String[][] matrizAnimais, String idAnimal) {
        for (int linha = 0; linha < matrizAnimais.length; linha++) {
            if (matrizAnimais[linha][0].equals(idAnimal)) {
                return matrizAnimais[linha][1];
            }
        }

        return "N/A";
    }

    public static String especieAnimal(String[][] matrizAnimais, String idAnimal) {
        for (int linha = 0; linha < matrizAnimais.length; linha++) {
            if (matrizAnimais[linha][0].equals(idAnimal)) {
                return matrizAnimais[linha][2];
            }
        }

        return "N/A";
    }

    public static void imprimirAnimaisHabitat(String[][] matrizAnimais) {
        String[] habitatsSemDuplicados = habitatsUnicos(matrizAnimais);

        for (int i = 0; i < habitatsSemDuplicados.length; i++) {
            System.out.println("\n***** " + habitatsSemDuplicados[i] + " *****");

            String[] idsAnimaisHabitatAtual = animaisDeUmHabitat(matrizAnimais, habitatsSemDuplicados[i]);
            for (int indexAnimal = 0; indexAnimal < idsAnimaisHabitatAtual.length; indexAnimal++) {
                System.out.print(nomeAnimal(matrizAnimais,idsAnimaisHabitatAtual[indexAnimal]));
                System.out.print(" | ");
                System.out.println(especieAnimal(matrizAnimais,idsAnimaisHabitatAtual[indexAnimal]));
            }

            System.out.println();
        }
    }





    /* Funções destinadas ao menu Cliente  */


    // 1. Ver catálogo de animais por habitat

    public static void listarHabitats (String[][] matrizAnimais, String habitat) {

        System.out.println("**** " + habitat + " *****");

        for (int i = 0; i < matrizAnimais.length; i++) {
            if (matrizAnimais[i][3].equals(habitat)) {
                String nome = matrizAnimais[i][1];
                String especie = matrizAnimais[i][2];

                System.out.println(" - " + nome + " (" + especie + ")");
            }
        }
    }

    public static void catalogoDeAnimaisPorHabitat (String[][] matrizAnimais) {

        String [] habitats = habitatsUnicos(matrizAnimais);
        for (int i = 0; i < habitats.length; i++) {
            listarHabitats(matrizAnimais, habitats[i]);
        }
    }


    // 2. Ver atividades de um Animal

    public static String [] encontrarNomeEspecie(String[][] matrizAnimais, String idAnimal) {

        for (int linha = 0; linha < matrizAnimais.length; linha++) {
            if (matrizAnimais[linha][0].equals(idAnimal)) {
                return new String [] {matrizAnimais[linha][1], matrizAnimais[linha][2]};
            }
        }
        return new String [] {"", ""};
    }

    public static void atividadesDoAnimal(String[][] matrizAnimais, String matrizInteracoes) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha o ID do animal que pretende: ");
        String idAnimal = input.nextLine();

        String [] id = encontrarNomeEspecie(matrizAnimais,idAnimal);

        if (id[0].equals("")){
            System.out.println("O Id colocado não existe no nosso Zoo");
        }


    }






    // 3. Simular Apadrinhamento de um animal

    public static String [] encontrarAnimalPorID(String[][] matrizAnimais, String idAnimal) {

        for (int linha = 0; linha < matrizAnimais.length; linha++) {
            if (matrizAnimais[linha][0].equals(idAnimal)) {
                return new String [] {matrizAnimais[linha][1], matrizAnimais[linha][2], matrizAnimais[linha][3]};
            }
        }
        return new String [] {"", "", ""};
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

        Scanner input = new Scanner(System.in);

        System.out.println("Nome do Cliente: ");
        String nomeCliente = input.nextLine();

        System.out.println("Email: ");
        String email = input.nextLine();

        System.out.println("Selecione o ID do animal que pretende adotar: ");
        String idAnimal = input.nextLine();

        String [] informacoesAnimal = encontrarAnimalPorID (matrizAnimais, idAnimal);

        if (informacoesAnimal[0].equals("")) {
            System.out.println("O id que inseriu não existe no nosso Zoo");
            return;
        }


        String nomeDoAnimal = informacoesAnimal[0];
        String especie = informacoesAnimal[1];
        String habitat = informacoesAnimal[2];

        System.out.println("Valor mensal a pagar: ");
        double custo = input.nextDouble();

        String plano = planoApadrinhamentoNovo(custo);


        System.out.println("\n **** Detalhes do seu Apadrinhamento **** ");
        System.out.println("Padrinho: " + nomeCliente + " (" + email + ")");
        System.out.println("Animal: " + nomeDoAnimal + " (" + especie + ") " + habitat);
        System.out.println("Plano de Apadrinhamento: " + plano);
        System.out.println("Custo: " + custo + "€/ mês");
    }



    // 4. Jogo de Adivinhar a Espécie


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




    // Função ficheiro Copyright

    public static void funcaoCopyright() {

        System.out.println("                                    ,---.           ,---.");
        System.out.println("                                  / /`.\\.--\"\"\"--./,'\"\\ \\");
        System.out.println("                                   \\ \\    _       _    / /");
        System.out.println("                                    `./  / __   __ \\  \\,'");
        System.out.println("                                     /    /_O)_(_O\\    \\");
        System.out.println("                                     |  .-'  ___  `-.  |");
        System.out.println("                                  .--|       \\_/       |--.");
        System.out.println("                               ,'    \\   \\   |   /   /    `.");
        System.out.println("                               /       `.  `--^--'  ,'       \\");
        System.out.println("                               .-.-.                        .-.-");
        System.out.println("                .-----------/         \\------------------/         \\--------------.");
        System.out.println("                | .---------\\         /----------------- \\         /------------. |");
        System.out.println("                | |          `-`--`--'                    `--'--'-'             | |");
        System.out.println("                | |                                                             | |");
        System.out.println("                | |                     FIM DO PROGRAMA                         | |");
        System.out.println("                | |                                                             | |");
        System.out.println("                | |                 PROJETO : CODESAVANA (ZOO)                  | |");
        System.out.println("                | |                                                             | |");
        System.out.println("                | |           PROJETO DESENVOLVIDO POR : PEDRO CAMPOS           | |");
        System.out.println("                | |                                                             | |");
        System.out.println("                | |                                                             | |");
        System.out.println("                | |              MÓDULO: PROGRAMAÇÃO ESTRUTURADA                | |");
        System.out.println("                | |                                                             | |");
        System.out.println("                | |                                                             | |");
        System.out.println("                | |                Todos os Direitos Reservados                 | |");
        System.out.println("                | |_____________________________________________________________| |");
        System.out.println("                |_________________________________________________________________|");
        System.out.println("                                    )__________|__|__________(");
        System.out.println("                                   |            ||            |");
        System.out.println("                                   |____________||____________|");
        System.out.println("                                     ),-----.(      ),-----.(");
        System.out.println("                                   ,'   ==.   \\    /  .==    `.");
        System.out.println("                                  /            )  (            \\");
        System.out.println("                                  `==========='    `==========='");

    }
}
