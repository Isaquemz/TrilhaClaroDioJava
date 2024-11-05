package edu.isaque.practicingjava;

import java.util.List;

public class Desafio03 {

    /*
        Desafio 3 - Verifique se todos os números da lista são positivos:
        Com a ajuda da Stream API, verifique se todos os números da lista são positivos e exiba
        o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var quantidadeNumerosNegativos = numeros.stream()
                .filter(n -> n < 0)
                .count();

        System.out.println(quantidadeNumerosNegativos == 0);

    }

}
