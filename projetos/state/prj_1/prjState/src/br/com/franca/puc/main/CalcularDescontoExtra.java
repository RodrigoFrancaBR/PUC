package br.com.franca.puc.main;

import java.math.BigDecimal;

import br.com.franca.puc.model.desconto.CalculadoraDeDescontoExtra;
import br.com.franca.puc.model.orcamento.Orcamento;

public class CalcularDescontoExtra {
	public static void main(String[] args) {

		Orcamento orcamento1 = new Orcamento(new BigDecimal("200"), 6);
		Orcamento orcamento2 = new Orcamento(new BigDecimal("200"), 4);
		Orcamento orcamento3 = new Orcamento(new BigDecimal("600"), 1);
		
		CalculadoraDeDescontoExtra calcExtra = new CalculadoraDeDescontoExtra();
		
		BigDecimal orcamentoComDesconto = calcExtra.calcular(orcamento1);
		System.out.println("################: " + orcamentoComDesconto);
		System.out.println(orcamento1.obterSituacao());
		orcamento1.aprovar();
		System.out.println(orcamento1.obterSituacao());
		
		BigDecimal resultado2 = calcExtra.calcular(orcamento2);
		System.out.println("################: " + resultado2);
		
		BigDecimal resultado3 = calcExtra.calcular(orcamento3);
		System.out.println("################: " + resultado3);				
		
	}
}
