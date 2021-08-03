package br.com.franca.puc.model.observer;

public class Morador extends InteressadoNoEvento {

	@Override
	public void informarSobreOEvento(String informacaoDoEvento) {
		System.out.println("Morador faz algo com a informação: " + informacaoDoEvento);
	}

}
