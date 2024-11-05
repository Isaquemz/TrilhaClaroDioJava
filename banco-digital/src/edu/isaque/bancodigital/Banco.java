package edu.isaque.bancodigital;

import edu.isaque.bancodigital.conta.Conta;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Banco {

    private String nome;
    private List<Conta> contas;

}