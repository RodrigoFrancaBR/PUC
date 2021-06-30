package br.com.puc.domain;

import java.util.List;

public class CasaComPiscina extends Casa {

	private Piscina piscina;

	protected CasaComPiscina(List<Parede> paredes, 
			TipoDeTelhado tipoDeTelhado, List<Porta> portas,
			List<Janela> janelas, Piscina piscina) {
		super(paredes, tipoDeTelhado, portas, janelas);
		this.piscina = piscina;
	}

	public CasaComPiscina(Piscina piscina) {
		this.piscina = piscina;
	}

	public Piscina getPiscina() {
		return piscina;
	}

	public void setPiscina(Piscina piscina) {
		this.piscina = piscina;
	}

	@Override
	public String toString() {
		return "CasaComPiscina [paredes=" + this.paredes + 
				", tipoDeTelhado=" + this.tipoDeTelhado +
				", portas=" + this.portas + ", janelas=" +
				this.janelas + ", piscina=" + this.piscina + "]";
	}
	

}
