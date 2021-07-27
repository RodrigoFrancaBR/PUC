package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Aprovado extends SituacaoDoOrcamento {

	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.obterValor().multiply(new BigDecimal("0.02"));
	}
	
	public void finalizar(Orcamento orcamento){
		orcamento.atualizarSituacao(new Finalizado());
	}
	
	@Override
	public String toString() {
		return "Aprovado";
	}
		
}
