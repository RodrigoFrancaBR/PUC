package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public abstract class SituacaoDoOrcamento {

	public abstract BigDecimal calcularDescontoExtra(Orcamento orcamento);

}
