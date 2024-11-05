package edu.isaque.bancodigital.transacao;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HistoricoTransacoes {

    protected List<LogTransacao> transacoes;

    public HistoricoTransacoes() {
        this.transacoes = new ArrayList<LogTransacao>();
    }

    public void addTransacao(LogTransacao transacao) {
        this.transacoes.add(transacao);
    }

}
