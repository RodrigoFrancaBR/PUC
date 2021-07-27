package br.com.franca.puc.model.orcamento;

public class Reprovado extends SituacaoDoOrcamento {	
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.atualizarSituacao(new Finalizado());
	}

}
