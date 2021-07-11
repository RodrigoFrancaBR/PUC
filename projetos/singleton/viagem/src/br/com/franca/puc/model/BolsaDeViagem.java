package br.com.franca.puc.model;

import java.math.BigDecimal;

public class BolsaDeViagem {
	private static BolsaDeViagem bolsaDeViagem;
	private BigDecimal valorDaBolsa = new BigDecimal("500.0");

	private BolsaDeViagem() {
		System.out.println("Criando um objeto BolsaDeViagem");
	}

	public static BolsaDeViagem getInstance() {
		System.out.println("Iniciando o getInstance");
		if (bolsaDeViagem == null) {
			bolsaDeViagem = new BolsaDeViagem();
		}
		System.out.println("Encerrando o getInstance");
		return bolsaDeViagem;
	}

	public BigDecimal obterValorDaBolsa() {
		return valorDaBolsa;
	}

}
