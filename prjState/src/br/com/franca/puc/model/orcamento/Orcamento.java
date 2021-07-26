package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Orcamento {
	private BigDecimal valor;
	// Item poderia ser uma classe...
	private int quantidadeDeItens;
	// transformando em classe
	// private String situacao;
	private SituacaoDoOrcamento situacao;

	public Orcamento(BigDecimal valor, int quantidadeDeItens) {
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
		// this.situacao = "Em Analise";
		this.situacao = new EmAnalise();
	}

	public BigDecimal obterValor() {
		return valor;
	}

	public int obterQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	// ifs que vão crescer
	
	/**
	private BigDecimal calcularDescontoExtra() {
		BigDecimal descontoEstra = BigDecimal.ZERO;

		if (situacao.equalsIgnoreCase("Em Analise")) {
			descontoEstra = valor.multiply(new BigDecimal("0.05"));
		} else if (situacao.equalsIgnoreCase("Aprovado")) {
			descontoEstra = valor.multiply(new BigDecimal("0.02"));
		}

		return descontoEstra;
	}*/

	private BigDecimal calcularDescontoExtra() {
		return this.situacao.calcularDescontoExtra(this);		
	}

	// quem fornece o desconto eh a situação e não o orcamento
	
	/**
	public void efetuarDescontoExtra() {
		BigDecimal descontoExtra = this.calcularDescontoExtra();
		BigDecimal subtract = this.valor.subtract(descontoExtra);
		this.valor = subtract;
	}*/
	
	public void efetuarDescontoExtra(){
		BigDecimal descontoExtra = this.calcularDescontoExtra();
		this.valor = this.valor.subtract(descontoExtra);
	}

	// transição de estados.. Cada estado deveria saber se pode trocar de estado e pra qual
	
	/**
	public void aprovar() {
		if (this.situacao.equalsIgnoreCase("Em Analise")) {
			this.situacao = "Aprovado";
		}
		throw new RuntimeException("Só pode aprovar se for Em Analise");
	}*/

	public SituacaoDoOrcamento obterSituacao() {
		return this.situacao;
	}

	public void atualizarSituacao(SituacaoDoOrcamento situacao) {
		this.situacao = situacao;
	}

}
