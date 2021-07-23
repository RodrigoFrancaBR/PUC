package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

/**
 * 
 * @author Rodrigo Dado um orçamento posso dar descontos
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
		// porem eu não sei qual é o valor do desconto, no caso do imposto eu sei quais impostos existem
		/**
		 * Se esse Orçamento tiver um desconto válido aplique, logo preciso passar por todos os tipos de descontos
		 *  e validar se ele é aplicável ou não. E se não for aplicavel vai para o próximo desconto disponivel, 
		 *  até encontrar um tipo de desconto que é aplicavel.
		 */
		
		return null;
		
		

	}
}
