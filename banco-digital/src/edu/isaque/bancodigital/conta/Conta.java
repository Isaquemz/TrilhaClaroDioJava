package edu.isaque.bancodigital.conta;

import edu.isaque.bancodigital.Cliente;
import edu.isaque.bancodigital.transacao.HistoricoTransacoes;

import edu.isaque.bancodigital.transacao.LogTransacao;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Conta implements IConta {

    private static final Integer AGENCIA_PADRAO = 1;
    private static Integer SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer numero;
    protected BigDecimal saldo;
    protected Cliente cliente;
    protected HistoricoTransacoes historicoTransacoes;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = BigDecimal.ZERO;
        this.historicoTransacoes = new HistoricoTransacoes();
    }

    @Override
    public void sacar(BigDecimal valor) {
        saldo = saldo.subtract(valor);

        this.historicoTransacoes.addTransacao(
            new LogTransacao("Saque no valor de R$ " + valor + " realizado.", valor)
        );
    }

    @Override
    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);

        this.historicoTransacoes.addTransacao(
            new LogTransacao("Deposito no valor de R$ " + valor + " realizado.", valor)
        );

    }

    public void depositar(Integer valor) {
        depositar(BigDecimal.valueOf(valor));
    }

    @Override
    public void transferir(BigDecimal valor, IConta iContaDestino) {

        Conta contaDestino = (Conta) iContaDestino;

        this.setSaldo(this.saldo.subtract(valor));
        contaDestino.setSaldo(contaDestino.saldo.add(valor));

        LogTransacao logTransacaoOrigem = new LogTransacao(
            "Transferência no valor de R$ " + valor + " realizado para a conta " +
                contaDestino.getNumero() + " .",
            valor
            );
        LogTransacao logTransacaoDestino = new LogTransacao(
            "Transferência no valor de R$ " + valor + " recebida da conta " +
                this.getNumero() + " .",
            valor
        );

        this.historicoTransacoes.addTransacao(logTransacaoOrigem);
        contaDestino.historicoTransacoes.addTransacao(logTransacaoDestino);

    }

    public void transferir(Integer valor, IConta iContaDestino) {
        transferir(BigDecimal.valueOf(valor), iContaDestino);
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
        System.out.println("==============================");
        this.imprimirTransacoes();
        System.out.println("==============================");
    }

    protected void imprimirTransacoes() {
        System.out.println("Transacões: ");

        this.historicoTransacoes
            .getTransacoes()
            .forEach(System.out::println);
    }

}