package edu.isaque.practicingjava;

import java.util.List;
import java.util.function.Predicate;

public class Desafio16 {

    /*
        Desafio 16 - Agrupe os números em pares e ímpares:
        Utilize a Stream API para agrupar os números em duas listas separadas, uma contendo os números pares e
        outra contendo os números ímpares da lista original, e exiba os resultados no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var numerosImpares = numeros.stream()
            .filter(Default.isEven.negate())
            .toList();

        var numerosPares = numeros.stream()
                .filter(Default.isEven)
                .toList();

        System.out.println("Impares: " + numerosImpares);
        System.out.println("Pares: " + numerosPares);

    }

}
