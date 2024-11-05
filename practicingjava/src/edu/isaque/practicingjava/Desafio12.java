package edu.isaque.practicingjava;

import java.util.List;

public class Desafio12 {

    /*
        Desafio 12 - Encontre o produto de todos os números da lista:
        Com a ajuda da Stream API, encontre o produto de todos os números da lista e exiba
        o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var total = numeros.stream()
            .reduce(1, (x, y) -> x * y);

        System.out.println(total);

    }

}
