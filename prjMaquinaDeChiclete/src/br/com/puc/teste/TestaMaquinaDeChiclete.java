package br.com.puc.teste;

import br.com.puc.state.opcao1.MaquinaDeChiclete;

public class TestaMaquinaDeChiclete {

	public static void main(String[] args) {

		MaquinaDeChiclete maquina = new MaquinaDeChiclete();

		// passo 1
		maquina.recarregarMaquina();

		// passo 2
		maquina.inserirMoeda();

		// passo 3
		maquina.escolherChiclete();

		// alternativo ao 3
		maquina.ejetarMoeda();

		// passo 4 se o alternativo não for executado
		maquina.retirarChiclete();
	}

}
