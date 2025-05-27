package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.utils.PetUtils;

import java.util.List;
import java.util.Scanner;

public class DeletarPetService {
   public BuscarPetService buscarPet = new BuscarPetService();
   public PetUtils petUtils = new PetUtils();

   public void deletandoPet(Scanner sc){
      List<Pet> petParaRemover = buscarPet.buscandoPet(sc);
      System.out.println("Digite o número do pet que deseja excluir: ");

      int valorExclusao = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i < petParaRemover.size(); i++) {
         if (petParaRemover.get(i).getIndex() == valorExclusao){
            System.out.println();
            System.out.println("Tem certeza que deseja excluir o pet?");
            System.out.println("[SIM] - [NÃO]");
            String respDefinitiva = sc.nextLine();

            if (respDefinitiva.toUpperCase().replaceAll(" ", "").equalsIgnoreCase("SIM")){
               boolean exclusao = PetUtils.deletandoArquivoPet(valorExclusao);
               if (exclusao){
                  PetUtils.petListArquivos.remove(valorExclusao - 1 );
                  System.out.println("Pet foi excluído com sucesso :D");
               }
            }else if (respDefinitiva.toUpperCase().trim().replaceAll(" ", "").replaceAll("A","Ã").equalsIgnoreCase("NÃO")){
               System.out.println("O pet NÃO será excluído, siga com as demais opções do menu");
               break;
            }else {
               System.out.println("O valor digitado não corresponde a nenhuma das opções, volte ao menu e tente novamente");
            }
         }
      }
   }
}
