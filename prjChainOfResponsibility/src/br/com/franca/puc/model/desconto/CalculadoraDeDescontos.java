package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class CalculadoraDeDescontos {
	/*
	 * Requisitos 1 - Fornecer descontos baseado no número de itens do orcamento
	 * (acima de 5 aplicar 5%) 2 - Fornecer descontos baseado no valor do
	 * orcamento (acima de 500,00 aplicar 10%) 3 - Caso não seja elegível o
	 * primeiro desconto de 5% verificar se é elegivel o próximo desconto de
	 * 10%.
	 */
	public BigDecimal calcularDesconto(Orcamento orcamento) {

		/*
		 * BigDecimal valor = orcamento.obterValor();
		 * 
		 * int comparacao = valor.compareTo(new BigDecimal("500.0"));
		 * 
		 * if (orcamento.obterQuantidadeDeItens() > 5) { return
		 * valor.multiply(new BigDecimal("0.1")); }
		 * 
		 * if (comparacao > 0) { return valor.multiply(new BigDecimal("0.1")); }
		 * 
		 * return BigDecimal.ZERO;
		 */

		// e se o orcamento for maior que 500 e tiver mais de cinco itens qual
		// dos dois ifs deveria cair?
		// metodo poderia receber um orcamento e um desconto (interface)e
		// retornava o desconto.calcular(orcamento)
		// porem eu não sei qual é o valor do desconto, no caso do imposto eu
		// sei quais impostos existem

		/**
		 * Se esse Orçamento tiver um desconto válido aplique, logo preciso
		 * passar por todos os tipos de descontos e validar se ele é aplicável
		 * ou não. E se não for aplicavel vai para o próximo desconto
		 * disponivel, até encontrar um tipo de desconto que é aplicavel.
		 */

		// obtem o primeiro desconto
		BigDecimal desconto = new DescontoNoOrcamentoComMaisDeCincoItens().calcularDesconto(orcamento);

		// se não for elegivel
		if (desconto == BigDecimal.ZERO) {
			// busca o segundo
			desconto = new DescontoParaValoresAcimaDeQuinhetos().calcularDesconto(orcamento.obterValor());
			// se não for elegivel
			if (desconto == BigDecimal.ZERO) {
				// busca proximo desconto..
			} else {
				return desconto;
			}
		} else {
			return desconto;
		}

		return desconto;

	}
}
