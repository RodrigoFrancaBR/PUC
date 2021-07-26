package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class EmAnalise extends SituacaoDoOrcamento {

	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.obterValor().multiply(new BigDecimal("0.05"));		
	}

	public void aprovar(Orcamento orcamento) {
		orcamento.atualizarSituacao(new Aprovado());
	}

	public void reprovar(Orcamento orcamento) {
		orcamento.atualizarSituacao(new Reprovado());
	}

	public void finalizar(Orcamento orcamento) {
		orcamento.atualizarSituacao(new Finalizado());
	}

	public void emAnalise(Orcamento orcamento) {
		orcamento.atualizarSituacao(new EmAnalise());
	}

}
