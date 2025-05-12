package sabrina.desafio.cadastro.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivos {
    public static List<String> lendoArquivo(){
        List<String> stringReader = new ArrayList<>();
        String stringPath = "formulario.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(stringPath))) {
            String line = br.readLine();
            while (line != null) {
                stringReader.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringReader;
    }
}
