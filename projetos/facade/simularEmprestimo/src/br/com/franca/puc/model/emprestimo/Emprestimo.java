package br.com.franca.puc.model.emprestimo;

import br.com.franca.puc.model.cliente.Cliente;

public class Emprestimo {
	public boolean passouNaAnaliseEmprestimo(Cliente cliente) {
		System.out.println("inicio do m�todo passouNaAnaliseEmprestimo");
		return cliente != null;
	}
}
