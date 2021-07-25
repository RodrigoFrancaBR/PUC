package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class DescontoNoOrcamentoParaValoresAcimaDeQuinhetos extends DescontoDoOrcamento{

	// quem define o próximo desconto é o proprio desconto e não o cliente
	public DescontoNoOrcamentoParaValoresAcimaDeQuinhetos() {
		super(new DescontoNoOrcamentoComMaisDeCincoItens(new DescontoZero()));
	}
	
	// quem define o próximo desconto é o cliente e não o desconto
	public DescontoNoOrcamentoParaValoresAcimaDeQuinhetos(DescontoDoOrcamento proximoDesconto) {
		super(proximoDesconto);
	}
	
	
/*
	public BigDecimal calcularDesconto(BigDecimal valor) {
		// validar se o valor é valido?
		int compare = valor.compareTo(new BigDecimal("500"));

		if (compare == 1) {
			return valor.multiply(new BigDecimal("0.1"));
		}

		return BigDecimal.ZERO;

	}*/

	@Override
	public BigDecimal calcular(Orcamento orcamento) {
		// validar se o valor é valido?
		int compare = orcamento.obterValor().compareTo(new BigDecimal("500"));

		if (compare == 1) {
			return orcamento.obterValor().multiply(new BigDecimal("0.1"));
		}

		return this.proximoDesconto.calcular(orcamento);
	}
}
