import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========SISTEMA DE CADASTRO========");

        String stringPath = "formulario.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(stringPath))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            while (true) {

                System.out.println("=====================");
                System.out.println("MENU PRINCIPAL");
                System.out.println("====================");
                System.out.println("1. Cadastrar um novo Pet");
                System.out.println("2. Alterar os dados do pet cadastrado");
                System.out.println("3. Deletar um pet cadastrado");
                System.out.println("4. Listar todos os pets cadastrados");
                System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
                System.out.println("6. Sair");

                System.out.print("RESPOSTA:");

                int respostaMenu = sc.nextInt();

                if (respostaMenu == 1) {
                    break;
                } else if (respostaMenu == 2) {
                    break;
                } else if (respostaMenu == 3) {
                    break;
                } else if (respostaMenu == 4) {
                    break;
                } else if (respostaMenu == 5) {
                    break;
                } else if (respostaMenu == 6) {
                    break;
                } else if (respostaMenu <= 0 || respostaMenu > 6) {
                    continue;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Valor de entrada inválido");
            e.getMessage();
        }
    }

    public static void inputInvalid(int respMenu) {
        if (respMenu <= 0 || respMenu > 6) {
            System.out.println("Resposta invalida");
            sc.nextInt();
        }
    }
}