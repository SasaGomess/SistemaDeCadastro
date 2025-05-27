package sabrina.desafio.cadastro.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOpcoes {


    public int exibindoMenu(Scanner scanner) {
        try {
            int resposta;
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("====================");
            System.out.println("1. Cadastrar um novo Pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.print("RESPOSTA:");
            resposta = scanner.nextInt();

            if (resposta >= 1 && resposta <= 6) {
                return resposta;
            } else {
                return exibindoMenu(scanner);
            }

        } catch (InputMismatchException e) {
            System.out.println("Valor invalido, tente novamente");
            scanner.next();
            return exibindoMenu(scanner);
        }
    }
}
