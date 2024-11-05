package edu.isaque.practicingjava;

import java.util.List;

public class Desafio10 {

    /*
        Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
        Utilize a Stream API para agrupar os valores ímpares múltiplos de 3 ou de 5 e exiba o
        resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var total = numeros.stream()
            .filter(numero -> numero % 3 == 0 || numero % 5 == 0)
            .reduce(0, Integer::sum);

        System.out.println(total);

    }

}
