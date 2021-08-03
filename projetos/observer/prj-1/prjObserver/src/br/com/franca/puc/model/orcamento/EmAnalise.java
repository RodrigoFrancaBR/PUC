package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class EmAnalise extends SituacaoDoOrcamento {

	// código comum para todas as subclasses de Situação de Orcamento
	// isolar na super classe o que não foi implementado é pq vai disparar exception
	
/*
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
	}*/
	

	@Override
	public String toString() {
		return "EmAnalise";
	}
	
	@Override
	public void aprovar(Orcamento orcamento) {
		// posso aprovar de em analise para aprovado
		orcamento.atualizarSituacao(new Aprovado());
	}
	
	@Override
	public void reprovar(Orcamento orcamento) {
		orcamento.atualizarSituacao(new Reprovado());
	}
	
	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.obterValor().multiply(new BigDecimal("0.05"));	
	}

}
