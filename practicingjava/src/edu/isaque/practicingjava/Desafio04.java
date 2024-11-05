package edu.isaque.practicingjava;

import java.util.List;

public class Desafio04 {

    /*
        Desafio 4 - Remova todos os valores ímpares:
        Utilize a Stream API para remover os valores ímpares da lista e imprima a lista resultante no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {
        numeros.stream()
            .filter(Default.isEven)
            .forEach(System.out::println);
    }

}
