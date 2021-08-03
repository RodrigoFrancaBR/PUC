package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class DescontoZero extends DescontoDoOrcamento {

	public DescontoZero() {
		super(null);
	}	

	@Override
	protected BigDecimal efetuarDesconto(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}

	@Override
	protected boolean descontoValido(Orcamento orcamento) {
		return true;
	}

}
