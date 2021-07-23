package br.com.franca.puc.model.imposto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public interface Imposto {
	public BigDecimal calcularImposto(Orcamento orcamento);
}
