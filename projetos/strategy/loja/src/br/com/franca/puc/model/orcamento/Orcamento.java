package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Orcamento {

	private BigDecimal valor;
	// Item poderia ser uma classe...
	private int quantidadeDeItens;

	public Orcamento(BigDecimal valor, int quantidadeDeItens) {		
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
	}

	public BigDecimal obterValor() {
		return valor;
	}

	public int obterQuantidadeDeItens() {
		return quantidadeDeItens;
	}	
	
}
