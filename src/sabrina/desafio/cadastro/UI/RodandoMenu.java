package sabrina.desafio.cadastro.UI;

import sabrina.desafio.cadastro.services.*;
import sabrina.desafio.cadastro.utils.*;

import java.util.Scanner;

public class RodandoMenu {
    public static void rodarMenu(Scanner scanner) {

        MenuOpcoes menuOpcoes = new MenuOpcoes();
        int opcao = menuOpcoes.exibindoMenu(scanner);
        CadastrarPets cadastrarPets = new CadastrarPets();
        AlterarPetService alterarPet = new AlterarPetService();
        BuscarPetService buscandoPet = new BuscarPetService();
        DeletarPetService deletarPet = new DeletarPetService();
        PetUtils.adcionandoPetPorArquivoLido();
        LeituraArquivos.lendoArquivo();

        do {
            scanner.nextLine();
            if (opcao == 1) {
                cadastrarPets.cadastrandoPet(scanner);
                PetUtils.adcionandoPetPorArquivoLido();
            } else if (opcao == 2) {
                alterarPet.alterandoDados(scanner);
            } else if (opcao == 3) {
                deletarPet.deletandoPet(scanner);
            } else if (opcao == 4) {
                PetUtils.imprimindoLista();
            } else if (opcao == 5) {
                buscandoPet.buscandoPet(scanner);
            } else if (opcao == 6) {
                System.out.println("Fechando o programa");
                break;
            }
            opcao = menuOpcoes.exibindoMenu(scanner);
        } while (opcao != 6);
        scanner.close();
    }
}
