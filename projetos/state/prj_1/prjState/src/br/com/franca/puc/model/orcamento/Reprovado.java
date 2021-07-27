package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Reprovado extends SituacaoDoOrcamento {

	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.atualizarSituacao(new Finalizado());
	}

}
