package br.com.puc.domain;

import java.util.ArrayList;
import java.util.List;

public class CasaComGaragemBuilder extends Builder{
	
	/*
	private List<Parede> paredes;
	private TipoDeTelhado tipoDeTelhado;
	private List<Porta> portas;
	private List<Janela> janelas;
	*/
	
	private Garagem garagem;
	
	public void buildParedes(int numeroDeParedes) {

		if (numeroDeParedes < 1) {
			throw new IllegalArgumentException("Numero de paredes " + "precisa ser maior que zero(0)");
		}

		List<Parede> paredes = new ArrayList<>();

		for (int i = 1; i <= numeroDeParedes; i++) {
			Parede parede = new Parede(i, "Preta", 5, 0.19f);
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
			Porta porta = new Porta(i, "Preta", TipoDePorta.SOLIDA, 0.82f, 2.10f);
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
			Janela janela = new Janela(2, 2, 2, 2, TipoDeJanela.PERSIANA_INTEGRADA);
			janelas.add(janela);
		}

		this.janelas = janelas;

	}

	public void buildTelhado() {
		this.tipoDeTelhado = TipoDeTelhado.MADEIRA;
	}
	
	public void buildGaragem() {
		this.garagem = new Garagem(2, 3.5f, 6.5f);
	}

	public CasaComGaragem buildCasa() {
		return new CasaComGaragem(paredes, tipoDeTelhado, portas, janelas, garagem);
	}

}
