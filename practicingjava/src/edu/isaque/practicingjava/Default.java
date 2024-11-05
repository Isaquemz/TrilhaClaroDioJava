package edu.isaque.practicingjava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Default {

    /*

        Desafios com o intuito de reforço e aprendizado do uso de Stream

        Repositorio base:
            https://github.com/digitalinnovationone/ganhando_produtividade_com_Stream_API_Java/tree/master/src/stream_api

     */

    static List<Integer> getList() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        return numeros;
    }

    static boolean isPrime(Integer number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false; // elimina todos os números pares maiores que 2
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) { // verifica apenas números ímpares
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static Predicate<Integer> isEven = num -> num % 2 == 0;

}
