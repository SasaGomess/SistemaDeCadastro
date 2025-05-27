package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.enums.TipoPet;
import sabrina.desafio.cadastro.utils.PetUtils;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class BuscarPetService {
    private BuscarPorDoisCriterios buscandoDoisCriterios = new BuscarPorDoisCriterios();
    private BuscarPorUmCriterio buscarPorUmCriterio = new BuscarPorUmCriterio();
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private DateTimeFormatter fmtPath = DateTimeFormatter.ofPattern("yyyyMMdd");

    public List<Pet> buscandoPet(Scanner scanner) {
        List<Pet> resultBusca = PetUtils.petListArquivos;
        boolean validando = false;
        while (!validando) {
            try {
                resultBusca = buscandoCriterioObrigatorio(resultBusca, scanner);

                System.out.println();

                System.out.println("Agora digite quantos criterios de busca você deseja [1 ou 2]: ");
                int criterios = scanner.nextInt();

                do {
                    if (criterios == 1 || criterios == 2) {
                        if (criterios == 1) {
                            resultBusca = buscarPorUmCriterio.buscandoPorCriterios(scanner, resultBusca);
                        } else {
                            resultBusca = buscandoDoisCriterios.buscandoPorCriterios(scanner, resultBusca);
                        }
                        break;
                    } else {
                        System.out.println("O resultado da busca foi inválido, escolha entre 1 e 2 e tente novamente");
                        criterios = scanner.nextInt();
                    }
                } while (criterios == 1 || criterios == 2);

                if (!resultBusca.isEmpty()) {
                    System.out.println("Pet(s) encontrado(s)");
                    for (Pet resultBuscas : resultBusca) {
                        System.out.println(resultBuscas);
                    }
                    validando = true;
                } else {
                    throw new IllegalStateException("O resultado retornou um valor nulo nenhum pet foi encontrado");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Dado inválido tente novamente!");
                scanner.next();
            } catch (NullPointerException | IllegalStateException e1) {
                System.out.println("Nenhum pet foi encontrado com a busca específicada! Tente novamente");
            }
        }
        return resultBusca;
    }

    public List<Pet> buscandoCriterioObrigatorio(List<Pet> resultBusca, Scanner scanner) throws InputMismatchException, IllegalStateException{

        System.out.println("Qual o tipo do Pet deseja filtrar? (cachorro ou gato): ");
        String resp = scanner.nextLine().trim().toUpperCase();
        do {
            if (resp.equalsIgnoreCase("CACHORRO")) {
                return resultBusca.stream().filter(x -> x.getTipoPet().equals(TipoPet.CACHORRO)).collect(Collectors.toList());
            } else if (resp.equalsIgnoreCase("GATO")) {
                return resultBusca.stream().filter(x -> x.getTipoPet().equals(TipoPet.GATO)).collect(Collectors.toList());
            }
            System.out.println("Tipo de animal inválido, digite somente Cachorro ou Gato");
            resp = scanner.nextLine().trim().toUpperCase();

        } while (!resp.equalsIgnoreCase("CACHORRO") && !resp.equalsIgnoreCase("GATO"));
        return null;
    }

    public List<Pet> buscandoCriterioData(List<Pet> resultBusca, Scanner scanner) {
        try {
            System.out.println("Agora digite a data de cadastro do pet: ");
            System.out.println("Digite mês e ano exemplo: (2025/05/15) ");
            LocalDate dataPorCriterio = LocalDate.parse(scanner.next(), fmt);
            String formatando = dataPorCriterio.format(fmtPath).toUpperCase().replaceAll("-", "");

            for (Map.Entry<Integer, Path> entry : PetUtils.arquivosJaCarregados.entrySet()) {
                if (entry.getValue().getFileName().toString().contains(formatando)) {
                   return resultBusca.stream().filter(p -> p.getIndex() == entry.getKey()).toList();
                }
            }
            return null;
        } catch (DateTimeParseException e) {
            System.out.println("O valor passado como data foi inválido, tente novamente: ");
            return buscandoCriterioData(resultBusca, scanner);
        }
    }
}
