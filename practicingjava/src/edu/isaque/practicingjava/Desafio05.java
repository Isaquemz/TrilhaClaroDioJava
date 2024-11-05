package edu.isaque.practicingjava;

import java.util.List;

public class Desafio05 {

    /*
        Desafio 5 - Calcule a média dos números maiores que 5:
        Com a Stream API, calcule a média dos números maiores que 5 e exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var media = numeros.stream()
            .filter(n -> n > 5)
            .mapToDouble((n) -> n)
            .average();

        System.out.println(media.getAsDouble());

    }

}
