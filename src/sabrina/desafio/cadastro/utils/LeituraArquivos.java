package sabrina.desafio.cadastro.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeituraArquivos {
    public static Map<Integer, String>lendoArquivo(){
        Map<Integer, String> stringReader = new HashMap<>();
        String stringPath = "formulario.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(stringPath))) {
            String line = br.readLine();
            int i = 1;
            while (line != null) {
                stringReader.put(i++, line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringReader;
    }
}
