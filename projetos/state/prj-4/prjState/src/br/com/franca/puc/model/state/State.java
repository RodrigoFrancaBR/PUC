package br.com.franca.puc.model.state;

public interface State {

	void recarregarMaquina();

	void inserirMoeda();

	void escolherChiclete();

	void retirarChiclete();

	void ejetarMoeda();
}
