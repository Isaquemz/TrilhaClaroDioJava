package edu.isaque.practicingjava;

import java.util.List;

public class Desafio02 {

    /*
        Desafio 2 - Imprima a soma dos números pares da lista:
        Utilizando a Stream API, realize a soma dos números pares da lista e exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var valorTotal = numeros.stream()
            .filter(Default.isEven)
            .reduce(0, Integer::sum);

        System.out.println(valorTotal);

    }

}
