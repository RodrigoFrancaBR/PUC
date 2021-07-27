package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Finalizado extends SituacaoDoOrcamento {

	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}

}
