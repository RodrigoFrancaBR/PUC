package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.exception.SituacaoDoOrcamentoException;

public abstract class SituacaoDoOrcamento {

	public abstract BigDecimal calcularDescontoExtra(Orcamento orcamento);

	// por default lança exception.. para não lançar a sub-classe precisa sobrescrever o método.
	public void colocarEmAnalise(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situação atual é, " + orcamento.obterSituacao().toString() + " não podendo atualizar para Em Análise.");
		// orcamento.atualizarSituacao(new EmAnalise());
		
	}	
	public void aprovar(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situação atual é, " + orcamento.obterSituacao().toString() + " não podendo atualizar para Aprovado.");
		// orcamento.atualizarSituacao(new Aprovado());
	}

	public void reprovar(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situação atual é, " + orcamento.obterSituacao().toString() + " não podendo atualizar para Reprovado.");
		// orcamento.atualizarSituacao(new Reprovado());
	}

	public void finalizar(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situação atual é, " + orcamento.obterSituacao().toString() + " não podendo atualizar para Finalizado.");
		// orcamento.atualizarSituacao(new Finalizado());
	}



}
