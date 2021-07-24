package br.com.franca.puc.main;

import java.math.BigDecimal;

import br.com.franca.puc.model.desconto.CalculadoraDeDescontos;
import br.com.franca.puc.model.orcamento.Orcamento;

public class CalcularDescontos {

	public static void main(String[] args) {
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();

		BigDecimal desconto = calculadora.calcularDesconto(new Orcamento(new BigDecimal("200"), 6)); // 10.00
		System.out.println(desconto);

		BigDecimal desconto2 = calculadora.calcularDesconto(new Orcamento(new BigDecimal("200"), 4)); // zero
		System.out.println(desconto2);

		BigDecimal desconto3 = calculadora.calcularDesconto(new Orcamento(new BigDecimal("600"), 1)); // 10%
		System.out.println(desconto3);

	}

}
