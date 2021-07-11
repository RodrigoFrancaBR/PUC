package br.com.franca.puc.model.credito;

import br.com.franca.puc.model.cliente.Cliente;

public class Credito {
	public boolean passouNaAnaliseDeCredito(Cliente cliente) {
		System.out.println("inicio do método analiseDeCredito");
		// alguma regra para validar analise de credito.
		return cliente != null;
	}
}
