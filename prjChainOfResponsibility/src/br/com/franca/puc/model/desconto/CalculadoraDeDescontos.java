package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class CalculadoraDeDescontos {
	/*
	 * Requisitos 1 - Fornecer descontos baseado no n�mero de itens do orcamento
	 * (acima de 5 aplicar 5%) 2 - Fornecer descontos baseado no valor do
	 * orcamento (acima de 500,00 aplicar 10%) 3 - Caso n�o seja eleg�vel o
	 * primeiro desconto de 5% verificar se � elegivel o pr�ximo desconto de
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
		// porem eu n�o sei qual � o valor do desconto, no caso do imposto eu
		// sei quais impostos existem

		/**
		 * Se esse Or�amento tiver um desconto v�lido aplique, logo preciso
		 * passar por todos os tipos de descontos e validar se ele � aplic�vel
		 * ou n�o. E se n�o for aplicavel vai para o pr�ximo desconto
		 * disponivel, at� encontrar um tipo de desconto que � aplicavel.
		 */

		// obtem o primeiro desconto
		BigDecimal desconto = new DescontoNoOrcamentoComMaisDeCincoItens().calcularDesconto(orcamento);

		// se n�o for elegivel
		if (desconto == BigDecimal.ZERO) {
			// busca o segundo
			desconto = new DescontoParaValoresAcimaDeQuinhetos().calcularDesconto(orcamento.obterValor());
			// se n�o for elegivel
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
