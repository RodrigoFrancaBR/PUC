package br.com.puc.state.exception;

public class NaoPodeImprimirException extends Exception {
	private static final long serialVersionUID = 8694198445070090203L;
	
	public NaoPodeImprimirException() {
	}

	public NaoPodeImprimirException(String msg) {
		super(msg);
	}

}
