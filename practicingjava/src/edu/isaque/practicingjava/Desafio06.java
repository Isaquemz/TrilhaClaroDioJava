package edu.isaque.practicingjava;

import java.util.List;

public class Desafio06 {
    /*
        Desafio 6 - Verificar se a lista contém algum número maior que 10:
        Utilize a Stream API para verificar se a lista contém algum número maior que 10
        e exiba o resultado no console.
     */

    static List<Integer> numeros = Default.getList();

    public static void main(String[] args) {

        var quantidadeNumerosMaioresDez = numeros.stream()
                .filter(n -> n > 10)
                .count();

        System.out.println(quantidadeNumerosMaioresDez > 0);

    }

}
