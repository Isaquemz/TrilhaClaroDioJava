package edu.isaque.practicingjava;

import java.util.Comparator;
import java.util.List;

public class Desafio07 {

    /*
        Desafio 7 - Encontrar o segundo número maior da lista:
        Com a ajuda da Stream API, encontre o segundo número maior da lista e exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {
        numeros.stream()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .ifPresent(System.out::println);
    }

}
