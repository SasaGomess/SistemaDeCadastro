package sabrina.desafio.cadastro.entities;

import sabrina.desafio.cadastro.enums.SexoPet;
import sabrina.desafio.cadastro.enums.TipoPet;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    private String nomeSobrenome;
    private TipoPet tipoPet;
    private SexoPet sexoPet;
    private Endereco endereco;
    private Double idade;
    private Double peso;
    private String raca;
    private int index;

    public Pet() {
    }

    public Pet(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        if (nomeSobrenome.trim().isEmpty()) {
            this.nomeSobrenome = NAO_INFORMADO;
        } else {
            this.nomeSobrenome = nomeSobrenome;
        }
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }

    public SexoPet getSexoPet() {
        return sexoPet;
    }

    public void setSexoPet(SexoPet sexoPet) {
        this.sexoPet = sexoPet;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
       this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setRaca(String raca) {
        if (raca.trim().isEmpty()){
            this.raca = NAO_INFORMADO;
        }else {
            this.raca = raca;
        }
    }

    public String gerandoNomeArquivoPet() {

        LocalDateTime timeNow = LocalDateTime.now();
        String gerandoData = timeNow.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));

        String gerandoNome = getNomeSobrenome().toUpperCase();
        String gerandoNomeArquivo = gerandoData + "-" + gerandoNome.replaceAll("\\s+", "") + ".txt";

        File folder = new File("\\petsCadastrados");
        String folderPath = folder.getParent();

        String criandoFile = folderPath + "C:\\temp\\ws-intelliJ\\Sistema de Cadastros\\petsCadastrados\\" + gerandoNomeArquivo;
        return criandoFile;
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(gerandoNomeArquivoPet()))) {
                bw.write("1 - " + getNomeSobrenome());
                bw.newLine();

                bw.write("2 - " + getTipoPet());
                bw.newLine();

                bw.write("3 - " + getSexoPet());
                bw.newLine();

                bw.write("4 - Rua " + getEndereco().getRua() + ", " + getEndereco().getNumeroCasa() + ", " + getEndereco().getCidade());
                bw.newLine();

                if (getIdade() == 0.0) {
                    bw.write("5 - " + NAO_INFORMADO);
                }else {
                    bw.write("5 - " + String.format("%.1f", getIdade()) + " anos");
                }
                bw.newLine();

                if (getPeso() == 0.0){
                    bw.write("6 - " + NAO_INFORMADO);
                }else {
                    bw.write("6 - " + String.format("%.1f", getPeso()) + "kg");
                }
                bw.newLine();
                bw.write("7 - " + getRaca());

            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void carregandoPet(Pet pet){
        File folder = new File("\\petsCadastrados");

       // List<Pet> petReader = save(pet);

//        for (Pet arquivoPet: petReader){
//            System.out.println(arquivoPet);
//        }
//        try(BufferedReader br = new BufferedReader(new FileReader(folder))){
//            if (!petReader.isEmpty()){
//                for (Pet petvalue : petReader){
//
//                }
//            }
//        }catch (IOException e){
//
//        }
//        return petReader;
   }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(nomeSobrenome, pet.nomeSobrenome) && tipoPet == pet.tipoPet && sexoPet == pet.sexoPet && Objects.equals(endereco, pet.endereco) && Objects.equals(idade, pet.idade) && Objects.equals(peso, pet.peso) && Objects.equals(raca, pet.raca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeSobrenome, tipoPet, sexoPet, endereco, idade, peso, raca);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(index);
        sb.append(". "+nomeSobrenome + " - ");
        sb.append(tipoPet + " - ");
        sb.append(sexoPet + " - ");
        sb.append(endereco + " - ");
        sb  = idade == 0.0 ? sb.append(NAO_INFORMADO + " - ") : sb.append(String.format("%.1f",idade) + " anos - ");
        sb  = peso == 0.0 ? sb.append(NAO_INFORMADO + " - ") : sb.append(String.format("%.1f",peso) + "kg - ");
        sb.append(raca);
        return sb.toString();
    }
}
