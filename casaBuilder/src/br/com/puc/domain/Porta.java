package br.com.puc.domain;

public class Porta {
	private int id;
	private String cor;
	private TipoDePorta tipo;
	private float largura;
	private float altura;

	public Porta() {
	}

	protected Porta(int id, String cor, TipoDePorta tipo, float largura, float altura) {
		this.id = id;
		this.cor = cor;
		this.tipo = tipo;
		this.largura = largura;
		this.altura = altura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TipoDePorta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDePorta tipo) {
		this.tipo = tipo;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Porta [cor=" + cor + ", tipo=" + tipo + ", largura=" + largura + ", altura=" + altura + "]";
	}

}
