package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

import br.com.franca.puc.model.imposto.Imposto;

public class CalculadoraDeImpostos {

	// dado um or�amento(valor do seu orcamento) qual � o calculo do imposto?
	// novo requisito dado um tipo do imposto qual o calculo do imposto?
	// algor�timo para obter o calculo do imposto muda conforme o tipo de imposto (estrat�gia)
	/*
	public BigDecimal calcularImposto(Orcamento orcamento, TipoDeImposto imposto) {
		// 10% 10/100 = 0,1 ou 0.1
		// Imposto ISS
		// https://www.contabilizei.com.br/contabilidade-online/o-que-e-iss-e-como-calcular/
		// dado um tipo de imposto executa um calculo para obter o imposto
		// problemas ifs e elses ou switch case gigantes
		switch (imposto) {
		case ICMS:
			return orcamento.getValor().multiply(new BigDecimal("0.1"));
		case ISS:
			// aliquota de 6% 6/100 = 0,06 ou 0.06 
			return orcamento.getValor().multiply(new BigDecimal("0.06"));
		default:
			return BigDecimal.ZERO;
		}

	}
	*/	
	
	public BigDecimal calcularImposto (Orcamento orcamento, Imposto imposto){		
		return imposto.calcularImposto(orcamento);		
					
	}
}
