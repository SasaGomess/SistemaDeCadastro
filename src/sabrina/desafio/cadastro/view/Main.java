package sabrina.desafio.cadastro.view;

import sabrina.desafio.cadastro.entities.Endereco;
import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.enums.SexoPet;
import sabrina.desafio.cadastro.enums.TipoPet;
import sabrina.desafio.cadastro.exceptions.IdadeException;
import sabrina.desafio.cadastro.exceptions.PesoException;
import sabrina.desafio.cadastro.services.CadastrarPets;
import sabrina.desafio.cadastro.services.MenuOpcoes;
import sabrina.desafio.cadastro.utils.LeituraArquivos;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static sabrina.desafio.cadastro.utils.LeituraArquivos.lendoArquivo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        MenuOpcoes menuOpcoes = new MenuOpcoes();
        int opcao = menuOpcoes.exibindoMenu(scanner);
        CadastrarPets cadastrarPets = new CadastrarPets();
        LeituraArquivos.lendoArquivo();
        try {
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

        } catch (InputMismatchException e) {
            System.out.println("Valor de entrada inválido");
            e.printStackTrace();
        }
    }
}