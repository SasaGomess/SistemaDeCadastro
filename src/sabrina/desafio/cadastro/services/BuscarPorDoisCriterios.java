package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static sabrina.desafio.cadastro.utils.ValidandoEntrada.REGEX_STRINGS;

public class BuscarPorDoisCriterios {
    private String nomeBuscado;
    private String racaBuscada;
    private Double idadeBuscada;
    private Double pesoBuscado;
    private String cidadeBuscada;
    private String rua;
    private String numeroCasa;
    private String sexoBuscado;

    public List<Pet> buscandoDoisCriterios(Scanner sc, List<Pet> resultPet) {
        List<Pet> petsPorDoisCriterios = new ArrayList<>();
        Predicate<Pet> predicate1 = null;
        Predicate<Pet> predicate2 = null;
        int resposta1;
        int resposta2;

        while (true) {
            System.out.println("Quais criterios de busca você deseja");
            System.out.println("1. Nome e/ou Sobrenome");
            System.out.println("2. Sexo");
            System.out.println("3. Idade");
            System.out.println("4. Peso");
            System.out.println("5. Raça");
            System.out.println("6. Endereço");


            System.out.print("1° critério: ");
            resposta1 = sc.nextInt();
            System.out.print("2° criterio: ");
            resposta2 = sc.nextInt();

            sc.nextLine();

            if (resposta1 <= 6 && resposta2 >= 1 || resposta2 <= 6 && resposta1 >= 1) {
                predicate1 = buscarPorDoisPredicados(sc, resposta1);
                predicate2 = buscarPorDoisPredicados(sc, resposta2);

                if (predicate1 != null && predicate2 != null) {
                    petsPorDoisCriterios = resultPet.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
                }
                break;
            }
        }
        return petsPorDoisCriterios;
    }

    public Predicate<Pet> buscarPorDoisPredicados(Scanner sc, int resposta) {

        try {
            switch (resposta) {
                case 1:
                    System.out.println("Digite o nome buscado");
                    nomeBuscado = sc.nextLine();
                    return p -> p.getNomeSobrenome().toUpperCase().trim().contains(nomeBuscado.toUpperCase().trim().replaceAll(REGEX_STRINGS, ""));
                case 2:
                    System.out.println("Digite o sexo buscado");
                    sexoBuscado = sc.nextLine();
                    return p -> p.getSexoPet().toString().equalsIgnoreCase(sexoBuscado.toUpperCase().trim());
                case 3:
                    System.out.println("Digite a idade buscada");
                    idadeBuscada = sc.nextDouble();
                    return p -> p.getIdade().equals(idadeBuscada);
                case 4:
                    System.out.println("Digite o peso buscado");
                    pesoBuscado = sc.nextDouble();
                    return p -> p.getPeso().equals(pesoBuscado);
                case 5:
                    System.out.println("Digite a raça buscada");
                    racaBuscada = sc.nextLine();
                    return p -> p.getRaca().toUpperCase().trim().contains(racaBuscada.toUpperCase().trim());
                case 6:
                    System.out.println("Por qual endereço deseja fazer a busca?");
                    System.out.println("[1] Cidade: ");
                    System.out.println("[2] Numero da casa: ");
                    System.out.println("[3] Rua: ");
                    int resp = sc.nextInt();
                    sc.nextLine();
                    do {
                        if (resp == 1) {
                            System.out.println("Digite a cidade que deseja buscar");
                            cidadeBuscada = sc.nextLine();
                            return p -> p.getEndereco().getCidade().toUpperCase().trim().contains(cidadeBuscada.toUpperCase().trim());
                        } else if (resp == 2) {
                            System.out.println("Digite o n° da casa");
                            numeroCasa = sc.nextLine();
                            return p -> p.getEndereco().getNumeroCasa().contains(numeroCasa.trim());
                        } else if (resp == 3) {
                            System.out.println("Digite a rua da casa");
                            rua = sc.nextLine();
                            return p -> p.getEndereco().getNumeroCasa().contains(rua.trim());
                        }
                        System.out.println("Endereco inválido digite novamente");
                        resp = sc.nextInt();
                    } while (resp != 1 && resp != 2 && resp != 3);
            }
            return null;
        } catch (InputMismatchException | NullPointerException e) {
            System.out.println("O valor digitado é inválido porfavor tente novamente");
            sc.next();
            return buscarPorDoisPredicados(sc, resposta);
        }
    }
}
