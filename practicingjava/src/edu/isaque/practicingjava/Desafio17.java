package edu.isaque.practicingjava;

import java.util.List;

public class Desafio17 {

    /*
        Desafio 17 - Filtrar os números primos da lista:
        Com a ajuda da Stream API, filtre os números primos da lista e exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {
        var numerosPrimos = numeros.stream()
            .filter(Default::isPrime)
            .toList();
        System.out.println(numerosPrimos);
    }

}
