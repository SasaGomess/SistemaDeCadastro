package sabrina.desafio.cadastro.utils;

import sabrina.desafio.cadastro.entities.Endereco;
import sabrina.desafio.cadastro.entities.Pet;
import sabrina.desafio.cadastro.enums.SexoPet;
import sabrina.desafio.cadastro.enums.TipoPet;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class PetUtils {
    public static List<Pet> petListArquivos = new ArrayList<>();
    public static Map<Integer, Path> arquivosJaCarregados = new TreeMap<>();
    private static Path caminhoDiretorio = Paths.get("petsCadastrados");
    private static Integer index = 1;

    public static List<Pet> adcionandoPetPorArquivoLido() {
        try (DirectoryStream<Path> arquivosStream = Files.newDirectoryStream(caminhoDiretorio)) {
            for (Path petArquivos : arquivosStream) {
                if (!arquivosJaCarregados.containsValue(petArquivos)){
                    System.out.println(petArquivos);
                    try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(petArquivos)))) {

                        String nome = br.readLine().substring(4);
                        String tipo = br.readLine().substring(4);
                        String genero = br.readLine().substring(4);
                        String endereco = br.readLine().substring(4);

                        String[] split = endereco.split(",");
                        String rua = split[0].substring(4);
                        String numero = split[1].trim();
                        String cidade = split[2].trim();
                        String idade = br.readLine().substring(4, 7).replace(",", ".");
                        String peso = br.readLine().substring(4, 7).replace(",", ".");
                        String raca = br.readLine().substring(4);
                        double valuePeso;
                        double valueIdade;


                        if (peso.trim().replaceAll(" ", "").equalsIgnoreCase("NÃOINFORMADO")){
                            String pesoFormatado = peso.replaceAll("NÃOINFORMADO", "0.0");
                            valuePeso = Double.parseDouble(pesoFormatado);
                        }else {
                            valuePeso = Double.parseDouble(peso);
                        }

                        if (idade.trim().replaceAll(" ", "").equalsIgnoreCase("NÃO")){
                            String idadeFormatada = idade.replaceAll("NÃO", "0");
                            valueIdade = Double.parseDouble(idadeFormatada);
                        }else {
                            valueIdade = Double.parseDouble(idade);
                        }

                        Pet pet = new Pet(nome, TipoPet.valueOf(tipo), SexoPet.valueOf(genero), new Endereco(rua, numero, cidade), valueIdade, valuePeso, raca);
                        pet.setIndex(index);
                        petListArquivos.add(pet);
                        arquivosJaCarregados.put(index, petArquivos);
                        index++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo/Pasta ainda vai ser criado(a)! Não existem nenhum pet cadastrado no arquivo ["  + e.getMessage() + "] ");
        }
        return petListArquivos;
    }

    public static void imprimindoLista(){
        for (Pet petlist : petListArquivos){
            System.out.println(petlist);
        }
    }

    public static boolean deletandoArquivoPet(Integer valorExclusao){
        try {
             return Files.deleteIfExists(arquivosJaCarregados.get(valorExclusao));
        }catch (IOException | UnsupportedOperationException | NullPointerException e){
            System.out.println("Ouve um erro na exclusão do pet tente novamente " + e.getMessage());
            return false;
        }
    }
}
