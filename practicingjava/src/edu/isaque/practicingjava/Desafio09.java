package edu.isaque.practicingjava;

import java.util.List;
import java.util.stream.Collectors;

public class Desafio09 {

    /*
        Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):
        Com a Stream API, verifique se todos os números da lista são distintos (não se repetem) e exiba o
        resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var quantidadeNumerosNaoDistintos = numeros.stream()
                .collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .count();

        System.out.println(quantidadeNumerosNaoDistintos <= 0);
    }

}
