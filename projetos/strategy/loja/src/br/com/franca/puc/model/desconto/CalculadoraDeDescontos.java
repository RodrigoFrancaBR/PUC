package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

/**
 * 
 * @author Rodrigo Dado um or�amento posso dar descontos
 */
public class CalculadoraDeDescontos {

	public BigDecimal calcularDesconto(Orcamento orcamento) {
		/*
		BigDecimal valor = orcamento.obterValor();

		int comparacao = valor.compareTo(new BigDecimal("500.0"));

		if (orcamento.obterQuantidadeDeItens() > 5) {
			return valor.multiply(new BigDecimal("0.1"));
		}

		if (comparacao > 0) {
			return valor.multiply(new BigDecimal("0.1"));
		}

		return BigDecimal.ZERO;*/
		// metodo poderia receber um orcamento e um desconto (interface)e retornava o desconto.calcular(orcamento)
		// porem eu n�o sei qual � o valor do desconto, no caso do imposto eu sei quais impostos existem
		/**
		 * Se esse Or�amento tiver um desconto v�lido aplique, logo preciso passar por todos os tipos de descontos
		 *  e validar se ele � aplic�vel ou n�o. E se n�o for aplicavel vai para o pr�ximo desconto disponivel, 
		 *  at� encontrar um tipo de desconto que � aplicavel.
		 */
		
		return null;
		
		

	}
}
