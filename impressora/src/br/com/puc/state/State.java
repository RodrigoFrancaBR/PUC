package br.com.puc.state;

import br.com.puc.state.exception.NaoPodeCancelarImpressaoException;
import br.com.puc.state.exception.NaoPodeColocarTintaException;
import br.com.puc.state.exception.NaoPodeDesligarException;
import br.com.puc.state.exception.NaoPodeImprimirException;
import br.com.puc.state.exception.NaoPodeLigarException;
import br.com.puc.state.exception.NaoPodePausarException;

public abstract class State {
	protected Impressora impressora;

	public State(Impressora impressora) {
		this.impressora = impressora;
	}

	void imprimir() throws NaoPodeImprimirException {
		throw new NaoPodeImprimirException(
				"Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString() + " n�o permite imprimir");
	}

	void pausarImpressao() throws NaoPodePausarException {
		throw new NaoPodePausarException("Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString()
				+ " n�o permite pausar impress�o");
	}

	void cancelarImpressao() throws NaoPodeCancelarImpressaoException {
		throw new NaoPodeCancelarImpressaoException("Estado atual, "
				+ impressora.obterEstadoAtualDaImpressora().toString() + " n�o permite cancelar impress�o");
	}

	void colocarTinta() throws NaoPodeColocarTintaException {
		throw new NaoPodeColocarTintaException(
				"Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString() + " n�o permite colocar tinta");
	}

	void ligar() throws NaoPodeLigarException {
		throw new NaoPodeLigarException("Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString()
				+ " n�o permite ligar impressora");
	}

	void desligar() throws NaoPodeDesligarException {
		throw new NaoPodeDesligarException("Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString()
				+ " n�o permite desligar impressora");
	}
}
