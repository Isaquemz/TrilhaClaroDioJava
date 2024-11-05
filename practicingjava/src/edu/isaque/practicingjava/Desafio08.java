package edu.isaque.practicingjava;

import java.util.List;

public class Desafio08 {
    /*
        Desafio 8 - Somar os dígitos de todos os números da lista:
        Utilizando a Stream API, realize a soma dos dígitos de todos os números da lista e
        exiba o resultado no console.
     */

    public static void calcularTotalNumeros(List<Integer> numeros) {
        var total = numeros.stream()
                .reduce(0, Integer::sum);
        System.out.println(total);
    }

    public static void calcularTotalCaracters(List<Integer> numeros) {
        var total = numeros.stream()
                .flatMap(num -> String.valueOf(num)
                        .chars()
                        .mapToObj(Character::getNumericValue))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(total);
    }

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {
        calcularTotalNumeros(numeros);
        calcularTotalCaracters(numeros);
    }

}
