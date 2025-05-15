package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.utils.PetUtils;
import sabrina.desafio.cadastro.utils.ValidandoEntrada;

import java.util.List;
import java.util.Scanner;

import static sabrina.desafio.cadastro.utils.PetUtils.petListArquivos;

public class AlterarPet {
    private String nomeAlteracao;
    private Double idadeAlteracao;
    private Double pesoAlteracao;
    private String cidadeAlteracao;
    private String racaAlteracao;
    private String numeroCasaAlteracao;
    private String ruaAlteracao;
    private BuscarPet buscarPet = new BuscarPet();
    private ValidandoEntrada entrada = new ValidandoEntrada();
    private PetUtils petUtils = new PetUtils();


    public void alterandoDados(Scanner sc){
        List<Pet> petParaAlteracao;
        petParaAlteracao = buscarPet.buscandoPet(sc);
        System.out.println("Digite o numero do pet que deseja alterar");

        int nParaAlterar = sc.nextInt();

        for (int i = 0; i < petParaAlteracao.size(); i++) {
            if (petParaAlteracao.get(i).getIndex() == nParaAlterar){
                System.out.println("Digite qual dado você deseja modificar: ");

                System.out.println("[1] Nome ");
                System.out.println("[2] Idade ");
                System.out.println("[3] Peso ");
                System.out.println("[4] Raça ");
                System.out.println("[5] Endereço");
                int resp = sc.nextInt();
                sc.nextLine();

                while (true){
                    if (resp == 1){
                        for (Pet petListArquivo : petListArquivos) {
                            if (petParaAlteracao.get(i).equals(petListArquivo)){
                                System.out.println("Digite o nome que deseja alterar: ");
                                nomeAlteracao = entrada.validadoNome(sc);
                                petUtils.deletandoArquivoPet(nParaAlterar);
                                petListArquivo.setNomeSobrenome(nomeAlteracao);
                                petListArquivo.save();
                            }
                        }
                        break;
                    }else if (resp == 2){
                        for (Pet petListArquivo : petListArquivos) {
                            if (petParaAlteracao.get(i).equals(petListArquivo)){
                                System.out.println("Digite a idade que deseja alterar: ");
                                idadeAlteracao = entrada.validandoIdade(sc);
                                petUtils.deletandoArquivoPet(nParaAlterar);
                                petListArquivo.setIdade(idadeAlteracao);
                                petListArquivo.save();
                            }
                        }
                        break;
                    } else if (resp == 3) {
                        for (Pet petListArquivo : petListArquivos) {
                            if (petParaAlteracao.get(i).equals(petListArquivo)){
                                System.out.println("Digite o peso que deseja alterar: ");
                                pesoAlteracao = entrada.validandoPeso(sc);
                                petUtils.deletandoArquivoPet(nParaAlterar);
                                petListArquivo.setPeso(pesoAlteracao);
                                petListArquivo.save();
                            }
                        }
                        break;
                    } else if (resp == 4) {
                        for (Pet petListArquivo : petListArquivos) {
                            if (petParaAlteracao.get(i).equals(petListArquivo)){
                                System.out.println("Digite a raca que deseja alterar: ");
                                racaAlteracao = entrada.validandoRaca(sc);
                                petUtils.deletandoArquivoPet(nParaAlterar);
                                petListArquivo.setRaca(racaAlteracao);
                                petListArquivo.save();
                            }
                        }
                        break;
                    } else if (resp == 5) {
                        System.out.println("Digite qual campo você deseja alterar:");
                        System.out.println("[1] Cidade: ");
                        System.out.println("[2] Numero da casa: ");
                        System.out.println("[3] Rua: ");
                        int respEndereco = sc.nextInt();
                        sc.nextLine();
                        do {
                            if (respEndereco == 1){
                                for (Pet petListArquivo : petListArquivos) {
                                    if (petParaAlteracao.get(i).equals(petListArquivo)) {
                                        System.out.println("Digite o valor de alteração da cidade: ");
                                        cidadeAlteracao = sc.nextLine();
                                        petUtils.deletandoArquivoPet(nParaAlterar);
                                        petListArquivo.getEndereco().setCidade(cidadeAlteracao);
                                        petListArquivo.save();
                                    }
                                }
                                break;
                            } else if (respEndereco == 2) {
                                for (Pet petListArquivo : petListArquivos) {
                                    if (petParaAlteracao.get(i).equals(petListArquivo)){
                                        System.out.println("Digite o valor de alteração do numero da casa: ");
                                        numeroCasaAlteracao = entrada.validandoEndereco(sc);
                                        petUtils.deletandoArquivoPet(nParaAlterar);
                                        petListArquivo.getEndereco().setNumeroCasa(numeroCasaAlteracao);
                                        petListArquivo.save();
                                    }
                                }
                                break;
                            } else if (respEndereco == 3) {
                                for (Pet petListArquivo : petListArquivos){
                                    if (petParaAlteracao.get(i).equals(petListArquivo)){
                                        System.out.println("Digite o valor de alteração da rua: ");
                                        ruaAlteracao = sc.nextLine();
                                        petUtils.deletandoArquivoPet(nParaAlterar);
                                        petListArquivo.getEndereco().setRua(ruaAlteracao);
                                        petListArquivo.save();
                                    }
                                }
                                break;
                            }
                            System.out.println("Numero inválido digite um numero dentro dos critérios especificados para alterar o endereço");
                            respEndereco = sc.nextInt();
                        }while (respEndereco <= 3 && respEndereco >= 1);
                    }
                    System.out.println("Numero inválido digite um numero dentro dos critérios especificados para alterar os dados do pet");
                }
            }
        }
    }
}
