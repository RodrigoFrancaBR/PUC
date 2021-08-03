package br.com.franca.puc.model.subject;

public class Porteiro extends DetentorDaInformacao {

	// metodo que muda o estado do seu objeto
	public void informarSobreOEvento(String informacaoDoEvento) {
		this.informacaoDoEvento = informacaoDoEvento;
		notificarInteressadosSobreOEvento();
	}

}
