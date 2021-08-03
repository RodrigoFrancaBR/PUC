package br.com.franca.puc.model.state;

public class Vazia extends State {

	public Vazia(MaquinaDeChiclete maquinaDeChiclete) {
		super(maquinaDeChiclete);
	}

	@Override
	public void inserirMoeda() {
		System.out.println("Favor recarregar a máquina.");
	}

	@Override
	public void ejetarMoeda() {
		System.out.println("Favor recarregar a máquina.");
	}

	@Override
	public void escolherChiclete() {
		System.out.println("Favor recarregar a máquina.");

	}

	@Override
	public void retirarChiclete() {
		System.out.println("Favor recarregar a máquina.");
	}

	@Override
	public void recarregarMaquina() {
		System.out.println("Recarregando máquina com chiclete.");
		this.maquinaDeChiclete.alterarEstadoDaMaquina(maquinaDeChiclete.getSemMoeda());
		System.out.println("Máquina Recarregada com chiclete.");
	}

}
