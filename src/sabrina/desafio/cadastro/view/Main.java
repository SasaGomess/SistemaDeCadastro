package sabrina.desafio.cadastro.view;

import sabrina.desafio.cadastro.UI.RodandoMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("|=================SISTEMA DE CADASTRO DE PETS=====================|");
        Scanner scanner = new Scanner(System.in);
        RodandoMenu.rodarMenu(scanner);
    }
}