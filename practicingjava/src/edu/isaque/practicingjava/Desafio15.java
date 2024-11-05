package edu.isaque.practicingjava;

import java.util.List;

public class Desafio15 {
     /*
        Desafio 15 - Verifique se a lista contém pelo menos um número negativo:
        Utilizando a Stream API, verifique se a lista contém pelo menos um número negativo e exiba o
        resultado no console.
      */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {
        var quantidadeNumerosNegativos = numeros.stream()
                .filter(n -> n < 0)
                .count();

        System.out.println(quantidadeNumerosNegativos > 0);
    }

}
