package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.utils.ValidandoEntrada;

import java.util.List;
import java.util.Scanner;

import static sabrina.desafio.cadastro.utils.PetUtils.petListArquivos;

public class AlterarPet {
    BuscarPet buscarPet = new BuscarPet();
    ValidandoEntrada entrada = new ValidandoEntrada();

    public void alterandoDados(Scanner sc){
        List<Pet> petParaAlteracao;
        petParaAlteracao = buscarPet.buscandoPet(sc);
        System.out.println("Digite o numero do pet que deseja alterar");

        int nParaAlterar = sc.nextInt();


        for (int i = 0; i < petParaAlteracao.size(); i++) {
            if (petParaAlteracao.get(i).getIndex() == nParaAlterar){
                int iLista = nParaAlterar - 1;
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
                                String nomeAlteracao = entrada.validadoNome(sc);
                                petListArquivos.get(iLista).setNomeSobrenome(nomeAlteracao);
                            }
                        }
                        break;
                    }else if (resp == 2){

                        for (Pet petListArquivo : petListArquivos) {
                            if (petParaAlteracao.get(i).equals(petListArquivo)){
                                System.out.println("Digite a idade que deseja alterar: ");
                                Double idadeAlteracao = entrada.validandoIdade(sc);
                                petListArquivos.get(iLista).setIdade(idadeAlteracao);
                            }
                        }
                        break;
                    } else if (resp == 3) {

                        for (Pet petListArquivo : petListArquivos) {
                            if (petParaAlteracao.get(i).equals(petListArquivo)){
                                System.out.println("Digite o peso que deseja alterar: ");
                                Double pesoAlteracao = entrada.validandoPeso(sc);
                                petListArquivos.get(iLista).setPeso(pesoAlteracao);
                            }
                        }
                        break;
                    } else if (resp == 4) {
                        for (Pet petListArquivo : petListArquivos) {
                            if (petParaAlteracao.get(i).equals(petListArquivo)){
                                System.out.println("Digite a raca que deseja alterar: ");
                                String racaAlteracao = entrada.validandoRaca(sc);
                                petListArquivos.get(iLista).setRaca(racaAlteracao);
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
                                        String cidadeAlteracao = sc.nextLine();
                                        petListArquivos.get(iLista).getEndereco().setCidade(cidadeAlteracao);
                                    }
                                }
                                break;
                            } else if (respEndereco == 2) {
                                for (Pet petListArquivo : petListArquivos) {
                                    if (petParaAlteracao.get(i).equals(petListArquivo)){
                                        System.out.println("Digite o valor de alteração do numero da casa: ");
                                        String numeroCasaAlteracao = entrada.validandoEndereco(sc);
                                        petListArquivos.get(iLista).getEndereco().setNumeroCasa(numeroCasaAlteracao);
                                    }
                                }
                                break;
                            } else if (respEndereco == 3) {
                                for (Pet petListArquivo : petListArquivos){
                                    if (petParaAlteracao.get(i).equals(petListArquivo)){
                                        System.out.println("Digite o valor de alteração da rua: ");
                                        String ruaAlteracao = sc.nextLine();
                                        petListArquivos.get(iLista).getEndereco().setRua(ruaAlteracao);
                                    }
                                }
                                break;
                            }
                            System.out.println("Numero inválido digite um numero dentro dos critérios especificados para alterar o endereço");
                            respEndereco = sc.nextInt();
                        }while (respEndereco < 3 && respEndereco >= 1);
                    }
                    System.out.println("Numero inválido digite um numero dentro dos critérios especificados para alterar os dados do pet");
                }
            }
        }




    }
}
