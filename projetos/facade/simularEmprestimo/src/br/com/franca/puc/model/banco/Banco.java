package br.com.franca.puc.model.banco;

import java.math.BigDecimal;

import br.com.franca.puc.model.cliente.Cliente;

public class Banco {
	
	private BigDecimal valorEmCaixa = new BigDecimal("1500.0");

	public boolean possuiDinheiroEmCaixa(Cliente cliente, BigDecimal valor) {

		System.out.println("inicio do método possuiDinheiroEmCaixa");

		clienteValido(cliente);

		boolean possuiDinheiroEmCaixa = true;

		int compareTo = valorEmCaixa.compareTo(valor);

		if (compareTo < 0) {
			possuiDinheiroEmCaixa = false;
		}

		System.out.println("Fim do método possuiDinheiroEmCaixa");

		return possuiDinheiroEmCaixa;

	}

	private void clienteValido(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente inválido");
		}
	}

}
