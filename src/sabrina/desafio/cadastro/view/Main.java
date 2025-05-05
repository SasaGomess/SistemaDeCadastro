package sabrina.desafio.cadastro.view;

import sabrina.desafio.cadastro.enums.SexoPet;
import sabrina.desafio.cadastro.enums.TipoPet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========SISTEMA DE CADASTRO========");

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
                    cadastrandoPet(stringReader);
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
            e.printStackTrace();
        }
    }

    public static void cadastrandoPet(List<String> stringReader) {
        Locale.setDefault(Locale.US);
        try {
            String regex1 = "(^[a-zA-Z]+\\s[a-zA-z]+$)";
            String regex2 = "[a-zA-Z]+";
            String regex3 = "[0-9.,]+";

            sc.nextLine();
            System.out.println(stringReader.get(0));

            String nome = sc.nextLine();
            Pattern pattern = Pattern.compile(regex1);
            Matcher matcher = pattern.matcher(nome);
            if (!matcher.matches()) {
                System.out.println("O texto precisa ser igual");
            }
            System.out.println(stringReader.get(1));

            String tipoPet = sc.next();
            TipoPet.valueOf(tipoPet);

            System.out.println(stringReader.get(2));
            String sexoPet = sc.next();
            SexoPet.valueOf(sexoPet);

            System.out.println(stringReader.get(3));

            System.out.print("Numero casa: ");
            Integer numeroCasa = sc.nextInt();
            System.out.print("Cidade: ");
            String cidade = sc.next();
            System.out.print("Rua: ");
            int rua = sc.nextInt();

            System.out.println(stringReader.get(4));
            String idadeAproxString = sc.next(regex3);

            idadeAproxString = idadeAproxString.replace(",", ".");

            Double idadeAprox = Double.parseDouble(idadeAproxString);

            System.out.println(stringReader.get(5));
            String pesoAproxString = sc.next(regex3);

            pesoAproxString = pesoAproxString.replace(",", ".");

            Double pesoAprox = Double.parseDouble(pesoAproxString);

            if (pesoAprox > 60.0 || pesoAprox < 0.5) {

            }
            if (idadeAprox > 20) {

            } else if (idadeAprox < 0) {

            }
            System.out.println(stringReader.get(6)); 

            String racaPet = sc.next(Pattern.compile(regex2));

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("O nome deve ter apenas ");
            e.printStackTrace();
        }

    }
}