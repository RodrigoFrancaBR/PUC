package br.com.puc.state;

public class Imprimindo extends State {

	public Imprimindo(Impressora impressora) {
		super(impressora);
	}

	@Override
	void imprimir() {
		System.err.println("Impressora imprimindo...");
		// lançar exception...
	}

	@Override
	void pausarImpressao() {
		this.impressora.alterarEstadoDaImpressora(impressora.getPausada());
	}

	@Override
	void cancelarImpressao() {
		this.impressora.alterarEstadoDaImpressora(impressora.getPronta());
	}

	@Override
	void colocarTinta() {
		System.err.println("Impressora imprimindo...");
		// lançar exception...
	}

	@Override
	void ligar() {
		System.err.println("Impressora imprimindo...");
		// lançar exception...
	}

	@Override
	void desligar() {
		System.err.println("Impressora imprimindo...");
		// lançar exception...
	}

}
