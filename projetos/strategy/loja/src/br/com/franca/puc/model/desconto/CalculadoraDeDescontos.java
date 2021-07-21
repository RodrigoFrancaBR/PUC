package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

/**
 * 
 * @author Rodrigo Dado um orçamento posso dar descontos
 */
public class CalculadoraDeDescontos {

	public BigDecimal calcularDesconto(Orcamento orcamento) {
		BigDecimal valor = orcamento.obterValor();

		int comparacao = valor.compareTo(new BigDecimal("500.0"));

		if (orcamento.obterQuantidadeDeItens() > 5) {
			return valor.multiply(new BigDecimal("0.1"));
		}

		if (comparacao > 0) {
			return valor.multiply(new BigDecimal("0.1"));
		}

		return BigDecimal.ZERO;

	}
}
