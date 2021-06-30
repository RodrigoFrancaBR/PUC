package br.com.puc.state;

public class Desligada extends State {

	Desligada(Impressora impressora) {
		super(impressora);
	}

	@Override
	void colocarTinta() {
		this.impressora.alterarEstadoDaImpressora(impressora.getPronta());
	}

	@Override
	void ligar() {
		this.impressora.alterarEstadoDaImpressora(impressora.getPronta());
	}

}
