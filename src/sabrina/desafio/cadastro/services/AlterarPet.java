package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.utils.ValidandoEntrada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterarPet {
    BuscarPet buscarPet = new BuscarPet();
    ValidandoEntrada entrada = new ValidandoEntrada();
    public void alterandoDados(Scanner sc){
        List<Pet> petParaAlteracao;
        petParaAlteracao = buscarPet.buscandoPet(sc);
        System.out.println("Digite o numero do pet que deseja alterar");

        int nParaAlterar = sc.nextInt();

        for (int i = 0; i < petParaAlteracao.size(); i++) {
            if(petParaAlteracao.get(i).getIndex() == nParaAlterar){
                nParaAlterar -= 1;
            }else {
                System.out.println("numero para alterar inválido");
            }
        }

        if (!petParaAlteracao.isEmpty()){
            petParaAlteracao.get(nParaAlterar);
        }

        System.out.println("Digite qual dado você deseja modificar: ");
        int resp = sc.nextInt();
        sc.nextLine();

        System.out.println("[1] Nome ");
        System.out.println("[2] Idade ");
        System.out.println("[3] Peso ");
        System.out.println("[4] Raça ");
        System.out.println("[5] Endereço");

    while (true){
        if (resp == 1){
            System.out.println("Digite o nome que deseja alterar: ");
            String nomeAlteracao = entrada.validadoNome(sc);
            petParaAlteracao.get(nParaAlterar).setNomeSobrenome(nomeAlteracao);
            break;
        }else if (resp == 2){
            System.out.println("Digite a idade que deseja alterar: ");
            Double idadeAlteracao = entrada.validandoIdade(sc);
            petParaAlteracao.get(nParaAlterar).setIdade(idadeAlteracao);
            break;
        } else if (resp == 3) {
            System.out.println("Digite o peso que deseja alterar: ");
            Double pesoAlteracao = entrada.validandoPeso(sc);
            petParaAlteracao.get(nParaAlterar).setPeso(pesoAlteracao);
            break;
        } else if (resp == 4) {
            System.out.println("Digite a raca que deseja alterar: ");
            String racaAlteracao = entrada.validandoRaca(sc);
            petParaAlteracao.get(nParaAlterar).setRaca(racaAlteracao);
            break;
        } else if (resp == 5) {

            System.out.println("Digite qual campo você deseja alterar:");
            System.out.println("[1] Cidade: ");
            System.out.println("[2] Numero da casa: ");
            System.out.println("[3] Rua: ");
            int respEndereco = sc.nextInt();

            do {
                if (respEndereco == 1){
                    System.out.println("Digite o valor de alteração da cidade: ");
                    String cidadeAlteracao = sc.nextLine();
                    petParaAlteracao.get(nParaAlterar).getEndereco().setCidade(cidadeAlteracao);
                    break;
                } else if (respEndereco == 2) {
                    System.out.println("Digite o valor de alteração do numero da casa: ");
                    String numeroCasaAlteracao = entrada.validandoEndereco(sc);
                    petParaAlteracao.get(nParaAlterar).getEndereco().setNumeroCasa(numeroCasaAlteracao);
                    break;
                } else if (respEndereco == 3) {
                    System.out.println("Digite o valor de alteração da rua: ");
                    String ruaAlteracao = sc.nextLine();
                    petParaAlteracao.get(nParaAlterar).getEndereco().setRua(ruaAlteracao);
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
