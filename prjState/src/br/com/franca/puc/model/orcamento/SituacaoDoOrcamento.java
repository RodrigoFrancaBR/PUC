package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.exception.SituacaoDoOrcamentoException;

public abstract class SituacaoDoOrcamento {

	// tornar concreto para ter um valor default pois 
	// quando for finalizado ou reprovado devolve sempre zero
	// isolar comportamentos comuns na classe mae	
	// public abstract BigDecimal calcularDescontoExtra(Orcamento orcamento);
	public BigDecimal calcularDescontoExtra(Orcamento orcamento){
		return BigDecimal.ZERO;
	}

	// por default lan�a exception.. para n�o lan�ar a sub-classe precisa sobrescrever o m�todo.
	public void colocarEmAnalise(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situa��o atual �, " + orcamento.obterSituacao().toString() + " n�o podendo atualizar para Em An�lise.");
		// orcamento.atualizarSituacao(new EmAnalise());
		
	}	
	public void aprovar(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situa��o atual �, " + orcamento.obterSituacao().toString() + " n�o podendo atualizar para Aprovado.");
		// orcamento.atualizarSituacao(new Aprovado());
	}

	public void reprovar(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situa��o atual �, " + orcamento.obterSituacao().toString() + " n�o podendo atualizar para Reprovado.");
		// orcamento.atualizarSituacao(new Reprovado());
	}

	public void finalizar(Orcamento orcamento) throws SituacaoDoOrcamentoException {
		throw new SituacaoDoOrcamentoException("A situa��o atual �, " + orcamento.obterSituacao().toString() + " n�o podendo atualizar para Finalizado.");
		// orcamento.atualizarSituacao(new Finalizado());
	}



}
