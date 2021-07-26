package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Aprovado extends SituacaoDoOrcamento {

	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.obterValor().multiply(new BigDecimal("0.02"));
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new RuntimeException("ERRO");
	}

	public void reprovar(Orcamento orcamento) {
		throw new RuntimeException("ERRO");
	}
	
	public void finalizar(Orcamento orcamento){
		orcamento.atualizarSituacao(new Finalizado());
	}
	
	public void emAnalise(Orcamento orcamento){
		throw new RuntimeException("ERRO");
	}

}
