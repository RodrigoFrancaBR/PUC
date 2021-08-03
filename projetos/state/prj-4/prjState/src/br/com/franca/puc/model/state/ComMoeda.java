package br.com.franca.puc.model.state;

public class ComMoeda implements State {

	private MaquinaDeChiclete maquinaDeChiclete;

	public ComMoeda(MaquinaDeChiclete maquinaDeChiclete) {
		this.maquinaDeChiclete = (maquinaDeChiclete);
	}

	@Override
	public void recarregarMaquina() {
		System.out.println("Favor escolher um chiclete ou ejetar a moeda.");
	}

	@Override
	public void inserirMoeda() {
		System.out.println("Favor escolher um chiclete ou ejetar a moeda.");
	}

	@Override
	public void escolherChiclete() {
		System.out.println("Escolhendo chiclete.");
		this.maquinaDeChiclete.alterarEstadoDaMaquina(maquinaDeChiclete.getChicleteVendido());
		System.out.println("Chiclete escolhido com sucesso.");

	}

	@Override
	public void retirarChiclete() {
		System.out.println("Favor escolher um chiclete ou ejetar a moeda.");
	}

	@Override
	public void ejetarMoeda() {
		System.out.println("Ejetando moeda.");
		this.maquinaDeChiclete.alterarEstadoDaMaquina(maquinaDeChiclete.getSemMoeda());
		System.out.println("Moeda ejetada com sucesso.");
	}

}
