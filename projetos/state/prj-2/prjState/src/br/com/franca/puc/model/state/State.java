package br.com.franca.puc.model.state;

import br.com.franca.puc.model.state.exception.NaoPodeCancelarImpressaoException;
import br.com.franca.puc.model.state.exception.NaoPodeColocarTintaException;
import br.com.franca.puc.model.state.exception.NaoPodeDesligarException;
import br.com.franca.puc.model.state.exception.NaoPodeImprimirException;
import br.com.franca.puc.model.state.exception.NaoPodeLigarException;
import br.com.franca.puc.model.state.exception.NaoPodePausarException;

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
