package edu.isaque.practicingjava;

import java.util.List;

public class Desafio14 {

    /*
        Desafio 14 - Encontre o maior número primo da lista:
        Com a Stream API, encontre o maior número primo da lista e exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var maiorNumeroPrimo = numeros.stream()
            .filter(Default::isPrime)
            .max(Integer::compare)
            .orElse(null);

        System.out.println(maiorNumeroPrimo);

    }

}
