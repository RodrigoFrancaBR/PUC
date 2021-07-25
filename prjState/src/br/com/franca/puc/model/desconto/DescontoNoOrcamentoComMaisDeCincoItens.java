package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class DescontoNoOrcamentoComMaisDeCincoItens extends DescontoDoOrcamento{


	// quem define o próximo desconto é o proprio desconto e não o cliente  
	public DescontoNoOrcamentoComMaisDeCincoItens() {
		super(new DescontoNoOrcamentoParaValoresAcimaDeQuinhetos(new DescontoZero()));
	}
	
	
   // quem define o próximo desconto é o cliente e não o desconto   	  	 
	public DescontoNoOrcamentoComMaisDeCincoItens(DescontoDoOrcamento proximoDesconto) {
		super(proximoDesconto);
	}
	
/*
	public BigDecimal calcularDesconto(Orcamento orcamento) {
		// validar se o valor é valido?

		if (orcamento.obterQuantidadeDeItens() > 5) {
			return orcamento.obterValor().multiply(new BigDecimal("0.05"));
		}

		return BigDecimal.ZERO;

	}*/

	@Override
	public BigDecimal calcular(Orcamento orcamento) {
		// validar se o valor é valido?

		if (orcamento.obterQuantidadeDeItens() > 5) {
			return orcamento.obterValor().multiply(new BigDecimal("0.05"));
		}
		
		return this.proximoDesconto.calcular(orcamento);
	}
}
