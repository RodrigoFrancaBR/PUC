package br.com.puc.state;

public class EmPausa extends State {

	EmPausa(Impressora impressora) {
		super(impressora);
	}

	@Override
	void imprimir() {
		this.impressora.alterarEstadoDaImpressora(impressora.getImprimindo());
	}

	@Override
	void pausarImpressao() {
		System.err.println("Impressora em pausa...");
		// lançar exception...
	}

	@Override
	void cancelarImpressao() {
		this.impressora.alterarEstadoDaImpressora(impressora.getPronta());
	}

	@Override
	void colocarTinta() {
		this.impressora.alterarEstadoDaImpressora(impressora.getPronta());
	}

	@Override
	void ligar() {
		System.err.println("Impressora em pausa...");
		// lançar exception...
	}

	@Override
	void desligar() {
		this.impressora.alterarEstadoDaImpressora(impressora.getDesligada());
	}

}
