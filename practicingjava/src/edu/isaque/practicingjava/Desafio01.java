package edu.isaque.practicingjava;

import java.util.List;

public class Desafio01 {
    /*
        Desafio 1 - Mostre a lista na ordem numérica:
        Crie um programa que utilize a Stream API para ordenar a lista de números em ordem crescente e
        a exiba no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void  main(String[] args) {
        numeros.stream()
            .sorted()
            .forEach(System.out::println);
    }

}
