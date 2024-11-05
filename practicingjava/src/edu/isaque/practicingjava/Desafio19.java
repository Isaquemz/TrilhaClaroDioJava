package edu.isaque.practicingjava;

import java.util.List;

public class Desafio19 {

    /*
        Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5:
        Com a Stream API, encontre a soma dos números da lista que são divisíveis tanto por 3 quanto por 5 e
        exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {
        numeros.stream()
            .filter(n -> n % 3 == 0 || n % 5 == 0)
            .reduce(Integer::sum)
            .ifPresent(System.out::println);
    }

}
