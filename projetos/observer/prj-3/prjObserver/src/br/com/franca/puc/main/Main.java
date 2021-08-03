package br.com.franca.puc.main;

import br.com.franca.puc.model.observer.InteressadoNoEvento;
import br.com.franca.puc.model.observer.Morador;
import br.com.franca.puc.model.observer.Sindico;
import br.com.franca.puc.model.subject.Porteiro;

public class Main {
	public static void main(String[] args) {
		Porteiro porteiro = new Porteiro();
		
		InteressadoNoEvento mordorA = new Morador();
		InteressadoNoEvento mordorB = new Morador();
		InteressadoNoEvento sindico = new Sindico();
		
		porteiro.adicionaInteressadoNoEvento(mordorA);
		porteiro.adicionaInteressadoNoEvento(mordorB);
		porteiro.adicionaInteressadoNoEvento(sindico);
		
		porteiro.informarSobreOEvento("Evento carnavel dia 10-02-2020");
		
		
	}
}
