package sabrina.desafio.cadastro.view;

import sabrina.desafio.cadastro.services.CadastrarPets;
import sabrina.desafio.cadastro.services.MenuOpcoes;
import sabrina.desafio.cadastro.utils.LeituraArquivos;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuOpcoes menuOpcoes = new MenuOpcoes();
        int opcao = menuOpcoes.exibindoMenu();
        CadastrarPets cadastrarPets = new CadastrarPets();
        LeituraArquivos.lendoArquivo();
        do {
            if (opcao == 1) {
                cadastrarPets.cadastrandoPet(scanner);
                break;
            } else if (opcao == 2) {
                break;
            } else if (opcao == 3) {
                break;
            } else if (opcao == 4) {
                break;
            } else if (opcao == 5) {
                break;
            } else if (opcao == 6) {
                System.out.println("Fechando o programa");
                break;
            }
        } while (opcao != 6);
        scanner.close();
    }
}