package br.com.puc.state;

public class SemTinta extends State {

	public SemTinta(Impressora impressora) {
		super(impressora);
	}

	@Override
	void imprimir() {
		System.err.println("Impressora sem tinta...");
		// lançar exception...
	}

	@Override
	void pausarImpressao() {
		System.err.println("Impressora sem tinta...");
		// lançar exception...
	}

	@Override
	void cancelarImpressao() {
		System.err.println("Impressora sem tinta...");
		// lançar exception...
	}

	@Override
	void colocarTinta() {
		this.impressora.alterarEstadoDaImpressora(impressora.getPronta());
	}

	@Override
	void ligar() {
		System.err.println("Impressora sem tinta...");
		// lançar exception...
	}

	@Override
	void desligar() {
		this.impressora.alterarEstadoDaImpressora(impressora.getDesligada());
	}

}
