package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.enums.TipoPet;
import sabrina.desafio.cadastro.services.interfaces.BuscarPetInterface;
import sabrina.desafio.cadastro.utils.PetUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuscarPet {
    private BuscarPorDoisCriterios buscandoDoisCriterios = new BuscarPorDoisCriterios();
    private BuscarPorUmCriterio buscarPorUmCriterio = new BuscarPorUmCriterio();

    public List<Pet> buscandoPet(Scanner scanner) {
        List<Pet> resultBusca = PetUtils.petListArquivos;
        resultBusca =  buscandoCriterioObrigatorio(resultBusca, scanner);
        if (!resultBusca.isEmpty()) {
            System.out.println("Pet(s) encontrado(s)");
            for (int i = 0; i < resultBusca.size(); i++) {
                System.out.println(resultBusca.get(i));
            }
        }
        System.out.println();

        System.out.println("Deseja buscar o pet pela data de cadastro?");

        System.out.println("Agora digite quantos criterios de busca você deseja [1 ou 2]: ");
        int criterios = scanner.nextInt();

        do {
            if(criterios == 1 || criterios == 2) {
                if (criterios == 1) {
                    resultBusca = buscarPorUmCriterio.buscandoPorUmCriterio(scanner, resultBusca);
                } else {
                    resultBusca = buscandoDoisCriterios.buscandoDoisCriterios(scanner, resultBusca);
                }
                break;
            }else {
                System.out.println("O resultado da busca foi inválido, escolha entre 1 e 2 e tente novamente");
                criterios = scanner.nextInt();
            }
        }while (criterios == 1 || criterios == 2);

        if (!resultBusca.isEmpty()) {
            System.out.println("Pet(s) encontrado(s)");
            for (Pet resultBuscas : resultBusca) {
                System.out.println(resultBuscas);
            }
        }
        return resultBusca;
    }
    public List<Pet> buscandoCriterioObrigatorio(List<Pet> resultBusca, Scanner scanner) throws InputMismatchException {

        System.out.println("Qual o tipo do Pet? (cachorro ou gato): ");
        String resp = scanner.nextLine().trim().toUpperCase();
        do {
            if (resp.equalsIgnoreCase("CACHORRO")) {
                return resultBusca.stream().filter(x -> x.getTipoPet().equals(TipoPet.CACHORRO)).collect(Collectors.toList());
            } else if (resp.equalsIgnoreCase("GATO")) {
                return resultBusca.stream().filter(x -> x.getTipoPet().equals(TipoPet.GATO)).collect(Collectors.toList());
            }
            System.out.println("Tipo de animal inválido, digite somente Cachorro ou Gato");
            resp = scanner.nextLine().trim().toUpperCase();

        }while (!resp.equalsIgnoreCase("CACHORRO") && !resp.equalsIgnoreCase("GATO"));
        return resultBusca;
    }
}
