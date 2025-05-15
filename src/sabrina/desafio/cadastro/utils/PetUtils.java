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

    public List<Pet> adcionandoPetPorArquivoLido() {
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

                        Pet pet = new Pet(new Endereco());
                        pet.setIndex(index);
                        pet.setNomeSobrenome(nome);
                        pet.setTipoPet(TipoPet.valueOf(tipo));
                        pet.setSexoPet(SexoPet.valueOf(genero));
                        pet.getEndereco().setRua(rua);
                        pet.getEndereco().setNumeroCasa(numero);
                        pet.getEndereco().setCidade(cidade);
                        pet.setIdade(Double.parseDouble(idade));
                        pet.setPeso(Double.parseDouble(peso));
                        pet.setRaca(raca);
                        petListArquivos.add(pet);
                        arquivosJaCarregados.put(index, petArquivos);
                        index++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ouve um erro na leitura do arquivo tente novamente"  + e.getMessage());
        }
        return petListArquivos;
    }
    public void imprimindoLista(){
        for (Pet petlist : petListArquivos){
            System.out.println(petlist);
        }
    }
    public boolean deletandoArquivoPet(Integer valorExclusao){
        try {
            if (Files.deleteIfExists(arquivosJaCarregados.get(valorExclusao))){
                arquivosJaCarregados.remove(valorExclusao);
            };
            return true;
        }catch (IOException | UnsupportedOperationException e){
            System.out.println("Ouve um erro na exclusão do pet tente novamente " + e.getMessage());
            return false;
        }
    }
}
