package edu.isaque.practicingjava;

import java.util.List;

public class Desafio11 {

    /*
        Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:
        Utilizando a Stream API, encontre a soma dos quadrados de todos os números da lista e exiba o
        resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var total = numeros.stream()
            .map(num -> num * num)
            .reduce(0, Integer::sum);

        System.out.println(total);

    }

}
