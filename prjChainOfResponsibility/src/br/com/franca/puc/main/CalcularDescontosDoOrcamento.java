package br.com.franca.puc.main;

import java.math.BigDecimal;

import br.com.franca.puc.model.desconto.CalculadoraDeDescontoDeOrcamento;
import br.com.franca.puc.model.orcamento.Orcamento;

public class CalcularDescontosDoOrcamento {

	public static void main(String[] args) {
		
		CalculadoraDeDescontoDeOrcamento calculadora = new CalculadoraDeDescontoDeOrcamento();

		BigDecimal desconto = calculadora.calcular(new Orcamento(new BigDecimal("200"), 6)); // 10.00
		System.out.println(desconto);

		BigDecimal desconto2 = calculadora.calcular(new Orcamento(new BigDecimal("200"), 4)); // zero
		System.out.println(desconto2);

		BigDecimal desconto3 = calculadora.calcular(new Orcamento(new BigDecimal("600"), 1)); // 10%
		System.out.println(desconto3);		

	}

}
