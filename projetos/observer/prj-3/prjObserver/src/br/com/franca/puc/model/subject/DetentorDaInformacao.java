package br.com.franca.puc.model.subject;

import java.util.ArrayList;
import java.util.List;

import br.com.franca.puc.model.observer.InteressadoNoEvento;

public abstract class DetentorDaInformacao {
	// pode ser um objeto evento com varias informacoes sobre o evento
	protected String informacaoDoEvento;

	protected List<InteressadoNoEvento> listaDeInteressadosNoEvento = new ArrayList<>();

	public void adicionaInteressadoNoEvento(InteressadoNoEvento interessado) {
		this.listaDeInteressadosNoEvento.add(interessado);
	}

	public void removeInteressadoNoEvento(InteressadoNoEvento interessado) {
		this.listaDeInteressadosNoEvento.remove(interessado);
	}

	protected void notificarInteressadosSobreOEvento() {
		// posso passar o evento para o observador
		// ou posso apenas informar o observador e ele faz o que tem que fazer
		// sem precisar passar informacoes sobre o event ele não precisa
		// conhecer o event
		this.listaDeInteressadosNoEvento
				.forEach(interessado -> interessado.informarSobreOEvento(this.informacaoDoEvento));
	}

}
