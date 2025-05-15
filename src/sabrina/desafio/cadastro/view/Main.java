package sabrina.desafio.cadastro.view;

import sabrina.desafio.cadastro.services.AlterarPet;
import sabrina.desafio.cadastro.services.BuscarPet;
import sabrina.desafio.cadastro.services.CadastrarPets;
import sabrina.desafio.cadastro.services.MenuOpcoes;
import sabrina.desafio.cadastro.services.DeletarPet;
import sabrina.desafio.cadastro.utils.LeituraArquivos;
import sabrina.desafio.cadastro.utils.PetUtils;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("=================SISTEMA DE CADASTRO DE PETS=====================");
        Scanner scanner = new Scanner(System.in);
        MenuOpcoes menuOpcoes = new MenuOpcoes();
        int opcao = menuOpcoes.exibindoMenu();
        CadastrarPets cadastrarPets = new CadastrarPets();
        AlterarPet alterarPet = new AlterarPet();
        BuscarPet buscandoPet = new BuscarPet();
        PetUtils petUtils = new PetUtils();
        DeletarPet deletarPet = new DeletarPet();
        petUtils.adcionandoPetPorArquivoLido();
        LeituraArquivos.lendoArquivo();

        do {
            if (opcao == 1) {
                cadastrarPets.cadastrandoPet(scanner);
                petUtils.adcionandoPetPorArquivoLido();
                opcao = menuOpcoes.exibindoMenu();
            } else if (opcao == 2) {
                alterarPet.alterandoDados(scanner);
                opcao = menuOpcoes.exibindoMenu();
            } else if (opcao == 3) {
                deletarPet.deletandoPet(scanner);
                opcao = menuOpcoes.exibindoMenu();
            } else if (opcao == 4) {
                petUtils.imprimindoLista();
                opcao = menuOpcoes.exibindoMenu();
            } else if (opcao == 5) {
                buscandoPet.buscandoPet(scanner);
                opcao = menuOpcoes.exibindoMenu();
            } else if (opcao == 6) {
                System.out.println("Fechando o programa");
                break;
            }
        } while (opcao != 6);
        scanner.close();
    }
}