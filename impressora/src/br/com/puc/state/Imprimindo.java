package br.com.puc.state;

import br.com.puc.state.exception.NaoPodeColocarTintaException;
import br.com.puc.state.exception.NaoPodeDesligarException;
import br.com.puc.state.exception.NaoPodeImprimirException;
import br.com.puc.state.exception.NaoPodeLigarException;

public class Imprimindo extends State {

	public Imprimindo(Impressora impressora) {
		super(impressora);
	}

	@Override
	void imprimir() throws NaoPodeImprimirException {
		throw new NaoPodeImprimirException("Impressora imprimindo");
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
	void colocarTinta() throws NaoPodeColocarTintaException {
		throw new NaoPodeColocarTintaException("Impressora imprimindo");
	}

	@Override
	void ligar() throws NaoPodeLigarException {
		throw new NaoPodeLigarException("Impressora imprimindo");
	}

	@Override
	void desligar() throws NaoPodeDesligarException {
		throw new NaoPodeDesligarException("Impressora imprimindo");
	}

}
