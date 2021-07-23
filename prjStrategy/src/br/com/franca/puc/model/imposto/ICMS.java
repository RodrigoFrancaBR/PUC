package br.com.franca.puc.model.imposto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class ICMS implements Imposto{
	
	public BigDecimal calcularImposto(Orcamento orcamento) {
		return orcamento.obterValor().multiply(new BigDecimal("0.1"));
	}
}
