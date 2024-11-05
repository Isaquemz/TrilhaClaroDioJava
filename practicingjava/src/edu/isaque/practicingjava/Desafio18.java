package edu.isaque.practicingjava;

import java.util.List;
import java.util.stream.Collectors;

public class Desafio18 {

    /*
        Desafio 18 - Verifique se todos os números da lista são iguais:
        Utilizando a Stream API, verifique se todos os números da lista são iguais e exiba o
        resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var quantidadePorNumeros = numeros.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println(quantidadePorNumeros.size() == 1);

    }

}
