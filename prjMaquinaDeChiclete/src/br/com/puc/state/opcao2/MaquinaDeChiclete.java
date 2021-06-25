package br.com.puc.state.opcao2;

public class MaquinaDeChiclete {

	private State vazia;
	private State SemMoeda;
	private State ComMoeda;
	private State ChicleteVendido;
	private State estadoAtual;

	public MaquinaDeChiclete() {
		this.vazia = new Vazia(this);
		SemMoeda = new SemMoeda(this);
		ComMoeda = new ComMoeda(this);
		ChicleteVendido = new ChicleteVendido(this);
		this.estadoAtual = this.vazia;
	}

	// obter estados

	public State getVazia() {
		return vazia;
	}

	public State getSemMoeda() {
		return SemMoeda;
	}

	public State getComMoeda() {
		return ComMoeda;
	}

	public State getChicleteVendido() {
		return ChicleteVendido;
	}

	public State getEstadoAtual() {
		return estadoAtual;
	}

	/**
	 * métodos de negócio
	 */

	public void recarregarMaquina() {
		System.out.println("Tentando recarregar a máquina com chiclete...");
		this.estadoAtual.recarregarMaquina();
	}

	public void inserirMoeda() {
		System.out.println("Tentando inserir moeda...");
		this.estadoAtual.inserirMoeda();
	}

	public void escolherChiclete() {
		System.out.println("Tentando escolher chiclete...");
		this.estadoAtual.escolherChiclete();
	}

	public void retirarChiclete() {
		System.out.println("Tentando retirar chiclete...");
		this.estadoAtual.retirarChiclete();
	}

	public void ejetarMoeda() {
		System.out.println("Tentando ejetar moeda...");
		this.estadoAtual.ejetarMoeda();
	}

	protected void alterarEstadoDaMaquina(State state) {
		this.estadoAtual = state;
	}

	public State obterEstadoAtualDaMaquina() {
		return this.estadoAtual;
	}

}
