package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BuscarPorDoisCriterios {
    private String nomeBuscado;
    private String racaBuscada;
    private Double idadeBuscada;
    private Double pesoBuscado;
    private String cidadeBuscada;
    private String sexoBuscado;

    public List<Pet> buscandoDoisCriterios(Scanner sc, List<Pet> resultPet) {
        List<Pet> petsPorDoisCriterios = new ArrayList<>();
        Predicate<Pet> predicate1 = null;
        Predicate<Pet> predicate2 = null;
        int resposta1;
        int resposta2;

        System.out.println("Quais criterios de busca você deseja");
        System.out.println("1. Nome e/ou Sobrenome");
        System.out.println("2. Sexo");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raça");
        System.out.println("6. Endereço");

        while (true){
            System.out.print("1° critério: ");
            resposta1 = sc.nextInt();
            System.out.println("2° criterio:");
            resposta2 = sc.nextInt();

            sc.nextLine();

            if (resposta1 <= 6 && resposta2 >= 1 || resposta2 <= 6 && resposta1 >= 1) {
                predicate1 = buscarPorDoisPredicados(sc, resposta1);
                predicate2 = buscarPorDoisPredicados(sc, resposta2);

                if (predicate1 != null && predicate2 != null) {
                    petsPorDoisCriterios = resultPet.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
                }

                if (!petsPorDoisCriterios.isEmpty()){
                    System.out.println("Pet(s) encontrado(s): ");
                    for (int i = 0; i < petsPorDoisCriterios.size(); i++) {
                        System.out.println((i + 1) + ". " + petsPorDoisCriterios.get(i));
                    }
                }
                break;
            }else {
                System.out.println("Digite um valor válido entre [1 e 6]");
            }
        }
        return petsPorDoisCriterios;
    }

    public Predicate<Pet> buscarPorDoisPredicados(Scanner sc, int resposta) {

        switch (resposta) {
            case 1:
                System.out.println("Digite o nome buscado");
                nomeBuscado = sc.nextLine();
                return p -> p.getNomeSobrenome().toUpperCase().trim().contains(nomeBuscado.toUpperCase().trim());
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
                System.out.println("Digite a cidade buscada");
                cidadeBuscada = sc.nextLine();
                return p -> p.getEndereco().getCidade().toUpperCase().trim().contains(cidadeBuscada.toUpperCase().trim());
            default:
                System.out.println("Valor de criterio inválido digite numeros entre [1] e [6] ");
                return null;
        }
    }
}
