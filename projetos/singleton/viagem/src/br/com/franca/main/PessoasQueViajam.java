package br.com.franca.main;

import java.math.BigDecimal;

import br.com.franca.puc.model.BolsaDeViagem;
import br.com.franca.puc.model.Pessoa;

public class PessoasQueViajam {

	public static void main(String[] args) {

		BolsaDeViagem bolsaDeViagemRodrigo = BolsaDeViagem.getInstance();
		BigDecimal valorDaBolsaRodrigo = bolsaDeViagemRodrigo.obterValorDaBolsa();

		Pessoa p1 = new Pessoa();
		p1.setId(1);
		p1.setNome("Rodrigo França");

		PessoasQueViajam.viajar(p1, valorDaBolsaRodrigo);

		Pessoa p2 = new Pessoa();
		p2.setId(2);
		p2.setNome("Bruna França");
		BolsaDeViagem bolsaDeViagemBruna = BolsaDeViagem.getInstance();
		BigDecimal valorDaBolsaDeViagemBruna = bolsaDeViagemBruna.obterValorDaBolsa();

		PessoasQueViajam.viajar(p2, valorDaBolsaDeViagemBruna);

	}

	public static void viajar(Pessoa pessoa, BigDecimal valorDaBolsa) {
		System.out.println("Pessoa: " + pessoa + ", está viajando com uma bolsa de, " + valorDaBolsa + " de desconto.");
	}
}
