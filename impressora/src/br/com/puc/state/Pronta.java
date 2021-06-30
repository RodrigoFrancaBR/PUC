package br.com.puc.state;

public class Pronta extends State {

	public Pronta(Impressora impressora) {
		super(impressora);
	}

	@Override
	void imprimir() {
		this.impressora.alterarEstadoDaImpressora(impressora.getImprimindo());
	}

	@Override
	void pausarImpressao() {
		System.err.println("Impressora pronta...");
		// lançar exception...
	}

	@Override
	void cancelarImpressao() {
		System.err.println("Impressora pronta...");
		// lançar exception...
	}

	@Override
	void colocarTinta() {
		System.err.println("Impressora pronta...");
		// lançar exception...
	}

	@Override
	void ligar() {
		System.err.println("Impressora pronta...");
		// lançar exception...
	}

	@Override
	void desligar() {
		this.impressora.alterarEstadoDaImpressora(impressora.getDesligada());
	}

}
