package br.com.franca.facade;

import java.math.BigDecimal;

import br.com.franca.puc.model.banco.Banco;
import br.com.franca.puc.model.cliente.Cliente;
import br.com.franca.puc.model.credito.Credito;
import br.com.franca.puc.model.emprestimo.Emprestimo;

public class Facade {
	private Banco banco;
	private Emprestimo emprestimo;
	private Credito credito;

	public Facade() {
		banco = new Banco();
		emprestimo = new Emprestimo();
		credito = new Credito();
	}

	public boolean podeRealizarEmprestimo(Cliente cliente, BigDecimal valor) {

		boolean podeRealizarEmprestimo = false;

		boolean passouNaAnaliseDeCredito = credito.passouNaAnaliseDeCredito(cliente);

		boolean passouNaAnaliseEmprestimo = emprestimo.passouNaAnaliseEmprestimo(cliente);

		boolean possuiDinheiroEmCaixa = banco.possuiDinheiroEmCaixa(cliente, valor);

		if (passouNaAnaliseDeCredito && passouNaAnaliseEmprestimo && possuiDinheiroEmCaixa) {
			podeRealizarEmprestimo = true;
		}

		return podeRealizarEmprestimo;
	}
}
