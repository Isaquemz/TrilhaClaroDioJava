package edu.isaque.practicingjava;

import java.util.List;

public class Desafio13 {

    /*
        Desafio 13 - Filtrar os números que estão num intervalo:
        Utilize a Stream API para filtrar os números que estão num
        intervalo específico (por exemplo, entre 5 e 10) e exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var numeroEntre5e10 = numeros.stream()
            .filter(n -> n >= 5 && n <= 10)
            .toList();

        System.out.println(numeroEntre5e10);

    }

}
