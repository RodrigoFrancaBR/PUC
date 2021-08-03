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
				"Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString() + " não permite imprimir");
	}

	void pausarImpressao() throws NaoPodePausarException {
		throw new NaoPodePausarException("Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString()
				+ " não permite pausar impressão");
	}

	void cancelarImpressao() throws NaoPodeCancelarImpressaoException {
		throw new NaoPodeCancelarImpressaoException("Estado atual, "
				+ impressora.obterEstadoAtualDaImpressora().toString() + " não permite cancelar impressão");
	}

	void colocarTinta() throws NaoPodeColocarTintaException {
		throw new NaoPodeColocarTintaException(
				"Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString() + " não permite colocar tinta");
	}

	void ligar() throws NaoPodeLigarException {
		throw new NaoPodeLigarException("Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString()
				+ " não permite ligar impressora");
	}

	void desligar() throws NaoPodeDesligarException {
		throw new NaoPodeDesligarException("Estado atual, " + impressora.obterEstadoAtualDaImpressora().toString()
				+ " não permite desligar impressora");
	}
}
