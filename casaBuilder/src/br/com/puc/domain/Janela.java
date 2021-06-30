package br.com.puc.domain;

public class Janela {

	private float altura;
	private float largura;
	private int quantidadeDeFolhas;
	private int quantidadeDeVidros;
	private TipoDeJanela tipo;

	public Janela() {
	}

	protected Janela(float altura, float largura, int quantidadeDeFolhas, int quantidadeDeVidros, TipoDeJanela tipo) {
		this.altura = altura;
		this.largura = largura;
		this.quantidadeDeFolhas = quantidadeDeFolhas;
		this.quantidadeDeVidros = quantidadeDeVidros;
		this.tipo = tipo;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public int getQuantidadeDeFolhas() {
		return quantidadeDeFolhas;
	}

	public void setQuantidadeDeFolhas(int quantidadeDeFolhas) {
		this.quantidadeDeFolhas = quantidadeDeFolhas;
	}

	public int getQuantidadeDeVidros() {
		return quantidadeDeVidros;
	}

	public void setQuantidadeDeVidros(int quantidadeDeVidros) {
		this.quantidadeDeVidros = quantidadeDeVidros;
	}

	public TipoDeJanela getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeJanela tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Janela [altura=" + altura + ", largura=" + largura + ", quantidadeDeFolhas=" + quantidadeDeFolhas
				+ ", quantidadeDeVidros=" + quantidadeDeVidros + ", tipo=" + tipo + "]";
	}

}
