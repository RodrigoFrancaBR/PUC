package br.com.franca.puc.model.imposto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class ISS implements Imposto {

	public BigDecimal calcularImposto(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.06"));
	}

}
