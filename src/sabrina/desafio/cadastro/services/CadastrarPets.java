package sabrina.desafio.cadastro.services;
import sabrina.desafio.cadastro.entities.Endereco;
import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.enums.SexoPet;
import sabrina.desafio.cadastro.enums.TipoPet;
import sabrina.desafio.cadastro.utils.ValidandoEntrada;
import java.util.InputMismatchException;
import java.util.Scanner;



import static sabrina.desafio.cadastro.utils.LeituraArquivos.lendoArquivo;

public class CadastrarPets {
    public void cadastrandoPet(Scanner sc) {
        lendoArquivo();
        Pet pet = new Pet(new Endereco());
        ValidandoEntrada entrada = new ValidandoEntrada();
        try {
            System.out.println(lendoArquivo().get(0));
            String nome = entrada.validadoNome(sc);
            pet.setNomeSobrenome(nome);

            System.out.println(lendoArquivo().get(1));
            String tipoPet = sc.nextLine();
            pet.setTipoPet(TipoPet.valueOf(tipoPet.toUpperCase()));

            System.out.println(lendoArquivo().get(2));
            String sexoPet = sc.nextLine();
            pet.setSexoPet(SexoPet.valueOf(sexoPet.toUpperCase()));

            System.out.println(lendoArquivo().get(3));
            System.out.print("Numero casa: ");
            String numeroCasa = entrada.validandoEndereco(sc);
            pet.getEndereco().setNumeroCasa(numeroCasa);

            System.out.print("Cidade: ");
            String cidade = sc.nextLine();
            pet.getEndereco().setCidade(cidade);

            System.out.print("Rua: ");
            String rua = sc.nextLine();
            pet.getEndereco().setRua(rua);

            System.out.println(lendoArquivo().get(4));
            Double idade = entrada.validandoIdade(sc);
            pet.setIdade(idade);

            System.out.println(lendoArquivo().get(5));
            double peso = entrada.validandoPeso(sc);
            pet.setPeso(peso);

            System.out.println(lendoArquivo().get(6));
            String racaPet = entrada.validandoRaca(sc);
            pet.setRaca(racaPet);
            System.out.println(pet);

            pet.save();
        } catch (InputMismatchException | IllegalArgumentException | EnumConstantNotPresentException e) {
            System.out.println(e.getMessage());
        }
    }
}
