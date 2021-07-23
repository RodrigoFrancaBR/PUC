package br.com.puc.state.opcao1;

public abstract class State {

	MaquinaDeChiclete maquinaDeChiclete;

	public State(MaquinaDeChiclete maquinaDeChiclete) {
		this.maquinaDeChiclete = maquinaDeChiclete;
	}

	public abstract void recarregarMaquina();

	public abstract void inserirMoeda();

	public abstract void escolherChiclete();

	public abstract void retirarChiclete();

	public abstract void ejetarMoeda();

}