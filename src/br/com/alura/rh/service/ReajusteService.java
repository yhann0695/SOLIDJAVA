package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacao;

    public ReajusteService(List<ValidacaoReajuste> validacao) {
        this.validacao = validacao;
    }

    public void reajusteSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        this.validacao.forEach(v -> v.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
