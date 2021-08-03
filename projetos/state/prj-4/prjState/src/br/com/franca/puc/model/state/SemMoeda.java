package br.com.franca.puc.model.state;

public class SemMoeda implements State {

	private MaquinaDeChiclete maquinaDeChiclete;

	public SemMoeda(MaquinaDeChiclete maquinaDeChiclete) {
		this.maquinaDeChiclete = maquinaDeChiclete;
	}

	@Override
	public void recarregarMaquina() {
		System.out.println("Favor inserir uma moeda.");
	}

	@Override
	public void inserirMoeda() {
		System.out.println("Inserindo moeda...");
		this.maquinaDeChiclete.alterarEstadoDaMaquina(maquinaDeChiclete.getComMoeda());
		System.out.println("Máquina com Moeda.");
	}

	@Override
	public void escolherChiclete() {
		System.out.println("Favor inserir uma moeda.");
	}

	@Override
	public void retirarChiclete() {
		System.out.println("Favor inserir uma moeda.");
	}

	@Override
	public void ejetarMoeda() {
		System.out.println("Favor inserir uma moeda.");
	}

}
