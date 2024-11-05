package edu.isaque.bancodigital;

import edu.isaque.bancodigital.conta.Conta;
import edu.isaque.bancodigital.conta.ContaCorrente;
import edu.isaque.bancodigital.conta.ContaPoupanca;

public class Main {

    /*
     * Objetivo:
     *      O objetivo deste projeto prático hands-on é reforçar o conhecimento em Programação 
     *      Orientada a Objetos (POO) em Java, através da implementação de um banco digital.
     * 
     * Descrição: 
     *      Neste projeto, será disponibilizado no GitHub um projeto de referência que utiliza os 
     *      conceitos de POO e Java para criar um banco digital. O contexto bancário será explorado 
     *      para explorar os pilares da orientação a objetos, e assim, os participantes poderão 
     *      reproduzir a solução e desenvolver sua capacidade de abstração.
     * 
     * GitHub Referencia: https://github.com/falvojr/lab-banco-digital-oo
     */

    public static void main(String[] args) {

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }

}
