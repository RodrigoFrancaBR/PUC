package br.com.puc.domain;

public class Garagem {
	private int quantidadeDeVagas;
	private float largura;
	private float comprimento;

	public Garagem() {
	}

	protected Garagem(int quantidadeDeVagas, float largura, float comprimento) {
		this.quantidadeDeVagas = quantidadeDeVagas;
		this.largura = largura;
		this.comprimento = comprimento;
	}

	public int getQuantidadeDeVagas() {
		return quantidadeDeVagas;
	}

	public void setQuantidadeDeVagas(int quantidadeDeVagas) {
		this.quantidadeDeVagas = quantidadeDeVagas;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	@Override
	public String toString() {
		return "Garagem [quantidadeDeVagas=" + quantidadeDeVagas + ", largura=" + largura + ", comprimento="
				+ comprimento + "]";
	}

}
