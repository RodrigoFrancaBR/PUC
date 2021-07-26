package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Reprovado extends SituacaoDoOrcamento {

	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}

	public void aprovar(Orcamento orcamento) {
		throw new RuntimeException("ERRO");
	}

	public void reprovar(Orcamento orcamento) {
		throw new RuntimeException("ERRO");
	}

	public void finalizar(Orcamento orcamento) {
		orcamento.atualizarSituacao(new Finalizado());
	}

	public void emAnalise(Orcamento orcamento) {
		throw new RuntimeException("ERRO");
	}
}
