package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Orcamento {

	private BigDecimal valor;

	public Orcamento(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal obterValor() {
		return valor;
	}

}
