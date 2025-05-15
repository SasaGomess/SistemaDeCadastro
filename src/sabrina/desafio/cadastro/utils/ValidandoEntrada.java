package sabrina.desafio.cadastro.utils;

import sabrina.desafio.cadastro.enums.SexoPet;
import sabrina.desafio.cadastro.enums.TipoPet;
import sabrina.desafio.cadastro.exceptions.IdadeException;
import sabrina.desafio.cadastro.exceptions.PesoException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidandoEntrada {

    public final static String REGEX_STRINGS = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+";
    public final static String REGEX_NOME_SOBRENOME = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+(\\s[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+)+$";

    public boolean nomeException(String nomeSobrenome) {
        if (!nomeSobrenome.trim().matches(REGEX_NOME_SOBRENOME)) {
            throw new IllegalArgumentException("O nome deverá ter [nome] e [sobrenome] e não deve ter caracteres especiais, Tente novamente :) ");
        }
        return true;
    }

    public boolean idadeExcecao(Double resultIdade) {
        if (resultIdade > 20 || resultIdade == 0.0 || (resultIdade > 0.0 && resultIdade < 1.0)){
            throw new IdadeException("Idade inválida, tente novamente (se o pet não possuir 1 ano ainda escolha a opcao [2])");
        }
        return true;
    }

    public boolean pesoException(Double pesoAprox) {
        if (pesoAprox > 60.0 || pesoAprox < 0.5) {
            throw new PesoException("O peso inválido [o peso precisa ser menor que 60kg ou maior que 500g]");
        }
        return true;
    }

    public String validadoNome(Scanner sc) {
        String nome = sc.nextLine();
        try {
            if (!nome.isEmpty()) {
                nomeException(nome);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validadoNome(sc);
        }
        return nome;
    }

    public double validandoIdade(Scanner sc) {

        System.out.println("A idade é em anos ou meses? Digite ([1] anos e [2] meses)");
        int resp = sc.nextInt();
        sc.nextLine();

        double resultIdade = 0.0;

        boolean entradaValida = false;

        if (resp == 2) {
            while (!entradaValida) {
                System.out.print("Digite a idade em meses:");
                String idadeAproxString = sc.nextLine();

                if (idadeAproxString.isEmpty()) {
                    return resultIdade;
                } else {
                    try {
                        idadeAproxString = idadeAproxString.replace(",", ".");
                        double idadeAprox = Double.parseDouble(idadeAproxString);
                        resultIdade = idadeAprox / 12.0;
                        return resultIdade;
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida por favor digite um numero.");
                    }
                }
            }
        } else if (resp == 1) {
            while (!entradaValida) {
                System.out.print("Digite a idade em anos:");
                String idadeAproxString = sc.nextLine();
                if (idadeAproxString.isEmpty()) {
                    return resultIdade;
                } else {
                    try {
                        idadeAproxString = idadeAproxString.replace(",", ".");
                        resultIdade = Double.parseDouble(idadeAproxString);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida por favor digite um numero.");
                    }
                }
            }
        }
        try {
            idadeExcecao(resultIdade);
        } catch (IdadeException e) {
            System.out.println(e.getMessage());
            return validandoIdade(sc);
        }
        return resultIdade;
    }

    public double validandoPeso(Scanner sc) {
        double pesoAprox = 0;

        boolean entradaValida = false;
        while (!entradaValida){
            String pesoAproxString = sc.nextLine();
            if (pesoAproxString.isEmpty()){
                return pesoAprox;
            }else {
                try{
                    pesoAproxString = pesoAproxString.replace(",", ".");
                    pesoAprox = Double.parseDouble(pesoAproxString);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Entrada inválida por favor digite um numero.");
                }
            }
        }
        try {
            pesoException(pesoAprox);
        } catch (PesoException e) {
            System.out.println(e.getMessage());
            return validandoPeso(sc);
        }
        return pesoAprox;
    }


    public String validandoRaca(Scanner sc){
        String racaPet = sc.nextLine();
        if(racaPet.isEmpty()){
            return racaPet;
        } else if (!racaPet.trim().matches(REGEX_STRINGS)) {
            System.out.println("A raça não pode conter numeros nem caracteres especiais tente novamente");
            return validandoRaca(sc);
        }
        return racaPet;
    }
    public String validandoEndereco(Scanner sc){
        String numeroCasa = null;
        int numeroCasaParse = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            numeroCasa = sc.nextLine();
            if (numeroCasa.isEmpty()){
                break;
            }else {
                try {
                    numeroCasaParse = Integer.parseInt(numeroCasa);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Entrada inválida por favor digite um numero.");
                }
            }
        }
        return numeroCasa;
    }
}
