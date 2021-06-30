package br.com.puc.state.exception;

public class NaoPodePausarException extends Exception {
	private static final long serialVersionUID = -506908304116741052L;

	public NaoPodePausarException() {
	}

	public NaoPodePausarException(String msg) {
		super(msg);
	}

}
