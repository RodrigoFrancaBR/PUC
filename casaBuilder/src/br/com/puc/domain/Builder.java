package br.com.puc.domain;

import java.util.List;

public abstract class Builder {

	protected List<Parede> paredes;
	protected TipoDeTelhado tipoDeTelhado;
	protected List<Porta> portas;
	protected List<Janela> janelas;

	public abstract void buildParedes(int numeroDeParedes);

	public abstract void buildPortas(int numeroDePortas);

	public abstract void buildJanelas(int numeroDeJanelas);

	public abstract void buildTelhado();
	
	public abstract Casa buildCasa();
}
