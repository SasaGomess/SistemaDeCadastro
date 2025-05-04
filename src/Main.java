import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=========SISTEMA DE CADASTRO========");

        String stringPath = "formulario.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(stringPath))){
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
}