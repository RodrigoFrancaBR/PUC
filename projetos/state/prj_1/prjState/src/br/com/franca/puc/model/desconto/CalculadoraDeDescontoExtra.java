package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class CalculadoraDeDescontoExtra {	
	public BigDecimal calcular(Orcamento orcamento) {
		orcamento.efetuarDescontoExtra();
		return orcamento.obterValor();
	}
}
