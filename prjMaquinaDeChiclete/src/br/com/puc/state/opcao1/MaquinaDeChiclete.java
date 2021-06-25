package br.com.puc.state.opcao1;

public class MaquinaDeChiclete {
	private State state;

	public MaquinaDeChiclete() {
		this.state = new Vazia(this);
	}

	public void recarregarMaquina() {
		System.out.println("Tentando recarregar a máquina com chiclete...");
		this.state.recarregarMaquina();
	}

	public void inserirMoeda() {
		System.out.println("Tentando inserir moeda...");
		this.state.inserirMoeda();
	}

	public void escolherChiclete() {
		System.out.println("Tentando escolher chiclete...");
		this.state.escolherChiclete();
	}

	public void retirarChiclete() {
		System.out.println("Tentando retirar chiclete...");
		this.state.retirarChiclete();
	}

	public void ejetarMoeda() {
		System.out.println("Tentando ejetar moeda...");
		this.state.ejetarMoeda();
	}

	protected void alterarEstadoDaMaquina(State state) {
		this.state = state;
	}

	public State obterEstadoAtualDaMaquina() {
		return this.state;
	}

}
