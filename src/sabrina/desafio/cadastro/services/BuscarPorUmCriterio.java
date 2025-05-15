package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Endereco;
import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.services.interfaces.BuscarPetInterface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuscarPorUmCriterio implements BuscarPetInterface {
    private String nomeBuscado;
    private String sexoBuscado;
    private Double pesoBuscado;
    private String idadeBuscada;
    private String racaBuscada;
    private String cidadeBuscada;
    private String numeroCasa;
    private String ruaBuscada;

    @Override
    public List<Pet> buscandoPorCriterios(Scanner sc, List<Pet> resultBusca) {
        try {
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
            sc.nextLine();

            if (resposta <= 6 && resposta >= 1) {
                switch (resposta) {
                    case 1:
                        System.out.println("Digite o nome ou sobrenome procurado");
                        nomeBuscado = sc.nextLine();
                        return petsPorUmCriterio = resultBusca.stream().filter(p -> p.getNomeSobrenome().toUpperCase().trim().contains(nomeBuscado.toUpperCase().trim())).collect(Collectors.toList());
                    case 2:
                        System.out.println("Digite o sexo procurado");
                        sexoBuscado = sc.nextLine();
                        return petsPorUmCriterio = resultBusca.stream().filter(p -> p.getSexoPet().toString().equalsIgnoreCase(sexoBuscado.toUpperCase().trim())).collect(Collectors.toList());
                    case 3:
                        System.out.println("Digite a idade procurada");
                        idadeBuscada = sc.nextLine();
                        return petsPorUmCriterio = resultBusca.stream().filter(p -> p.getIdade().toString().replaceAll(",", "").contains(idadeBuscada.replaceAll(",", ""))).collect(Collectors.toList());
                    case 4:
                        System.out.println("Digite o peso procurado");
                        pesoBuscado = sc.nextDouble();
                        return petsPorUmCriterio = resultBusca.stream().filter(p -> p.getPeso().toString().replaceAll(",", "").contains(pesoBuscado.toString().replaceAll(",", ""))).collect(Collectors.toList());
                    case 5:
                        System.out.println("Digite a raça procurada");
                        racaBuscada = sc.nextLine();
                        return petsPorUmCriterio = resultBusca.stream().filter(p -> p.getRaca().toUpperCase().trim().contains(racaBuscada.toUpperCase().trim())).collect(Collectors.toList());
                    case 6:
                        System.out.println("Digite qual parte do endereco deseja buscar");
                        System.out.println("[1] Cidade: ");
                        System.out.println("[2] Numero da casa: ");
                        System.out.println("[3] Rua: ");
                        int resp = sc.nextInt();
                        sc.nextLine();
                        do {
                            if (resp == 1) {
                                System.out.println("Digite a cidade que deseja buscar");
                                cidadeBuscada = sc.nextLine();
                                return resultBusca.stream().filter(p -> p.getEndereco().getCidade().toUpperCase().trim().contains(cidadeBuscada.toUpperCase().trim())).toList();
                            } else if (resp == 2) {
                                System.out.println("Digite o n° da casa");
                                numeroCasa = sc.nextLine();
                                return resultBusca.stream().filter(p -> p.getEndereco().getNumeroCasa().toUpperCase().trim().contains(numeroCasa.toUpperCase().trim())).toList();
                            } else if (resp == 3) {
                                System.out.println("Digite a rua da casa");
                                ruaBuscada = sc.nextLine();
                                return resultBusca.stream().filter(p -> p.getEndereco().getRua().toUpperCase().trim().contains(ruaBuscada.toUpperCase().trim())).toList();
                            }
                            System.out.println("Endereco inválido digite novamente");
                            resp = sc.nextInt();
                        } while (resp != 1 && resp != 2 && resp != 3);
                }
            }
            return petsPorUmCriterio;
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Pet não encontrado, ou entrada inválida tente novamente Por Favor: ");
            sc.next();
            return buscandoPorCriterios(sc, resultBusca);
        }
    }
}
