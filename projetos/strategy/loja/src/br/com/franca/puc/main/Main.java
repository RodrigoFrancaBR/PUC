package br.com.franca.puc.main;

import java.math.BigDecimal;

import br.com.franca.puc.model.imposto.TipoDeImposto;
import br.com.franca.puc.model.orcamento.CalculadoraDeImpostos;
import br.com.franca.puc.model.orcamento.Orcamento;

public class Main {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(new BigDecimal("100.0"));
		CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();
		// ((1000 * 10) / 100) = 100  -- 1000 * 0.10 = 100 
		BigDecimal calculoDoImpostoICMS = calculadoraDeImpostos.calcularImposto(orcamento, TipoDeImposto.ICMS);
		
		// ((1000 * 6) / 100) = 60  -- 1000 * 0.6 = 100
		BigDecimal calculoDoImpostoISS = calculadoraDeImpostos.calcularImposto(orcamento, TipoDeImposto.ISS);
		
		System.out.println("calculoDoImpostoICMS: " + calculoDoImpostoICMS);
		System.out.println("calculoDoImpostoISS: " + calculoDoImpostoISS);

	}

}
