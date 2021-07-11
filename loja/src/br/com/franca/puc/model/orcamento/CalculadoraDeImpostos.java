package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImpostos {

	// dado um orçamento(valor do seu orcamento) qual o calculo do imposto?

	public BigDecimal calcularImposto(Orcamento orcamento) {
		// 10% 10/100 = 0,1 ou 0.1
		// Imposto ISS
		// https://www.contabilizei.com.br/contabilidade-online/o-que-e-iss-e-como-calcular/
		return orcamento.getValor().multiply(new BigDecimal("0.1"));

	}
}
