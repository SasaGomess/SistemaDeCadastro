package sabrina.desafio.cadastro.services;

import sabrina.desafio.cadastro.entities.Pet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastrandoPets {

    public static void gerandoArquivoPet(Pet pet) {
        LocalDateTime timeNow = LocalDateTime.now();
        String gerandoData = timeNow.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'1234"));
        String gerandoNome = pet.getNomeSobrenome().trim().toUpperCase().trim();
        String gerandoNomeArquivo = gerandoData + "-" + gerandoNome.replaceAll("\\s+", "") + ".txt";
        System.out.println(gerandoNomeArquivo);
        File folder = new File("\\petsCadastrados");
        String folderPath = folder.getParent();
        boolean criandoFolder = new File(folderPath + "\\petsCadastrados").mkdir();
        String criandoFile = folderPath + "C:\\temp\\ws-intelliJ\\Sistema de Cadastros\\petsCadastrados\\" + gerandoNomeArquivo;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(criandoFile))) {
            bw.write("1 - " + pet.getNomeSobrenome());
            bw.newLine();
            bw.write("2 - " + pet.getTipoPet());
            bw.newLine();
            bw.write("3 - " + pet.getSexoPet());
            bw.newLine();
            bw.write("4 - Rua " + pet.getEndereco().getRua() + ", " + pet.getEndereco().getNumeroCasa()+ ", "+ pet.getEndereco().getCidade());;
            bw.newLine();
            bw.write("5 - " + pet.getIdade() + " anos");
            bw.newLine();
            bw.write("6 - " + pet.getPeso() + "kg");
            bw.newLine();
            bw.write("7 - " + pet.getTipoPet());
            bw.newLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
