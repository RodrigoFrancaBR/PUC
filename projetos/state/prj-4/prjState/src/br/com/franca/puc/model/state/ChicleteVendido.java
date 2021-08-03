package br.com.franca.puc.model.state;

public class ChicleteVendido implements State {

	private MaquinaDeChiclete maquinaDeChiclete;

	public ChicleteVendido(MaquinaDeChiclete maquinaDeChiclete) {
		this.maquinaDeChiclete = maquinaDeChiclete;
	}

	@Override
	public void recarregarMaquina() {
		System.out.println("Favor retirar o chiclete vendido.");
	}

	@Override
	public void inserirMoeda() {
		// futuramente pode ser possível inserir moedas com chicletes vendidos..
		System.out.println("Favor retirar o chiclete vendido.");
	}

	@Override
	public void escolherChiclete() {
		System.out.println("Favor retirar o chiclete vendido.");
	}

	@Override
	public void retirarChiclete() {
		System.out.println("Retirando chiclete vendido.");
		this.maquinaDeChiclete.alterarEstadoDaMaquina(maquinaDeChiclete.getSemMoeda());
		System.out.println("Chiclete retirado com sucesso.");
	}

	@Override
	public void ejetarMoeda() {
		System.out.println("Favor retirar o chiclete vendido.");
	}

}
