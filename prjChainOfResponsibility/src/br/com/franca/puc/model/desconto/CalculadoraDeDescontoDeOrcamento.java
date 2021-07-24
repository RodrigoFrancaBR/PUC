package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public class CalculadoraDeDescontoDeOrcamento {
	/*
	 * Requisitos 1 - Fornecer descontos baseado no número de itens do orcamento
	 * (acima de 5 aplicar 5%) 2 - Fornecer descontos baseado no valor do
	 * orcamento (acima de 500,00 aplicar 10%) 3 - Caso não seja elegível o
	 * primeiro desconto de 5% verificar se é elegivel o próximo desconto de
	 * 10%.
	 */
	public BigDecimal calcular(Orcamento orcamento) {

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

		/* E se o orcamento for maior que 500 e tiver mais de cinco itens qual dos dois ifs deveria cair?
		 * A calculadora de desconto poderia receber um orcamento e um Desconto (interface) 
		 * DescontoDeDezPorCento, descontoDeVintePorcento etc.. e ai cada Desconto faz o calculo baseado no valor do orcamento..
		 * Porem a calculadora de descontos não sabe qual o desconto vem do cliente (main) 
		 * A intenção é a calculadora receber um orcamento e aplicar descontos por qtdItens ou 
		 * valor de orcamento ou outros coisas
		 *
		 */ 
		
		/**
		 * Se esse Orçamento tiver um desconto válido aplique, logo preciso
		 * passar por todos os tipos de descontos e validar se ele é aplicável
		 * ou não. E se não for aplicavel vai para o próximo desconto
		 * disponivel, até encontrar um tipo de desconto que é aplicavel.
		 */

		// tentativa frustrada.. classe cresce muito e com muitos ifs.. nem da pra fazer switch para bigdecimal
		// obtem o primeiro desconto
		
		/*
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
	 */
		
		
		// todo desconto deve conhecer o próximo desconto, para quando o desconto principal não for atendido chama o próximo
		/*
			
		DescontoNoOrcamentoComMaisDeCincoItens desconto = 
				new DescontoNoOrcamentoComMaisDeCincoItens(
						new DescontoNoOrcamentoParaValoresAcimaDeQuinhetos(
								new DescontoZero()));
		return desconto.calcular(orcamento);*/
		
		
		DescontoNoOrcamentoParaValoresAcimaDeQuinhetos desconto = new DescontoNoOrcamentoParaValoresAcimaDeQuinhetos();

		return desconto.calcular(orcamento);
	}
	
}
