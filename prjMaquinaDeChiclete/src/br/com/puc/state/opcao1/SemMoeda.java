package br.com.puc.state.opcao1;

public class SemMoeda extends State {

	public SemMoeda(MaquinaDeChiclete maquinaDeChiclete) {
		super(maquinaDeChiclete);
	}

	@Override
	public void recarregarMaquina() {
		System.out.println("Favor inserir uma moeda.");
	}

	@Override
	public void inserirMoeda() {
		System.out.println("Inserindo moeda...");
		this.maquinaDeChiclete.alterarEstadoDaMaquina(new ComMoeda(maquinaDeChiclete));
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
