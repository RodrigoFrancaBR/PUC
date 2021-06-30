package br.com.puc.domain;

import java.math.BigDecimal;

public class Piscina {
	private BigDecimal preco;
	private String cor;
	private float comprimento;
	private float largura;
	private float profundidade;

	public Piscina() {
	}

	protected Piscina(float comprimento, float largura, float profundidade) {		
		this.comprimento = comprimento;
		this.largura = largura;
		this.profundidade = profundidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}

	@Override
	public String toString() {
		return "Piscina [preco=" + preco + ", cor=" + cor + ", comprimento=" + comprimento + ", largura=" + largura
				+ ", profundidade=" + profundidade + "]";
	}

}
