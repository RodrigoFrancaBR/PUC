package br.com.franca.puc.model.state.exception;

public class NaoPodeImprimirUltimaFolhaException extends Exception {
	private static final long serialVersionUID = 5719429173487995199L;

	public NaoPodeImprimirUltimaFolhaException(String msg) {
		super(msg);
	}

	public NaoPodeImprimirUltimaFolhaException(Exception ex) {
		super(ex);
	}

}
