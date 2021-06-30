package br.com.puc.domain;

import java.util.ArrayList;
import java.util.List;

public class CasaBuilder extends Builder{
	/*
	private List<Parede> paredes;
	private TipoDeTelhado tipoDeTelhado;
	private List<Porta> portas;
	private List<Janela> janelas;
*/
	public void buildParedes(int numeroDeParedes) {

		if (numeroDeParedes < 1) {
			throw new IllegalArgumentException("Numero de paredes " + "precisa ser maior que zero(0)");
		}

		List<Parede> paredes = new ArrayList<>();

		for (int i = 1; i <= numeroDeParedes; i++) {
			Parede parede = new Parede(i, "Branca", 3, 0.15f);
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
			Porta porta = new Porta(i, "Amarela", TipoDePorta.MACIÇA, 0.82f, 2.10f);
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
			Janela janela = new Janela(1.20f, 1.20f, 2, 2, TipoDeJanela.CORRER);
			janelas.add(janela);
		}

		this.janelas = janelas;

	}

	public void buildTelhado() {
		this.tipoDeTelhado = TipoDeTelhado.CERAMICA;
	}

	public Casa buildCasa() {
		return new Casa(paredes, tipoDeTelhado, portas, janelas);
	}

}
