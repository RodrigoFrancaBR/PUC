package br.com.puc.state.opcao1;

public class ChicleteVendido extends State {

	public ChicleteVendido(MaquinaDeChiclete maquinaDeChiclete) {
		super(maquinaDeChiclete);
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
		this.maquinaDeChiclete.alterarEstadoDaMaquina(new SemMoeda(maquinaDeChiclete));
		System.out.println("Chiclete retirado com sucesso.");
	}

	@Override
	public void ejetarMoeda() {
		System.out.println("Favor retirar o chiclete vendido.");
	}

}
