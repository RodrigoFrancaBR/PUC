package br.com.puc.domain;

import java.util.ArrayList;
import java.util.List;

public class CasaComPiscinaBuilder extends Builder {
	private Piscina piscina;

	public void buildParedes(int numeroDeParedes) {

		if (numeroDeParedes < 1) {
			throw new IllegalArgumentException("Numero de paredes " + "precisa ser maior que zero(0)");
		}

		List<Parede> paredes = new ArrayList<>();

		for (int i = 1; i <= numeroDeParedes; i++) {
			Parede parede = new Parede(i, "Azul", 6, 0.22f);
			paredes.add(parede);
		}

		this.paredes = paredes;

	}

	public void buildPortas(int numeroDePortas) {
		if (numeroDePortas < 1) {
			throw new IllegalArgumentException("Numero de portas " + "precisa ser maior que zero (0)");
		}

		List<Porta> portas = new ArrayList<>();

		for (int i = 1; i <= numeroDePortas; i++) {
			Porta porta = new Porta(i, "Azul", TipoDePorta.SARRAFEADA, 0.90f, 1.59f);
			portas.add(porta);
		}

		this.portas = portas;

	}

	public void buildJanelas(int numeroDeJanelas) {

		if (numeroDeJanelas < 1) {
			throw new IllegalArgumentException("Numero de janelas " + "precisa ser maior que zero (0)");
		}

		List<Janela> janelas = new ArrayList<>();

		for (int i = 1; i <= numeroDeJanelas; i++) {
			Janela janela = new Janela(4, 2, 2, 2, TipoDeJanela.RETRATIL);
			janelas.add(janela);
		}

		this.janelas = janelas;

	}

	public void buildTelhado() {
		this.tipoDeTelhado = TipoDeTelhado.VIDRO;
	}

	public void buildPiscina() {
		this.piscina = new Piscina(3, 1.80f, 0.80f);
	}

	public CasaComPiscina buildCasa() {
		return new CasaComPiscina(paredes, tipoDeTelhado, portas, janelas, piscina);
	}

}
