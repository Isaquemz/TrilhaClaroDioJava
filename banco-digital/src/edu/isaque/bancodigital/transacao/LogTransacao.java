package edu.isaque.bancodigital.transacao;

import lombok.*;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class LogTransacao {

    private static Integer SEQUENCIAL = 1;

    private Integer codigo;
    private String descricao;
    private BigDecimal valor;
    private LocalDateTime dataCadastro;

    public LogTransacao(String descricao, BigDecimal valor) {
        this.codigo = SEQUENCIAL++;
        this.descricao = descricao;
        this.valor = valor;
        this.dataCadastro = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return  "Descricao: " + descricao +
                " - Valor: R$" + valor +
                " - Data: " + dataCadastro.format(formatter);
    }
}
