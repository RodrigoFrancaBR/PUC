package br.com.franca.puc.model.observer;

public class Sindico extends InteressadoNoEvento {

	@Override
	public void informarSobreOEvento(String informacaoDoEvento) {
		System.out.println("Sindico, faz algo quando � notificado do evento: " + informacaoDoEvento);
	}

}
