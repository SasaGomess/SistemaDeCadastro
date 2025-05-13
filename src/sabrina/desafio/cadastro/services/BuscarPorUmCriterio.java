package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Endereco;
import sabrina.desafio.cadastro.entities.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuscarPorUmCriterio {
    public static List<Pet> buscandoPorUmCriterio(Scanner sc, List<Pet> resultBusca){
        List<Pet> petsPorUmCriterio = new ArrayList<>();
        System.out.println("Qual criterio de busca você deseja");
        System.out.println("1. Nome e/ou Sobrenome");
        System.out.println("2. Sexo");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raça");
        System.out.println("6. Endereço");
        System.out.print("RESPOSTA: ");
        int resposta = sc.nextInt();

        while (resposta <= 6 && resposta >= 1){
            switch (resposta){
                case 1:
                    String nomeBuscado = sc.nextLine();
                    petsPorUmCriterio = resultBusca.stream().filter(p -> p.getNomeSobrenome().toUpperCase().trim().contains(nomeBuscado.toUpperCase().trim())).collect(Collectors.toList());
                    break;
                case 2:
                    String sexoBuscado = sc.nextLine();
                    petsPorUmCriterio = resultBusca.stream().filter(p -> p.getSexoPet().toString().equalsIgnoreCase(sexoBuscado.toUpperCase().trim())).collect(Collectors.toList());
                    break;
                case 3:
                    Double idadeBuscada = sc.nextDouble();
                    petsPorUmCriterio = resultBusca.stream().filter(p -> p.getIdade().equals(idadeBuscada)).collect(Collectors.toList());
                    break;
                case 4:
                    Double pesoBuscado = sc.nextDouble();
                    petsPorUmCriterio = resultBusca.stream().filter(p -> p.getPeso().equals(pesoBuscado)).collect(Collectors.toList());
                    break;
                case 5:
                    String racaBucada = sc.nextLine();
                    petsPorUmCriterio = resultBusca.stream().filter(p -> p.getRaca().toUpperCase().trim().contains(racaBucada.toUpperCase().trim())).collect(Collectors.toList());
                    break;
                case 6:
                    String enderecoBuscado = sc.nextLine();
                    petsPorUmCriterio = resultBusca.stream().filter(p -> p.getEndereco().getCidade().toUpperCase().trim().contains(enderecoBuscado.toUpperCase().trim())).collect(Collectors.toList());
                    break;
                default:
                    System.out.println("Pet não encontrado, tente novamente: ");
                    buscandoPorUmCriterio(sc, resultBusca);
                    break;
            }
            System.out.println("Pet(s) encontrado(s): ");
            for (int i = 0; i < petsPorUmCriterio.size(); i++) {
                System.out.println((i+1)+ ". " + petsPorUmCriterio.get(i));
            }
        }
        return petsPorUmCriterio;
    }
}
