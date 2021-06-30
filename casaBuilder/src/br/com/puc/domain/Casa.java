package br.com.puc.domain;

import java.util.List;

public class Casa {
	protected List<Parede> paredes;
	protected List<Porta> portas;
	protected List<Janela> janelas;
	protected TipoDeTelhado tipoDeTelhado;

	public Casa() {
	}

	protected Casa(List<Parede> paredes, TipoDeTelhado tipoDeTelhado,
			List<Porta> portas, List<Janela> janelas) {
		
		this.tipoDeTelhado = tipoDeTelhado;
		this.paredes = paredes;
		this.portas = portas;
		this.janelas = janelas;
	}

	/**
	 * gets and sets
	 * 
	 */

	public List<Parede> getParedes() {
		return paredes;
	}

	public void setParedes(List<Parede> paredes) {
		this.paredes = paredes;
	}

	public TipoDeTelhado getTipoDeTelhado() {
		return tipoDeTelhado;
	}

	public void setTipoDeTelhado(TipoDeTelhado tipoDeTelhado) {
		this.tipoDeTelhado = tipoDeTelhado;
	}

	public List<Porta> getPortas() {
		return portas;
	}

	public void setPortas(List<Porta> portas) {
		this.portas = portas;
	}

	public List<Janela> getJanelas() {
		return janelas;
	}

	public void setJanelas(List<Janela> janelas) {
		this.janelas = janelas;
	}

	@Override
	public String toString() {
		return "Casa [paredes=" + paredes + ", tipoDeTelhado=" + tipoDeTelhado + ", portas=" + portas + ", janelas=" + janelas
				+ "]";
	}

}
