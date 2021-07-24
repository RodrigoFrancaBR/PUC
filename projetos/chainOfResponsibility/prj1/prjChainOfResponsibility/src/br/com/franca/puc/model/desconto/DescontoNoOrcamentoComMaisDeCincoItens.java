package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class DescontoNoOrcamentoComMaisDeCincoItens {

	public BigDecimal calcularDesconto(Orcamento orcamento) {
		// validar se o valor é valido?

		if (orcamento.obterQuantidadeDeItens() > 5) {
			return orcamento.obterValor().multiply(new BigDecimal("0.05"));
		}

		return BigDecimal.ZERO;

	}
}
