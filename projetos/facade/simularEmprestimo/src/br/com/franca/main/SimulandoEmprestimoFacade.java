package br.com.franca.main;

import java.math.BigDecimal;

import br.com.franca.facade.Facade;
import br.com.franca.puc.model.cliente.Cliente;

public class SimulandoEmprestimoFacade {
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();

		Facade facade = new Facade();

		boolean podeRealizarEmprestimo = facade.podeRealizarEmprestimo(cliente, new BigDecimal("2000.0"));

		if (podeRealizarEmprestimo) {
			System.out.println("Emprestimo autorizado!");
		} else {
			System.out.println("Emprestimo não Autorizado!");
		}
	}
}
