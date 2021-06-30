package br.com.puc.domain;

public class Parede {
	private int id;
	private String cor;
	private float altura;
	private float largura;

	public Parede() {
	}

	protected Parede(int id, String cor, float altura, float largura) {
		this.id = id;
		this.cor = cor;
		this.altura = altura;
		this.largura = largura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Parede [id=" + id + ", cor=" + cor + ", altura=" + altura + ", largura=" + largura + "]";
	}
	
	

}
