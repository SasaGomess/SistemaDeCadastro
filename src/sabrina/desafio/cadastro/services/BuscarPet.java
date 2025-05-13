package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.enums.TipoPet;
import sabrina.desafio.cadastro.services.interfaces.BuscarPetInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuscarPet implements BuscarPetInterface {
    Scanner scanner = new Scanner(System.in);
    BuscarPorDoisCriterios buscandoDoisCriterios = new BuscarPorDoisCriterios();

    @Override
    public List<Pet> buscandoPet(List<Pet> list, Pet pet) {
        List<Pet> resultBusca = new ArrayList<>();
        List<Pet> resultBuscaComCriterios = new ArrayList<>();
        resultBusca =  buscandoCriterioObrigatorio(resultBusca, list);

        System.out.println("Agora digite quantos criterios de busca você deseja [1 ou 2]: ");
        int criterios = scanner.nextInt();

        do{
            if (criterios == 1){
                resultBuscaComCriterios = BuscarPorUmCriterio.buscandoPorUmCriterio(scanner, resultBusca);
            }else if (criterios == 2){
                resultBuscaComCriterios = buscandoDoisCriterios.buscandoDoisCriterios(scanner, resultBusca);
            }
        }while (criterios != 1 || criterios != 2);

        return resultBuscaComCriterios;
    }
    public List<Pet> buscandoCriterioObrigatorio(List<Pet> resultBusca, List<Pet> list){
        System.out.println("Qual o tipo do Pet?(cachorro ou gato): ");
        String resp = scanner.nextLine();
        String respBusca = resp.trim().toUpperCase();

        if (respBusca.equalsIgnoreCase("CACHORRO")) {
            resultBusca = list.stream().filter(x -> x.getTipoPet().equals(TipoPet.CACHORRO)).collect(Collectors.toList());
        } else if (respBusca.equalsIgnoreCase("GATO")) {
            resultBusca = list.stream().filter(x -> x.getTipoPet().equals(TipoPet.GATO)).collect(Collectors.toList());
        } else {
            System.out.println("O tipo do pet não existe. Por favor escolha entre Gato ou Cachorro");
        }
        if (!resultBusca.isEmpty()) {
            System.out.println("Pet(s) encontrado(s)");
            for (int i = 0; i < resultBusca.size(); i++) {
                System.out.println((i + 1) + ". " + resultBusca.get(i));
            }
        }
        return resultBusca;
    }
}
