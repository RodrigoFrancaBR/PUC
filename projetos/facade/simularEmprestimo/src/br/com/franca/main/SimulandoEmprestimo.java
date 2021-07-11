package br.com.franca.main;

import java.math.BigDecimal;

import br.com.franca.puc.model.banco.Banco;
import br.com.franca.puc.model.cliente.Cliente;
import br.com.franca.puc.model.credito.Credito;
import br.com.franca.puc.model.emprestimo.Emprestimo;

public class SimulandoEmprestimo {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();

		if (passouNaAnaliseDeCredito(cliente)) {

			System.out.println("Passou na Analise de Credito.");

			if (passouNaAnaliseEmprestimo(cliente)) {

				System.out.println("Passou na Analise de Emprestimo.");

				if (possuiDinheiroEmCaixa(cliente, new BigDecimal("2000.0"))) {

					System.out.println("Possui dinheiro em Caixa.");

				} else {

					System.out.println("Não Possui dinheiro em Caixa.");
				}

			} else {

				System.out.println("Não Passou na Analise de Emprestimo.");
			}

		} else {

			System.out.println("Não Passou na Analise de Credito");
		}
	}

	private static boolean passouNaAnaliseDeCredito(Cliente cliente) {
		Credito credito = new Credito();
		return credito.passouNaAnaliseDeCredito(cliente);
	}

	private static boolean passouNaAnaliseEmprestimo(Cliente cliente) {
		Emprestimo emprestimo = new Emprestimo();
		return emprestimo.passouNaAnaliseEmprestimo(cliente);
	}

	private static boolean possuiDinheiroEmCaixa(Cliente cliente, BigDecimal valor) {
		Banco banco = new Banco();
		return banco.possuiDinheiroEmCaixa(cliente, valor);
	}

}
