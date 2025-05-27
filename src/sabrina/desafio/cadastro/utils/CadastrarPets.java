package sabrina.desafio.cadastro.utils;
import sabrina.desafio.cadastro.entities.Endereco;
import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.enums.SexoPet;
import sabrina.desafio.cadastro.enums.TipoPet;

import java.util.InputMismatchException;
import java.util.Scanner;



import static sabrina.desafio.cadastro.utils.LeituraArquivos.lendoArquivo;

public class CadastrarPets {
    public void cadastrandoPet(Scanner sc) {

        lendoArquivo();
        ValidandoEntrada entrada = new ValidandoEntrada();

        try {
            System.out.println();
            System.out.println(" > Cadastrando um novo pet! Por favor insira as informacoes a seguir: ");
            System.out.println();
            System.out.println(lendoArquivo().get(1));
            String nome = entrada.validadoNome(sc);

            System.out.println(lendoArquivo().get(2));
            String tipoPet = sc.nextLine();

            System.out.println(lendoArquivo().get(3));
            String sexoPet = sc.nextLine();


            System.out.println(lendoArquivo().get(4));
            System.out.print("Numero casa: ");
            String numeroCasa = entrada.validandoEndereco(sc);


            System.out.print("Cidade: ");
            String cidade = sc.nextLine();
       ;

            System.out.print("Rua: ");
            String rua = sc.nextLine();


            System.out.println(lendoArquivo().get(5));
            Double idade = entrada.validandoIdade(sc);


            System.out.println(lendoArquivo().get(6));
            double peso = entrada.validandoPeso(sc);


            System.out.println(lendoArquivo().get(7));
            String racaPet = entrada.validandoRaca(sc);


            Pet pet = new Pet(nome, TipoPet.valueOf(tipoPet.toUpperCase()), SexoPet.valueOf(sexoPet.toUpperCase()), new Endereco(numeroCasa, cidade, rua),idade, peso, racaPet);
            pet.save();
            System.out.println("=============PET CADASTRADO COM SUCESSO==============");
        } catch (InputMismatchException | IllegalArgumentException | EnumConstantNotPresentException e) {
            System.out.println(e.getMessage());
        }
    }
}
