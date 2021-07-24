package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

public class DescontoParaValoresAcimaDeQuinhetos {

	public BigDecimal calcularDesconto(BigDecimal valor) {
		// validar se o valor é valido?
		int compare = valor.compareTo(new BigDecimal("500"));

		if (compare == 1) {
			return valor.multiply(new BigDecimal("0.1"));
		}

		return BigDecimal.ZERO;

	}
}
