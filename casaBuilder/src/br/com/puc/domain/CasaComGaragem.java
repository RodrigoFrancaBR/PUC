package br.com.puc.domain;

import java.util.List;

public class CasaComGaragem extends Casa {
	private Garagem garagem;

	public CasaComGaragem() {
	}

	public CasaComGaragem(Garagem garagem) {
		this.garagem = garagem;
	}

	protected CasaComGaragem(List<Parede> paredes,
			TipoDeTelhado tipoDeTelhado, List<Porta> portas,
			List<Janela> janelas, Garagem garagem) {
		super(paredes, tipoDeTelhado, portas, janelas);
		this.garagem = garagem;
	}

	public Garagem getGaragem() {
		return garagem;
	}

	public void setGaragem(Garagem garagem) {
		this.garagem = garagem;
	}

	@Override
	public String toString() {
		return "CasaComGaragem [paredes=" + this.paredes + 
				", tipoDeTelhado=" + this.tipoDeTelhado + 
				", portas=" + this.portas + ", janelas=" +
				this.janelas + ", piscina=" + this.garagem + "]";
	}

}
