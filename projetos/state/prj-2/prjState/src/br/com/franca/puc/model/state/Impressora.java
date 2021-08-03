package br.com.franca.puc.model.state;

import br.com.franca.puc.model.state.exception.NaoPodeCancelarImpressaoException;
import br.com.franca.puc.model.state.exception.NaoPodeColocarTintaException;
import br.com.franca.puc.model.state.exception.NaoPodeDesligarException;
import br.com.franca.puc.model.state.exception.NaoPodeImprimirException;
import br.com.franca.puc.model.state.exception.NaoPodeImprimirUltimaFolhaException;
import br.com.franca.puc.model.state.exception.NaoPodeLigarException;
import br.com.franca.puc.model.state.exception.NaoPodePausarException;

public class Impressora {
	private State desligada;
	private State pronta;
	private State semTinta;
	private State imprimindo;
	private State emPausa;
	private State estadoAtual;

	public Impressora() {
		this.desligada = new Desligada(this);
		this.pronta = new Pronta(this);
		this.semTinta = new SemTinta(this);
		this.imprimindo = new Imprimindo(this);
		this.emPausa = new EmPausa(this);
		this.estadoAtual = desligada;
	}

	protected void alterarEstadoDaImpressora(State state) {
		this.estadoAtual = state;
	}

	public State obterEstadoAtualDaImpressora() {
		return this.estadoAtual;
	}

	public void ligar() throws NaoPodeLigarException {
		System.out.println("Ligando impressora...");
		this.estadoAtual.ligar();
		System.out.println("Impressora ligada com sucesso...");
	}

	public void imprimir() throws NaoPodeImprimirException {
		System.out.println("Imprimindo...");
		this.estadoAtual.imprimir();
		System.out.println("imprimindo com sucesso!!");
	}

	public void pausarImpressao() throws NaoPodePausarException {
		System.out.println("Pausando impressão...");
		this.estadoAtual.pausarImpressao();
		System.out.println("Impressão em pausa com sucesso!!");
	}

	public void desligar() throws NaoPodeDesligarException {
		System.out.println("Desligando impressora...");
		this.estadoAtual.desligar();
		System.out.println("Impressora desligada com sucesso!!");
	}

	public void cancelarImpressao() throws NaoPodeCancelarImpressaoException {
		System.out.println("Cancelando a impressão...");
		this.estadoAtual.cancelarImpressao();
		System.out.println("Impressão cancelada com sucesso!!");
	}

	public void imprimirUltimaFolha() throws NaoPodeImprimirUltimaFolhaException {
		System.out.println("Imprimindo ultima folha...");

		try {
			this.estadoAtual.imprimir();
			System.out.println("Ultima folha impressa com sucesso!!");
			this.alterarEstadoDaImpressora(getSemTinta());
			System.out.println("Impressora sem tinta com suecsso!!");
		} catch (NaoPodeImprimirException ex) {
			ex.printStackTrace();
			throw new NaoPodeImprimirUltimaFolhaException(ex);
		}

	}

	public void terminarImpressao() {
		System.out.println("terminando de imprimir...");
		this.alterarEstadoDaImpressora(getPronta()); // estado atual imprimindo
		System.out.println("Impressora pronta para imprimir com sucesso!!");
	}

	public void colocarTinta() throws NaoPodeColocarTintaException {
		System.out.println("Colocando tinta na impressora...");
		this.estadoAtual.colocarTinta();
		System.out.println("Tinta colocada com sucesso na impressora!!");

	}

	/**
	 * gets dos estados
	 * 
	 * @return
	 */

	public State getEmPausa() {
		return emPausa;
	}

	public State getDesligada() {
		return desligada;
	}

	public State getPronta() {
		return pronta;
	}

	public State getSemTinta() {
		return semTinta;
	}

	public State getImprimindo() {
		return imprimindo;
	}

	public State getPausada() {
		return emPausa;
	}

	public State getEstadoAtual() {
		return estadoAtual;
	}

}
